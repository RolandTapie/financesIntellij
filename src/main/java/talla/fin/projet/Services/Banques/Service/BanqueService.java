package talla.fin.projet.Services.Banques.Service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talla.fin.projet.Entities.Banques.Beans.Banque;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;
import talla.fin.projet.Repositories.Banques.BanqueRepository;
import talla.fin.projet.Repositories.FluxFinanciers.CodaRepository;
import talla.fin.projet.Services.Banques.Interfaces.InterfaceBanqueService;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class BanqueService implements InterfaceBanqueService {
    BanqueRepository banqueRepository;
    CodaRepository codaRepository;

    @Override
    public List<Banque> ListeBanque(){
        return  banqueRepository.findAll();
    }

    @Override
    public List<Coda> ListeCoda() {return codaRepository.findAll();
    }

    @Override
    public void MiseajourBanque(Integer id, String nom, String adresse, String numEntreprise) {
        Banque banque = banqueRepository.findById(id).orElseThrow();
        banque.setNom(nom);
        banque.setAdresse(adresse);
        banque.setNumentreprise(numEntreprise);
        banqueRepository.save(banque);
        System.out.println("Enregistrement : " + banque.toString());
    }

    @Override
    public void SupprimerBanque(Integer id)
    {
        String banque = (banqueRepository.findById(id)).toString();
        banqueRepository.deleteById(id);
        System.out.println("Suppression : " + banque);
    }

    @Override
    public Banque AjouterBanque(String nom, String adresse, String numEntreprise)
    {
        Banque banque = new Banque();
        banque.setNom(nom);
        banque.setAdresse(adresse);
        banque.setNumentreprise(numEntreprise);
        banqueRepository.save(banque);
        return banque;
    }

}
