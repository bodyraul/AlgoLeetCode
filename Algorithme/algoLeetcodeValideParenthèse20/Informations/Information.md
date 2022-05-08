# Information

- Cet algorithme permet de saisir une phrase et de faire en sorte qu'il n'y ait pas d'autre parenthèse ouvertes de même types entre l'ouverture d'une parenthèse et sa fermeture.
- exemple1 : (sfs{d)dsd} => return true 
- exemple2 : (sdq(dqd) {sqd){dsqd}qsdq} => return false 
-De plus une parenthèse fermée ne peut pas se situer devant une parenthèse ouverte
-exemple : dfds)sdf()fdgd) => return false