import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static Scanner vstup = new Scanner(System.in);
    public static void main(String[] args) {
        uloha3();
    }
    static void uloha3(){
        System.out.println("Zadaj cislo");
        int c = vstup.nextInt();
        System.out.println("Zadaj start");
        int l = vstup.nextInt();
        System.out.println("Zadaj koniec");
        int r = vstup.nextInt();
        System.out.println(rozbitie(c));
        System.out.println(pocetJednotiek(rozbitie(c), l, r));
        //System.out.println(pocetJednotiek2(rozbitie(c)));
    }
    static int pocetJednotiek(ArrayList<Integer> paPole, int l, int r) {
        int pocet = 0;
        for (int i = l-1; i < r; i++) {
            if (paPole.get(i) == 1) {
                pocet++;
            }
        }
        return pocet;
    }
    static int pocetJednotiek2(ArrayList<Integer> paPole) {
        int pocet = 0;
        for (int i = 0; i < paPole.size(); i++) {
            if (paPole.get(i) == 1) {
                pocet++;
            }
        }
        return pocet;
    }
    static ArrayList<Integer> rozbitie(int cislo) {
        ArrayList<Integer> noveCisla = rozbitieCislaList(cislo);
        int pozicia = 0;
        while(noveCisla.size() > pozicia) {
            if (noveCisla.get(pozicia) > 1) {
                noveCisla.add(pozicia + 1, rozbitieCislaList(noveCisla.get(pozicia)).get(2));
                noveCisla.add(pozicia + 1, rozbitieCislaList(noveCisla.get(pozicia)).get(1));
                noveCisla.set(pozicia, rozbitieCislaList(noveCisla.get(pozicia)).get(0));
            }
            if (noveCisla.get(pozicia) <= 1) {
                pozicia++;
            }
        }
        return noveCisla;
    }
    static ArrayList<Integer> rozbitieCislaList(int c){
        ArrayList<Integer> cisla = new ArrayList<>();
        if(c <= 1) {
            cisla.add(c);
            return cisla;
        } else {
            int x = c/2;
            int cislo2 = c % 2;
            cisla.add(x);
            cisla.add(cislo2);
            cisla.add(x);
            return cisla;
        }
    }
}