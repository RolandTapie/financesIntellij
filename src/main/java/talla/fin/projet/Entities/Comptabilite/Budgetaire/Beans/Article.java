package talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Fonction fonction;
    @ManyToOne
    private Economique economique;
    @ManyToOne
    private Projet projet;
    @ManyToOne
    private Exercice exercice;
    @ManyToOne
    private Departement departement;
    private String autres="";
}
