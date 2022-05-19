package talla.fin.projet.Entities.Dette.Beans;

import lombok.Data;

@Data
public class Commun {

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
    public String numPret="";
    public String banque="";
    public String libellepret="";
    public String devise="";

    public Object clone()
    {
        Commun com = new Commun();
        com.setDateinv(dateinv);
        com.setImmatriculation(immatriculation);
        com.setNomEmprunteur(nomEmprunteur);
        com.setIns(ins);
        com.setEmprunteur(emprunteur);
        com.setComptabilite(comptabilite);
        com.setMaj(maj);
        com.setVersion(version);
        com.setDatefichier(datefichier);
        com.setDebutmaj(debutmaj);
        com.setFinmaj(finmaj);
        com.setSequencepret(sequencepret);
        com.setSequenceenregistrement(sequenceenregistrement);
        com.setNumPret(numPret);
        com.setBanque(banque);
        com.setLibellepret(libellepret);
        com.setDevise(devise);

        return com;

    }
}
