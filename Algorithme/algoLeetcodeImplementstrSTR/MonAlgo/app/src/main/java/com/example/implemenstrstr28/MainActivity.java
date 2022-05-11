package com.example.implemenstrstr28;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {
int resultat=0;
String phrase1="bonjour et bienvenue aurelien";
String phrase2="aurelien";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        resultat=strStr(phrase1,phrase2);
        System.out.println(" resultat "+String.valueOf(resultat));
    }
    public int strStr(String phrase1,String phrase2){
        int index=0;
        if (phrase1.length()==0 || phrase2.length()==0){
            return index=0;
        }else{
            if(phrase1.contains(phrase2)){
                return  index=phrase1.indexOf(phrase2);
            }
        }
      return index=-1;

    }
}