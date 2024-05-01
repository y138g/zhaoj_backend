package com.itgr.zhaoj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgr.zhaoj.model.dto.question.QuestionQueryRequest;
import com.itgr.zhaoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.itgr.zhaoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.itgr.zhaoj.model.entity.Question;
import com.itgr.zhaoj.model.entity.QuestionSubmit;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itgr.zhaoj.model.entity.User;
import com.itgr.zhaoj.model.vo.QuestionSubmitVO;
import com.itgr.zhaoj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ygking
 * @description 针对表【question_submit(题目提交)】的数据库操作Service
 * @createDate 2024-04-25 20:25:48
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {


    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取问题提交封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取问题提交封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);

}
