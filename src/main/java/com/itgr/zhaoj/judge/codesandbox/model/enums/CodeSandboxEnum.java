package com.itgr.zhaoj.judge.codesandbox.model.enums;

import org.apache.commons.lang3.ObjectUtils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum CodeSandboxEnum {


    EXAMPLE("事例代码沙箱", "ExampleCodeSandbox"),
    REMOTE("远程代码沙箱", "RemoteCodeSandbox"),
    THIRD_PARTY("第三方代码沙箱", "ThirdPartyCodeSandbox");

    private final String text;

    private final String value;

    CodeSandboxEnum(String text, String value) {
        this.text = text;
        this.value = value;
    }

    /**
     * 获取值列表
     *
     * @return
     */
    public static List<String> getValues() {
        return Arrays.stream(values()).map(item -> item.value).collect(Collectors.toList());
    }

    /**
     * 根据 value 获取枚举
     *
     * @param value
     * @return
     */
    public static CodeSandboxEnum getEnumByValue(String value) {
        if (ObjectUtils.isEmpty(value)) {
            return null;
        }
        for (CodeSandboxEnum anEnum : CodeSandboxEnum.values()) {
            if (anEnum.value.equals(value)) {
                return anEnum;
            }
        }
        return null;
    }

    public String getValue() {
        return value;
    }

    public String getText() {
        return text;
    }
}
