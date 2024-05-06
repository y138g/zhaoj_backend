package com.itgr.zhaoj.judge.codesandbox.impl;

import com.itgr.zhaoj.judge.codesandbox.CodeSandbox;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeResponse;
import com.itgr.zhaoj.model.dto.questionsubmit.JudgeInfo;
import com.itgr.zhaoj.model.enums.JudgeInfoMessageEnum;
import com.itgr.zhaoj.model.enums.QuestionSubmitStatusEnum;

import java.util.List;

/**
 * @author ygking
 * 事例代码沙箱（跑通流程）
 */
public class ExampleCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        List<String> inputList = executeCodeRequest.getInputList();
        ExecuteCodeResponse executeCodeResponse = new ExecuteCodeResponse();
        executeCodeResponse.setOutputList(inputList);
        executeCodeResponse.setMessage("测试执行成功");
        executeCodeResponse.setStatus(QuestionSubmitStatusEnum.SUCCEED.getValue());
        JudgeInfo judgeInfo = new JudgeInfo();
        judgeInfo.setMessage(JudgeInfoMessageEnum.ACCEPTED.getText());
        judgeInfo.setMemory(100L);
        judgeInfo.setTime(100L);
        executeCodeResponse.setJudgeInfo(judgeInfo);
        return executeCodeResponse;

    }
}
