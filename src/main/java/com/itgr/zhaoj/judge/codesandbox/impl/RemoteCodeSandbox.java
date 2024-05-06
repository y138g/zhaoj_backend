package com.itgr.zhaoj.judge.codesandbox.impl;

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
        return null;
    }
}
