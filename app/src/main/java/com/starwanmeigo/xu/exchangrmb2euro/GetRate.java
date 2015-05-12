package com.starwanmeigo.xu.exchangrmb2euro;

import android.os.StrictMode;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * Created by xu on 24.04.15.
 */
public class GetRate {
    public float GetRate(){
        manageException();
        Document doc_1 = null;
        try {
            doc_1 = Jsoup.connect("http://www.kuaiyilicai.com/uprate/eur.html").get();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String myString = doc_1.body().text();
        String huiLv = myString.substring(myString.indexOf("币:")+3);
        String huiLv_2 =huiLv.substring(huiLv.indexOf(""),huiLv.indexOf("(")-1);
        Document doc_2 = Jsoup.parse(huiLv_2);

        Log.i("..................", doc_2.body().text() + ".");
        String rateFLoatString = doc_2.body().text().replace("&nbsp;","");
        Log.i("..................",rateFLoatString+".");
        final float rateFloat = Float.parseFloat(rateFLoatString);
        /*Rate.setText(rateFLoatString)*/;
        return rateFloat;
    }

    public void manageException() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder()
                .detectDiskReads().detectDiskWrites().detectNetwork() // or
                        // .detectAll()
                        // for
                        // all
                        // detectable
                        // problems
                .penaltyLog().build());
        StrictMode.setVmPolicy(new StrictMode.VmPolicy.Builder()
                .detectLeakedSqlLiteObjects().penaltyLog().penaltyDeath()
                .build());
    }
}
