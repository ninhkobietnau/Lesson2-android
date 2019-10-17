package com.example.designlogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected TextView tvLogin;
    protected EditText edtFirstName , edtLastName , edtEmail , edtUser , edtPassword;
    protected Button btnCreateAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUp();
        Control();
    }

    private void Control() {
        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLogin = new Intent(MainActivity.this , Main2Activity.class);
                startActivity(intentLogin);
            }
        });

        btnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtFirstName.getText().length() != 0 && edtLastName.getText().length() != 0
                    && edtEmail.getText().length() != 0 && edtUser.getText().length() != 0
                    && edtPassword.getText().length() != 0) {

                    String ten = edtUser.getText().toString().trim();
                    String mk = edtPassword.getText().toString().trim();

                    Toast.makeText(MainActivity.this , "Bạn đã đăng ký thành công" , Toast.LENGTH_SHORT).show();

                    Intent intentCreateAccount = new Intent(MainActivity.this , Main2Activity.class);
                    intentCreateAccount.putExtra("ten" , ten);
                    intentCreateAccount.putExtra("mk" , mk);
                    startActivity(intentCreateAccount);
                } else {
                    Toast.makeText(MainActivity.this , "Hãy nhập đủ thông tin" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void SetUp() {
        edtFirstName = findViewById(R.id.editFirstName);
        edtLastName = findViewById(R.id.editLastName);
        edtEmail = findViewById(R.id.editEMail);
        edtUser = findViewById(R.id.editUser);
        edtPassword = findViewById(R.id.editPassword);
        tvLogin = findViewById(R.id.textViewLogInActivity);
        btnCreateAccount = findViewById(R.id.buttonCreateAccount);
    }
}
