package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;

import com.example.manel.KidsBook.Entities.Question;
import com.example.manel.KidsBook.webServiceConf.ServerAdress;
import com.example.manel.KidsBook.webServiceConf.Utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class QuestionMOD {

    private Context context;
    private int idCnt;
    private int idMs;
    private Question tabQs;

    public QuestionMOD(Context context, int idCnt, int idMs) {
        this.context = context;
        this.idCnt = idCnt;
        this.idMs = idMs;
    }

    public Question quest() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            RestTemplate restTemplateq = new RestTemplate();
            restTemplateq.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplateq.getRequestFactory()).setConnectTimeout(Utils.getRequestDelay());
            final String urlq = ServerAdress.getserverAdr() + "/Question/lQs/" + idCnt + "/" + idMs + "/";
            tabQs = restTemplateq.getForObject(urlq, Question.class);

            return tabQs;
        } catch (Exception ex) {
            Log.e("Excption", ex.toString());
        }
        return null;
    }

}
