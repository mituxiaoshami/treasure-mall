package com.example.treasuremall.api.factory.item.impl;

import com.example.treasuremall.api.factory.item.ItemFactory;
import com.example.treasuremall.api.query.item.ItemQuery;
import com.example.treasuremall.api.query.item.impl.ItemQueryImpl;

public class ItemFactoryImpl implements ItemFactory {

    @Override
    public ItemQuery createQuery() {
        return new ItemQueryImpl();
    }

}
