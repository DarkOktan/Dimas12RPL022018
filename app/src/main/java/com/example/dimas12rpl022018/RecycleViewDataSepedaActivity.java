package com.example.dimas12rpl022018;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerViewAccessibilityDelegate;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class RecycleViewDataSepedaActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private AdapterViewDataSepeda adapter;

    ArrayList<MasterBarang> datalist;

    CardView cvInbox;

    TextView tvKode, tvMerk, tvJenis, tvWarna, tvHargaSewa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle_view_data_sepeda);

        cvInbox = findViewById(R.id.cvInboxDataSepeda);
        tvKode = findViewById(R.id.txtKode);
        tvMerk = findViewById(R.id.txtMerk);
        tvJenis = findViewById(R.id.txtJenis);
        tvWarna = findViewById(R.id.txtWarna);
        tvHargaSewa = findViewById(R.id.txtHargaSewa);
        recyclerView = findViewById(R.id.listdatasepeda);

        datalist = new ArrayList<>();

        Log.d("Response", "onCreate: ");

        AndroidNetworking.post(BaseUrl.url + "getdatasepeda.php")
                .setTag("test")
                .setPriority(Priority.MEDIUM)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray data = response.getJSONArray("result");

                            Log.d("OnResponse", "Data Sepeda View");
                            for (int i = 0; i < data.length(); i++) {

                                MasterBarang modelSepeda = new MasterBarang();
                                JSONObject object = data.getJSONObject(i);
                                modelSepeda.setId(object.getString("id"));
                                modelSepeda.setKode(object.getString("kode"));
                                modelSepeda.setMerk(object.getString("merk"));
                                modelSepeda.setJenis(object.getString("jenis"));
                                modelSepeda.setWarna(object.getString("warna"));
                                modelSepeda.setHargasewa(object.getString("hargasewa"));
                                datalist.add(modelSepeda);

                            }

                            adapter = new AdapterViewDataSepeda(datalist);

                            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(RecycleViewDataSepedaActivity.this);

                            recyclerView.setLayoutManager(layoutManager);

                            recyclerView.setAdapter(adapter);

                            Log.d("pay1", "onResponse: " + response.getJSONArray("result"));
                            Log.d("Response", "Length: " + datalist.size());

                            if (response.getJSONArray("result").length() == 0){

                                recyclerView.setVisibility(View.GONE);

                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError anError) {
                        Log.d("geo", "onResponse: " + anError.toString());
                        Log.d("geo", "onResponse: " + anError.getErrorBody());
                        Log.d("geo", "onResponse: " + anError.getErrorCode());
                        Log.d("geo", "onResponse: " + anError.getErrorDetail());
                    }
                });
    }
}