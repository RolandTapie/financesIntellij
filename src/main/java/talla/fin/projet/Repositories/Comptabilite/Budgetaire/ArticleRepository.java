package talla.fin.projet.Repositories.Comptabilite.Budgetaire;

import org.springframework.data.jpa.repository.JpaRepository;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    public Article findByArt(String article);
}
