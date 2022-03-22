package com.example.treasuremall.api.context;

import com.example.treasuremall.api.content.Content;

import java.util.HashSet;
import java.util.Set;

public class Context<N extends Content> {

    /**
     * 指定查询结果需包含的内容
     */
    protected Set<N> contentSet = new HashSet<>();

    /**
     * 添加查询内容
     * @param contents 查询内容
     */
    @SafeVarargs
    public final void addContent(N... contents) {
        if (contents != null) {
            for (N content : contents) {
                if (content != null) {
                    this.contentSet.add(content);
                }
            }
        }
    }

    public Set<N> getContentSet() {
        return contentSet;
    }

}
