package com.example.manel.KidsBook.Model;

import android.util.Log;

import com.example.manel.KidsBook.Entities.Conte;
import com.example.manel.KidsBook.webServiceConf.ServerAdress;
import com.example.manel.KidsBook.webServiceConf.Utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class ConteMOD {

    public Conte[] listcnt() {
        Conte[] lstcnt;

        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(Utils.getRequestDelay());
            final String url = ServerAdress.getserverAdr() + "/Conte/allConte/";
            lstcnt = restTemplate.getForObject(url, Conte[].class);

            return lstcnt;
        } catch (Exception ex) {
            Log.e("Excption", ex.toString());
        }
        return null;
    }
}
