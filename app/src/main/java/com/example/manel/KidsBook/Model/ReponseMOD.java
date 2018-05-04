package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.util.Log;

import com.example.manel.KidsBook.Entities.Reponse;
import com.example.manel.KidsBook.webServiceConf.ServerAdress;
import com.example.manel.KidsBook.webServiceConf.Utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ReponseMOD {

    private int idQs;
    private Context context;

    public ReponseMOD(Context context, int idQs) {
        this.context = context;
        this.idQs = idQs;
    }

    public Reponse rep() {
        Reponse rep;
        try {
            RestTemplate restTemplateq = new RestTemplate();
            restTemplateq.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplateq.getRequestFactory()).setConnectTimeout(Utils.getRequestDelay());
            final String urlr = ServerAdress.getserverAdr() + "/Question/Rs/" + idQs + "/";
            rep = restTemplateq.getForObject(urlr, Reponse.class);
            return rep;
        } catch (Exception ex) {
            Log.e("Excption", ex.toString());
        }
        return null;
    }
}
