package com.profit.stockcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
Button trget1,trget2,trget3;
TextView security_nm,bbuy1,bbuy2,bbuy3,bbuy4,bbuy5,qqty1,qqty2,qqty3,qqty4,qqty5,ttotal1,ttotal2,ttotal3,ttotal4,ttotal5,avg,profit_percentage,total_invested,profit_text,sell;
int total_investments_count=0;
Integer selling_price;
    String total_val;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);
        trget1 = findViewById(R.id.target1);
        trget2 = findViewById(R.id.target2);
        trget3 = findViewById(R.id.target3);
        security_nm = findViewById(R.id.security_nm);
        bbuy1 = findViewById(R.id.buy1);
        bbuy2 = findViewById(R.id.buy2);
        bbuy3 = findViewById(R.id.buy3);
        bbuy4 = findViewById(R.id.buy4);
        bbuy5 = findViewById(R.id.buy5);
        qqty1 =findViewById(R.id.qnty1);
        qqty2 =findViewById(R.id.qnty2);
        qqty3 =findViewById(R.id.qnty3);
        qqty4 =findViewById(R.id.qnty4);
        qqty5 =findViewById(R.id.qnty5);
        ttotal1=findViewById(R.id.total1);
        ttotal2=findViewById(R.id.total2);
        ttotal3=findViewById(R.id.total3);
        ttotal4=findViewById(R.id.total4);
        ttotal5=findViewById(R.id.total5);
        avg=findViewById(R.id.avg);
        sell=findViewById(R.id.sp);
        profit_percentage=findViewById(R.id.pprpfit_percentage);
        total_invested=findViewById(R.id.tot_invested_amt);
        profit_text=findViewById(R.id.total_profit);
        Bundle bundle=getIntent().getExtras();
        String sec_buy1 = bundle.getString("intent_buy1");
        String sec_buy2= bundle.getString("intent_buy2");
        String sec_buy3 = bundle.getString("intent_buy3");
        String sec_buy4 = bundle.getString("intent_buy4");
        String sec_buy5 = bundle.getString("intent_buy5");
        String sec_qt1 = bundle.getString("intent_qt1");
        String sec_qt2 = bundle.getString("intent_qt2");
        String sec_qt3 = bundle.getString("intent_qt3");
        String sec_qt4 = bundle.getString("intent_qt4");
        String sec_qt5 = bundle.getString("intent_qt5");
        String sec_tt1 =bundle.getString("intent_tt1");
        String sec_tt2 =bundle.getString("intent_tt2");
        String sec_tt3 =bundle.getString("intent_tt3");
        String sec_tt4 =bundle.getString("intent_tt4");
        String sec_tt5 =bundle.getString("intent_tt5");
        String sec_security_name=bundle.getString("security_name");
         total_val = bundle.getString("intent_total_total_value");
        String t1 =bundle.getString("intent_t1");
        String t2 =bundle.getString("intent_t2");
        String t3 =bundle.getString("intent_t3");
        Log.e("second","oncreate"+sec_buy1);
       security_nm.setText(sec_security_name);
       trget1.setText(t1);
       trget2.setText(t2);
       trget3.setText(t3);
       bbuy1.setText(sec_buy1);
        bbuy2.setText(sec_buy2);
        bbuy3.setText(sec_buy3);
        bbuy4.setText(sec_buy4);
        bbuy5.setText(sec_buy5);
       qqty1.setText(sec_qt1);
        qqty2.setText(sec_qt2);
        qqty3.setText(sec_qt3);
        qqty4.setText(sec_qt4);
        qqty5.setText(sec_qt5);
       ttotal1.setText(sec_tt1);
       total_invested.setText(total_val);
       total_investments_count= Integer.parseInt(sec_qt1);


       if(!(sec_tt2.equals("0")))
       {

           ttotal2.setText(sec_tt2);
total_investments_count=total_investments_count+Integer.parseInt(sec_qt2);
       }
        if(!(sec_tt3.equals("0")))
        {
            ttotal3.setText(sec_tt3);
            total_investments_count=total_investments_count+Integer.parseInt(sec_qt3);
        }
            if(!(sec_tt4.equals("0")))
            {
                ttotal4.setText(sec_tt4);
                total_investments_count=total_investments_count+Integer.parseInt(sec_qt4);
            }
                if(!(sec_tt5.equals("0")))
                {
                    ttotal5.setText(sec_tt5);
                    total_investments_count=total_investments_count+Integer.parseInt(sec_qt5);
                }


Integer sec_total = Integer.valueOf(total_val);
        Integer avg1 = sec_total/total_investments_count;
        String avg_text = String.valueOf(avg1);
        avg.setText(avg_text);
        selling_price= Integer.valueOf(t1);
        Integer tot_selling_price = selling_price*total_investments_count;
        Integer tot_buying_price = sec_total;
        double fixed_charges = 0.01+0.01+0.02+0.02;
        double profit = tot_selling_price-tot_buying_price-fixed_charges;
        double profit_p = (profit/tot_buying_price)*100;
        String pp= String.valueOf(profit_p);
        String pp1  =pp+"%";
        profit_percentage.setText(pp1);
        String p_profit = String.valueOf(profit);
        profit_text.setText(p_profit);
        String spp = String.valueOf(tot_selling_price);
        sell.setText(spp);
        final Boolean target1=true;
trget1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        trget1.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget2.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget1.setTextColor(getResources().getColor(R.color.colorwhite));
        trget2.setTextColor(getResources().getColor(R.color.colorBlack));
        trget3.setTextColor(getResources().getColor(R.color.colorBlack));
        Integer sec_total = Integer.valueOf(total_val);
        Integer avg1 = sec_total/total_investments_count;
        String avg_text = String.valueOf(avg1);
        avg.setText(avg_text);
        selling_price= Integer.valueOf(trget1.getText().toString());
        Integer tot_selling_price = selling_price*total_investments_count;
        Integer tot_buying_price = sec_total;
        double fixed_charges = 0.01+0.01+0.02+0.02;
        double profit = tot_selling_price-tot_buying_price-fixed_charges;
        double profit_p = (profit/tot_buying_price)*100;
        String pp= String.valueOf(profit_p);
        String pp1  =pp+"%";
        profit_percentage.setText(pp1);
        String p_profit = String.valueOf(profit);
        profit_text.setText(p_profit);
        String spp = String.valueOf(tot_selling_price);
        sell.setText(spp);
    }
});
trget2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        trget2.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget1.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget2.setTextColor(getResources().getColor(R.color.colorwhite));
        trget1.setTextColor(getResources().getColor(R.color.colorBlack));
        trget3.setTextColor(getResources().getColor(R.color.colorBlack));
        Integer sec_total = Integer.valueOf(total_val);
        Integer avg1 = sec_total/total_investments_count;
        String avg_text = String.valueOf(avg1);
        avg.setText(avg_text);
        selling_price= Integer.valueOf(trget2.getText().toString());
        Integer tot_selling_price = selling_price*total_investments_count;
        Integer tot_buying_price = sec_total;
        double fixed_charges = 0.01+0.01+0.02+0.02;
        double profit = tot_selling_price-tot_buying_price-fixed_charges;
        double profit_p = (profit/tot_buying_price)*100;
        String pp= String.valueOf(profit_p);
        String pp1  =pp+"%";
        profit_percentage.setText(pp1);
        String p_profit = String.valueOf(profit);
        profit_text.setText(p_profit);
        String spp = String.valueOf(tot_selling_price);
        sell.setText(spp);
    }
});
trget3.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        trget3.setBackgroundColor(getResources().getColor(R.color.lightblue));
        trget1.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget2.setBackgroundColor(getResources().getColor(R.color.darkgray));
        trget3.setTextColor(getResources().getColor(R.color.colorwhite));
        trget2.setTextColor(getResources().getColor(R.color.colorBlack));
        trget1.setTextColor(getResources().getColor(R.color.colorBlack));
        Integer sec_total = Integer.valueOf(total_val);
        Integer avg1 = sec_total/total_investments_count;
        String avg_text = String.valueOf(avg1);
        avg.setText(avg_text);
        selling_price= Integer.valueOf(trget3.getText().toString());
        Integer tot_selling_price = selling_price*total_investments_count;
        Integer tot_buying_price = sec_total;
        double fixed_charges = 0.01+0.01+0.02+0.02;
        double profit = tot_selling_price-tot_buying_price-fixed_charges;
        double profit_p = (profit/tot_buying_price)*100;
        String pp= String.valueOf(profit_p);
        String pp1  =pp+"%";
        profit_percentage.setText(pp1);
        String p_profit = String.valueOf(profit);
        profit_text.setText(p_profit);
        String spp = String.valueOf(tot_selling_price);
        sell.setText(spp);
    }
});
    }
//    protected void removeBlinkingText(Button txt) {
//
//    }
//    protected void startBlinkingText(Button txt) {
//        ObjectAnimator anim = ObjectAnimator.ofInt(trget1,"backgroundColor", Color.WHITE,Color.RED,Color.WHITE);
//        anim.setDuration(800);
//        anim.setEvaluator(new ArgbEvaluator());
//        anim.setRepeatMode(ValueAnimator.REVERSE);
//        anim.setRepeatCount(Animation.INFINITE);
//        anim.start();
//
//    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("second","onstart");
    }
}
