import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.parser.SimpleNode;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.Statement;
import net.sf.jsqlparser.statement.select.*;

import java.io.StringReader;
import java.util.List;

public class BaseTest {

    public static void main(String[] args) throws Exception{
        String sql = "select * from user where 1=1 and id = 1 and user = 'mike' and name in (a,b,c)";
        String sql1 = "select * from (select * from teacher)";
        String sql2 = "select id,(select * from dual) from (select * from teacher) ";
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        Select select = (Select) parserManager.parse(new StringReader(sql));
        PlainSelect plain = (PlainSelect) select.getSelectBody();
        AndExpression where = (AndExpression)plain.getWhere();
        String stringExpression = where.getStringExpression();
        SimpleNode astNode = where.getASTNode();
        System.out.println("==");
    }
}
