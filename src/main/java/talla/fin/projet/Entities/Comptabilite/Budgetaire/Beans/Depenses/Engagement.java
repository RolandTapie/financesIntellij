package talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Depenses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Article;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Engagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private FactureIn factureIn;

    @ManyToOne
    private Article article;
    private String libelle="Engagemende la depense";
    private double montantEng=1233444;
    private String statutEng="Definitif";
    private String college="89";
    private double soldeEng=950;
}
