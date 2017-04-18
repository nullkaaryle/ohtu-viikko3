package ohtu.intjoukkosovellus;

import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner lukija = new Scanner(System.in);
        Sovellus sovellus = new Sovellus(lukija);
        sovellus.kaynnista();
    }
    
}
