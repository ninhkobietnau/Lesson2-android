package com.example.designlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    protected TextView tvSignUp;
    protected Button btnLogin , btnBack;
    protected EditText edtUserLogin , edtPasswordLogin ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        SetUp();
        Control();
    }

    private void Control() {
        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentSignUp = new Intent(Main2Activity.this , MainActivity.class);
                startActivity(intentSignUp);
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentBack = new Intent(Main2Activity.this , MainActivity.class);
                startActivity(intentBack);
            }
        });

        Intent intent = this.getIntent();
        final String ten = intent.getStringExtra("ten");
        final String mk = intent.getStringExtra("mk");

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtUserLogin.getText().length() != 0 && edtPasswordLogin.getText().length() != 0) {
                    if (edtUserLogin.getText().toString().equals(ten) && edtPasswordLogin.getText().toString().equals(mk)) {
                        Toast.makeText(Main2Activity.this , "Bạn đã đăng nhập thành công",Toast.LENGTH_SHORT).show();
                        Intent intentLogin = new Intent(Main2Activity.this , Main3Activity.class);
                        startActivity(intentLogin);
                    } else {
                        Toast.makeText(Main2Activity.this , "Sai tên tài khoản hoặc mật khẩu !",Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(Main2Activity.this , "Hãy nhập đầy đủ thông tin !",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SetUp() {
        btnBack = findViewById(R.id.buttonBack);
        btnLogin = findViewById(R.id.buttonLogin);
        edtUserLogin = findViewById(R.id.editUserLogin);
        edtPasswordLogin = findViewById(R.id.editPasswordLogin);
        tvSignUp = findViewById(R.id.textViewSignUp);
    }
}
