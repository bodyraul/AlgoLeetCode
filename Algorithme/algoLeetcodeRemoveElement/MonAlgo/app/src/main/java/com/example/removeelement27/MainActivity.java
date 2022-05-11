package com.example.removeelement27;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int[] num = {1,3,0,3,4,3,3,3,6,3,5};
    int valeur=0;
    int doublons=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valeur= valeurDouble(num);
        doublons=nombreIterationValeur(valeur,num);
        int[] tableauFinal=new int[doublons];
        tableauFinal=tableaufinale(doublons,valeur,num);
        for (int k=0;k<tableauFinal.length;k++){
          System.out.println(String.valueOf(tableauFinal[k]));
        }
    }

    public int valeurDouble(int [] nombres){
        int valeur=0;
        for (int k=0;k<nombres.length;k++){
            for(int j=0;j<nombres.length;j++){
                if(nombres[k]==nombres[j] && k!=j){
                    return valeur=nombres[k];
                }
            }
        }
        return valeur;
    }

    public int nombreIterationValeur(int valeur, int[] nombre){
       int iteration=0;
       for (int k=0;k<nombre.length;k++){
           if (nombre[k]==valeur){
               iteration++;
           }
       }
       return iteration;
    }
    public int[] tableaufinale(int doublons,int valeur,int[]nombre){
        int[] tableauFinal=new int[doublons-1];
        int j=0;
        for (int k=0;k<nombre.length;k++){
            if(nombre[k]!=valeur){
                tableauFinal[j]=nombre[k];
                j++;
            }
        }
        return tableauFinal;
    }
}