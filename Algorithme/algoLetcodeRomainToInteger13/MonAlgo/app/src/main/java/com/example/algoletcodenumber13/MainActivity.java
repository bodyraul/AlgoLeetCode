package com.example.algoletcodenumber13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText ecrire;
    TextView afficher;
    Button valider;
    String souschaine="";
    List<Integer> sommePlusIndiceDelete;
    int[] tableauSommeEtIndices =new int[2];
    int somme;
    int  indice=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ecrire=findViewById(R.id.editTextTextEcrire);
        afficher=findViewById(R.id.textViewAfficher);
        valider=findViewById(R.id.buttonValider);
        String chiffreRomain="";



        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                somme=0;
                String chiffreRomain=ecrire.getText().toString();

                if (chiffreRomain.matches("[mMcCdDxXlLvViI]+")==true){

                    char[] tableau = chiffreRomain.toCharArray();

                   tableauSommeEtIndices = testeMCX('m','c','M','C',1000,100,somme,indice,tableau);
                    tableauSommeEtIndices= testDLV('d','c','D','C',500,100,tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    tableauSommeEtIndices= testeMCX('c','x','C','X',100,10,tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    tableauSommeEtIndices= testDLV('l','x','L','X',50,10,tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    tableauSommeEtIndices= testeMCX('x','i','X','I',10,1,tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    tableauSommeEtIndices= testDLV('v','i','V','I',5,1,tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    somme=testI(tableauSommeEtIndices[0],tableauSommeEtIndices[1],tableau);
                    afficher.setText(String.valueOf(somme));

                }else{
                    Toast.makeText(MainActivity.this, "saisissez un chiffre romain valide", Toast.LENGTH_SHORT).show();
                    return;
                }

            }

        });

    }


    public int[] testeMCX(char lettreSuperieurMinuscule, char lettreInferieurMinuscule, char lettreSuperieurMajuscule, char lettreInferieurMajuscule, int nbAdittion, int nbSoustraction, int somme, int indice,char[] tableau){


        int tailleTableau=tableau.length;
        for(int k=indice;k<tailleTableau;k++){
            if(tableau[k]==lettreSuperieurMinuscule || tableau[k]==lettreSuperieurMajuscule){
                indice=k;
                somme+=nbAdittion;
                break;
            }
        }if( indice!=tailleTableau-1 && (tableau[indice+1]==lettreSuperieurMinuscule||tableau[indice+1]==lettreSuperieurMajuscule)){
            somme+=nbAdittion;

        }if(indice!=tailleTableau-1 && indice!=tailleTableau-2 && (tableau[indice+2]==lettreSuperieurMinuscule||tableau[indice+2]==lettreSuperieurMajuscule)){
            somme+=nbAdittion;
        }if (indice >=1 && (tableau[indice-1]==lettreInferieurMinuscule||tableau[indice-1]==lettreInferieurMajuscule)){
            somme-=nbSoustraction;
        }
        int[] tableauSommeEtIndice=new int[2];
        tableauSommeEtIndice[0]=somme;
        tableauSommeEtIndice[1]=indice;
        return tableauSommeEtIndice;
    }


    public int[] testDLV(char lettreSuperieurMinuscule, char lettreInferieurMinuscule, char lettreSuperieurMajuscule, char lettreInferieurMajuscule, int nbAdittion, int nbSoustraction, int somme, int indice, char[] tableau){

        int tailleTableau=tableau.length;
        int index=0;
        for(int k=indice;k<tailleTableau;k++){
            if(tableau[k]==lettreSuperieurMinuscule||tableau[k]==lettreSuperieurMajuscule){
                indice=k;
                somme+=nbAdittion;
                index=1;
                break;
            }
        }
        if (index==1 && indice >=1 && (tableau[indice-1]==lettreInferieurMinuscule||tableau[indice-1]==lettreInferieurMajuscule)){
            somme-=nbSoustraction;
        }
        int[] tableauSommeEtIndice=new int[2];
        tableauSommeEtIndice[0]=somme;
        tableauSommeEtIndice[1]=indice;
        return tableauSommeEtIndice;
    }

    public int testI( int somme, int indice, char[] tableau){
        int tailleTableau=tableau.length;
        int index=0;
        for(int k=indice;k<tailleTableau;k++){
            if(tableau[k]=='i'||tableau[k]=='I'){
                somme+=1;
                index+=1;
                if (index>=3){
                    break;
                }
            }
        }
    return somme;
    }




}
