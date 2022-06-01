package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Exercice;

public interface ExerciceRepository extends JpaRepository<Exercice,Integer> {
}
