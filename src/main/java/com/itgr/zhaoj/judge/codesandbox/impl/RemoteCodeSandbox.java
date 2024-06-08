package com.itgr.zhaoj.judge.codesandbox.impl;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.alibaba.excel.util.StringUtils;
import com.itgr.zhaoj.common.ErrorCode;
import com.itgr.zhaoj.exception.BusinessException;
import com.itgr.zhaoj.judge.codesandbox.CodeSandbox;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeRequest;
import com.itgr.zhaoj.judge.codesandbox.model.ExecuteCodeResponse;

/**
 * @author ygking
 * 远程代码沙箱
 */
public class RemoteCodeSandbox implements CodeSandbox {
    @Override
    public ExecuteCodeResponse executeCode(ExecuteCodeRequest executeCodeRequest) {
        System.out.println("远程代码沙箱");
        // todo 改成远程服务器地址
        String url = "http://localhost:8080/executeCode";
        String json = JSONUtil.toJsonStr(executeCodeRequest);
        String responseStr = HttpUtil.createPost(url)
                .body(json)
                .execute()
                .body();
        if (StringUtils.isBlank(responseStr)){
            throw new BusinessException(ErrorCode.PARAMS_ERROR
                    , "executeCode remoteSandbox error, message = " + responseStr);
        }
        return JSONUtil.toBean(responseStr, ExecuteCodeResponse.class);
    }
}
