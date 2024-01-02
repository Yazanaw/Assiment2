package com.example.assiment2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    public static final String FLAG = "FLA";
    private boolean flag = false;
    EditText nam;
    EditText pas;
    EditText mail;
    EditText date;
    Button bu3;
   // Button bum4;
    List al;
    TextView tt;
    CheckBox ch;
    //Button back;

    Gson gson=new Gson();
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        setuo();
        setupSharedPrefs();

        bu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);
                startActivity(intent);                         }
        });
        load();


    }
    public void setuo(){
        nam=findViewById(R.id.nam);
        pas=findViewById(R.id.pas);
        mail=findViewById(R.id.mail);
        date=findViewById(R.id.date);
        bu3=findViewById(R.id.bu3);
       // tt=findViewById(R.id.tt);
        ch=findViewById(R.id.ch);
//        back=findViewById(R.id.back);
//        bum4=findViewById(R.id.bum4);
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();

    }
    public void save(){
        String name,pass,email,Date;

        name=nam.getText().toString();
        pass=pas.getText().toString();
        email=mail.getText().toString();
        Date=date.getText().toString();

        if(ch.isChecked()) {
            if(!flag) {

                editor.putString("naa", name);
                editor.putString("paa", pass);
                editor.putString("ema", email);
                editor.putString("Daa", Date);

                editor.putBoolean(FLAG, true);
                editor.commit();
            }
        }else {
            System.out.println("no data");
        }
    }

    public void load (){
        flag = prefs.getBoolean(FLAG, false);

        if(flag){
            String namee=prefs.getString("naa","");
            String pase=prefs.getString("paa","");
            String emm=prefs.getString("ema","");
            String Dat=prefs.getString("Daa","");

            // user[]uu=json.fromJson(str,user[].class);


            nam.setText(namee);
            pas.setText(pase);
            mail.setText(emm);
            date.setText(Dat);
            ch.setChecked(true);
        }

        else {

        }
             }






    @Override
    protected void onStop() {

        super.onStop();
        save();
    }

    @Override
    protected void onPause() {

        super.onPause();
        save();
    }
}