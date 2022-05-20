package talla.fin.projet.Repositories.Dette;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Dette.Beans.Echeance;

public interface EcheanceRepository extends JpaRepository<Echeance,Integer> {
}
