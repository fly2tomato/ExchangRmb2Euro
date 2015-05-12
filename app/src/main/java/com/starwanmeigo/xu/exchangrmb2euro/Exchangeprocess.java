package com.starwanmeigo.xu.exchangrmb2euro;


/**
 * Created by xu on 08.04.15.
 */
public class Exchangeprocess {

    float euro;
    float rate;

    public Exchangeprocess(float euro, float rate){
        this.euro = euro;
        this.rate = rate;
    }

    public float getRmb(){
        return (float)(euro*rate);
    }
}
