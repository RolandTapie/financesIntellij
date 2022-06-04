package talla.fin.projet.Entities.Imports.Budgetaire;

import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Allocation;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Economique;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Fonction;
import talla.fin.projet.Exceptions.ArticleNonValideException;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.AllocationRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.FonctionRepository;
import talla.fin.projet.Services.Comptabilite.Budgetaire.Implementations.ServiceArticle;
import talla.fin.projet.Services.Comptabilite.Budgetaire.Interfaces.IFServiceArticle;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ImportAllocation {

    public static void Execution(String source, AllocationRepository allocationRepository, FonctionRepository fonctionRepository, EconomiqueRepository economiqueRepository) throws FileNotFoundException {

        String article ="";
        double initial=0;
        double solde=0;
        String cahier="";
        String date="";


        Scanner scan = new Scanner(new File(source+"Allocations.txt"));


        while (scan.hasNextLine()) {
            String ligne=scan.nextLine();

            String[] champs=ligne.split(";");
            article = champs[0];
            initial= Double.parseDouble(champs[1].replace(",","."));
            solde= Double.parseDouble(champs[2].replace(",","."));
            cahier= champs[3];
            date= champs[4];


            Allocation allocation= new Allocation();

            //TODO: Valider l'article
            IFServiceArticle serviceArticle = new ServiceArticle() {
            };
            Article article1 = serviceArticle.ConstitutionArticle(article);

            try {
                Boolean test = serviceArticle.ValidationArticle(article1, fonctionRepository, economiqueRepository);
                if (test==true)
                {
                    allocation.setArticle(article);
                    allocation.setInitial(initial);
                    allocation.setSolde(solde);
                    allocation.setCahier(cahier);
                    allocation.setDate(date);

                    //TODO: lier aux entités JPA

                    allocationRepository.save(allocation);
                    System.out.println("Article enregistré : "+ article);
                }
            } catch (ArticleNonValideException anve)
            {
                System.out.println(anve.getMessage());
                System.out.println("Article non valide : "+ article);
            }



        }
    }
}
