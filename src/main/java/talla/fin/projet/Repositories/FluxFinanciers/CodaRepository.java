package talla.fin.projet.Repositories.FluxFinanciers;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;

public interface CodaRepository extends JpaRepository<Coda, Integer> {
}
