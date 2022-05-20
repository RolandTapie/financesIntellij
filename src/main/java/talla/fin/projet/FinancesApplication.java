package talla.fin.projet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import talla.fin.projet.Entities.Banques.Beans.Banque;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Compte;
import talla.fin.projet.Repositories.Banques.BanqueRepository;
import talla.fin.projet.Repositories.Dette.*;
import talla.fin.projet.Repositories.FluxFinanciers.CodaRepository;
import talla.fin.projet.Repositories.FluxFinanciers.CompteRepository;
import talla.fin.projet.Repositories.FluxFinanciers.SoldeRepository;
import talla.fin.projet.Services.Dette.Services.LireInventaireDette;
import talla.fin.projet.Services.FluxFinanciers.Services.LectureCoda;

@SpringBootApplication
public class FinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancesApplication.class, args);
	}

	@Bean
	CommandLineRunner debut(BanqueRepository banqueRepository,CommunRepository communRepository, SignaletiqueRepository signaletiqueRepository, EmpruntRepository empruntRepository, EcheanceRepository echeanceRepository, CoutRepository coutRepository, CompteRepository compteRepository, CodaRepository codaRepository, SoldeRepository soldeRepository)
	{
		return args -> {
//
//			Banque banque1 = new Banque();
//			banque1.setNom("ING");
//			banque1.setAdresse("Adresse ING");
//			banque1.setNumentreprise("Num entreprise ING");
//			banqueRepository.save(banque1);
//			Banque banque2 = new Banque();
//			banque1.setNom("Belfius");
//			banque1.setAdresse("Adresse Belfius");
//			banque1.setNumentreprise("Num entreprise Belfius");
//			banqueRepository.save(banque2);

			LectureCoda lectureCoda = new LectureCoda(compteRepository);
			lectureCoda.ControleEtImport();
			lectureCoda.getListe().forEach(c -> {
				codaRepository.save(c);
			});
			lectureCoda.getListesolde().forEach(s ->{
				soldeRepository.save(s);
			});

			LireInventaireDette lireInventaireDette = new LireInventaireDette();
			lireInventaireDette.execution(banqueRepository);

			System.out.println("Sauvegarde des données communes...");
			lireInventaireDette.getListeCom().forEach(commun -> {
				communRepository.save(commun);
			});
			System.out.println("Sauvegarde des signalétiques...");
			lireInventaireDette.getListeSign().forEach(signaletique -> {
				signaletiqueRepository.save(signaletique);
			});
			System.out.println("Sauvegarde des échéances...");
			lireInventaireDette.getListeEch().forEach(echeance -> {
				echeanceRepository.save(echeance);
			});
			System.out.println("Sauvegarde des échéances : coût...");
			lireInventaireDette.getListecout().forEach(cout -> {
				coutRepository.save(cout);
			});

			System.out.println("Initialisation terminée");
		};
	}
}
