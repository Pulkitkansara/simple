
//this is fro  displaying  reecords
package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class list extends AppCompatActivity {

    ListView l;
    SQLiteDatabase myDb;
    String a="";
    ArrayList list = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        l = findViewById(R.id.list1);
        try
        {
            myDb = this.openOrCreateDatabase("UserDb", Context.MODE_PRIVATE,null);
            Cursor c = myDb.rawQuery("SELECT * FROM  usr_table",null);
            if (c!=null)
            {
                c.moveToFirst();
                do
                {
                    String u_id = c.getString(0);
                    String fname = c.getString(1);
                    String lname = c.getString(2);
                    String email = c.getString(3);

                    a = "Id :"+u_id+"\n"+"First_Name : "+fname+"\n"+"Last_Name : "+lname+"\n"+"Email : "+email+"\n";
                    list.add(a);

                }while (c.moveToNext());

                ArrayAdapter adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_activated_1,list);
                l.setAdapter(adapter);
            }
        }
        catch (Exception e)
        {
            Toast.makeText(getApplicationContext(),"Error :"+e,Toast.LENGTH_LONG).show();
        }


    }
}
