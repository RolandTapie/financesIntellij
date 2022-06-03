package talla.fin.projet.Entities.Imports.Budgetaire;

import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Depenses.Engagement;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Depenses.FactureIn;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Economique;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EngagementRepository;

import javax.persistence.ManyToOne;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportEngagement {

    public static void Execution(EngagementRepository engagementRepository) throws FileNotFoundException {

        FactureIn factureIn;

        Article article;
        String libelle="Engagemende la depense";
         double montantEng=1233444;
         String statutEng="Definitif";
         String college="89";
         double soldeEng=950;

        Scanner scan = new Scanner(new File("src/main/java/talla/fin/projet/ZFiles/Engagements.txt"));


        while (scan.hasNextLine()) {
            String ligne=scan.nextLine();

            String[] champs=ligne.split(";");

            libelle=champs[1];
            montantEng=Double.parseDouble(champs[2].replace(",","."));
            statutEng=champs[3];
            college=champs[4];
            soldeEng=Double.parseDouble(champs[5].replace(",","."));

            Engagement engagement = new Engagement();

            engagement.setLibelle(libelle);
            engagement.setMontantEng(montantEng);
            engagement.setStatutEng(statutEng);
            engagement.setCollege(college);
            engagement.setSoldeEng(soldeEng);

            engagementRepository.save(engagement);

        }
    }
}
