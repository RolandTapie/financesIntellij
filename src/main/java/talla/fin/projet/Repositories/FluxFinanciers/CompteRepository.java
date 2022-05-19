package talla.fin.projet.Repositories.FluxFinanciers;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Compte;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
}
