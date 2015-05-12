package com.starwanmeigo.xu.exchangrmb2euro;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button buttonEuro = (Button) findViewById(R.id.buttoneuro);
        final Button buttonRmb = (Button) findViewById(R.id.buttonrmb);

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
        final String rateFLoatString = doc_2.body().text().replace("&nbsp;","");
        Log.i("..................",rateFLoatString+".");
        final float rateFloat = Float.parseFloat(rateFLoatString);

        buttonEuro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("rate",rateFloat);
                intent.putExtras(bundle);
                startActivity(intent);

            }
        });


        buttonRmb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Activity3.class);
                Bundle bundle = new Bundle();
                bundle.putFloat("rate",rateFloat);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


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
