package com.example.treasuremall.api.context.base;

import com.example.treasuremall.api.factory.item.ItemFactory;
import com.example.treasuremall.api.factory.item.impl.ItemFactoryImpl;


/**
 * 基础的上下文
 */
public class TreasureMallContext {

    /**
     * 商品工厂
     */
    public static final ItemFactory ITEM_FACTORY = new ItemFactoryImpl();


}
