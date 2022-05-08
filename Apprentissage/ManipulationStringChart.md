# Manipulation String

- permet de récupérer un caractère du String à l'indice i
```
String s ="bonjour";
char symbol = s.charAt(i)     
```


- [mMcCdDxXlLvViI]+" teste si les caractères définis dans le regex son présents dans toute la phrase et non pas seulement pour la première lettre comparé à "[mMcCdDxXlLvViI]" => le "+" fait la différence ici.
```
if (chiffreRomain.matches("[mMcCdDxXlLvViI]+")==true)
```


- convertir un type Char en String
```
char charVar = 'c';
String strVar = String.valueof(charvar);
```


- convertir un type int en String
```
int nombre = 1;
String strVar = String.valueof(nombre);
```


- récupérer un sous ensemble d'une phrase.
```
String phrase = "bonjour";
String phrase2 = phrase.substring(0,3); // phrase2="bonj";
```


- Supprimer un sous ensemble d'une phrase
```
String phrase = "bon jour";
int position = 3;
String phrase2 = phrase.substring(0,position) + phrase.substring(position+1) ; 
// phrase2="bonjour";
```


# Manipulation Char

- permet de récupérer tous les caractères d'une phrase dans un tableau de caractères pour les manipuler un à un
```
String phrase="bonjour";
char[] tableau = phrase.toCharArray();
```