import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzes1 =new ArrayList<>();
    File file=new File("bejegyzesek.csv");
    public static void main(String[] args) {
        bejegyzes1.add(new Bejegyzes("Git Jakab","Autósmagazin"));
        bejegyzes1.add(new Bejegyzes("Commit Ferenc","Tuningolás"));

        System.out.print("Mennyi új bejegyzést szeretnél? ");
        Scanner sc = new Scanner(System.in);
        int bekertszam = sc.nextInt();
        sc.nextLine();

        if (bekertszam < 0){
            System.out.println("Rossz szám! Csak természetes szám lehet.");
        }else{
            for (int i = 0; i < bekertszam; i++) {
                System.out.print("szerző: ");
                String szerzo = sc.nextLine();
                System.out.print("tartalom: ");
                String tartalom = sc.nextLine();
                bejegyzes1.add(new Bejegyzes(szerzo,tartalom));
            }
        }



    }
}
