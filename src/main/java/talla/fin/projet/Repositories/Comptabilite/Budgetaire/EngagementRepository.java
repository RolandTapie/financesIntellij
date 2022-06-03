package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Depenses.Engagement;

public interface EngagementRepository extends JpaRepository<Engagement, Integer> {

}
