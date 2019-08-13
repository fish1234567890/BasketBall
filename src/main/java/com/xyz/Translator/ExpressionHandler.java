package com.xyz.Translator;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.statement.select.PlainSelect;

import java.util.Map;

public class ExpressionHandler {

    public String handler(PlainSelect plainSelect, Map params){
        Expression expression = plainSelect.getWhere();
        if(expression instanceof AndExpression){
            AndExpression and = (AndExpression) expression;
            Expression rightExpression = and.getRightExpression();
        }
        return null;
    }
}
