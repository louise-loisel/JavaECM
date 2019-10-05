package com.company;

public class testfile {

    public static void main(String[] args) {

        // ***** Vérification des classes Personne, CompteBanq

        Personne Default = new Personne("Jane", "Doe");

        Personne Aimée = new Personne("Aimée", "Boinnot", "296750000000000", "adresse");
        System.out.println("sexe Aimée = +"Aimée.getSexe());
        System.out.println("année naiss Aimée = " + Aimée.getAnneeNaissance());
        System.out.println("age Aimée = " + Aimée.calculAge());
        System.out.println("dept Aimée = " + Aimée.getDeptNaissance()); // problème avec le département de naissance, retourne '0'?
        Aimée.setNumSecu("105780000000000");
        System.out.println("sexe Aimée = " + Aimée.getSexe());
        System.out.println("année naiss Aimée = " + Aimée.getAnneeNaissance());
        System.out.println("age Aimée = " + Aimée.calculAge());
        System.out.println("dept Aimée = " + Aimée.getDeptNaissance()); // problème avec le département de naissance, retourne '0'?
        Personne Alice = new Personne("Alice", "Howard", "295920000000000", "adresse");
        CompteBanq AliceBanque = new CompteBanq("125", Alice, "123", "234");
        System.out.println("solde Alice défaut= " + AliceBanque.getSolde()); // solde par défaut = 0
        System.out.println("découvert autorisé Alice défaut= " + AliceBanque.getDecouvertAutorise()); // découvert autorisé par défaut
        System.out.println("versement mauvais code")
        AliceBanque.versement(100, "000"); // tentative versement mauvais code
        System.out.println("versement bon code")
        AliceBanque.versement(100, "123"); // versement code correct
        System.out.println("verification bon versement, solde alice =" + AliceBanque.getSolde());// vérification bon versement
        System.out.println(" retrait mauvais code, trop découvert")
        AliceBanque.retrait(25, "000");// retrait mauvais code, trop découvert
        System.out.println(" retrait bon code, trop découvert")
        AliceBanque.retrait(200, "123");// retrait bon code, trop découvert
        System.out.println("retrait -25 bon code, pas de découvert")
        AliceBanque.retrait(25, "123");// retrait bon code, pas de découvert
        // premier retrait 25
        System.out.println("augmentation découvert + 50, mauvais code")
        AliceBanque.setDecouvertAutorise(50, "000"); // augmentation découvert, mauvais code
        System.out.println("augmentation découvert + 50, bon code")
        AliceBanque.setDecouvertAutorise(50, "234");// augmentation découvert, bon code
        System.out.println("Vérification que le découvert a bien fonctionné")
        System.out.println(AliceBanque.getDecouvertAutorise());
        System.out.println("retrait -20, mauvais code")
        AliceBanque.retrait(20, "000");//retrait bon découvert, mauvais code
        System.out.println("retrait -20, bon code")
        AliceBanque.retrait(20, "123");// retrait découvert acceptable, bon code
        // deuxième retrait 20
        System.out.println("print solde alice")
        System.out.println(AliceBanque.getSolde());


        // ****** Vérification des classes EleveDigi, Etudiant, Note

        Note maths = new Note("maths", 15, 60, true);
        Note phys = new Note("phys", 6, false);
        Note chim = new Note("chim", 10, 60, true);

        Array<Note> listeNotes = {maths, phys};

        EleveDigital elevedigi = new EleveDigital("Aimée", "Boinnot", "296750000000000", "adresse", 12312341234, 2015, 2, listeNotes);

        elevedigi.getNotes();
        elevedigi.ajouteNote(chim);
        elevedigi.getNotes();

        System.out.println("Est ce qu'il faut qu'on puisse récupérer d'autres attributs?");
        // pour l'instant ine, promo, annee sont en protected, ils faudrait des getters

        System.out.println("Nom et sexe de l'élève digi, attributs classe mère");
        elevedigi.getNom();
        elevedigi.getSexe();


    //******* Vérification des classes Personnel, Iatos, Enseignant

    // ****** Vérification des classes/interfaces Enfant, Collégien, Lycéen, BB, Ecolier - Scolaire

    // vérifier qu'une classe implémente bien l'interface scolaire :

        if ((!(MaxBB instanceof Scolaire) && (MaxEcolier instanceof Scolaire) && (MaxCollegien instanceof Scolaire) && (MaxLyceen instanceof Scolaire))) {
            System.out.println("Interface Scolaire bien implémentée");
        } else {
            System.out.println("Interface Scolaire mal implémentée, erreur à affiner");
        }

    }
}
