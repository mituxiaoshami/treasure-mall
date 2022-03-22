package com.example.treasuremall.api.query;

import com.example.treasuremall.api.content.Content;

/**
 * 规范查询行为
 */
public interface Query<N extends Content, Q extends Query<N, Q>> {

    /**
     * 添加查询内容
     * @param contents 添加查询内容
     * @return Q 返回自身的查询行为或者子类的查询行为
     */
    Q addContent(N... contents);

}
