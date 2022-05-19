package talla.fin.projet.Repositories.FluxFinanciers;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Solde;

public interface SoldeRepository extends JpaRepository<Solde, Integer> {
}
