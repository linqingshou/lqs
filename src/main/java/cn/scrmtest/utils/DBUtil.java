package cn.scrmtest.utils;

import cn.scrmtest.config.DBProperties;
import cn.scrmtest.modle.LoginCase;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

public class DBUtil {
    public static SqlSession getSqlSession(Properties properties) throws IOException {
        InputStream stream = Resources.getResourceAsStream("db.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream, properties);
        SqlSession sqlSession = factory.openSession();
        return sqlSession;
    }

    public static Iterator<Object[]> getCaseInfo(String s) throws IOException {
        SqlSession sqlSession = DBUtil.getSqlSession(DBProperties.dbCase);
        List<Object> cases = sqlSession.selectList(s);
        List<Object[]> testObj = new ArrayList<Object[]>();
        for (Object u : cases) {
            //做一个形式转换
            testObj.add(new Object[]{u});
        }
        return testObj.iterator();
    }

    public static void main(String[] args) {
        SqlSession sqlSession = null;
        try {
            sqlSession = new DBUtil().getSqlSession(DBProperties.dbCase);
            List<LoginCase> login_case = sqlSession.selectList("loginCase");
            for (LoginCase lc:login_case) {
                System.out.println(lc);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }


}
