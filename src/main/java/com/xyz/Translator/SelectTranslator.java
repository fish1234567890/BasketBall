package com.xyz.Translator;

import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;

import java.io.StringReader;
import java.util.Map;
import java.util.Set;


/**
 * 查询语句的翻译器
 *
 * 采外观模式，只要实现translate即可。
 */
public class SelectTranslator extends AbstractTranslator {

    /**
     * 将最初在xml中的sql语句根据参数的不同翻译成可以直接放到preparedStatement执行的sql语句。
     * @param originalSql  xml中的sql语句
     * @param realParams  实际用到的参数
     * @return  翻译后的sql语句
     */
    protected String translate(String originalSql, Map<String, Object> realParams) {
        try{
            CCJSqlParserManager parserManager = new CCJSqlParserManager();
            Select select = (Select) parserManager.parse(new StringReader(originalSql));
            PlainSelect plain = (PlainSelect) select.getSelectBody();
            AndExpression where = (AndExpression)plain.getWhere();
        } catch (Exception e){
            e.printStackTrace();
        }

        String sql ="";
        Set<Map.Entry<String, Object>> entries = realParams.entrySet();
        for(Map.Entry<String, Object> entry : entries){
            String key = "#{"+entry.getKey()+"}";
            sql = originalSql.replaceAll(key, "?");
        }
        return sql;
    }
}
