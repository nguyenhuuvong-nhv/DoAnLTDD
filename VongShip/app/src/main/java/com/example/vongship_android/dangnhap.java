package com.example.vongship_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class dangnhap extends AppCompatActivity {
    private Button btdangnhap;
    private TextView tvgoidangki;
    private TextView tvgoiquenmatkhau;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangnhap);
        btdangnhap = (Button) findViewById(R.id.dangnhap);
        tvgoidangki = (TextView)  findViewById(R.id.dangki);
        tvgoiquenmatkhau = (TextView) findViewById(R.id.forgotTv);

        btdangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangnhap.this, MainActivity.class);
                startActivity(intent);
            }
        });
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