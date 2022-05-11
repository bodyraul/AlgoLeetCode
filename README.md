# Information

- Dans le dossier  Apprentissage, il y  a une liste de toutes les méthodes ou techniques apprises répertoriées par catégories. 
-  Dans le dossier Algorithme, il y a  des sous-dossiers composés  de mon algorithme, d'une correction proposée par des développeurs sur le forum de Leetcode et d'une  note expliquant  le résultat attendu de cet algorithme.
- De plus, chaque algorithme sera écrit en JAVA et la plupart du temps accompagné d'une interface graphique réalisée sur Adroid studio.

# Je vous souhaite une bonne visite


``

class Solution{ 
    public int romanToInt(String S){ 
        int ans = 0, num = 0;
        for (int i = S.length()-1; i >= 0; i--){
            switch(S.charAt(i)){ 
            
                case 'I': num = 1; break;
                case 'V': num = 5; break;
                case 'X': num = 10; break;
                case 'L': num = 50; break;
                case 'C': num = 100; break;
                case 'D': num = 500; break;
                case 'M': num = 1000; break;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
}

``
