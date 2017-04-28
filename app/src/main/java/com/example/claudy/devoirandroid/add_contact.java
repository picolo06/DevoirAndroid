package com.example.claudy.devoirandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class add_contact extends AppCompatActivity {
   // SqqDev salli;
   DatabaseHelper mDatabaseHelper;

    private FloatingActionButton btnAddData;
    private EditText insnom;
    private EditText insprenom;
    private EditText insadr;
    private EditText instel;
    private EditText insmail;
   private EditText insstatut;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_contact);

        mDatabaseHelper = new DatabaseHelper(this);
        //salli = new SqqDev(this);
       insnom = (EditText) findViewById(R.id.nom);
        insprenom = (EditText) findViewById(R.id.prenom);
        insadr = (EditText) findViewById(R.id.adr);
        instel = (EditText) findViewById(R.id.tel);
       insmail = (EditText) findViewById(R.id.mail);
        insstatut = (EditText) findViewById(R.id.stat);
        btnAddData = (FloatingActionButton) findViewById(R.id.btnAddData);


     /*   btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = insnom.getText().toString();
                if (insnom.length() != 0) {
                    AddData();
                } else {
                    Toast.makeText(add_contact.this, "You must put something in the text field!", Toast.LENGTH_LONG).show();
                }

            }
        });

     */
        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newnom = insnom.getText().toString();
                String newprenom = insprenom.getText().toString();
                String newmail = insmail.getText().toString();
                String newtel = instel.getText().toString();
                String newadr = insadr.getText().toString();
                String newstat = insstatut.getText().toString();

                if (insnom.length() != 0) {
                    AddData(newnom,newprenom,newmail,newtel,newadr,newstat);
                    insnom.setText("");
                    insstatut.setText("");
                    insadr.setText("");
                    instel.setText("");
                    insmail.setText("");
                    insprenom.setText("");
                } else {
                    toastMessage("You must put something in the text field!");
                }

            }
        });
    }



    public  void cancelmv (View view)

    {
        Intent intent = new Intent(add_contact.this, MainActivity.class);
        startActivity(intent);
    }

    public void AddData(String newnom,String newprenom,String newmail,String newtel,String newadr,String newstat) {
        boolean insertData = mDatabaseHelper.addData(newnom,newprenom,newmail,newtel,newadr,newstat);

        if (insertData) {
            toastMessage("Data Successfully Inserted!");
        } else {
            toastMessage("Something went wrong");
        }
    }

   /* public void AddData() {

                boolean isInserted = salli.insertdata(insnom.getText().toString(), insprenom.getText().toString(), insmail.getText().toString(), instel.getText().toString(), insadr.getText().toString(), insstatut.getText().toString());
                if (isInserted){
                    Toast.makeText(add_contact.this,"Data inserted",Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(add_contact.this,"Data not inserted",Toast.LENGTH_LONG).show();

                }
    } */

    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }

}
