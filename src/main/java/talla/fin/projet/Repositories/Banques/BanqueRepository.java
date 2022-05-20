package talla.fin.projet.Repositories.Banques;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Banques.Beans.Banque;

import java.util.List;

public interface BanqueRepository extends JpaRepository<Banque,Integer> {
    List<Banque> findByNom(String nom);
}
