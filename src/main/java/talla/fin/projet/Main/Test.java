package talla.fin.projet.Main;

import talla.fin.projet.Configuration.Configs;

import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        Configs configs= new Configs();
        configs.lecture();
        System.out.println(configs.toString());

    }
}
