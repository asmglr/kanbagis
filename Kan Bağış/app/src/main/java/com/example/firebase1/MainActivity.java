package com.example.firebase1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText et_isim, et_yas, et_kan, et_telefon, et_sehir;
    Button btn_kaydet,btn_guncelle, btn_Sil;
    GridView grid;
    Bagiscilar secilen;
    GridViewAdapter gridViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_isim=(EditText) findViewById(R.id.et_isim);
        et_yas=(EditText) findViewById(R.id.et_yas);
        et_kan= (EditText) findViewById(R.id.et_kan);
        et_telefon= (EditText) findViewById(R.id.et_telefon);
        et_sehir= (EditText) findViewById(R.id.et_sehir);
        btn_kaydet = (Button) findViewById(R.id.btn_kaydet);
        btn_guncelle = (Button) findViewById(R.id.btn_Guncelle);
        btn_Sil = (Button) findViewById(R.id.btn_Sil);
        grid= (GridView) findViewById(R.id.grid);

        final ArrayList<Bagiscilar> veriler=new ArrayList<Bagiscilar>();

        final DatabaseReference baglanti = FirebaseDatabase.getInstance().getReference("Bagiscilar");
baglanti.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
       veriler.clear();

        for(DataSnapshot ds: dataSnapshot.getChildren())
        {
            veriler.add(new Bagiscilar(ds.child("id").getValue().toString(),
                    ds.child("isim").getValue().toString(),
                    ds.child("yas").getValue().toString(),
                    ds.child("kan").getValue().toString(),
                    ds.child("telefon").getValue().toString(),
                    ds.child("sehir").getValue().toString()));
        }
        gridViewAdapter =new GridViewAdapter(MainActivity.this,veriler);
        grid.setAdapter(gridViewAdapter);


    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {

    }

});

btn_Sil.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String id = secilen.getId();
        baglanti.child(id).removeValue();
        et_isim.setText("");
        et_yas.setText("");
        et_kan.setText("");
        et_telefon.setText("");
        et_sehir.setText("");
    }
});

btn_guncelle.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        String id= secilen.getId();
        Bagiscilar guncelBagis= new Bagiscilar(id,et_isim.getText().toString(),et_yas.getText().toString(),et_kan.getText().toString(),et_telefon.getText().toString(),et_sehir.getText().toString());
        baglanti.child(id).setValue(guncelBagis);
        et_isim.setText("");
        et_yas.setText("");
        et_kan.setText("");
        et_telefon.setText("");
        et_sehir.setText("");
    }
});

grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

        secilen = gridViewAdapter.getItem(i);
        et_isim.setText(secilen.getIsim());
        et_yas.setText(secilen.getYas());
        et_kan.setText(secilen.getKan());
        et_telefon.setText(secilen.getTelefon());
        et_sehir.setText(secilen.getSehir());

    }
});

        btn_kaydet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id= baglanti.push().getKey();
                Bagiscilar yeniBagislar= new Bagiscilar(id,et_isim.getText().toString(),et_yas.getText().toString(),et_kan.getText().toString(),et_telefon.getText().toString(),et_sehir.getText().toString());
                baglanti.child(id).setValue(yeniBagislar);
                et_isim.setText("");
                et_yas.setText("");
                et_kan.setText("");
                et_telefon.setText("");
                et_sehir.setText("");
            }
        });

    }
}