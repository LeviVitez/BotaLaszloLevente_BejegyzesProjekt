import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static List<Bejegyzes> bejegyzes1 =new ArrayList<>();
    File file=new File("bejegyzesek.csv");
    public static void main(String[] args) {
        //2.a
        bejegyzes1.add(new Bejegyzes("Git Jakab","Autósmagazin"));
        bejegyzes1.add(new Bejegyzes("Commit Ferenc","Tuningolás"));

        //2.b
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

        //2.c
        try {
            FileReader fr = new FileReader("bejegyzesek.csv");
            BufferedReader br = new BufferedReader(fr);
            String sor = br.readLine();
            while (sor != null && !sor.equals("")) {
                String[] tomb = sor.split(";");
                bejegyzes1.add(new Bejegyzes(tomb[0], tomb[1]));
                sor = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace(System.err);
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }

        //2.e
        System.out.print("kérek egy szöveget ");
        Scanner sc2 = new Scanner(System.in);
        String textvaltozas = sc.nextLine();
        bejegyzes1.get(1).setTartalom(textvaltozas);

        //2.f
        for (int i = 0; i < bejegyzes1.size() ; i++) {
            System.out.println(bejegyzes1.get(i).getSzerzo());
            System.out.println(bejegyzes1.get(i).getTartalom());
            System.out.println(bejegyzes1.get(i).getLikeok());
            System.out.println(bejegyzes1.get(i).getLetrejott());
            System.out.println(bejegyzes1.get(i).getSzerkesztve());
            System.out.println();
        }

        //3.a
        int legtobblike=0;
        for (int i = 0; i < bejegyzes1.size() ; i++) {
            if (bejegyzes1.get(i).getLikeok()>legtobblike){
                legtobblike=bejegyzes1.get(i).getLikeok();
            }
        }
        System.out.printf("legtöbb lájkos bejegyzés: %d \n",legtobblike);

        //3.b
        boolean vane35=false;
        for (int i = 0; i < bejegyzes1.size() ; i++) {
            if (bejegyzes1.get(i).getLikeok()>35){
                vane35=true;
            }
        }
        if (vane35==true){
            System.out.println("van 35-nél több likeos bejegyzés");
        }else{
            System.out.println("nincs 35-nél több likeos bejegyzés");
        }

        //3.c
        int kevesebbmint15like=0;
        for (int i = 0; i < bejegyzes1.size() ; i++) {
            if (bejegyzes1.get(i).getLikeok()<15){
                kevesebbmint15like++;
            }
        }
        System.out.printf("%d-db bejegyzés volt aminek kevesebb, mint 15 likeja volt",kevesebbmint15like);


    }
}
