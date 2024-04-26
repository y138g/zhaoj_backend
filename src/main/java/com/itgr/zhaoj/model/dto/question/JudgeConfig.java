package com.itgr.zhaoj.model.dto.question;

import lombok.Data;

/**
 * @author ygking
 */
@Data
public class JudgeConfig {

    /**
     * 时间限制(ms)
     */
    private Long timeLimit;

    /**
     * 内存限制(kb)
     */
    private Long memoryLimit;

    /**
     * 栈限制(kb)
     */
    private Long stackLimit;
}
