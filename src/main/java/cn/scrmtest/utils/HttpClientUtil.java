package cn.scrmtest.utils;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;

public class HttpClientUtil {
    private static CloseableHttpClient client;

    public static CloseableHttpClient getClient() {

        client = HttpClients.createDefault();

        return client;
    }

    public static String getResult(HttpPost post, JSONObject param) throws IOException {
        post.setHeader("content-type", "application/json");
        StringEntity entity = new StringEntity(param.toString(), "utf-8");
        post.setEntity(entity);
        String result;
        CloseableHttpResponse response = getClient().execute(post);
        result = EntityUtils.toString(response.getEntity(), "utf-8");
        return result;
    }

    public static void main(String[] args) throws IOException {
        HttpPost post = new HttpPost("http://localhost:8989/user/login");
        JSONObject param = new JSONObject();
        param.put("username", "yt9999999");
        param.put("password", "12345a");
        String result = getResult(post, param);
        System.out.println(result);
    }
}
