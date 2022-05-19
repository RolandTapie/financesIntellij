package talla.fin.projet.Repositories.FluxFinanciers;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Compte;

import java.util.List;

public interface CompteRepository extends JpaRepository<Compte, Integer> {
    List<Compte> findByCompte(String compte);
}
