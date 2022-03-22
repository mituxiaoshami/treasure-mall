package com.example.treasuremall.api;

import com.example.treasuremall.api.context.base.TreasureMallContext;
import com.example.treasuremall.api.factory.item.ItemFactory;

/**
 * @description: API的开头，代表是TreasureMall这个系统
 * @author 小沙弥
 * @date 2021/7/23 9:23 下午
 */
public final class TreasureMall {

    /**
     * 商品领域
     */
    public static final ItemFactory ITEM = TreasureMallContext.ITEM_FACTORY;

}
