package com.itgr.zhaoj.model.dto.questionsubmit;

import lombok.Data;

/**
 * @author ygking
 */
@Data
public class judgeInfo {


    /**
     * 程序执行信息
     */ 
    private String message;

    /**
     * 运行时间（ms）
     */
    private Long time;

    /**
     * 内存占用（kb）
     */
    private Long memory;
    
    /**
     * 栈占用(kb)
     */
    private Long stack;
}
