package talla.fin.projet.Entities.Imports.Budgetaire;

import talla.fin.projet.Entities.Imports.Generale.ImportCG;
import talla.fin.projet.Entities.Imports.Tiers.ImportTiers;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.AllocationRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EngagementRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.FonctionRepository;
import talla.fin.projet.Repositories.Comptabilite.Generale.CGRepository;
import talla.fin.projet.Repositories.Tiers.TiersRepository;

import java.io.FileNotFoundException;

public class Imports {

    public static String source="src/main/java/talla/fin/projet/ZFiles/";
    
    public static void execution(CGRepository cgRepository,EngagementRepository engagementRepository, TiersRepository tiersRepository, AllocationRepository allocationRepository, FonctionRepository fonctionRepository, EconomiqueRepository economiqueRepository) {

        System.out.println("  > Import du fichier de Fonctions");
        try {
            ImportFonction.Execution(source, fonctionRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("  > Import du fichier de CG");
        try {
            ImportCG.Execution(source, cgRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de CG inexistant");
        }

        System.out.println("  > Import du fichier de Economiques");
        try {
            ImportEconomique.Execution(source, economiqueRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("  > Import du fichier de Allocations");
        System.out.println("  > Validation des articles necessaire à l'import des allocations");
        try {
            ImportAllocation.Execution(source,allocationRepository,fonctionRepository, economiqueRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de Allocations inexistant");
        }
        System.out.println("  > Import du fichier de Tiers");
        try {
            ImportTiers.Execution(source,tiersRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de fonctions inexistant");
        }

        System.out.println("  > Import du fichier de Engagements");
        try {
            ImportEngagement.Execution(source,engagementRepository);
        } catch (FileNotFoundException f)
        {
            System.out.println("Fichier d'import de Engagements inexistant");
        }
    }
}
