package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Departement;

public interface DepartementRepository extends JpaRepository<Departement, Integer> {
    Departement findByNom (String nomDepartement);
}
