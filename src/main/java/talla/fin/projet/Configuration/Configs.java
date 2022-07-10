package talla.fin.projet.Configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

@Data
@NoArgsConstructor
@ToString
public class Configs {

    private  String source ="src/main/resources/Configs/ConfigFinances.txt";
    private    String environnement;
    private  String domaine;
    private  String chemin;


    public  String lecture() throws FileNotFoundException {
        System.out.println("Lecture du fichier de configuration");
        Scanner scan = new Scanner(new File(source));
        String route="";
        System.out.println(source);
        while (scan.hasNextLine()) {
            String ligne = scan.nextLine();
            String[] champs = ligne.split(":");
            environnement = champs[0];
            domaine = champs[1];
            chemin = champs[2];

        }
        route=chemin;
        return route;
    }


}

