package com.example.fuelshow;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class myAdpt extends RecyclerView.Adapter<myAdpt.myviewH> {

ArrayList<fuelEff> dataholder;

    public myAdpt(ArrayList<fuelEff> dataholder) {
        this.dataholder = dataholder;
    }

    @NonNull
    @Override
    public myviewH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_singlerow,parent,false);
       return new myviewH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewH holder, int position) {
        holder.newdate.setText(dataholder.get(position).getDate());
        holder.newtime.setText(dataholder.get(position).getTime());
        holder.fuelrsperltr.setText(dataholder.get(position).getRsperltr());
        holder.fuellitres.setText(dataholder.get(position).getLitres());
        holder.fueldkm.setText(dataholder.get(position).getDkm());
        holder.fueldprice.setText(dataholder.get(position).getDprice());
    }

    @Override
    public int getItemCount() {
        return dataholder.size();
    }

    class myviewH extends RecyclerView.ViewHolder{

        EditText newdate,newtime,fuelrsperltr,fuellitres,fueldkm;
        TextView fueldprice;
        public myviewH(@NonNull View itemView) {
            super(itemView);
            newdate = (EditText)itemView.findViewById((R.id.date));
            newtime = (EditText)itemView.findViewById((R.id.time));
            fuelrsperltr  = (EditText)itemView.findViewById((R.id.id_rsperltr));
            fuellitres = (EditText)itemView.findViewById((R.id.id_litres));
            fueldkm = (EditText)itemView.findViewById((R.id.id_km));
            fueldprice = (TextView)itemView.findViewById((R.id.id_avg_eco));

        }
    }
}
