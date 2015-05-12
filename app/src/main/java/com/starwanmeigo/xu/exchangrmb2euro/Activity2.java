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
import android.widget.EditText;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class Activity2 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity2);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final float rateFloat = bundle.getFloat("rate");

        final EditText Euro = (EditText) findViewById(R.id.euro);
        final TextView Rmb = (TextView) findViewById(R.id.rmb);
        final TextView Rate = (TextView) findViewById(R.id.rate);
        Button exchange_Rate = (Button) findViewById(R.id.exchange_button);

        Rate.setText(Float.toString(rateFloat));

        exchange_Rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String Euro_Str = Euro.getText().toString();
                //String Rate_Str = Rate.getText().toString();
                float euroFloat = Float.parseFloat(Euro_Str);
                //float rateFloat = Float.parseFloat(Rate_Str);
                Exchangeprocess exchangeprocess = new Exchangeprocess( euroFloat,rateFloat);
                float rmbFloat = exchangeprocess.getRmb();
                Rmb.setText(Float.toString(rmbFloat));
            }
        });

    }
}
