package talla.fin.projet.Services.Banques.Interfaces;

import talla.fin.projet.Entities.Banques.Beans.Banque;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;

import java.util.List;

public interface InterfaceBanqueService {
    List<Banque> ListeBanque();
    List<Coda> ListeCoda();

    void MiseajourBanque(Integer id, String nom, String adresse, String numEntreprise);

    void SupprimerBanque(Integer id);

    Banque AjouterBanque(String nom, String adresse, String numEntreprise);
}
