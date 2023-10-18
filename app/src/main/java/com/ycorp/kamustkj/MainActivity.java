package com.ycorp.kamustkj;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.mipmap.ic_launcher);
        toolbar.setTitle("Kamus");
        toolbar.setSubtitle("by. Yosep B.");
        setSupportActionBar(toolbar);

        txtKata = (EditText) findViewById(R.id.txtKata);
        txtArti = (EditText) findViewById(R.id.txtArti);

        DataKamus datakamus = new DataKamus(this);
        db = datakamus.getWritableDatabase();
        datakamus.createTable(db);
        datakamus.generateData(db);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case R.id.action_settings:
                Intent in1 = new Intent("com.ycorp.kamustkj.Main2Activity");
                startActivity(in1);
                return true;

            case R.id.action_aboutyosep:
                Intent in2 = new Intent("com.ycorp.kamustkj.Main3Activity");
                startActivity(in2);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private SQLiteDatabase db = null;
    private Cursor kamusCursor = null;
    private EditText txtKata;
    private EditText txtArti;
    public static final String KATA = "kata";
    public static final String ARTI = "arti";

    public void getTerjemahan(View view) {
        String result = "";
        String tkjword = txtKata.getText().toString();
        kamusCursor = db.rawQuery("SELECT ID, KATA, ARTI "
                + "FROM kamus where KATA='" + tkjword
                + "' ORDER BY KATA", null);

        if (kamusCursor.moveToFirst()) {
            result = kamusCursor.getString(2);
            for (; !kamusCursor.isAfterLast();
                 kamusCursor.moveToNext()) {
                result = kamusCursor.getString(2);
            }
        }
        if (result.equals("")) {
            result = "Terjemahan Not Found";
        }
        txtArti.setText(result);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

}
