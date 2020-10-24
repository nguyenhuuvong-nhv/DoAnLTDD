package com.example.vongship_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class dangki extends AppCompatActivity {
    private TextView tvgoidangnhap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        tvgoidangnhap = (TextView)  findViewById(R.id.dangnhap);
        tvgoidangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangki.this, dangnhap.class);
                startActivity(intent);
            }
        });
    }
}