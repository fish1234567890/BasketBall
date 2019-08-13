import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.statement.select.*;

import java.io.StringReader;

public class BaseTest {

    public static void main(String[] args) throws Exception{
        String sql = "select * from user where 1=1 and id = 1 and user = 'mike' and name in (a,b,c) or address = 1";
        String sql1 = "select * from (select * from teacher)";
        String sql2 = "select id,(select * from dual) from (select * from teacher) ";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(sql));
        PlainSelect plain = (PlainSelect) select.getSelectBody();
        Expression where = plain.getWhere();

        //String stringExpression = where.getStringExpression();
        //SimpleNode astNode = where.getASTNode();
        System.out.println("==");
    }
}
