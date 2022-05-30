package talla.fin.projet.Entities.Comptabilite.Generale.Beans;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class CG {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String numeroCg="1700";
    private String libelle="Emprunts à plus d'un an";
    private String catBilan="Passif";
    private String rubrique="VIII.A.I";
}
