 package com.example.onmad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Themsinhvien extends AppCompatActivity {
EditText etensv,eque,ens,enh;
Button themsv,btnlietke;
ListView lvsv;
ArrayList<sinhvien>listsv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themsinhvien);
        etensv=findViewById(R.id.edttensv);
        eque=findViewById(R.id.edtque);
        ens=findViewById(R.id.edtnamsinh);
        enh=findViewById(R.id.edtnamhoc);
        themsv=findViewById(R.id.btnthemsv);
        btnlietke=findViewById(R.id.btnloc);
        lvsv=findViewById(R.id.listsv);

        themsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper db=new databaseHelper(getBaseContext());
                sinhvien sv=new sinhvien(etensv.getText().toString(),eque.getText().toString(),Integer.parseInt(ens.getText().toString()),Integer.parseInt(enh.getText().toString()));
                db.themsv(sv);

                Toast.makeText(getApplicationContext(),"Thêm sv thành công",Toast.LENGTH_SHORT).show();
                databaseHelper db1=new databaseHelper(getBaseContext());
                update();




            }
        });
        update();
//        databaseHelper db=new databaseHelper(getBaseContext());
//        listsv=db.listSV();
//        final String[] data =new String[listsv.size()];
//        //Toast.makeText(getApplicationContext(),listsv.get(0).toObject()+"",Toast.LENGTH_SHORT).show();
//        for(int i=0;i<listsv.size();i++){
//            data[i]=listsv.get(i).toObject()+"";
//        }
//        ArrayAdapter<String> arr=new ArrayAdapter<String>(Themsinhvien.this, android.R.layout.simple_list_item_1,data);
//
//        lvsv.setAdapter(arr);
        btnlietke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper db=new databaseHelper(getBaseContext());
                listsv=db.getLoc();
                final String[] data =new String[listsv.size()];
                //Toast.makeText(getApplicationContext(),listsv.get(0).toObject()+"",Toast.LENGTH_SHORT).show();
                for(int i=0;i<listsv.size();i++){
                    data[i]=listsv.get(i).toObject()+"";
                }
                ArrayAdapter<String> arr=new ArrayAdapter<String>(Themsinhvien.this, android.R.layout.simple_list_item_1,data);
                lvsv.setAdapter(arr);
            }
        });



    }
    public void update(){
        databaseHelper db=new databaseHelper(getBaseContext());
        listsv=db.listSV();
        final String[] data =new String[listsv.size()];
        //Toast.makeText(getApplicationContext(),listsv.get(0).toObject()+"",Toast.LENGTH_SHORT).show();
        for(int i=0;i<listsv.size();i++){
            data[i]=listsv.get(i).toObject()+"";
        }
        ArrayAdapter<String> arr=new ArrayAdapter<String>(Themsinhvien.this, android.R.layout.simple_list_item_1,data);

        lvsv.setAdapter(arr);
    }
}