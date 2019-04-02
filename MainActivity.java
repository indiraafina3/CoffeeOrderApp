package com.codepolitan.coffeorderapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CheckBox etch1, etch2, etch3, etch4;
    TextView tvharga1, tvharga2, tvdrink1, tvdrink2;

    int totalharga1, totalharga2, totaldrink1, totaldrink2;

    int hargakopi = 5000;
    int hargakopi2 = 3000;

    int htopping1=2000;
    int htopping2=1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totaldrink1 = 1;
        totaldrink2 = 1;
        totalharga1 = hargakopi;
        totalharga2 = hargakopi2;

        etch1 = findViewById(R.id.ch1);
        etch2 =findViewById(R.id.ch2);
        etch3 = findViewById(R.id.ch3);
        etch4 = findViewById(R.id.ch4);

        tvdrink1 = findViewById(R.id.drink1);
        tvdrink2 = findViewById(R.id.drink2);
        tvharga1 = findViewById(R.id.harga1);
        tvharga2 = findViewById(R.id.harga2);

        tvharga1.setText("Rp."+hargakopi);
        tvharga2.setText("Rp."+hargakopi2);

        etch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    totalharga1+=htopping1;
                    tvharga1.setText("Rp."+totalharga1);
                }else totalharga1-=htopping1;
            }
        });
        etch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if (b) {
                    //htopping=2000;
                    totalharga1+=htopping1;
                    tvharga1.setText("Rp."+totalharga1);
                }else
                    //hargatopping=0;
                    totalharga1-=htopping1;
                tvharga1.setText("Rp."+totalharga1);
                //totalharga1= totaldrink1*hargakopi + (totaldrink1*htopping)
                //tvharga1.setText("Rp."+totalharga1);
            }
        });
    }

    public void minus(View view) {
        if(totaldrink1>1) {
            totaldrink1--;
            tvdrink1.setText("" + totaldrink1);
            totalharga1 = totaldrink1*hargakopi;
            tvharga1.setText("Rp."+totalharga1);
        }else {
            Toast.makeText(this, "Minimal pesanan adalah satu", Toast.LENGTH_SHORT).show();
        }
    }

    public void add(View view) {
        totaldrink1++;
        tvdrink1.setText(""+totaldrink1);
        totalharga1 = totaldrink1*hargakopi;
        tvharga1.setText("Rp."+totalharga1);
    }

    public void minus1(View view) {
        if(totaldrink2>1) {
            totaldrink2--;
            tvdrink2.setText("" + totaldrink2);
            totalharga2 = totaldrink2*hargakopi2;
            tvharga2.setText("Rp."+totalharga2);
        }else {
            Toast.makeText(this, "Minimal pesanan adalah satu", Toast.LENGTH_SHORT).show();
        }
    }


    public void add2(View view) {
        totaldrink2++;
        tvdrink2.setText(""+totaldrink2);
        totalharga2 = totaldrink2*hargakopi2;
        tvharga2.setText("Rp."+totalharga2);
    }
}
