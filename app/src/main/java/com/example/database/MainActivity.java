package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper myDb;
   // EditText e,e1,e2,e3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb=new DatabaseHelper(this);
       /* e=findViewById(R.id.editText2);
        e1=findViewById(R.id.editname);
        e2=findViewById(R.id.editAmark);
        e3=findViewById(R.id.editJmark);*/



    }

    public void add(View view){
        startActivity(new Intent(MainActivity.this,adddetails.class));
    }




    public void view(View view){


        Cursor res = myDb.getAllData();
        if(res.getCount() == 0) {
            // show message
            showMessage("Error","Nothing found");
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Id :"+ res.getString(0)+"\n");
            buffer.append("First_Name :"+ res.getString(1)+"\n");
            buffer.append("Last_Name :"+ res.getString(2)+"\n");
            buffer.append("Email :"+ res.getString(3)+"\n\n");


        }

        // Show all data
        showMessage("Data",buffer.toString());
    }
    public void showMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

    public void del(View view){
        startActivity(new Intent(MainActivity.this,searchActivity.class));
    }

    public void edit(View view){
        startActivity(new Intent(MainActivity.this,adddetails.class));
    }

    public void list(View view){
        startActivity(new Intent(MainActivity.this,list.class));
    }









}




