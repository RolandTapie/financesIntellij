package talla.fin.projet.Entities.Comptabilite.Budgetaire.Beans.Depenses;


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
public class Ordonnancement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Imputation imputation;
    private double montantOrdonnance=566777;
    private String College="31/12/2022";
}
