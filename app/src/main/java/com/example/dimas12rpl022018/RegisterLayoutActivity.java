package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterLayoutActivity extends AppCompatActivity {

    EditText txtNama, txtEmail, txtPassword, txtNoktp, txtNohp, txtAlamat;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        txtNama = findViewById(R.id.txtregname);
        txtEmail = findViewById(R.id.txtregemail);
        txtPassword = findViewById(R.id.txtregpassword);
        txtNoktp = findViewById(R.id.txtregnoktp);
        txtNohp = findViewById(R.id.txtregnohp);
        txtAlamat = findViewById(R.id.txtregalamat);
        btnRegister = findViewById(R.id.btn_registeration);


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nama = txtNama.getText().toString();
                String email = txtEmail.getText().toString();
                String noKtp = txtNoktp.getText().toString();
                String noHp = txtNohp.getText().toString();
                String alamat = txtAlamat.getText().toString();
                String password = txtPassword.getText().toString().trim();
                AndroidNetworking.post(BaseUrl.url + "login.php")
                        .addBodyParameter("noktp", noKtp)
                        .addBodyParameter("email", email)
                        .addBodyParameter("password", password)
                        .addBodyParameter("nama", nama)
                        .addBodyParameter("nohp", noHp)
                        .addBodyParameter("alamat", alamat)
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("hasil", "onResponse: ");
                                try {
                                    JSONObject status = response.getJSONObject("STATUS");
                                    JSONObject message = response.getJSONObject("MESSAGE");
                                    Log.d("STATUS", "onResponse: " + status);
                                    if (status.equals("SUCCESS")) {
                                        Intent intent = new Intent(RegisterLayoutActivity.this, DasboardLayoutActivity.class);
                                        startActivity(intent);
                                        finish();
                                    } else {
                                        Toast.makeText(RegisterLayoutActivity.this, message.toString(), Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {

                            }
                        });
            }});
    }
}