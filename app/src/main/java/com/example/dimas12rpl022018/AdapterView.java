package com.example.dimas12rpl022018;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.dimas12rpl022018.Model;
import com.example.dimas12rpl022018.R;

import androidx.annotation.NonNull;
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
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        holder.tvNama.setText(dataList.get(position).getNama());
        holder.tvEmail.setText(dataList.get(position).getEmail());
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
            tvNama = itemView.findViewById(R.id.txtNama);
            tvEmail = itemView.findViewById(R.id.txtEmail);
        }
    }

}
