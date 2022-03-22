package com.example.treasuremall.api.query.item;

import com.example.treasuremall.api.query.Query;
import com.example.treasuremall.api.content.item.ItemContent;

public interface ItemQuery extends Query<ItemContent, ItemQuery> {

    /**
     * 根据商品ID查询商品。
     * @param itemId 商品ID
     * @return 商品查询行为
     */
    ItemQuery queryItemById(Long itemId);

}
