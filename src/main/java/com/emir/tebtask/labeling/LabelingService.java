package com.emir.tebtask.labeling;

import com.emir.tebtask.appconfig.AppConfig;
import com.google.gson.Gson;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LabelingService {

    private final AppConfig appConfig;

    @Autowired
    public LabelingService(AppConfig appConfig) {
        this.appConfig = appConfig;
    }

    public LabelingResponse tagData(Labeling text) {
        OkHttpClient http = new OkHttpClient();
        Gson gson = new Gson();
        // final String url = "http://127.0.0.1:5005/zero-shot/sentiment-for-java";
        final String url = appConfig.getZeroshotUrl();
        String reqBody = gson.toJson(text);
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, reqBody);
        Request request = new Request.Builder()
                .url(url)
                .post(requestBody)
                .build();
        try {
            Response response = http.newCall(request).execute();
            if (response.isSuccessful()) {
                ResponseBody responseBody = response.body();
                String resp = responseBody.string();
                LabelingResponse labelingResponse = gson.fromJson(resp, LabelingResponse.class);
                return labelingResponse;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return new LabelingResponse();
    }
}

