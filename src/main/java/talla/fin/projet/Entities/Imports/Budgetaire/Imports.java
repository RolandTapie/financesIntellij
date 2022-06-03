package talla.fin.projet.Entities.Imports.Budgetaire;

import talla.fin.projet.Entities.Imports.Tiers.ImportTiers;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.AllocationRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EngagementRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.FonctionRepository;
import talla.fin.projet.Repositories.Tiers.TiersRepository;

import java.io.FileNotFoundException;

public class Imports {
    public static void execution(EngagementRepository engagementRepository, TiersRepository tiersRepository, AllocationRepository allocationRepository, FonctionRepository fonctionRepository, EconomiqueRepository economiqueRepository) {
        System.out.println("Import du fichier de Fonctions");
        try {
            ImportFonction.Execution(fonctionRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("Import du fichier de Economiques");
        try {
            ImportEconomique.Execution(economiqueRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("Import du fichier de Allocations");
        try {
            ImportAllocation.Execution(allocationRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("Import du fichier de Tiers");
        try {
            ImportTiers.Execution(tiersRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("Import du fichier de Engagements");
        try {
            ImportEngagement.Execution(engagementRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de Engagements inexistant");
        }
    }
}
