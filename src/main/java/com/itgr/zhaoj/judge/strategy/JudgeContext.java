package com.itgr.zhaoj.judge.strategy;

import com.itgr.zhaoj.model.dto.question.JudgeCase;
import com.itgr.zhaoj.judge.codesandbox.model.JudgeInfo;
import com.itgr.zhaoj.model.entity.Question;
import com.itgr.zhaoj.model.entity.QuestionSubmit;
import lombok.Data;

import java.util.List;

/**
 * @author ygking
 * 上下文
 */
@Data
public class JudgeContext {
    private JudgeInfo judgeInfo;

    private List<String> inputList;

    private List<String> outputList;

    private List<JudgeCase> judgeCaseList;

    private Question question;

    private QuestionSubmit questionSubmit;
}
