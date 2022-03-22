package com.example.treasuremall.api.query.item.impl;

import com.example.treasuremall.api.context.item.ItemContext;
import com.example.treasuremall.api.query.item.ItemQuery;
import com.example.treasuremall.api.content.item.ItemContent;
import com.example.treasuremall.api.query.AbstractQueryImpl;

public class ItemQueryImpl extends AbstractQueryImpl<ItemContent, ItemQuery> implements ItemQuery {

    /**
     * 商品查询的上下文
     */
    private static final ItemContext ITEM_CONTEXT = new ItemContext();

    @Override
    public ItemQuery queryItemById(Long itemId) {
        System.out.println("Hello World");
        for (ItemContent itemContent : getContext().getContentSet()) {
            System.out.println(itemContent);
        }
        return null;
    }

    @Override
    public ItemQuery addContent(ItemContent... contents) {
        return super.addContent(contents);
    }

    @Override
    public ItemContext getContext() {
        return ITEM_CONTEXT;
    }

}
