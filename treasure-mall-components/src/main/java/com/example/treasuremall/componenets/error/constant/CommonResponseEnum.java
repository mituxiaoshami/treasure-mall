package com.example.treasuremall.componenets.error.constant;

/**
 * @author 小沙弥
 * @description 错误统一返回
 * @date 2022/3/22 11:09 上午
 */
public enum CommonResponseEnum {

    /**
     * 服务器发生错误, 请联系管理员
     */
    SERVER_ERROR(500, "服务器发生错误, 请联系管理员!"),

    ;


    /**
     * 返回码
     */
    private final int code;


    /**
     * 返回消息
     */
    private final String message;


    CommonResponseEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    public int getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }





}
