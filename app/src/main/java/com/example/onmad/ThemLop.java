package com.example.onmad;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ThemLop extends AppCompatActivity {
    EditText eten,emota;
    Button btnthemlop;
    ListView listviewlop,listviewtke;
    ArrayList<lop> listlop;
    ArrayList<sinhvienLop> listdk=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_lop);

        eten=findViewById(R.id.edttenlop);
        emota=findViewById(R.id.edtmota);
        btnthemlop=findViewById(R.id.btnthemlop);
        listviewlop=findViewById(R.id.listlop);

        btnthemlop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lop lop=new lop (eten.getText().toString(),emota.getText().toString());
                databaseHelper db=new databaseHelper(getBaseContext());
                db.themlop(lop);
                Toast.makeText(getApplicationContext(),"them lop thanh cong",Toast.LENGTH_SHORT).show();
                update();
            }
        });
        update();
//        databaseHelper db=new databaseHelper(getBaseContext());
//        listlop=db.listLop();
//        final String [] data=new String[listlop.size()];
//        for(int i=0;i<listlop.size();i++){
//            data[i]=listlop.get(i).toObject()+"";
//        }
//        ArrayAdapter<String> arr=new ArrayAdapter<>(ThemLop.this, android.R.layout.simple_list_item_1,data);
//       listviewlop.setAdapter(arr);

    listviewlop.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                databaseHelper db1 = new databaseHelper(getBaseContext());
               int tem=listlop.get(position).getMalop();
               listdk = db1.listThongke(tem);//.listdk(tem);
               final String[] data = new String[listdk.size()];
               for (int i = 0; i < listdk.size(); i++) {

                   sinhvien s=getsv(listdk.get(i).getMasv());
                   lop l=getlop(listdk.get(i).getMalop());
                   data[i] =s.getTensv()+"      "+ listdk.get(i).toObject() + "     "+l.getTenlop();
                   Toast.makeText(getApplicationContext(),data[i]+"",Toast.LENGTH_SHORT).show();
               }
        Intent intent=new Intent(ThemLop.this,dslop.class);
        intent.putExtra("list",data);
        startActivity(intent);

    }
});

    }
    public void update(){
        databaseHelper db=new databaseHelper(getBaseContext());
        listlop=db.listLop();
        final String [] data=new String[listlop.size()];
        for(int i=0;i<listlop.size();i++){
            data[i]=listlop.get(i).toObject()+"";
        }
        ArrayAdapter<String> arr=new ArrayAdapter<>(ThemLop.this, android.R.layout.simple_list_item_1,data);
        listviewlop.setAdapter(arr);
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