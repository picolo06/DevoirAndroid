package com.example.claudy.devoirandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class edit_contact extends AppCompatActivity {

    FloatingActionButton btnViewUpdate;

    EditText upnom;
    EditText upprenom;
    EditText upadr;
    EditText uptel;
    EditText upmail;
    EditText editTextId;
    EditText upstatut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_contact);

        upnom = (EditText) findViewById(R.id.enom);
        upprenom = (EditText) findViewById(R.id.eprenom);
        upadr = (EditText) findViewById(R.id.eadr);
        uptel = (EditText) findViewById(R.id.etel);
        upmail = (EditText) findViewById(R.id.email);
        upstatut = (EditText) findViewById(R.id.estat);
        editTextId = (EditText) findViewById(R.id.edittId);
        btnViewUpdate = (FloatingActionButton) findViewById(R.id.btnViewUpdate);


    }

    public  void cancelsv (View view)

    {
        Intent intent = new Intent(edit_contact.this, selected_contact.class);
        startActivity(intent);
    }
}
