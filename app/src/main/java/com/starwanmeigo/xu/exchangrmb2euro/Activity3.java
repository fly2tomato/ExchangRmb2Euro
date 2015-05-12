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


public class Activity3 extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity3);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        final float rateFloat = bundle.getFloat("rate");

        final TextView Euro = (TextView) findViewById(R.id.euro);
        final EditText Rmb = (EditText) findViewById(R.id.rmb);
        final TextView Rate = (TextView) findViewById(R.id.rate);
        Button exchange_Rate = (Button) findViewById(R.id.exchange_button);

        Rate.setText(Float.toString(rateFloat));

        exchange_Rate.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String Rmb_Str = Rmb.getText().toString();
                //String Rate_Str = Rate.getText().toString();
                float rmbFloat = Float.parseFloat(Rmb_Str);
                //float rateFloat = Float.parseFloat(Rate_Str);
                Exchangeprocess_2 exchangeprocess_2 = new Exchangeprocess_2( rmbFloat,rateFloat);
                float euroFloat = exchangeprocess_2.getEuro();
                Euro.setText(Float.toString(euroFloat));
            }
        });
    }
}
