package talla.fin.projet.Services.Comptabilite.Budgetaire.Implementations;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Economique;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Fonction;
import talla.fin.projet.Exceptions.ArticleNonValideException;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.FonctionRepository;
import talla.fin.projet.Services.Comptabilite.Budgetaire.Interfaces.IFServiceArticle;

@AllArgsConstructor
@NoArgsConstructor
public class ServiceArticle implements IFServiceArticle {
    FonctionRepository fonctionRepository;
    EconomiqueRepository economiqueRepository;
    @Override
    public Boolean ValidationArticle(Article article, FonctionRepository fonctionRepository, EconomiqueRepository economiqueRepository) throws ArticleNonValideException {
        Boolean result=true; //true
        int idf=article.getFonction().getId();
        int ide=article.getEconomique().getId();
        Fonction fonction = fonctionRepository.findById(idf).orElseThrow(()-> new ArticleNonValideException("Fonction non existante"));
        Economique economique= economiqueRepository.findById(ide).orElseThrow(()-> new ArticleNonValideException("Economique non existante"));
        if (fonction==null || economique==null)
        {
            result = false;
            throw new ArticleNonValideException("la fonction ou l'économique est inexistante");
        }

        return  result;
    }
}
