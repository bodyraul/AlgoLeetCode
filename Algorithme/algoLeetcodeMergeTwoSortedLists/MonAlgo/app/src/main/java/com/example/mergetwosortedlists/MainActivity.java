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
                nombre1=Integer.valueOf(saisirListe1.getText().toString());
                liste1.add(nombre1);
                Collections.sort(liste1);
                for (Integer nombre:liste1
                     ) {
                    phrase=phrase.concat(String.valueOf(nombre)+ " | ");
                }
                afficherListe1.setText(phrase);
                phrase="";
                saisirListe1.setText("");

            }
        });

        ajouterListe2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre2=Integer.valueOf(saisirListe2.getText().toString());
                liste2.add(nombre2);
                Collections.sort(liste2);
                for (Integer nombre:liste2
                ) {
                    phrase2=phrase2.concat(String.valueOf(nombre)+ " | ");
                }
                afficherListe2.setText(phrase2);
                phrase2="";
                saisirListe2.setText("");
            }
        });

        trier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                listeTriee=trierListe(liste1,liste2);

                for (Integer nombre:listeTriee
                ) {
                    if (listeTriee.size()==1){
                        phraseResultat=phraseResultat.concat(String.valueOf(nombre));
                    }else{
                        phraseResultat=phraseResultat.concat(String.valueOf(nombre)+ " | ");
                    }
                }
                afficherListeTriee.setText(phraseResultat);
            }
        });

    }

    public List<Integer> trierListe(List<Integer> liste1,List<Integer> liste2){
        List<Integer> listeTriee = new ArrayList<Integer>();
        int tailleTbaleau=liste1.size()+liste2.size();
        int indice1=0;
        int indice2=0;
        final int tailleListe1=liste1.size();
        boolean valider;

        if (liste1.size()==0 && liste2.size()==0){
            listeTriee.add(0);
            return listeTriee;
        }
        if (liste1.size()==0){
            for (Integer nombre:liste2
            ) {
                listeTriee.add(nombre);
            }
        }
        if (liste2.size()==0){
            for (Integer nombre:liste1
            ) {
                listeTriee.add(nombre);
            }
        }
        if(liste1.size()!=0 && liste2.size()!=0 /*&&  liste1.size()> liste2.size()*/){
            while (listeTriee.size()!=tailleTbaleau){
                if( indice1<liste1.size() && indice2<liste2.size() && liste2.get(indice2)<= liste1.get(indice1) ){
                    listeTriee.add(liste2.get(indice2));
                    indice2++;
                }else if ( indice2<liste2.size() && liste2.get(indice2)> liste1.get(liste1.size()-1)){
                    liste1.add(liste2.get(indice2));
                    indice2++;
                }else{
                    listeTriee.add(liste1.get(indice1));
                    indice1++;
                }

            }
        }
       /* for (Integer nombre: listeTriee
        ) {
            System.out.println(" tri "+nombre);
        }
        for (Integer nombre: liste1
             ) {
            System.out.println(" liste1 "+nombre);
        }*/


        return listeTriee;
    }
}