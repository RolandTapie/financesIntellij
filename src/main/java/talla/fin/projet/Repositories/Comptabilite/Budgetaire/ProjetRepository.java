package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Projet;

public interface ProjetRepository extends JpaRepository<Projet, Integer> {
    Projet findByNumeroprojet (String numProjet);
}
