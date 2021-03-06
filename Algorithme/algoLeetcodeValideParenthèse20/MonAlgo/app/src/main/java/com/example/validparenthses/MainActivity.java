package com.example.validparenthses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText saisir;
    TextView afficher;
    Button valider;
    String message="";
    boolean resultat;
    boolean resultat2;
    boolean resultat3;
    boolean resultatFinal;
    char [] messageEnChar;
    List<Integer> indiceParenthesesOuvertes =new ArrayList<Integer>();
    List<Integer> indiceCrochetsOuverts =new ArrayList<Integer>();
    List<Integer> indiceAccoladesOuvertes =new ArrayList<Integer>();
    List<Integer> indiceParenthesesFermees =new ArrayList<Integer>();
    List<Integer> indiceCrochetsFermes =new ArrayList<Integer>();
    List<Integer> indiceAccoladesFermees =new ArrayList<Integer>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisir =findViewById(R.id.editTextTextSaisir);
        afficher =findViewById(R.id.textView1);
        valider =findViewById(R.id.buttonValider);
        afficher.setText("");

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                message=saisir.getText().toString();
                inialisationListeparenth√®se();
                resultat=testAllListe(indiceParenthesesOuvertes,indiceParenthesesFermees,messageEnChar,'(',')');
                resultat2=testAllListe(indiceAccoladesOuvertes,indiceAccoladesFermees,messageEnChar,'{','}');
                resultat3=testAllListe(indiceCrochetsOuverts,indiceCrochetsFermes,messageEnChar,'[',']');
                resultatFinal=testFinal(resultat,resultat2,resultat3);
                afficher.setText(String.valueOf(resultatFinal));
                message="";
                saisir.setText("");
            }
        });
    }
    // m√©thode qui r√©cup√®re les indices des () [] et {} de la phrase
    // et return une liste
    public List<Integer> rechercheIndiceParenthese(String message,char element){
        int j=0;
        List<Integer> indice = new ArrayList<Integer>();
        char[] phraseEnChar= message.toCharArray();
        for (int k=0;k<phraseEnChar.length;k++){
            if(phraseEnChar[k]==element){

                indice.add(k);
            }
        }
        return indice;
    }

    // m√©thode qui initialise les listes qui sont return de la m√©thode
    // "rechercheIndiceParenthese"
    public void inialisationListeparenth√®se(){
        messageEnChar=message.toCharArray();
        indiceParenthesesOuvertes =rechercheIndiceParenthese(message,'(');
        indiceCrochetsOuverts =rechercheIndiceParenthese(message,'[');
        indiceAccoladesOuvertes =rechercheIndiceParenthese(message,'{');
        indiceParenthesesFermees=rechercheIndiceParenthese(message,')');
        indiceCrochetsFermes =rechercheIndiceParenthese(message,']');
        indiceAccoladesFermees =rechercheIndiceParenthese(message,'}');
    }

    // m√©thode qui v√©rifie :
    // 1 ) Qu'il y a autant de parenth√®ses ferm√©es que de parenth√®ses ouvertes
    //2) Que l'indice de la parenht√®se ferm√©e qui correspond √† l'indice de la
    // parenth√®se ouverte dans la phrase ne soit pas inf√©rieur.
    //3) regarde si entre la parenth√®se ferm√©e et la parenth√®se ouverte il n'y a pas
    // '(' ou ')'
    public Boolean testAllListe(List<Integer> parentheseOuvertes,List<Integer> parentheseFermees,char[] phrase,char signe1,char signe2){
        int indice=0;
        if(parentheseFermees.size()!=parentheseOuvertes.size()){
            return false;
        }

        for (int k=0;k<parentheseFermees.size();k++){
            if(parentheseFermees.get(k)<parentheseOuvertes.get(k)){
                return false;
            }
        }

        for(int j=0;j<parentheseOuvertes.size();j++){
            for (int k=parentheseOuvertes.get(j);k<(parentheseFermees.get(j))-1;k++){
                if(phrase[k+1] == signe1 || phrase[k+1] == signe2){
                    return false;
                }

            }
        }
       return true;

    }

    public boolean testFinal(boolean resultatA,boolean resultatB,boolean resultatC){
        if (resultatA==true && resultatB==true && resultatC==true){
            return true;
        }
        return false;
    }

}