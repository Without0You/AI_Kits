package com.example.ai_demo.util;

import com.baidu.aip.nlp.AipNlp;
import org.json.JSONObject;

public class Text_Correction {


    public static void main(String[] args) {
        String APP_ID = "121603030";
        String API_KEY = "3qIrDbMSus9Nw7pqXcVyyrfz";
        String SECRET_KEY = "qv47Bxp5xAfq85ZeDBRXRJOqadCmj6v2";

        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
//        client.setConnectionTimeoutInMillis(2000);
//        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 调用接口
        String text = "百度是一家人工只能公司";
        JSONObject res = client.ecnet(text, null);
        System.out.println(res.toString(2));

    }
}
