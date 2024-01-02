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

public class MainActivity extends AppCompatActivity {
    Gson json=new Gson();
    public static final String FLAG = "FLAG";
    private boolean flag = false;
    EditText name;
    EditText pass;
    Button bu;
    CheckBox check;
    TextView t;
    Button bu2;
   // Button bu6;
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setviews();
        setupSharedPrefs();
        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity5.class);
                startActivity(intent);
            }
        });
        load();
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                 startActivity(intent);
            }
        });
//       bu6.setOnClickListener(new View.OnClickListener() {
//           @Override
//           public void onClick(View v) {
//               Intent in = new Intent(MainActivity.this, MainActivity4.class);
//               startActivity(in);
//           }
//       });


    }
    private void setviews(){

        name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        bu=findViewById(R.id.bu);
        check=findViewById(R.id.check);
        // t= findViewById(R.id.t);
         bu2=findViewById(R.id.bu2);
         //bu6=findViewById(R.id.bu6);
    }
    private void setupSharedPrefs() {
        prefs= PreferenceManager.getDefaultSharedPreferences(this);
        editor=prefs.edit();

    }
    public void save(){
      String n,p;
     // String []arr = new String[3];
      n=name.getText().toString();
      p=pass.getText().toString();

     // user u=new user(n,p);
     if(check.isChecked()) {
         if(!flag) {
            // String us = json.toJson(u);

             editor.putString("na", n);
             editor.putString("ps",p);
             editor.putBoolean(FLAG, true);
             editor.commit();
         }
     }else {
         System.out.println("no data");
     }
    }
    public void load(){
        flag = prefs.getBoolean(FLAG, false);
       // String str=prefs.getString("use","");

            if(flag){
            String nam=prefs.getString("na","");
            String pas=prefs.getString("ps","");
           // user[]uu=json.fromJson(str,user[].class);

          //  t.setText(nam+pas);
            name.setText(nam);
            pass.setText(pas);
            check.setChecked(true);
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