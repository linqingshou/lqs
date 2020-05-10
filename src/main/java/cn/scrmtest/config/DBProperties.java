package cn.scrmtest.config;

import java.util.Properties;

public class DBProperties {
    public static final Properties dbCase;
    public static final Properties dbScrm;

    static {
        dbCase = new Properties();
        dbCase.setProperty("jdbc.driver","com.mysql.jdbc.Driver");
        dbCase.setProperty("jdbc.url","jdbc:mysql://rm-bp17u5a8x20jk01fz2o.mysql.rds.aliyuncs.com:3306/cases?useSSL=false");
        dbCase.setProperty("jdbc.user","root");
        dbCase.setProperty("jdbc.password","LQS@527089599");

        dbScrm = new Properties();
        dbScrm.setProperty("jdbc.driver","com.mysql.jdbc.Driver");
        dbScrm.setProperty("jdbc.url","jdbc:mysql://rm-bp17u5a8x20jk01fz2o.mysql.rds.aliyuncs.com:3306/scrmtest?useSSL=false");
        dbScrm.setProperty("jdbc.user","root");
        dbScrm.setProperty("jdbc.password","LQS@527089599");
    }
}
