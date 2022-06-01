package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Fonction;

public interface FonctionRepository extends JpaRepository<Fonction, Integer> {
    public Fonction findByNumfonction(String numeroFonction);
}
