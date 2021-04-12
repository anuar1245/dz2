package com.example.dz2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editTextMessege ,editTextSubject ;

TextView editTextTo;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMessege = findViewById(R.id.Edit_Message);
        editTextSubject = findViewById(R.id.Edit_subject);
        editTextTo = findViewById(R.id.text_to);


        Button buttonsend = findViewById(R.id.btnsend);
        buttonsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMAil();
            }

            private void sendMAil() {
                String recipientlist = editTextTo.getText().toString();
                String[] recipients = recipientlist.split(",");
                //example@gmail

                String subject = editTextSubject.getText().toString();
                String messege = editTextMessege.getText().toString();

                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_EMAIL,recipients);
                intent.putExtra(intent.EXTRA_SUBJECT,subject);
                intent.putExtra(Intent.EXTRA_TEXT,messege);
                intent.setType("messege/rfs822");
                startActivity(Intent.createChooser(intent,"Choose an  email client"));
            }
        });
    }
}