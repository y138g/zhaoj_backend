package com.itgr.zhaoj.model.dto.questionsubmit;

import com.itgr.zhaoj.common.PageRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 查询请求
 *
 * @author y138g
 * @from <a href="https://github.com/y138g">yg的开源仓库</a>
 */

@Data
@EqualsAndHashCode(callSuper = true)
public class QuestionSubmitQueryRequest extends PageRequest implements Serializable {

    //用户 id、题目 id、编程语言、题目状态查询提交记录

    /**
     * 编程语言
     */
    private String language;

    /**
     * 判题状态（0-待判题，1-判题中，2-成功，3-失败）
     */
    private Integer status;

    /**
     * 题目id
     */
    private Long questionId;

    /**
     * 用户id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}
