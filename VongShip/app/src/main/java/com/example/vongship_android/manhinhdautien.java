package com.example.vongship_android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class manhinhdautien extends AppCompatActivity {

    private Button btgoidangnhap;
    private TextView tvgoidangki;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manhinhdautien);
        btgoidangnhap = (Button) findViewById(R.id.signinBt);
        tvgoidangki = (TextView)  findViewById(R.id.dangki);
        btgoidangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manhinhdautien.this, dangnhap.class);
                startActivity(intent);
            }
        });
        tvgoidangki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(manhinhdautien.this, dangki.class);
                startActivity(intent);
            }
        });
    }
}