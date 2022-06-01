package talla.fin.projet.Entities.Imports.Budgetaire;

import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.*;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportFonction {

    public static void Execution( FonctionRepository fonctionRepositoryry) throws FileNotFoundException {

        String numfonction ="";
        String libelle="";

        Scanner scan = new Scanner(new File("src/main/java/talla/fin/projet/ZFiles/Fonctions.txt"));


        while (scan.hasNextLine()) {
            String ligne=scan.nextLine();

            String[] champs=ligne.split(";");
            numfonction = champs[0];
           libelle= champs[1];

           Fonction fonction = new Fonction();
           fonction.setNumfonction(numfonction);
           fonction.setLibelle(libelle);

           fonctionRepositoryry.save(fonction);

        }
    }
}
