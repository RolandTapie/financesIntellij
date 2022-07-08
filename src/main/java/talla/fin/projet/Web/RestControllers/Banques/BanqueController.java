package talla.fin.projet.Web.RestControllers.Banques;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import talla.fin.projet.Entities.Banques.Beans.Banque;
import talla.fin.projet.Entities.FluxFinanciers.Beans.Coda;
import talla.fin.projet.Entities.Tiers.Beans.Tiers;
import talla.fin.projet.Services.Banques.Interfaces.InterfaceBanqueService;
import talla.fin.projet.Services.Banques.Service.BanqueService;
import talla.fin.projet.Services.Tiers.TiersService;

import java.util.List;

@RestController
@AllArgsConstructor
public class BanqueController {
private InterfaceBanqueService banqueService;
private TiersService tiersService;

    @GetMapping("/Banques")
    public List<Banque> ListeBanque(){
        return banqueService.ListeBanque();
    }
    @GetMapping("/Flux")
    public List<Coda> ListeFlux(){
        return banqueService.ListeCoda();
    }
    @GetMapping("/Tiers")
    public List<Tiers> ListeTier(){
        return tiersService.listeTiers();
    }
}
