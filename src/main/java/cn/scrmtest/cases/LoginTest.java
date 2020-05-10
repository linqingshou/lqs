package cn.scrmtest.cases;

import cn.scrmtest.config.UrlConfig;
import cn.scrmtest.modle.LoginCase;
import cn.scrmtest.utils.DBUtil;
import cn.scrmtest.utils.HttpClientUtil;
import com.mongodb.util.JSON;
import org.apache.http.client.methods.HttpPost;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

public class LoginTest {


    @Test(dataProvider = "login")
    public void login(LoginCase loginCase) throws IOException {
        HttpPost post = new HttpPost(UrlConfig.loginUrl);
        JSONObject param = new JSONObject();
        param.put("username",loginCase.getUsername());
        param.put("password",loginCase.getPassword());
        String result = HttpClientUtil.getResult(post, param);
        Map parse = (Map) JSON.parse(result);
        Assert.assertEquals(parse.get("status"),loginCase.getExpect());

    }

    @DataProvider(name = "login")
    public Iterator<Object[]> info() throws IOException {
        return DBUtil.getCaseInfo("loginCase");
    }


}
