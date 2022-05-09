package com.example.mergetwosortedlists;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView afficherListe1;TextView afficherListe2;TextView afficherListeTriee;
    EditText saisirListe1;EditText saisirListe2;
    Button ajouterListe1;Button ajouterListe2;Button trier;
    List<Integer> liste1= new ArrayList<Integer>();List<Integer> liste2= new ArrayList<Integer>();List<Integer> listeTriee= new ArrayList<Integer>();
    OperationList operationList=new OperationList();
    Integer nombre1,nombre2;
    String phrase="";String phrase2="";String phraseResultat="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisirListe1=findViewById(R.id.editTextTextSaisir);saisirListe2=findViewById(R.id.editTextTextSaisir2);
        afficherListe1=findViewById(R.id.textView1);afficherListe2=findViewById(R.id.textView2);afficherListeTriee=findViewById(R.id.textView3);
        ajouterListe1=findViewById(R.id.buttonValider);ajouterListe2=findViewById(R.id.buttonValider2);trier=findViewById(R.id.buttontrier);
        afficherListe1.setText("");afficherListe2.setText("");afficherListeTriee.setText("");

        ajouterListe1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saisirListe1.getText().toString().matches("[0-9]+")==true){
                    nombre1=Integer.valueOf(saisirListe1.getText().toString());
                    liste1.add(nombre1);
                }else{
                    saisirListe1.setText("");
                    Toast.makeText(MainActivity.this, "Vous ne devez saisir que des chiffres", Toast.LENGTH_SHORT).show();
                    return;
                }
                Collections.sort(liste1);
                phrase=operationList.concatPhrase(liste1,phrase);
                afficherEtViderTexte1();

            }
        });

        ajouterListe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (saisirListe2.getText().toString().matches("[0-9]+")==true){
                    nombre2=Integer.valueOf(saisirListe2.getText().toString());
                    liste2.add(nombre2);
                }else{
                    saisirListe2.setText("");
                    Toast.makeText(MainActivity.this, "Vous ne devez saisir que des chiffres", Toast.LENGTH_SHORT).show();
                    return;
                }
                Collections.sort(liste2);
                phrase2=operationList.concatPhrase(liste2,phrase2);
                afficherEtViderTexte2();
            }
        });

        trier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listeTriee=operationList.trierListe(liste1,liste2);
                phraseResultat=operationList.concatPhrase(listeTriee,phraseResultat);
                afficherListeTriee.setText(phraseResultat);
                phraseResultat="";
                desactivationBoutton();
            }
        });

    }


    public void afficherEtViderTexte1(){
        afficherListe1.setText(phrase);
        phrase="";
        saisirListe1.setText("");
    }

    public void afficherEtViderTexte2(){
        afficherListe2.setText(phrase2);
        phrase2="";
        saisirListe2.setText("");
    }

    public void desactivationBoutton(){
        if (trier.getText().toString().contains("trier")){
            ajouterListe2.setEnabled(false);
            ajouterListe1.setEnabled(false);
            trier.setText("Recommencer");
        }else{
            ajouterListe2.setEnabled(true);
            ajouterListe1.setEnabled(true);
            liste1.clear();
            liste2.clear();
            listeTriee.clear();
            trier.setText("trier");
            afficherListeTriee.setText("");
            afficherListe1.setText("");
            afficherListe2.setText("");
        }

    }



}