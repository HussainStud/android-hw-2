package com.tutorial.the2ndregistarationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.net.Uri;
import android.content.Intent;
import android.widget.Button;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        Bundle bundle = getIntent().getExtras();
        String inputName = bundle.getString("NAME");
        int inputAge = bundle.getInt("AGE");
        int inputPhoneNumber = bundle.getInt("PHONE_NUMBER");
        String inputMail = bundle.getString("MAIL");
        String inputJob = bundle.getString("JOB");

        TextView txtName = findViewById(R.id.txtName);
        TextView txtAge = findViewById(R.id.txtAge);
        TextView txtPhoneNumber = findViewById(R.id.txtphoneNumber);
        TextView txtMail = findViewById(R.id.txtEmail);
        TextView txtJob = findViewById(R.id.txtJob);

        Button btnCall = findViewById(R.id.btnCall);
        Button btnMail = findViewById(R.id.btnMail);




        txtName.setText("Name: "+ inputName);
        txtAge.setText("Age: "+ inputAge);
        txtPhoneNumber.setText("Phone Number: " + inputPhoneNumber);
        txtMail.setText("Mail: "+ inputMail);
        txtJob.setText("Job: "+ inputJob);

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent phoneIntent = new Intent(Intent.ACTION_CALL);
                phoneIntent.setData(Uri.parse("tel:" + Integer.toString(inputPhoneNumber)));
                if (ActivityCompat.checkSelfPermission(MainActivity2.this,
                        Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(MainActivity2.this, "there is no phone client", Toast.LENGTH_SHORT).show();
                    return;
                }
                startActivity(phoneIntent);
            }
        });


        btnMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, inputMail);
                emailIntent.putExtra(Intent.EXTRA_CC, "hussainsstudies@gmail.com");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");
                try {
                    startActivity(Intent.createChooser(emailIntent, "Send mail..."));
                    finish();
                    Log.i("Finished sending email...", "");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(MainActivity2.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}