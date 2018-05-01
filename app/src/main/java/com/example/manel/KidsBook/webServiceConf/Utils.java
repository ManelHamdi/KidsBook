package com.example.manel.KidsBook.webServiceConf;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;

/**
 * Created by manel on 10/04/2018.
 */

public class Utils {
    public static int getRequestDelay() {
        return 2000;
    }

    public static String getCaptcha() {
        int len = 6;
        String AB = "123456789ABCDEFGH";
        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String DateConverter(String UserDate) {
        SimpleDateFormat fromUser = new SimpleDateFormat("ddMMyyyy");
        SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            return myFormat.format(fromUser.parse(UserDate));
        } catch (Exception e) {
            return UserDate;
        }

    }

    private static boolean haveNetworkConnection(Context mContext) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;
        ConnectivityManager cm = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }


}