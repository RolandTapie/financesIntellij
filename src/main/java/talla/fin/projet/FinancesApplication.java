package talla.fin.projet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Compte;
import talla.fin.projet.Repositories.FluxFinanciers.CodaRepository;
import talla.fin.projet.Repositories.FluxFinanciers.CompteRepository;
import talla.fin.projet.Repositories.FluxFinanciers.SoldeRepository;
import talla.fin.projet.Services.FluxFinanciers.Services.LectureCoda;

@SpringBootApplication
public class FinancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancesApplication.class, args);
	}

	@Bean
	CommandLineRunner debut(CompteRepository compteRepository, CodaRepository codaRepository, SoldeRepository soldeRepository)
	{
		return args -> {
//			Compte cpte= new Compte();
//			cpte.setCompte("12345");
//			compteRepository.save(cpte);
//			cpte=compteRepository.findById(1).orElseThrow();
//			Coda coda = new Coda();
//			coda.setCompte(cpte);
//			codaRepository.save(coda);

			LectureCoda lectureCoda = new LectureCoda(compteRepository);
			lectureCoda.ControleEtImport();
			lectureCoda.getListe().forEach(c -> {
				codaRepository.save(c);
			});
			lectureCoda.getListesolde().forEach(s ->{
				soldeRepository.save(s);
			});
			System.out.println("Initialisation terminée");
		};
	}
}
