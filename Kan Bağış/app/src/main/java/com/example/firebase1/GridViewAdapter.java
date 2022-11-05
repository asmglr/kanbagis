package com.example.firebase1;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class GridViewAdapter extends BaseAdapter {
    ArrayList<Bagiscilar> gelenbagiscilar = new ArrayList<Bagiscilar>();
    LayoutInflater layoutInflater;
    Context context;

    public GridViewAdapter(Activity activity, ArrayList<Bagiscilar> gelenbagiscilar)
    {
        this.gelenbagiscilar=gelenbagiscilar;
        this.context=activity;
        this.layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); //Layout inflater service ile oluştur
    }

    @Override
    public int getCount() {

        return gelenbagiscilar.size();
    }

    @Override
    public Bagiscilar getItem(int i) {

        return gelenbagiscilar.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View olustur= layoutInflater.inflate(R.layout.gridviewlayout,null);

        TextView tv_id= (TextView) olustur.findViewById(R.id.tv_id);
        TextView tv_isim= (TextView) olustur.findViewById(R.id.tv_isim);
        TextView tv_yas= (TextView) olustur.findViewById(R.id.tv_yas);
        TextView tv_kan= (TextView) olustur.findViewById(R.id.tv_kan);
        TextView tv_telefon= (TextView) olustur.findViewById(R.id.tv_telefon);
        TextView tv_sehir= (TextView) olustur.findViewById(R.id.tv_sehir);

        int sira= i+1;

        tv_id.setText(String.valueOf(sira));
        tv_isim.setText(gelenbagiscilar.get(i).getIsim());
        tv_yas.setText(gelenbagiscilar.get(i).getYas());
        tv_kan.setText(gelenbagiscilar.get(i).getKan());
        tv_telefon.setText(gelenbagiscilar.get(i).getTelefon());
        tv_sehir.setText(gelenbagiscilar.get(i).getSehir());
        return olustur;
    }
}
