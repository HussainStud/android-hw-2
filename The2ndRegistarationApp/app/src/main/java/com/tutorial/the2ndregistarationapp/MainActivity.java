package com.tutorial.the2ndregistarationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtName = findViewById(R.id.edtName);
        EditText edtAge = findViewById(R.id.edtAge);
        EditText edtPhoneNumber = findViewById(R.id.edtPhoneNumber);
        EditText edtMail = findViewById(R.id.edtMail);
        EditText edtJob = findViewById(R.id.edtJob);

        Button btnNext = findViewById(R.id.btnNext);

        btnNext.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);


            String name = edtName.getText().toString();
            int age;
            int phoneNumber;

            String mail = edtMail.getText().toString();
            String job = edtJob.getText().toString();

            if(TextUtils.isEmpty(name)) {
                edtName.setError("Please fill in the required information");
                return;
            }

              if(TextUtils.isEmpty(edtAge.getText().toString())) {
                edtAge.setError("Please fill in the required information");
                return;
            } else {
                  age = Integer.parseInt(edtAge.getText().toString());
              }

              if(TextUtils.isEmpty(edtPhoneNumber.getText().toString())) {
                edtPhoneNumber.setError("Please fill in the required information");
                return;
            } else {
                  phoneNumber = Integer.parseInt(edtPhoneNumber.getText().toString());
              }

              if(TextUtils.isEmpty(mail)) {
                edtMail.setError("Please fill in the required information");
                return;
            }

              if(TextUtils.isEmpty(job)) {
                edtJob.setError("Please fill in the required information");
                return;
            }
              if(TextUtils.isEmpty(name)) {
                edtName.setError("Please fill in the required information");
                return;
            }

            intent.putExtra("NAME", name);
            intent.putExtra("AGE", age);
            intent.putExtra("PHONE_NUMBER", phoneNumber);
            intent.putExtra("MAIL", mail);
            intent.putExtra("JOB", job);

            startActivity(intent);
        });
    }
}