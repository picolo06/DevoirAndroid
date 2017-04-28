package com.example.claudy.devoirandroid;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class selected_contact extends AppCompatActivity {
    FloatingActionButton btnDelete;
    DatabaseHelper mDatabaseHelper;

    private String selectedName;
    private String selectedPrenom;
    private String selectedEmail;
    private String selectedTelephone;
    private String selectedAdresse;
    private String selectedStatut;

    private TextView insnom;
    private TextView insprenom;
    private TextView insadr;
    private TextView instel;
    private TextView insmail;
    private TextView insstatut;

    private int selectedID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_contact);

        btnDelete = (FloatingActionButton) findViewById(R.id.btndelete);
        mDatabaseHelper = new DatabaseHelper(this);

        insnom = (TextView) findViewById(R.id.selnomtxt);
        insprenom = (TextView) findViewById(R.id.selprenomtxt);
        insadr = (TextView) findViewById(R.id.seladrtxt);
        instel = (TextView) findViewById(R.id.selteltxt);
        insmail = (TextView) findViewById(R.id.selmailtxt);
        insstatut = (TextView) findViewById(R.id.selstatuttxt);

        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id",-1); //NOTE: -1 is just the default value
        selectedName = receivedIntent.getStringExtra("name");
        selectedPrenom = receivedIntent.getStringExtra("PRENOM");
        selectedEmail = receivedIntent.getStringExtra("MAIL");
        selectedTelephone = receivedIntent.getStringExtra("TELEPHONE");
        selectedAdresse = receivedIntent.getStringExtra("ADRESSE");
        selectedStatut = receivedIntent.getStringExtra("STATUT");

        insnom.setText(selectedName);
        insprenom.setText(selectedPrenom);
        insadr.setText(selectedEmail);
        instel.setText(selectedTelephone);
        insmail.setText(selectedAdresse);
        insstatut.setText(selectedStatut);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDatabaseHelper.deleteName(selectedID,selectedName);
                insnom.setText("");
                insprenom.setText("");
                insadr.setText("");
                instel.setText("");
                insmail.setText("");
                insstatut.setText("");
                toastMessage("removed from database");
            }
        });

    }

    public  void modifyev (View view)

    {
        Intent intent = new Intent(selected_contact.this, edit_contact.class);
        startActivity(intent);
    }





    private void toastMessage(String message){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
