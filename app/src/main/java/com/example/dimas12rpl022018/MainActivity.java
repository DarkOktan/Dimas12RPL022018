package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt_username;
    EditText txt_password;
    Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = (Button)findViewById(R.id.btnLogin);
        txt_username = (EditText)findViewById(R.id.txtUsername);
        txt_password = (EditText)findViewById(R.id.txtPassword);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (txt_username.getText().toString().equalsIgnoreCase("admin") && txt_password.getText().toString().equalsIgnoreCase("pw003360")) {
                    Toast.makeText(getApplicationContext(), "Thank you for LOGIN!", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(), "Username/Password is Invalid", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}