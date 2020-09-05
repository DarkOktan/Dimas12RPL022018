package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityMainMenu extends AppCompatActivity {

    Button btn_costumer, btn_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        btn_costumer = findViewById(R.id.btn_data);
        btn_logout = findViewById(R.id.btn_logout);

        btn_costumer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMainMenu.this, AdminCostumerData.class);
                startActivity(intent);
            }
        });

        btn_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityMainMenu.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}