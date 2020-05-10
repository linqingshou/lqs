package cn.scrmtest.cases;


import cn.scrmtest.config.UrlConfig;
import cn.scrmtest.utils.CaseUrl;
import org.testng.annotations.BeforeSuite;

public class TestBefore {


    @BeforeSuite(groups = "url")
    public void beforeTest(){
        UrlConfig.loginUrl = CaseUrl.getUrl("login.uri");
    }
}
