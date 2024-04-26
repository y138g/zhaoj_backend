package com.itgr.zhaoj.service;

import com.itgr.zhaoj.model.entity.PostThumb;
import com.baomidou.mybatisplus.extension.service.IService;
import com.itgr.zhaoj.model.entity.User;

/**
 * 帖子点赞服务
 *
 * @author y138g
 * @from <a href="https://github.com/y138g">yg的开源仓库</a>
 */
public interface PostThumbService extends IService<PostThumb> {

    /**
     * 点赞
     *
     * @param postId
     * @param loginUser
     * @return
     */
    int doPostThumb(long postId, User loginUser);

    /**
     * 帖子点赞（内部服务）
     *
     * @param userId
     * @param postId
     * @return
     */
    int doPostThumbInner(long userId, long postId);
}
