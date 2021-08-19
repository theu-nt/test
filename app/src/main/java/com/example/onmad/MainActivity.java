package com.example.onmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button btnsv,btnlop,btndky,btntke,btndsach;
    ArrayList<sinhvien>listsv;
    ArrayList<lop>listlop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhxa();
        btnsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Themsinhvien.class);
                startActivity(intent);
            }
        });

        btnlop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ThemLop.class);
                startActivity(intent);
            }
        });
        btndky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,dangky.class);
                startActivity(intent);
            }
        });

    }

    private void anhxa() {
        btnsv=findViewById(R.id.qlsv);
        btnlop=findViewById(R.id.qllop);
        btndky=findViewById(R.id.dangky);
        btntke=findViewById(R.id.thongke);
        btndsach=findViewById(R.id.danhsach);
    }
}