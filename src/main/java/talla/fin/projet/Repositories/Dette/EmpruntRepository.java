package talla.fin.projet.Repositories.Dette;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Dette.Beans.Emprunt;

public interface EmpruntRepository extends JpaRepository<Emprunt,Integer> {
}
