package com.xyz.Translator;

import com.xyz.entity.BasketConfiguration;
import com.xyz.entity.RunableSql;
import com.xyz.entity.SqlDefinition;
import com.xyz.entity.SqlXmlFileHolder;
import com.xyz.util.CommonUtil.CollectionUtils;
import com.xyz.util.CommonUtil.StringUtils;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.PlainSelect;
import net.sf.jsqlparser.statement.select.Select;
import net.sf.jsqlparser.statement.select.SelectBody;
import net.sf.jsqlparser.statement.select.SelectItem;

import java.io.StringReader;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface Translator {

    <T> RunableSql<T> getRunableSql(String id, Map<String,Object> params,Class<T> resultType);


}
