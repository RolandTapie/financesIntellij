package talla.fin.projet.Services.Tiers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import talla.fin.projet.Entities.Tiers.Beans.Tiers;
import talla.fin.projet.Repositories.Tiers.TiersRepository;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class TiersService {

  TiersRepository tiersRepository;

    public List<Tiers> listeTiers(){
        return  tiersRepository.findAll();
    }
}
