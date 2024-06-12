package com.itgr.zhaoj.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.itgr.zhaoj.common.BaseResponse;
import com.itgr.zhaoj.common.ErrorCode;
import com.itgr.zhaoj.common.ResultUtils;
import com.itgr.zhaoj.exception.BusinessException;
import com.itgr.zhaoj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.itgr.zhaoj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.itgr.zhaoj.model.entity.QuestionSubmit;
import com.itgr.zhaoj.model.entity.User;
import com.itgr.zhaoj.model.vo.QuestionSubmitVO;
import com.itgr.zhaoj.service.QuestionSubmitService;
import com.itgr.zhaoj.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Detainted;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子点赞接口
 *
 * @author y138g
 * @from <a href="https://github.com/y138g">yg的开源仓库</a>
 */
@RestController
@RequestMapping("/question_submit")
@Slf4j
@Detainted
public class QuestionSubmitController {

    @Resource
    private QuestionSubmitService questionSubmitService;

    @Resource
    private UserService userService;
//
//    /**
//     * 提交题目
//     *
//     * @param questionSubmitAddRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/")
//    public BaseResponse<Long> doQuestionSubmit(@RequestBody QuestionSubmitAddRequest questionSubmitAddRequest,
//                                               HttpServletRequest request) {
//        if (questionSubmitAddRequest == null || questionSubmitAddRequest.getQuestionId() <= 0) {
//            throw new BusinessException(ErrorCode.PARAMS_ERROR);
//        }
//        // 登录才能提交
//        final User loginUser = userService.getLoginUser(request);
//        Long questionSubmitId = questionSubmitService.doQuestionSubmit(questionSubmitAddRequest, loginUser);
//        return ResultUtils.success(questionSubmitId);
//    }
//
//
//    /**
//     * 分页获取题目提交列表（仅管理员和本人）
//     *
//     * @param questionSubmitQueryRequest
//     * @param request
//     * @return
//     */
//    @PostMapping("/list/page")
//    public BaseResponse<Page<QuestionSubmitVO>> listQuestionSubmitByPage(@RequestBody QuestionSubmitQueryRequest questionSubmitQueryRequest,
//                                                                         HttpServletRequest request) {
//        long current = questionSubmitQueryRequest.getCurrent();
//        long size = questionSubmitQueryRequest.getPageSize();
//        //数据库查询原始提交信息
//        Page<QuestionSubmit> questionSubmitPage = questionSubmitService.page(new Page<>(current, size),
//                questionSubmitService.getQueryWrapper(questionSubmitQueryRequest));
//        //信息对应权限进行脱敏
//        final User loginUser = userService.getLoginUser(request);
//        return ResultUtils.success(questionSubmitService.getQuestionSubmitVOPage(questionSubmitPage, loginUser));
//    }

}
