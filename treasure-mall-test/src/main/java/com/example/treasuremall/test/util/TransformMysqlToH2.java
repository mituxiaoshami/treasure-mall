package com.example.treasuremall.test.util;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.Files;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author 小沙弥
 * @description Mysql 转成 H2 语法
 * @date 2022/3/22 4:49 下午
 */
public class TransformMysqlToH2 {


    /**
     * MYSQL 建表语句路径
     */
    private static final String DB_PATH = "/treasure-mall-test/src/main/resources/db/";


    public static void main(String[] args) throws IOException {
        // Mysql 建表语句转换成H2
        convert("mysql.sql", "h2.sql");
    }


    /**
     * 转换方法
     * @param mysqlFileName mysql文件名
     * @param h2FileName h2文件名
     */
    private static void convert(String mysqlFileName, String h2FileName) throws IOException {
        String sqlPath = new File(".").getCanonicalPath();
        String mysqlFilePath = sqlPath + TransformMysqlToH2.DB_PATH + mysqlFileName;
        File file = new File(mysqlFilePath);
        String content = Files.toString(file, Charsets.UTF_8);
        content = "SET MODE MYSQL;\n\n" + content;
        content = content.replaceAll("`", "");
        content = content.replaceAll("\\\\\"", "\"");
        content = content.replaceAll(" COLLATE.*(?=D)", "");
        content = content.replaceAll(" COMMENT.*'(?=,)", "");
        content = content.replaceAll("\\).*ENGINE.*(?=;)", ")");
        content = content.replaceAll("DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP", "DEFAULT CURRENT_TIMESTAMP");
        content = content.replaceAll(" CHARACTER SET utf8", "");
        String[] tableList = content.split(";");
        List<String> newTableList = Lists.newArrayList();
        for (String table : tableList) {
            if (StringUtils.isBlank(table)) {
                continue;
            }
            if (table.contains("TABLE")) {
                table = uniqueKey(table);
            }
            newTableList.add(table);
        }
        content = StringUtils.join(newTableList, ";");
        String h2FilePath = sqlPath + TransformMysqlToH2.DB_PATH + h2FileName;
        File h2File = new File(h2FilePath);
        if (!h2File.exists()) {
            h2File.createNewFile();
        }
        Files.write(content, h2File, Charsets.UTF_8);
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
