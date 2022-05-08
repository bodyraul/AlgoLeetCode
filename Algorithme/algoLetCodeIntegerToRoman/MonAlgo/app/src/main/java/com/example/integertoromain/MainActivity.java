package com.example.integertoromain;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText saisir;
TextView afficher;
Button valider;
String nombreString="";
String nombreString2;
String chiffreString= "";
Integer nombreInteger=0;
String convertion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saisir=findViewById(R.id.editTextTextSaisir);
        afficher=findViewById(R.id.textView1);
        afficher.setText("");
        valider=findViewById(R.id.buttonValider);

        valider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initialisation();
                if(nombreString2.matches("[0-9]+")==true){
                    nombreInteger=Integer.valueOf(nombreString);
                    ajouterConvertionMCX(1000,3001,"M","M","M","M");
                    ajouterConvertionMCX(100,1000,"C","CD","D","CM");
                    ajouterConvertionMCX(10,100,"X","XL","L","XC");
                    ajouterConvertionUnite(1,9,"I","IV","V","IX");
                    afficher.setText(nombreString2+" = "+convertion);
                    saisir.setText("");
                }
                else {
                    Toast.makeText(MainActivity.this, "Vous ne pouvez saisir que des chiffres", Toast.LENGTH_SHORT).show();
                    saisir.setText("");
                    return;
                }
            }
        });
    }

    public void initialisation(){
        afficher.setText("");
        nombreString2="";
        convertion="";
        nombreString=saisir.getText().toString();
        nombreString2=saisir.getText().toString();
    }

    public String conversionPremierChiffre(String chiffreString,String unAtrois,String quatre,String cinq,String neuf){
        Integer chiffreInteger=Integer.valueOf(chiffreString);
        String convertion="";

       if (chiffreInteger>=1 && chiffreInteger<=3){
          for (int k=0;k<chiffreInteger;k++){
              convertion+=unAtrois ;
          }
       }
       if (chiffreInteger==4){
           convertion+=quatre;
       }
        if (chiffreInteger==5){
            convertion+=cinq;
        }
        if (chiffreInteger>=6 && chiffreInteger<=8){
            convertion=cinq;
            for (int k=5;k<chiffreInteger;k++){
                convertion+=unAtrois ;
            }
        }
        if (chiffreInteger==9){
            convertion=neuf;
        }
       return convertion;
    }

    public void ajouterConvertionMCX(int nbInferieur, int nbSuperieur, String unAtrois, String quatre, String cinq, String neuf){
        if (nombreInteger>=nbInferieur && nombreInteger<nbSuperieur){
            chiffreString=nombreString.substring(0,1);
            nombreString=nombreString.substring(1,(nombreString.length()));
            nombreInteger=Integer.valueOf(nombreString);
            convertion+=conversionPremierChiffre(chiffreString,unAtrois,quatre,cinq,neuf);

        }
    }

    public void ajouterConvertionUnite(int nbInferieur, int nbSuperieur, String unAtrois, String quatre, String cinq, String neuf){
        if (nombreInteger>=1 && nombreInteger<=9){
            chiffreString=nombreString.substring(0,1);
            convertion+=conversionPremierChiffre(chiffreString,unAtrois,quatre,cinq,neuf);
            System.out.println(convertion);
        }
    }


}

