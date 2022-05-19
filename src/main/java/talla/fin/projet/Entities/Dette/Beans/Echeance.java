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
public class Echeance implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    public String dateinv="";
    public String immatriculation="";
    public String nomEmprunteur="";
    public String ins="";
    public String emprunteur="";
    public String comptabilite="";
    public String maj="";
    public String version="";
    public String datefichier="";
    public String debutmaj="";
    public String finmaj="";
    public String sequencepret="";
    public String sequenceenregistrement="";

    @ManyToOne
    public Emprunt numPret;

    @ManyToOne
    public Banque banque;

    public String libellepret="";
    public String devise="";
    public String numemprunt="";
    public String typecontenu="";
    public String numtranche="";
    public String dateech="";
    public double montant=0;
    public String sdr="";


    public Object clone()
    {
        Echeance ech = new Echeance();
        //ech.setIdcom(idcom);
        ech.setNumemprunt(numemprunt);
        ech.setBanque(banque);
        ech.setDateech(dateech);
        ech.setMontant(montant);
        ech.setNumtranche(numtranche);
        ech.setSdr(sdr);
        ech.setTypecontenu(typecontenu);

        return ech;

    }
}
