package com.example.treasuremall.api.factory.item;

import com.example.treasuremall.api.query.item.ItemQuery;

public interface ItemFactory {

    /**
     * 商品的查询行为
     */
    ItemQuery createQuery();

}
