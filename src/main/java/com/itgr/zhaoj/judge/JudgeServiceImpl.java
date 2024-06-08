package com.itgr.zhaoj.judge;

import cn.hutool.json.JSONUtil;
import com.itgr.zhaoj.common.ErrorCode;
import com.itgr.zhaoj.exception.BusinessException;
import com.itgr.zhaoj.judge.codesandbox.CodeSandbox;
import com.itgr.zhaoj.judge.codesandbox.CodeSandboxFactory;
import com.itgr.zhaoj.judge.codesandbox.CodeSandboxProxy;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.itgr.zhaoj.judge.strategy.DefaultJudgeStrategy;
import com.itgr.zhaoj.judge.strategy.JudgeContext;
import com.itgr.zhaoj.judge.strategy.JudgeStrategy;
import com.itgr.zhaoj.model.dto.question.JudgeCase;
import com.itgr.zhaoj.judge.codesandbox.model.JudgeInfo;
import com.itgr.zhaoj.model.entity.Question;
import com.itgr.zhaoj.model.entity.QuestionSubmit;
import com.itgr.zhaoj.model.enums.QuestionSubmitStatusEnum;
import com.itgr.zhaoj.service.QuestionService;
import com.itgr.zhaoj.service.QuestionSubmitService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ygking
 */
@Service
public class JudgeServiceImpl implements JudgeService {

    @Resource
    private QuestionSubmitService questionSubmitService;
    @Resource
    private QuestionService questionService;

    @Value("${codeSandbox.type:example}")
    private String type;

    @Override
    public QuestionSubmit doJudge(long questionSubmitId) {
        //1. 传入题目 id，获取对应的题目、题目提交信息（代码、编程语言等）
        QuestionSubmit questionSubmit = questionSubmitService.getById(questionSubmitId);
        if (questionSubmit == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "提交信息不存在");
        }
        Question question = questionService.getById(questionSubmit.getQuestionId());
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR, "题目不存在");
        }
        //2. 若题目提交状态为等待中，则不重复执行
        if (!Objects.equals(questionSubmit.getStatus(), QuestionSubmitStatusEnum.WAITING.getValue())) {
            throw new BusinessException(ErrorCode.OPERATION_ERROR, "正在判题....");

        }
        //3. 更改判题状态为“判题中”，防止重复执行，也能返回前端给用户查看（类似锁，内部锁）
        QuestionSubmit updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        boolean update = questionSubmitService.updateById(updateQuestionSubmit);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目更新错误");
        }
        //4. 调用沙箱，获取执行结果（response）
        CodeSandbox codeSandbox = CodeSandboxFactory.newInstance(type);
        codeSandbox = new CodeSandboxProxy(codeSandbox);
        String language = questionSubmit.getLanguage();
        String code = questionSubmit.getCode();
        //获取输入用例
        String judgeCaseStr = question.getJudgeCase();
        List<JudgeCase> judgeCaseList = JSONUtil.toList(judgeCaseStr, JudgeCase.class);
        List<String> inputList = judgeCaseList.stream().map(JudgeCase::getInput).collect(Collectors.toList());
        ExecuteCodeRequest executeCodeRequest = ExecuteCodeRequest.builder()
                .language(language)
                .code(code)
                .inputList(inputList)
                .build();
        ExecuteCodeResponse executeCodeResponse = codeSandbox.executeCode(executeCodeRequest);
        List<String> outputList = executeCodeResponse.getOutputList();
        //5. 根据沙箱执行结果，设置题目的判题状态和信息
        JudgeContext judgeContext = new JudgeContext();
        judgeContext.setJudgeInfo(executeCodeResponse.getJudgeInfo());
        judgeContext.setInputList(inputList);
        judgeContext.setOutputList(outputList);
        judgeContext.setJudgeCaseList(judgeCaseList);
        judgeContext.setQuestion(question);
        judgeContext.setQuestionSubmit(questionSubmit);
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        JudgeInfo judgeInfo = judgeStrategy.doJudge(judgeContext);
        //修改数据库中的判题结果
        updateQuestionSubmit = new QuestionSubmit();
        updateQuestionSubmit.setId(questionSubmitId);
        updateQuestionSubmit.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        updateQuestionSubmit.setJudgeInfo(JSONUtil.toJsonStr(judgeInfo));
        update = questionSubmitService.updateById(updateQuestionSubmit);
        if (!update) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目更新错误");
        }
        //todo 更新题目提交数
        return questionSubmitService.getById(questionSubmitId);
    }
}
