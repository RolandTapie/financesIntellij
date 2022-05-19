package talla.fin.projet.Entities.Dette.Beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import talla.fin.projet.Entities.Banques.Beans.Banque;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Emprunt implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String type="1";

    @ManyToOne
    private Banque banque;
    private String designation="emprunt test";
    private String statut="en cours";
    private String nature="710";
    private double mad=100000;
    private double montant=100000;
    private double conversion=100000;
    private double taux=1.5;
    private double revision=0;
    private String moderemboursement="constant";
    private String pInt="Annuelle";
    private String pCap="Annuelle";
    private String codeOperation="à definir";
    private String codeFonctionnel="000";
    private String codeEconomique="21101";
    private String codeActivite="Entité publique";
    private String structure="SWAP";
}
