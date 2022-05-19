package talla.fin.projet.Services.Dette.Interfaces;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeanUtils;
import talla.fin.projet.Entities.Dette.Beans.Commun;
import talla.fin.projet.Entities.Dette.Beans.Cout;
import talla.fin.projet.Entities.Dette.Beans.Echeance;
import talla.fin.projet.Entities.Dette.Beans.Signaletique;

import javax.persistence.Entity;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LireInventaireDette {
    List<Signaletique> listeSign = new ArrayList<Signaletique>();
    List<Echeance> listeEch = new ArrayList<Echeance>();
    List<Commun> listeCom = new ArrayList<Commun>();
    List<Cout> listecout = new ArrayList<Cout>();

    public void lireInventaire() {

        LireInventaireDette liste = null;
        String chemin = "C:\\Users\\Liege\\Downloads\\Inventaire";
        File path = new File(chemin);
        File[] files = path.listFiles();
        int max = files.length;
        int nb_file = 0;

        for (int i = 0; i < max; i++) {
            // On teste s'il s'agit d'un fichier et on vérifie la nature de l'extension du
            // fichier
            if (files[i].isFile() & (files[i].getName().indexOf(".INV") != (-1))
                    | files[i].getName().indexOf(".INV") != (-1)) {
                //System.out.println("Fichier trouvé");
                File file = new File(chemin + "/" + files[i].getName());


                //nb_file++; // On incrémente le compteur de fichier

                try {
                    FileReader fr;
                    fr = new FileReader(file);
                    BufferedReader br = new BufferedReader(fr);
                    String line;
                    Commun com=new Commun();
                    Signaletique sign = new Signaletique();
                    Echeance ech= new Echeance();
                    Cout ct=new Cout();

                    String idcom="";
                    while ((line = br.readLine()) != null && !line.equals("")) {
/////////////////////////////////////////////////////////////////////////////////////////////////////////

                        switch ((line.substring(0, 1))) {

                            case "0": //Commun

                                com.setDateinv(line.substring(1,9));
                                com.setImmatriculation(line.substring(26,36));
                                idcom = com.getImmatriculation();
                                com.setNomEmprunteur(line.substring(36,62));
                                com.setIns(line.substring(62,67));
                                com.setEmprunteur(line.substring(67,79));
                                com.setComptabilite(line.substring(79,81));
                                com.setMaj(line.substring(81,86));
                                com.setVersion(line.substring(95,96));
                                com.setDatefichier(line.substring(99,107));
                                com.setDebutmaj(line.substring(107,115));
                                com.setFinmaj(line.substring(115,123));

                                //System.out.println("HEADER");
                                break;

                            case "1": //Commun
                                com.setSequencepret(line.substring(1,7));
                                com.setSequenceenregistrement(line.substring(7,13));
                                com.setNumPret(line.substring(26,32));
                                ech.setNumemprunt(com.getNumPret());
                                com.setBanque(line.substring(32,35));
                                //ech.setBanque(com.getBanque());
                                com.setLibellepret(line.substring(35,115));
                                com.setDevise(line.substring(115,118));

                                //Utile pour sauvegar dans signaletique, echeance et cout
                               // sign.setIdcom(idcom);
                                BeanUtils.copyProperties(sign, com);
                                BeanUtils.copyProperties(ct, com);
                                BeanUtils.copyProperties(ech, com);
                                //ct.setIdcom(idcom);
                                //ech.setIdcom(idcom);

                                Commun com1 = (Commun)com.clone();
                                listeCom.add(com1);

                                //System.out.println("Type1 ajouté à la liste");
                                break;

                            case "2": //Signaletique

                                sign.setMontant(line.substring(32,47));
                                sign.setTypecredit(line.substring(47,49));
                                sign.setDateconseil(line.substring(49,57));
                                sign.setDateaccord(line.substring(57,65));
                                sign.setTiers(line.substring(65,77));
                                sign.setCompte(line.substring(77,89));
                                sign.setMode(line.substring(89,91));
                                sign.setCategorie(line.substring(91,95));
                                sign.setStructure(line.substring(95,96));
                                sign.setFinstructure(line.substring(96,104));

                                //signaletique sign1=(signaletique)sign.clone();

                                //listeSign.add(sign1);
                                //System.out.println("Tyep2");
                                break;

                            case "3": //Signaletique

                                sign.setDatetutelle(line.substring(102,107));
                                sign.setDettepret(line.substring(110,125));
                                sign.setTypepret(line.substring(125,127));
                                sign.setStatut(line.substring(127,128));

                                Signaletique sign2=(Signaletique)sign.clone();

                                listeSign.add(sign2);

                                //System.out.println("Type3");
                                break;

                            case "4":
                                //System.out.println("Type4");
                                break;

                            case "5":

                                ct.setDuree(line.substring(32,35));
                                ct.setTauxInt(line.substring(35,43));
                                ct.setDateRev(line.substring(43,51));
                                ct.setPerInt(line.substring(51,52));
                                ct.setEchInitInt(line.substring(52,60));
                                ct.setPerRemb(line.substring(60,61));
                                ct.setEchInitRemb(line.substring(61,69));
                                ct.setNombreTranche(line.substring(69,72));
                                ct.setDifferer(line.substring(72,75));
                                ct.setFin(line.substring(75,83));
                                ct.setCompteInit(line.substring(83,95));
                                ct.setCompteRemb(line.substring(95,107));
                                ct.setTauxRemb(line.substring(107,115));
                                ct.setTauxRev(line.substring(115,123));
                                ct.setPerRev(line.substring(123,125));
                                ct.setPlan(line.substring(125,126));

                                Cout ct1=(Cout)ct.clone();

                                listecout.add(ct1);

                                //System.out.println("Type5");
                                break;

                            case "6":
                                //System.out.println("Type6");
                                break;

                            case "7":



                                ech.setTypecontenu(line.substring(32,33));

                                if (ech.getTypecontenu().equals("1"))
                                {

                                    nb_file=nb_file+2;

                                    //echeance e1 = new echeance();
                                    ech.setNumtranche(line.substring(33,36));
                                    ech.setDateech(line.substring(36,44));
                                    ech.setMontant(Double.parseDouble(line.substring(45,59))/100);
                                    ech.setSdr(line.substring(59,74));

                                    Echeance e1 = (Echeance)ech.clone();
                                    //e1=ech;
                                    listeEch.add(e1);

                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

                                    ech.setNumtranche(line.substring(74,77));
                                    ech.setDateech(line.substring(77,85));
                                    ech.setMontant(Double.parseDouble(line.substring(85,100))/100);
                                    ech.setSdr(line.substring(100,115));

                                    Echeance e2 = (Echeance)ech.clone();
                                    //e2=ech;
                                    listeEch.add(e2);


                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

                                }

                                else if (ech.getTypecontenu().equals("2"))
                                {
                                    nb_file=nb_file+4;

                                    ech.setDateech(line.substring(33,41));
                                    ech.setMontant(Double.parseDouble(line.substring(41,56))/100);

                                    Echeance e1 = (Echeance)ech.clone();
                                    //e1=ech;
                                    listeEch.add(e1);

                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

                                    ech.setDateech(line.substring(56,64));
                                    ech.setMontant(Double.parseDouble(line.substring(64,79))/100);
                                    Echeance e2 = (Echeance)ech.clone();
                                    //e2=ech;
                                    listeEch.add(e2);

                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

                                    ech.setDateech(line.substring(79,87));
                                    ech.setMontant(Double.parseDouble(line.substring(87,102))/100);

                                    Echeance e3 = (Echeance)ech.clone();
                                    //e3=ech;
                                    listeEch.add(e3);

                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

                                    ech.setDateech(line.substring(102,110));
                                    ech.setMontant(Double.parseDouble(line.substring(110,125))/100);
                                    Echeance e4 = (Echeance)ech.clone();
                                    //e4=ech;
                                    listeEch.add(e4);

                                    ech.setNumtranche("");
                                    ech.setDateech("");
                                    ech.setMontant(0);
                                    ech.setSdr("");

								/*
								ech.setNumTranche("");
								ech.setDateEch("");
								ech.setMontant("");
								ech.setSdr("");*/

                                }


                                //System.out.println("Type7");
                                break;

                            case "8": //Signaletique
                                //System.out.println("Type8");
                                break;

                            case "A":
                                //System.out.println("TypeA");
                                break;

                            case "B":
                                //System.out.println("TypeB");
                                break;

                            case "C":
                                //System.out.println("TypeC");
                                break;

                            case "D":
                                //System.out.println("TypeD");
                                break;

                            case "E":
                                //System.out.println("TypeE");
                                break;

                            case "9":
                                //System.out.println("Type9");
                                break;
                        }

////////////////////////////////////////////////////////////////////////////////////////////////////////
                    }

                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // Créer l'objet BufferedReader

            }
        }

        System.out.println ("taille de la liste" + listeEch.size() + " nombre de lignes 7: " + nb_file );
        System.out.println("");
        System.out.println("Injection des informations dettes dans la base de données...");

    }

}
