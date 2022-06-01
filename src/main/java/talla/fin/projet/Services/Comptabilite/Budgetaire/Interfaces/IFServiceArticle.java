package talla.fin.projet.Services.Comptabilite.Budgetaire.Interfaces;

import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;
import talla.fin.projet.Exceptions.ArticleNonValideException;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.EconomiqueRepository;
import talla.fin.projet.Repositories.Comptabilite.Budgetaire.FonctionRepository;

public interface IFServiceArticle {

    Boolean ValidationArticle(Article article, FonctionRepository fonctionRepository, EconomiqueRepository economiqueRepository) throws ArticleNonValideException;
}
