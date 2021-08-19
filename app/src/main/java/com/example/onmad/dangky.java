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

public class dangky extends AppCompatActivity {
    EditText edmasv,edmalop,edtinchi,edkyhoc;
    Button btndangky,btnload;
    ArrayList<sinhvienLop> listdk,listtest=new ArrayList<>();
    ListView lvdk;
    String ma="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dangky);
        edmalop=findViewById(R.id.malopdk);
        edmasv=findViewById(R.id.masvdk);
        edtinchi=findViewById(R.id.tc);
        edkyhoc=findViewById(R.id.kyhoc);
        btndangky=findViewById(R.id.btndangky);
        btnload=findViewById(R.id.btnload);
        lvdk=findViewById(R.id.lvdk);

        btndangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 ma=edmasv.getText().toString()+"";
                databaseHelper db=new databaseHelper(getBaseContext());
                if(getsv(Integer.parseInt(edmasv.getText().toString()))==null){
                    Toast.makeText(getApplicationContext(),"K có sv này, MSV k hợp lệ",Toast.LENGTH_SHORT).show();

                }
                else {
                    if (getlop(Integer.parseInt(edmalop.getText().toString())) == null) {
                        Toast.makeText(getApplicationContext(), "K có lớp này, Mã lớp k hợp lệ", Toast.LENGTH_SHORT).show();

                    }
                    else{
                        sinhvienLop tm = new sinhvienLop(Integer.parseInt(edmasv.getText().toString()), Integer.parseInt(edmalop.getText()
                                .toString()), Integer.parseInt(edtinchi.getText().toString()), Integer.parseInt(edkyhoc.getText().toString()));
                        listtest.add(tm);
                        final String[] data = new String[listtest.size()];
                        for (int i = 0; i < listtest.size(); i++) {
                            data[i] = listtest.get(i).toObject() + "";
                        }
                        ArrayAdapter<String> arr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);
                        lvdk.setAdapter(arr);

                        db.themdky(tm);
                        Toast.makeText(getApplicationContext(),"them dang ky thanh cong",Toast.LENGTH_SHORT).show();


                    }
                }


            } });
        btnload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(ma.length()>0) {
                    databaseHelper db1 = new databaseHelper(getBaseContext());
                    int tem=Integer.parseInt(edmasv.getText().toString().trim());
                    listdk = db1.listdk(tem);
                    final String[] data = new String[listdk.size()];
                    for (int i = 0; i < listdk.size(); i++) {
                        data[i] = listdk.get(i).toObject() + "";
                    }
                    ArrayAdapter<String> arr = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, data);
                    lvdk.setAdapter(arr);
              //  }
            }
        });





    }
    public sinhvien getsv(int ma){
        databaseHelper db2=new databaseHelper(getBaseContext());
        sinhvien s=db2.searchSV(ma);
        return s;
    }
    public lop getlop(int ma){
        databaseHelper db2=new databaseHelper(getBaseContext());
        lop s=db2.searchlop(ma);
        return s;
    }
}