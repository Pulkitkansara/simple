
//this program is  for inserting data into databaseX
package com.example.database;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
public class adddetails extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText e,e1,e2,e3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adddetails);


        myDb=new DatabaseHelper(this);
        e=findViewById(R.id.editid);
        e1=findViewById(R.id.editfname);
        e2=findViewById(R.id.editlname);
        e3=findViewById(R.id.editemail);
    }



    public void add(View view){
        boolean isInserted = myDb.insertData(
                e1.getText().toString(),
                e2.getText().toString(),
                e3.getText().toString());

        if(isInserted == true)
            Toast.makeText(adddetails.this,"Data Inserted",Toast.LENGTH_LONG).show();
        else
            Toast.makeText(adddetails.this,"Data not Inserted",Toast.LENGTH_LONG).show();

    }


    public void update(View view){
        boolean isUpdate = myDb.updateData(
                e.getText().toString(),
                e1.getText().toString(),
                e2.getText().toString(),
                e3.getText().toString());
        if(isUpdate == true) {
            Toast.makeText(adddetails.this,"Data Updated",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(adddetails.this, "Data not Updated", Toast.LENGTH_LONG).show();
        }

    }
}
