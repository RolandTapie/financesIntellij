package talla.fin.projet.Entities.Imports.Generale;

import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Allocation;
import talla.fin.projet.Entities.Comptabilite.Generale.Beans.CG;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.AllocationRepository;
import talla.fin.projet.Repositories.Comptabilite.Generale.CGRepository;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportCG {
    public static void Execution(String source, CGRepository cgRepository) throws FileNotFoundException {

        String numeroCg="1700";
         String libelle="Emprunts à plus d'un an";
         String catBilan="Passif";
        String rubrique="VIII.A.I";


        Scanner scan = new Scanner(new File(source+"CG.txt"));


        while (scan.hasNextLine()) {
            String ligne=scan.nextLine();

            String[] champs=ligne.split(";");
            numeroCg = champs[0];
            libelle= champs[1];
            catBilan= champs[2];
            rubrique= champs[3];


            CG cg = new CG();

            cg.setNumeroCg(numeroCg);
            cg.setLibelle(libelle);
            cg.setCatBilan(catBilan);
            cg.setRubrique(rubrique);

            //TODO: lier aux entités JPA


            cgRepository.save(cg);

        }
    }
}
