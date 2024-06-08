package com.itgr.zhaoj.judge;

import com.itgr.zhaoj.model.entity.QuestionSubmit;

/**
 * 判题服务
 */
public interface JudgeService {
    QuestionSubmit doJudge(long questionSubmitId);
}
