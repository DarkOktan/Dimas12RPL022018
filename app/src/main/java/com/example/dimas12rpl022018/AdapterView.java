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

public class AdapterView extends RecyclerView.Adapter<AdapterView.UserViewHolder> {

    private ArrayList<Model> dataList;
    View viewku;

    public AdapterView(ArrayList<Model> dataList) {
        this.dataList = dataList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        viewku = layoutInflater.inflate(R.layout.activity_admin_costumer_data, parent, false);
        return new UserViewHolder(viewku);

    }

    @Override
    public void onBindViewHolder(@NonNull final UserViewHolder holder, final int position) {
        Log.d("onResponse", dataList.get(position).getNama());

        holder.tvNama.setText(dataList.get(position).getNama());
        holder.tvEmail.setText(dataList.get(position).getEmail());
        holder.cvInbox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), EditCostumer.class);
                intent.putExtra("id", dataList.get(position).getId());
                intent.putExtra("nama", dataList.get(position).getNama());
                intent.putExtra("email", dataList.get(position).getEmail());
                intent.putExtra("nohp", dataList.get(position).getNohp());
                intent.putExtra("alamat", dataList.get(position).getAlamat());
                intent.putExtra("noktp", dataList.get(position).getNoktp());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class UserViewHolder extends RecyclerView.ViewHolder{
        private TextView tvNama, tvEmail;
        CardView cvInbox;

        UserViewHolder(View itemView) {
            super(itemView);
            cvInbox = itemView.findViewById(R.id.cvInbox);
            tvNama = itemView.findViewById(R.id.tvNama);
            tvEmail = itemView.findViewById(R.id.tvEmail);
        }
    }

}
