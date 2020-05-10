package cn.scrmtest.utils;

import java.util.Locale;
import java.util.ResourceBundle;

public class CaseUrl {
    private static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(String uri){
        String testUrl = bundle.getString("scrm.url");
        String url = testUrl + bundle.getString(uri);
        return url;
    }

    public static void main(String[] args) {
        String url = CaseUrl.getUrl("login.uri");
        System.out.println(url);
    }

}
