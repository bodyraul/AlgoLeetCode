package com.example.removedupliatesfromsortedarray26;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
int []nombres ={0,0,1,1,1,2,2,3,3,4,4,4};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String phrase1="";
        String phrase2="";
        int nombre=removeDuplicates(nombres);
        int[] nombresAttendu = new int[nombre];
        nombresAttendu=remplissageTableau(nombresAttendu);
        for(int k=0;k<nombres.length;k++){
            phrase1=phrase1.concat(String.valueOf(nombres[k]));
        }

        for(int k=0;k<nombresAttendu.length;k++){
           phrase2=phrase2.concat(String.valueOf(nombresAttendu[k]));
        }
        System.out.println(phrase1);
        System.out.println(phrase2);
        System.out.println(" nombres de doublons =  "+String.valueOf(nombre));

    }

    public int removeDuplicates(int [] nombres){
        int doublons=0;
        for (int j=1;j<nombres.length;j++){
            if ( j<nombres.length-1 && nombres[j] == nombres[j-1] && nombres[j] == nombres[j+1] ){
                doublons=doublons;

            }else{
                if (j<nombres.length-1 && nombres[j]==nombres[j-1] && nombres[j]!=nombres[j+1] ){
                    doublons++;

                }else {
                    if (j == nombres.length-1 && nombres[j]==nombres[j-1]){
                        doublons++;
                    }
                }
            }
        }
        return doublons;
    }

    public int[] remplissageTableau(int[] tableau){
        for (int k =0;k<tableau.length;k++){
            tableau[k]=k;
        }
        return tableau;
    }
}