package com.example.vongship_android;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class dangki extends AppCompatActivity {
    private TextView tvgoidangnhap;
    private CheckBox cp_policy;
    private EditText inputEmail, inputPassword, confirmPass;
    private Button btSignUp;
    private ProgressBar progressBar;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangki);
        tvgoidangnhap = (TextView)  findViewById(R.id.dangnhap);
        btSignUp = (Button) findViewById(R.id.bt_dangki);
        inputEmail = (EditText) findViewById(R.id.user_Signup);
        inputPassword = (EditText) findViewById(R.id.pass_Signup);
        confirmPass =(EditText) findViewById(R.id.confirmTv);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        cp_policy = (CheckBox) findViewById(R.id.policy);
        auth = FirebaseAuth.getInstance();



        tvgoidangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(dangki.this, dangnhap.class);
                startActivity(intent);
            }
        });

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String confirm = confirmPass.getText().toString().trim();

                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(getApplicationContext(), "Email không được trống!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(getApplicationContext(), "Nhập mật khẩu!", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu quá ngắn, trên 6 kí tự!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.equals(confirm)==false) {
                    Toast.makeText(getApplicationContext(), "Mật khẩu nhập không khớp!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (cp_policy.isChecked()==false){
                    Toast.makeText(getApplicationContext(), "Vui lòng đồng ý điều khoản, chính sách!", Toast.LENGTH_SHORT).show();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);
                //create user
                auth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(dangki.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(dangki.this, "Tạo tài khoản thành công:" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                                progressBar.setVisibility(View.GONE);
                                // If sign in fails, display a message to the user. If sign in succeeds
                                // the auth state listener will be notified and logic to handle the
                                // signed in user can be handled in the listener.
                                if (!task.isSuccessful()) {
                                    Toast.makeText(dangki.this, "Thất bại." + task.getException(),
                                            Toast.LENGTH_SHORT).show();
                                } else {
                                    startActivity(new Intent(dangki.this, MainActivity.class));
                                    finish();
                                }
                            }
                        });

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        progressBar.setVisibility(View.GONE);
    }
}