package com.example.dimas12rpl022018;

import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dimas12rpl022018.Model;
import com.example.dimas12rpl022018.R;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterViewDataSepeda extends RecyclerView.Adapter<AdapterViewDataSepeda.UserViewHolder> {

    private ArrayList<MasterBarang> dataList;
    View viewku;

    public AdapterViewDataSepeda(ArrayList<MasterBarang> dataList){
        this.dataList = dataList;
        Log.d("Adapter", "Masuk Adapter");
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.adapterview_data_sepeda, parent, false);
        return new AdapterViewDataSepeda.UserViewHolder(viewku);

    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, final int position) {
        Log.d("Merk Sepeda", "GetMerk: " + dataList.get(position).getMerk());

        holder.tvMerk.setText(dataList.get(position).getMerk());
        holder.tvJenis.setText(dataList.get(position).getJenis());
        holder.tvWarna.setText(dataList.get(position).getWarna());
        holder.tvHargaSewa.setText(dataList.get(position).getHargasewa());

        holder.cvInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), EditDataSepedaActvity.class);
                intent.putExtra("id", dataList.get(position).getId());
                intent.putExtra("kode", dataList.get(position).getKode());
                intent.putExtra("merk", dataList.get(position).getMerk());
                intent.putExtra("jenis", dataList.get(position).getJenis());
                intent.putExtra("warna", dataList.get(position).getWarna());
                intent.putExtra("hargasewa", dataList.get(position).getHargasewa());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() { return dataList.size(); }

    class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvMerk, tvJenis, tvWarna, tvHargaSewa;
        CardView cvInbox;

        UserViewHolder(View adapterView) {
            super(adapterView);
            cvInbox = adapterView.findViewById(R.id.cvInboxDataSepeda);
            tvMerk = adapterView.findViewById(R.id.tvMerk);
            tvJenis = adapterView.findViewById(R.id.tvJenis);
            tvWarna = adapterView.findViewById(R.id.tvWarna);
            tvHargaSewa = adapterView.findViewById(R.id.tvHargaSewa);
        }
    }
}
