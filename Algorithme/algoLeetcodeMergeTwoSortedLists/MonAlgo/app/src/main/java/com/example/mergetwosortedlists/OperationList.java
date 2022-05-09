package com.example.mergetwosortedlists;

import java.util.ArrayList;
import java.util.List;

public class OperationList {


    public List<Integer> trierListe(List<Integer> liste1,List<Integer> liste2){
        int tailleTbaleau=liste1.size()+liste2.size();
        List<Integer>listeTriee= new ArrayList<Integer>();
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

        return listeTriee;
    }


    public String concatPhrase(List<Integer> list,String phrase){
        for(int k=0;k<list.size();k++){
            if (k!=list.size()-1){
                phrase=phrase.concat( String.valueOf(list.get(k))+"  ");
            }
            if (k==list.size()-1){
                phrase=phrase.concat( String.valueOf(list.get(k)));
            }
        }
        return phrase;
    }
}
