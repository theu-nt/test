package com.example.onmad;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class dslop extends AppCompatActivity {
ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dslop);
        lv=findViewById(R.id.dslop);

       // listdk=(ArrayList<sinhvienLop> )getIntent().getCharSequenceArrayListExtra("list");//(ArrayList<sinhvienLop> )getIntent().getSerializableExtra("list");
        final String[] data = getIntent().getStringArrayExtra("list");//new String[listdk.size()];

       // for (int i = 0; i < listdk.size(); i++) {
//            data[i] = listdk.get(i).toObject() + "";
//            Toast.makeText(getApplicationContext(),data[i]+"",Toast.LENGTH_SHORT).show();
//
//        }
        ArrayAdapter<String> arr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);

        lv.setAdapter(arr);
    }
}