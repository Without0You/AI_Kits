package com.example.ai_demo.util;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.baidu.aip.nlp.AipNlp;
import com.baidu.aip.ocr.AipOcr;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;

public class AiUtils {
    public static String img(MultipartFile file){
        String APP_ID = "79544756";
        String API_KEY = "RXimvf8Jp7SXH7sESvbu6nx4";
        String SECRET_KEY = "TYXJBKACumReXI03KLuMxl585iyjwx68";
        // 初始化一个AipImageClassify
        AipImageClassify client = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);



        // 调用接口
        JSONObject res = null;
        try {
            res = client.advancedGeneral(file.getBytes(), new HashMap<String, String>());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        JSONObject result = res.getJSONArray("result").getJSONObject(0);
        String s = "这张图" + result.getDouble("score") * 100 + "%的可能是" + result.getString("root") + "-" + result.getString("keyword");


        return s;
    }


    public static String word(MultipartFile file) throws IOException {
        //设置APPID/AK/SK
        String APP_ID = "121602716";
        String API_KEY = "lZlY9grbiaoeVs16KKEjYzok";
        String SECRET_KEY = "9C2uYiisOTP8SgBBPqUW9A7tx9nT1Qwb";
        // 初始化一个AipOcr
        AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);

        // 可选：设置网络连接参数
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);


        System.setProperty("aip.log4j.conf", "path/to/your/log4j.properties");

        // 调用接口

        JSONObject res = client.basicGeneral(file.getBytes(), new HashMap<String, String>());
        JSONArray jsonArray = res.getJSONArray("words_result");
        StringBuffer x = new StringBuffer();
        for(int i = 0; i < jsonArray.length(); i++){
            x.append(jsonArray.getJSONObject(i).getString("words")).append("\n");
        }
        return x.toString();
    }
    public static String nlp(String text){
        String APP_ID = "121603030";
        String API_KEY = "3qIrDbMSus9Nw7pqXcVyyrfz";
        String SECRET_KEY = "qv47Bxp5xAfq85ZeDBRXRJOqadCmj6v2";

        // 初始化一个AipNlp
        AipNlp client = new AipNlp(APP_ID, API_KEY, SECRET_KEY);


        // 调用接口

        JSONObject res = client.ecnet(text, null);
        String res1 = res.getJSONObject("item").getString("correct_query");

        return res1;
    }

    public static void main(String[] args) {
        String text = "百度是一家人工只能公司!!!!!";
        System.out.println(nlp(text));
    }
}
