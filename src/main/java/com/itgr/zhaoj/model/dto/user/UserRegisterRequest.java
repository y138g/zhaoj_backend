package com.itgr.zhaoj.model.dto.user;

import java.io.Serializable;

import lombok.Data;

/**
 * 用户注册请求体
 *
 * @author y138g
 * @from <a href="https://github.com/y138g">yg的开源仓库</a>
 */
@Data
public class UserRegisterRequest implements Serializable {

    private static final long serialVersionUID = 3191241716373120793L;

    private String userAccount;

    private String userPassword;

    private String checkPassword;

    private String userName;
}
