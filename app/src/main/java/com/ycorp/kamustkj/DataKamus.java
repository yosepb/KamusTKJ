package com.ycorp.kamustkj;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataKamus extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "dbkamus";
    public static final String KATA = "kata";
    public static final String ARTI = "arti";

    public DataKamus(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    public void createTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS kamus");
        db.execSQL("CREATE TABLE if not exists kamus (id INTEGER PRIMARY KEY AUTOINCREMENT, kata TEXT, arti TEXT);");
    }

    public void generateData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(KATA, "Jaringan Komputer");
        cv.put(ARTI, "Jaringan yang digunakan untuk bertukar data");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "IP Address");
        cv.put(ARTI, "Alamat Komputer");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "DNS");
        cv.put(ARTI, "(Domanin Name Server), digunakan untuk menerjemahkan alamat IP ke domain address dan sebaliknya");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "DHCP");
        cv.put(ARTI, "(Domain Host Control Protocol), digunakan untuk memberi IP secara otomatis kepada Client maupun Server");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Proxy");
        cv.put(ARTI, "digunakan untuk memblokir jaringan di lingkungan daring");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "NAT");
        cv.put(ARTI, "(Network Address Translation)");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "FTP");
        cv.put(ARTI, "(File Transfer Protocol)");
        db.insert("kamus", KATA, cv);
        //bagian Kata Hardware Jaringan.
        cv.put(KATA, "Router");
        cv.put(ARTI, "Alat untuk menghubungkan jaringan yang berbeda (lihat arti Mikrotik OS dan Routerboard)");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Repeater");
        cv.put(ARTI, "Hardware yang digunakan untuk memperluas jangkauan jaringan LAN");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "HUB");
        cv.put(ARTI, "Hardware yang digunakan untuk mengkoneksikan client dan server");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Switch");
        cv.put(ARTI, "Sama halnya dengan HUB, hanya saja Switch lebih pintar");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Tang Krimping");
        cv.put(ARTI, "Tang yang dipakai untuk mematenkan RJ-45 dengan kabel UTP");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Routerboard");
        cv.put(ARTI, "Hardware Router keluaran Mikrotik");
        db.insert("kamus", KATA, cv);
        //bagian Kata Hardware Jaringan.
        cv.put(KATA, "Motherboad");
        cv.put(ARTI, "(Papan Induk), tempat dimana komponen-komponen komputer seperti processor berada");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Processor");
        cv.put(ARTI, "Otaknya Komputer");
        db.insert("kamus", KATA, cv);
        //bagian Kata Software.
        cv.put(KATA, "Mikrotik OS");
        cv.put(ARTI, "Sistem Operasi keluaran Mikrotik");
        db.insert("kamus", KATA, cv);
        cv.put(KATA, "Winbox");
        cv.put(ARTI, "Software yang digunakan untuk mensetting Mikrotik via GUI");
        db.insert("kamus", KATA, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
    }
}
