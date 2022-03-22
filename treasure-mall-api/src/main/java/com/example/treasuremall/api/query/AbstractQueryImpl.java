package com.example.treasuremall.api.query;

import com.example.treasuremall.api.content.Content;
import com.example.treasuremall.api.context.Context;

/**
 * 抽象实现查询行为
 * @param <N> 查询内容
 * @param <Q> 查询行为
 */
public abstract class AbstractQueryImpl<N extends Content, Q extends Query<N, Q>> implements Query<N, Q> {

    /**
     * 添加查询内容
     * @param contents 查询内容
     * @return Q 返回自身或子类的查询行为
     */
    @Override
    public Q addContent(N... contents) {
        // 添加查询内容
        getContext().addContent(contents);
        return (Q) this;
    }


    /**
     * 获取上下文
     * @return 上下文
     */
    protected abstract Context<N> getContext();

}
