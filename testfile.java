package com.company;

public class testfile {

    public static void main(String[] args) {

        // ***** Vérification des classes Personne, CompteBanq

        Personne Default = new Personne("Jane", "Doe");
        
        //Test Personne Aimée
        Personne Aimée = new Personne("Aimée", "Boinnot", "296753700000000", "adresse");
        System.out.println("sexe Aimée = " + Aimée.getSexe());
        System.out.println("année naiss Aimée = " + Aimée.getAnneeNaissance());
        System.out.println("age Aimée = " + Personne.calculAge(Aimée));
        System.out.println("dept Aimée = " + Aimée.getDeptNaissance()); // 
        Aimée.setNumSecu("105781300000000");
        System.out.println("sexe Aimée = " + Aimée.getSexe());
        System.out.println("année naiss Aimée = " + Aimée.getAnneeNaissance());
        System.out.println("age Aimée = " + Personne.calculAge(Aimée));
        System.out.println("dept Aimée = " + Aimée.getDeptNaissance());
        
        /*
CONSOLE
sexe Aimée = F
année naiss Aimée = 1996
age Aimée = 23
dept Aimée = 37
sexe Aimée = M
année naiss Aimée = 2005
age Aimée = 14
dept Aimée = 13
        */
        
        Personne Alice = new Personne("Alice", "Howard", "295920000000000", "adresse");
        CompteBanq AliceBanque = new CompteBanq("125", Alice, "123", "234");
        System.out.println("solde Alice défaut= " + AliceBanque.getSolde()); // solde par défaut = 0
        System.out.println("découvert autorisé Alice défaut= " + AliceBanque.getDecouvertAutorise()); // découvert autorisé par défaut
        System.out.println("on teste versement mauvais code");
        try {
            AliceBanque.versement(100, "000");
        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
        }
        try {
            System.out.println("on teste versement bon code");
            AliceBanque.versement(100, "123"); // versement code correct
            System.out.println("verification bon versement, solde alice =" + AliceBanque.getSolde());// vérification bon versement
            System.out.println("on teste retrait mauvais code, trop découvert");
            AliceBanque.retrait(25, "000");// retrait mauvais code, trop découvert
        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
            }
        try {
            System.out.println("on teste retrait bon code, trop découvert");
            AliceBanque.retrait(200, "123");// retrait bon code, trop découvert
        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
        }
/* CONSOLE
solde Alice défaut= 0.0
découvert autorisé Alice défaut= 0.0
on teste versement mauvais code
Vous avez rentre un code incorrect
on teste versement bon code
verification bon versement, solde alice =100.0
on teste retrait mauvais code, trop découvert
Vous avez rentre un code incorrect
on teste retrait bon code, trop découvert
Découvert insuffisant
*/
        System.out.println("on teste retrait -25 bon code, pas de découvert");
        AliceBanque.retrait(25, "123");// retrait bon code, pas de découvert
        // premier retrait 25
        System.out.println("augmentation découvert + 50, mauvais code");
        AliceBanque.setDecouvertAutorise(50, "000"); // augmentation découvert, mauvais code
        System.out.println("augmentation découvert + 50, bon code");
        AliceBanque.setDecouvertAutorise(50, "234");// augmentation découvert, bon code
        System.out.println("Vérification que le découvert a bien fonctionné");
        System.out.println(AliceBanque.getDecouvertAutorise());
        System.out.println("retrait -20, mauvais code");
        AliceBanque.retrait(20, "000");//retrait bon découvert, mauvais code
        System.out.println("retrait -20, bon code");
        AliceBanque.retrait(20, "123");// retrait découvert acceptable, bon code
        // deuxième retrait 20
        System.out.println("print solde alice");
        System.out.println(AliceBanque.getSolde());
        
/* CODE AVEC LA BONNE SYNTHAXE POUR LES EXCEPTIONS

        System.out.println("on teste retrait -25 bon code, pas de découvert");
        try {
            AliceBanque.retrait(25, "123");// retrait bon code, pas de découvert
        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
        }
        // premier retrait 25
        System.out.println("augmentation découvert + 50, mauvais code");
        AliceBanque.setDecouvertAutorise(50, "000"); // augmentation découvert, mauvais code
        System.out.println("augmentation découvert + 50, bon code");
        AliceBanque.setDecouvertAutorise(50, "234");// augmentation découvert, bon code
        System.out.println("Vérification que le découvert a bien fonctionné");
        System.out.println(AliceBanque.getDecouvertAutorise());

        try {
            System.out.println("retrait -20, mauvais code");
            AliceBanque.retrait(20, "000");//retrait bon découvert, mauvais code

        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
        }
        System.out.println("retrait -20, bon code");
        try {
            AliceBanque.retrait(20, "123");// retrait découvert acceptable, bon code
        }
        catch (CodeIncorrectException e){
            System.out.println(e.getMessage());
        }
        // deuxième retrait 20
        System.out.println("print solde alice");
        System.out.println(AliceBanque.getSolde());
        
--------------CONSOLE
on teste retrait -25 bon code, pas de découvert
augmentation découvert + 50, mauvais code
augmentation découvert + 50, bon code
Vérification que le découvert a bien fonctionné
50.0
retrait -20, mauvais code
Vous avez rentre un code incorrect
retrait -20, bon code
print solde alice
55.0        


*/


        // ****** Vérification des classes EleveDigi, Etudiant, Note

        Note maths = new Note("maths", 15, 60);
        Note phys = new Note("phys", 6, 60);
        Note chim = new Note("chim", 10, 60);

        ArrayList<Note> listeNotes = new ArrayList<Note>();
        listeNotes.add(maths);
        listeNotes.add(phys);


        EleveDigital elevedigi = new EleveDigital("Aimée", "Boinnot", "296750000000000", "adresse", "12312341234", 2015, 2);
        elevedigi.ajouteNote(maths);elevedigi.ajouteNote(phys);
        System.out.println((elevedigi.getNotes().get(0)).getNote()); // juste pour vérifier le nombre d'éléments dans la liste
        elevedigi.ajouteNote(chim);
        System.out.println((elevedigi.getNotes().get(1)).getNote());
/* CONSOLE
15.0
6.0
*/
        

        System.out.println("Est ce qu'il faut qu'on puisse récupérer d'autres attributs?");
        
        
        // pour l'instant ine, promo, annee sont en protected, ils faudrait des getters
// ------------------------TEST ELEVE, NOTE, ELEVEDIGIT-----------------
        System.out.println("Nom et sexe de l'élève digi, attributs classe mère");
        System.out.println(elevedigi.getNom());
        System.out.println(elevedigi.getSexe());


        System.out.println("Nous allons tester les classes Note, Eleve, EleveDigital");
        System.out.println("On crée un élève en Digital, Marie Dupont");
        EleveDigital Marie = new EleveDigital("Dupont","Marie", "2960737000000", "Launay", 151410, 17, 2019);

        System.out.println("Quelle est l'opération voulue ? \n1 : créer un étudiant \n2 : créer un étudiant en digital \n3 : déclarer une nouvelle note à Marie");
        Scanner sc2 = new Scanner(System.in);
        String choixEtudiant = sc2.nextLine();
        if (choixEtudiant.equals("1")) {
            Scanner etudiant1 = new Scanner(System.in);
            System.out.println("Merci de rentrer le nom");
            String nomE = etudiant1.nextLine();
            System.out.println("Merci de rentrer le prenom");
            String prenomE = etudiant1.nextLine();
            System.out.println("Merci de rentrer le numéro de sécurité sociale");
            String numSecuE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'adresse");
            String adresseE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'ine");
            String ineE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'année de cycle");
            int promoE = etudiant1.nextInt();
            System.out.println("Merci de rentrer l'année");
            int anneeE = etudiant1.nextInt();
            Eleve eleve1 = new Eleve(nomE, prenomE, numSecuE, ineE, promoE, anneeE, adresseE);
            System.out.println("L'élève "+eleve1.getNom()+" a bien été créé.");
        }
        else if (choixEtudiant.equals("2")) {
            Scanner etudiant1 = new Scanner(System.in);
            System.out.println("Merci de rentrer le nom");
            String nomE = etudiant1.nextLine();
            System.out.println("Merci de rentrer le prenom");
            String prenomE = etudiant1.nextLine();
            System.out.println("Merci de rentrer le numéro de sécurité sociale");
            String numSecuE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'adresse");
            String adresseE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'ine");
            String ineE = etudiant1.nextLine();
            System.out.println("Merci de rentrer l'année");
            int anneeE = etudiant1.nextInt();
            System.out.println("Merci de rentrer l'année de cycle");
            int promoE = etudiant1.nextInt();
            EleveDigital eleveDigital1 = new EleveDigital(nomE, prenomE, numSecuE, adresseE, ineE, promoE, anneeE);
            System.out.println("L'élève digital"+eleveDigital1.getNom()+" a bien été créé.");
        }
        else if (choixEtudiant.equals("3")) {
            Scanner note1 = new Scanner(System.in);
            System.out.println("Note obtenue :");
            float noteE = note1.nextInt();
            note1.nextLine();
            System.out.println("Nom de la matière :");
            String matiereE = note1.nextLine();
            System.out.println("Nombres de crédits :");
            int creditsE = note1.nextInt();
            Note noteAj = new Note(matiereE, noteE, creditsE);
            System.out.println("La note vient d'être créée.");
            Marie.ajouteNote(noteAj);
            System.out.println("Marie a désormais les notes suivantes en stock : " + Marie.getNotes());
            System.out.println("Marie a t elle validé ?");
            if (noteAj.isValidation()) {
                System.out.println("Oui elle a validé avec " + noteAj.getNote());
            } else {
                System.out.println("Non elle n'a pas validé");
            }
        }
        else {
            System.out.println("Je n'ai pas compris.");
        }
 /* ----------------CONSOLE----------------------------    
 ----------------------------------Création Etudiant
Nous allons tester les classes Note, Eleve, EleveDigital
      
On crée un élève en Digital, Marie Dupont
Quelle est l'opération voulue ? ? 
1 : créer un étudiant 
2 : créer un étudiant en digital 
3 : déclarer une nouvelle note à Marie
1
Merci de rentrer le nom
Loisel
Merci de rentrer le prenom
Louise
Merci de rentrer le numéro de sécurité sociale
296370796000000
Merci de rentrer l'adresse
Launay
Merci de rentrer l'ine
15206780
Merci de rentrer l'année de cycle
2
Merci de rentrer l'année
2017
L'élève Loisel a bien été créé.

Process finished with exit code 0
----------------------------- Création EleveDigital
Quelle est l'opération voulue ? 
1 : créer un étudiant 
2 : créer un étudiant en digital 
3 : déclarer une nouvelle note à Marie
2
Merci de rentrer le nom
Dupont
Merci de rentrer le prenom
Pierre
Merci de rentrer le numéro de sécurité sociale
195350980000006
Merci de rentrer l'adresse
Paris
Merci de rentrer l'ine
128369
Merci de rentrer l'année
2017
Merci de rentrer l'année de cycle
4
L'élève digitalDupont a bien été créé.

Process finished with exit code 0
----------------------------- Création note en dessous de la moyenne
Quelle est l'opération voulue ? 
1 : créer un étudiant 
2 : créer un étudiant en digital 
3 : déclarer une nouvelle note à Marie
3
Note obtenue :
9
Nom de la matière :
Maths
Nombres de crédits :
3
La note vient d'être créée.
Marie a désormais la note suivante en stock : 9.0
Marie a t elle validé ?
Non elle n'a pas validé

Process finished with exit code 0
----------------------------- Création note au dessus de la moyenne
Quelle est l'opération voulue ? 
1 : créer un étudiant 
2 : créer un étudiant en digital 
3 : déclarer une nouvelle note à Marie
3
Note obtenue :
18
Nom de la matière :
Maths
Nombres de crédits :
5
La note vient d'être créée.
Marie a désormais la note suivante en stock : 18.0
Marie a t elle validé ?
Oui elle a validé avec 18.0

Process finished with exit code 0
*/
        
       
        
        
        
        
    //******* Vérification des classes Personnel, Iatos, Enseignant

        // tentative de création d'instance de Personnel (ne devrait pas être possible)
        Personnel Kaiser = new Personnel ("Kaiser", "Soze", "1877500000", "usual suspects", "entrée 20 septembre", 150);
        System.out.println("temps travail Kaiser (personnel)?");
        Kaiser.getTempsTravail();
        System.out.println("nom Kaiser (personnel), attributs Personne?");
        Kaiser.getNom();

        //
        Iatos Yassine=new Iatos("Yassine", "Amiri", "1867900000", "lalaladresse", "entrée 15 septembre", 150, 47, (float) 1.2);
        System.out.println("nom Yassine, héritage Personne = " +  Yassine.getNom());
        System.out.println("tempsTravail Yassine, héritage Personnelll = " +  Yassine.tempsTravail);
        System.out.println("fixe Yassine, attributs défaut Iatos 1200 = " +  Yassine.getFixe());
        System.out.println("taux Yassine, attributs octroyé Iatos 1.2 =" +  Yassine.getTaux());
        Yassine.setTaux((float)1.3);
        System.out.println("taux Yassine changé avec setTaux 1.3 = " +  Yassine.getTaux());
        Yassine.setFixe(2000);
        System.out.println("fixe Yassine changé 2000 = " +  Yassine.getFixe());
        System.out.println("salaire Yassine = 3061,1 ? " + Yassine.calculSalaire());

        Enseignant JazzarsansDécharge=new Enseignant ("Catherine","Jazzar","17613000000","centrale marseille","entree 2007",200,"PRAG");
        System.out.println("nom Jazzar, héritage Personne = " +  JazzarsansDécharge.getNom());
        System.out.println("PRAG fixe = 2000, hminprime = 384 ? " + JazzarsansDécharge.getFixe() + ", "+ JazzarsansDécharge.gethMinPrime());
        
        
        
    // ****** Vérification des classes/interfaces Enfant, Collégien, Lycéen, BB, Ecolier - Scolaire

    // vérifier qu'une classe implémente bien l'interface scolaire :

        if ((!(MaxBB instanceof Scolaire) && (MaxEcolier instanceof Scolaire) && (MaxCollegien instanceof Scolaire) && (MaxLyceen instanceof Scolaire))) {
            System.out.println("Interface Scolaire bien implémentée");
        } else {
            System.out.println("Interface Scolaire mal implémentée, erreur à affiner");
        }

    }
}
