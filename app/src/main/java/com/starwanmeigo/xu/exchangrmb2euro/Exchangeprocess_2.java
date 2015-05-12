package com.starwanmeigo.xu.exchangrmb2euro;

/**
 * Created by xu on 24.04.15.
 */
public class Exchangeprocess_2 {

    float rmb;
    float rate;

    public Exchangeprocess_2(float rmb, float rate){
        this.rmb = rmb;
        this.rate = rate;
    }

    public float getEuro(){
        return (float)(rmb/rate);
    }
}
