package com.example.vongship_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dangnhap extends AppCompatActivity {

    private TextView tvgoidangki;
    private TextView tvgoiquenmatkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        tvgoidangki = (TextView)  findViewById(R.id.dangki);
        tvgoiquenmatkhau = (TextView) findViewById(R.id.forgotTv);

        tvgoidangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, dangki.class);
                startActivity(intent);
            }
        });
        tvgoiquenmatkhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, quenmatkhau.class);
                startActivity(intent);
            }
        });

    }
}