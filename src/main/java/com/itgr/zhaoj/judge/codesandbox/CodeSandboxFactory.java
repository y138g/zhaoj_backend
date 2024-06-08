package com.itgr.zhaoj.judge.codesandbox;

import com.itgr.zhaoj.judge.codesandbox.impl.ExampleCodeSandbox;
import com.itgr.zhaoj.judge.codesandbox.impl.RemoteCodeSandbox;
import com.itgr.zhaoj.judge.codesandbox.impl.ThirdPartyCodeSandbox;

/**
 * @author ygking
 * 代码沙箱工厂（根据字符串参数创建指定的代码沙箱事例）
 */
public class CodeSandboxFactory {


    /**
     * 创建代码沙箱事例
     * @param type 沙箱类型
     * @return 沙箱事例
     */
    public static CodeSandbox newInstance(String type) {
        switch (type) {
            case "example":
                return new ExampleCodeSandbox();
            case "remote":
                return new RemoteCodeSandbox();
            case "thirdParty":
                return new ThirdPartyCodeSandbox();
            default:
                return new ExampleCodeSandbox();
        }
    }
}
