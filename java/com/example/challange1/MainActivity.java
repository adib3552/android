package com.example.challange1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void btnClick(View v){
        EditText fName=findViewById(R.id.firstName);
        EditText lName=findViewById(R.id.lastName);
        EditText mail=findViewById(R.id.email);
        TextView txt1=findViewById(R.id.greet);
        TextView txt2=findViewById(R.id.showMail);

        txt1.setText("Hello "+fName.getText().toString()+" "+lName.getText().toString());
        txt2.setText("Your E-mail is: "+mail.getText().toString());



    }
}