package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class searchActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText e;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
       // myDb= new SQLiteDatabase(this);
        myDb = new DatabaseHelper(this);


        e = findViewById(R.id.editText);

    }
        public void click(View v) {
            Integer deletedRows = myDb.deleteData(e.getText().toString());
            if(deletedRows > 0)
                Toast.makeText(searchActivity.this,"Data Deleted",Toast.LENGTH_LONG).show();
            else
                Toast.makeText(searchActivity.this,"Data not Deleted",Toast.LENGTH_LONG).show();
        }
    }



    















