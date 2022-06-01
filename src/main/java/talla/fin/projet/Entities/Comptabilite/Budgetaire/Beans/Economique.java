package talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import talla.fin.projet.Entities.Comptabilite.Generale.Beans.CG;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Economique {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String eco="121-01";
    private String libelle="Test Code Eco";
    private String nature="Test nature";
    private String service="Ordinaire";

    @ManyToOne
    private CG cgDebit;

    @ManyToOne
    private CG cgCredit;// acceptée ou refusée
}
