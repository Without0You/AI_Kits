package com.example.ai_demo.util;

import org.json.JSONObject;
import com.baidu.aip.ocr.AipOcr;

import java.util.HashMap;

public class Character_Recognition {


    public static void main(String[] args) {
        //设置APPID/AK/SK
        String APP_ID = "121602716";
        String API_KEY = "lZlY9grbiaoeVs16KKEjYzok";
        String SECRET_KEY = "9C2uYiisOTP8SgBBPqUW9A7tx9nT1Qwb";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);

        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理

        // 可选：设置log4j日志输出格式，若不设置，则使用默认配置
        // 也可以直接通过jvm启动参数设置此环境变量
        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口
        String path = "C:\\Users\\Lenovo\\Pictures\\Screenshots\\屏幕截图 2025-09-02 200544.png";
        JSONObject res = client.basicGeneral(path, new HashMap<String, String>());
        System.out.println(res.toString(2));

    }
}