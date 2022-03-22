package com.example.treasuremall.componenets.error.enums.impl;

import com.example.treasuremall.componenets.error.asserts.impl.BusinessExceptionAssert;

/**
 * @author 小沙弥
 * @description 商品错误枚举
 * @date 2022/3/21 3:04 下午
 */
public enum ItemErrorEnum implements BusinessExceptionAssert {

    /**
     * 商品ID不能为空
     */
    ITEM_ID_NOT_NULL(1001, "商品ID不能为空!"),


    /**
     * 商品价格不能为空
     */
    ITEM_PRICE_IS_NULL(1002, "商品价格不能为空!")
    ;


    /**
     * 返回码
     */
    private final int code;


    /**
     * 返回消息
     */
    private final String message;


    ItemErrorEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }


    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }


}
