package com.example.manel.KidsBook.Model;

import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import com.example.manel.KidsBook.Entities.Mediascene;
import com.example.manel.KidsBook.webServiceConf.ServerAdress;
import com.example.manel.KidsBook.webServiceConf.Utils;

import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class MediasceneMOD {
    Context context;
    public MediasceneMOD(Context context) {
        this.context = context  ;
    }

    public Mediascene[] listMeds(int idconte){
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        try {
            RestTemplate restTemplate = new RestTemplate();
            restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
            ((SimpleClientHttpRequestFactory) restTemplate.getRequestFactory()).setConnectTimeout(Utils.getRequestDelay());
            final String url = ServerAdress.getserverAdr() + "/Mediascene/allMs/" + idconte + "/";
            Mediascene[] tabMs = restTemplate.getForObject(url, Mediascene[].class);
            //Toast.makeText(context, "dao tab length "+tabMs.length , Toast.LENGTH_LONG).show();
            //Log.e("tablengthid",""+idconte);
            //Log.e("tablength",""+tabMs.length);
            return tabMs;
        } catch (Exception ex) {
            Log.e("Excption dao", ex.toString());
        }
        return null;
    }

}
