package com.itgr.zhaoj.judge.strategy;

import com.itgr.zhaoj.model.dto.questionsubmit.JudgeInfo;

/**
 * @author ygking
 * 判题策略模式
 */
public interface JudgeStrategy {
    JudgeInfo doJudge(JudgeContext judgeContext);
}
