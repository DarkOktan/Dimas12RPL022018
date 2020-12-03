package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class AddDataSepedaActivity extends AppCompatActivity {

    EditText txtKode, txtMerk, txtJenis, txtWarna,  txtHargaSewa;
    Button btnAdd, btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data_sepeda);

        txtKode = findViewById(R.id.txtkode);
        txtMerk = findViewById(R.id.txtmerk);
        txtJenis = findViewById(R.id.txtjenis);
        txtWarna = findViewById(R.id.txtwarna);
        txtHargaSewa = findViewById(R.id.txthargasewa);
        btnAdd = findViewById(R.id.btn_addsepeda);
        btnReset = findViewById(R.id.btn_resetSepeda);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String kode = txtKode.getText().toString();
                String merk = txtMerk.getText().toString();
                String jenis = txtJenis.getText().toString();
                String warna = txtWarna.getText().toString();
                String hargasewa = txtHargaSewa.getText().toString();
                AndroidNetworking.post(BaseUrl.url + "insertdatasepeda.php")
                        .addBodyParameter("kode", kode)
                        .addBodyParameter("merk", merk)
                        .addBodyParameter("jenis", jenis)
                        .addBodyParameter("warna", warna)
                        .addBodyParameter("hargasewa", hargasewa)
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("hasil", "onResponse: ");
                                try {
                                    Log.d("RegisterResponse", "Masuk");

                                    JSONObject result = response.getJSONObject("Result");
                                    String status = result.getString("STATUS");

                                    if (status.equals("SUCCESS")){
                                        Log.d("RegisterResponse", "Done");

                                        Intent intent = new Intent(AddDataSepedaActivity.this, RecycleViewDataSepedaActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Log.d("Soy", "onError: " + anError.getErrorBody());
                                Log.d("Soy", "onError: " + anError.getLocalizedMessage());
                                Log.d("Soy", "onError: " + anError.getErrorDetail());
                                Log.d("Soy", "onError: " + anError.getResponse());
                                Log.d("Soy  ", "onError: " + anError.getErrorCode());
                            }
                        });
            }});

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddDataSepedaActivity.this, AddDataSepedaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}