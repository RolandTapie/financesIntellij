package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Fonction;

import java.util.List;

public interface FonctionRepository extends JpaRepository<Fonction, Integer> {
    public List<Fonction> findByNumfonction(String numeroFonction);
}
