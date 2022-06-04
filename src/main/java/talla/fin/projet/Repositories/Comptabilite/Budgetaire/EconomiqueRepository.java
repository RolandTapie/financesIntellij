package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Economique;

import java.util.List;

public interface EconomiqueRepository extends JpaRepository<Economique,Integer> {
    public List<Economique> findByEco(String NumEconomique);
}
