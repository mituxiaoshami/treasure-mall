package com.example.treasuremall.test.util;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 小沙弥
 * @description Mysql 转成 H2 语法
 * @date 2022/3/22 4:49 下午
 */
public class TransformMysqlToH2 {

    public static void main(String[] args) throws IOException {
        //sql地址
        String filePath = Objects.requireNonNull(TransformMysqlToH2.class.getClassLoader().getResource("db/schema.sql")).getFile();
        System.out.println(filePath);
        File file = new File(filePath);
        String content = Files.toString(file, Charsets.UTF_8);
        content = "SET MODE MYSQL;\n\n" + content;
        content = content.replaceAll("`", "");
        content = content.replaceAll("COLLATE.*(?=D)", "");
        content = content.replaceAll("COMMENT.*'(?=,)", "");
        content = content.replaceAll("\\).*ENGINE.*(?=;)", ")");
        content = content.replaceAll("DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", " AS CURRENT_TIMESTAMP");
        content = uniqueKey(content);
        System.out.println(content);
    }


    /**
     * h2的索引名必须全局唯一
     *
     * @param content sql建表脚本
     * @return 替换索引名为全局唯一
     */
    private static String uniqueKey(String content) {
        int inc = 0;
        Pattern pattern = Pattern.compile("(?<=KEY )(.*?)(?= \\()");
        Matcher matcher = pattern.matcher(content);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group() + inc++);
        }
        matcher.appendTail(sb);
        content = sb.toString();
        return content;
    }
}
