package com.example.onmad;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class databaseHelper extends SQLiteOpenHelper {
    public static final String databasename="sinhvienlop";
    private static final String table1="sinhvien",table2="lop",table3="sinhviendklop";
    private static final String masv="masv",tensv="tensv",que="que",namsinh="namsinh",namhoc="namhoc";
    private static final String malop="malop",tenlop="tenlop",mota="mota";
    private static final String idd="idd",idsv="idsv",idlop="idlop",sotinchi="sotinchi",kyhoc="kyhoc";


    public Context context;

    public databaseHelper(Context context){
        super(context,databasename,null,3);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

            String sql="CREATE TABLE "+table1+" ( "+masv+" integer primary key autoincrement," +
                    " "+tensv+" text, "+que+" text, "+namsinh+" int, "+namhoc+" int)";
            db.execSQL(sql);
            String sqlq="CREATE TABLE "+table2+" ( "+malop+" integer primary key autoincrement, "+tenlop+" text, "+mota+" text)";
            db.execSQL(sqlq);
            String sql3="CREATE TABLE "+table3+" ( "+idd+" integer primary key autoincrement, "+idsv+" integer, "+idlop+" integer, " +
                    " "+sotinchi+" integer, "+kyhoc+" integer)";
            db.execSQL(sql3);

    }
//    SQLiteDatabase db=this.getWritableDatabase();
//    ContentValues values=new ContentValues();
//        values.put(name,sp.getTen());
//        values.put(anh,sp.getAnh());
//        values.put(theloai,sp.getTheloai());
//        values.put(gia,sp.getGia());
//
//        db.insert(tablename,null,values);
//        db.close();
    public void themsv(sinhvien sv){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tensv,sv.getTensv());
        values.put(que,sv.getQuequan());
        values.put(namsinh,sv.getNamsinh());
        values.put(namhoc,sv.getNamhoc());
        db.insert(table1,null,values);
        db.close();
    }
    public void themlop(lop lop){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(tenlop,lop.getTenlop());
        values.put(mota,lop.getMota());

        db.insert(table2,null,values);
        db.close();
    }
    public void themdky(sinhvienLop s){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put(idsv,s.getMasv());
        values.put(idlop,s.getMalop());
        values.put(sotinchi,s.getSotinchi());
        values.put(kyhoc,s.getKyhoc());

         db.insert(table3,null,values);
        Toast.makeText(context,"DB them dang ky thanh cong",Toast.LENGTH_SHORT).show();
        db.close();
    }


public ArrayList<sinhvienLop>listdk(int msv){


        ArrayList<sinhvienLop> list=new ArrayList<>();
        String sql="select * from "+table3+" where "+idsv+" = "+msv;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                sinhvienLop s = new sinhvienLop();
                s.setMa(cursor.getInt(0));
                s.setMasv(cursor.getInt(1));
                s.setMalop(cursor.getInt(2));
                s.setSotinchi(cursor.getInt(3));
                s.setKyhoc(cursor.getInt(4));
                list.add(s);
            }while (cursor.moveToNext());
        }
    cursor.close();
    db.close();

    return list;
}

    public ArrayList<sinhvien> listSV(){
        ArrayList<sinhvien>list=new ArrayList<>();
        String sql="select * from "+table1;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                sinhvien sv=new sinhvien();
                sv.setMasv(cursor.getInt(0));
                sv.setTensv(cursor.getString(1));
                sv.setQuequan(cursor.getString(2));
                sv.setNamsinh(cursor.getInt(3));
                sv.setNamhoc(cursor.getInt(4));
                list.add(sv);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }
    public sinhvien searchSV(int ma){
        String sql="select * from "+table1+" where "+masv+" = "+ma;
        sinhvien sv=new sinhvien();

        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                sv.setMasv(cursor.getInt(0));
                sv.setTensv(cursor.getString(1));
                sv.setQuequan(cursor.getString(2));
                sv.setNamsinh(cursor.getInt(3));
                sv.setNamhoc(cursor.getInt(4));
                //list.add(sv);
                return sv;

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return null;
    }

    public lop searchlop(int ma){
        String sql="select * from "+table2+" where "+malop+" = "+ma;
        lop lp=new lop();
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                lp.setMalop(cursor.getInt(0));
                lp.setTenlop(cursor.getString(1));
                lp.setMota(cursor.getString(2));
                return lp;
                //list.add(sv);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return null;
    }
    public ArrayList<lop> listLop(){
        ArrayList<lop>list=new ArrayList<>();
        String sql="select * from "+table2;
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                lop lp=new lop();
                lp.setMalop(cursor.getInt(0));
                lp.setTenlop(cursor.getString(1));
                lp.setMota(cursor.getString(2));
                list.add(lp);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }
    //sv tên thêu đang học năm 2
    public ArrayList<sinhvien>getLoc(){
        ArrayList<sinhvien>list=new ArrayList<>();
        String sql="select * from "+table1+" where "+tensv+" = 'thêu' and "+namhoc+" = 2";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do{
                sinhvien sv=new sinhvien();
                sv.setMasv(cursor.getInt(0));
                sv.setTensv(cursor.getString(1));
                sv.setQuequan(cursor.getString(2));
                sv.setNamsinh(cursor.getInt(3));
                sv.setNamhoc(cursor.getInt(4));
                list.add(sv);

            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;

    }

    public ArrayList<sinhvienLop>listThongke(int mlop){


        ArrayList<sinhvienLop> list=new ArrayList<>();
        String sql="select * from "+table3+" where "+idlop+" = "+mlop+" order by "+idsv+" desc";
        SQLiteDatabase db=this.getReadableDatabase();
        Cursor cursor=db.rawQuery(sql,null);
        if(cursor.moveToFirst()){
            do {
                sinhvienLop s = new sinhvienLop();
                s.setMa(cursor.getInt(0));
                s.setMasv(cursor.getInt(1));
                s.setMalop(cursor.getInt(2));
                s.setSotinchi(cursor.getInt(3));
                s.setKyhoc(cursor.getInt(4));
                list.add(s);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();

        return list;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
         db.execSQL("DROP TABLE IF EXISTS "+table1);
        onCreate(db);
        Toast.makeText(context, "Drop successfully", Toast.LENGTH_SHORT).show();
//    copyDatabase();
//}
    }
}
