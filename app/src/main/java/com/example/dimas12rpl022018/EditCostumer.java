package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class EditCostumer extends AppCompatActivity {

    TextView tvId;
    EditText etNama, etEmai, etNoHp, EtAlamat, etNoKtp;
    Button btnEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_costumer);

        tvId = findViewById(R.id.tvId);
        etNama = findViewById(R.id.txtNama);
        etEmai = findViewById(R.id.txtEmail);
        etNoHp = findViewById(R.id.txtNohp);
        EtAlamat = findViewById(R.id.txtAlamat);
        etNoKtp = findViewById(R.id.txtNoktp);
        btnEdit = findViewById(R.id.btnEdit);

        Bundle extras = getIntent().getExtras();
        final String id = extras.getString("id");
        final String nama = extras.getString("nama");
        final String email = extras.getString("email");
        final String nohp = extras.getString("nohp");
        final String alamat = extras.getString("alamat");
        final String noktp = extras.getString("noktp");

        tvId.setText("Id :" + id);
        etNama.setText(nama);
        etEmai.setText(email);
        etNoHp.setText(nohp);
        EtAlamat.setText(alamat);
        etNoKtp.setText(noktp);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AndroidNetworking.post(BaseUrl.url + "edit_data.php")
                        .addBodyParameter("id", id)
                        .addBodyParameter("nama", etNama.getText().toString())
                        .addBodyParameter("email", etEmai.getText().toString())
                        .addBodyParameter("nohp", etNoHp.getText().toString())
                        .addBodyParameter("alamat", EtAlamat.getText().toString())
                        .addBodyParameter("noktp", etNoKtp.getText().toString())
                        .setPriority(Priority.LOW)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("onResponse" , "Edited");

                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    boolean sukses = hasil.getBoolean("respon");
                                    if (sukses) {
                                        Intent returnIntent = new Intent(EditCostumer.this, AdminCostumerData.class);
                                        returnIntent.putExtra("refresh", "refresh");
                                        startActivity(returnIntent);
                                        finish();
                                        Toast.makeText(EditCostumer.this, "Edit Suskses", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(EditCostumer.this, "Edit gagal", Toast.LENGTH_SHORT).show();
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onError(ANError anError) {
                                Log.d("OnResponse", "No Connection");
                            }
                        });
            }
        });
    }
}