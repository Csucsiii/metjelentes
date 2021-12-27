package com.exam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<Town> towns = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        F1(new File("tavirathu13.txt"));
        F2();
        F3();
        F4();
        F5();
        F6();
    }

    public static void F1(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()){
            String[] args = scanner.nextLine().split(" ");
            towns.add(new Town(args[0], args[1], args[2], Integer.parseInt(args[3])));
        }
        scanner.close();

        System.out.println("\n1. Feladat");
        System.out.println("Fájl beolvasva, és megfelelően eltárolva.");
    }

    public static void F2(){
        System.out.println("\n2. Feladat");
        System.out.print("Kérlek adj meg egy időpontot(pl.: BB): ");
        Scanner in = new Scanner(System.in);

        String townId = in.nextLine().toUpperCase();

        in.close();

        List<Town> targetTowns = new ArrayList<>();
        for (Town town: towns) {
            if (town.getId().equalsIgnoreCase(townId)){
                targetTowns.add(town);
            }
        }
        System.out.println("A " + townId + " legutolsó mérés ekkor történt: "+ formatTime(targetTowns.get(targetTowns.size() - 1).getTime()));

    }

    public static void F3(){

        Town targetTown = new Town();
        targetTown.setTemperature(0);
        for (Town town : towns) {
            if (targetTown.getTemperature() < town.getTemperature()){
                targetTown = town;
            }
        }
        System.out.println("\n3. Feladat");
        System.out.println(targetTown.getId() + "-ban volt " + formatTime(targetTown.getTime()) + "-kor a hőmérséklet pedig " + targetTown.getTemperature() + " fok volt");
    }

    public static void F4(){
        System.out.println("\n4. Feladat");
        boolean found = false;
        for (Town town : towns) {
            if (town.getWind().equalsIgnoreCase("00000")){
                System.out.println("Település: " + town.getId() + " Idő: " + formatTime(town.getTime()));
                found = true;
            }
        }

        if (!found){
            System.out.println("Nem volt szélcsend a mérések idején.");
        }

    }

    public static void F5(){
        System.out.println("\n5. Feladat");

        List<String> townNames = getTowns();
        for (String townName: townNames){
            Temperature temperature = getMidTemperature(townName);
            getTemperatureRange(temperature);
            System.out.println(temperature.getId() + " Középhőmérséklet: " + temperature.getMidTemp() + ", Hőmérséklet-ingadozás: " + temperature.getTempRange());
        }
    }

    public static void F6() throws IOException {
        System.out.println("\n6. Feladat");
        FileWriter fileWriter = new FileWriter("X.txt");
        for (Town town: towns){
            fileWriter.write(town.getTime() + ": " + "#".repeat(Math.max(0, Integer.parseInt(town.getWind().substring(3, 5)))) + "\n");
        }
        fileWriter.close();

        System.out.println("A fájl elkészült.");
    }

    private static void getTemperatureRange(Temperature temperature){
        int min = 1000;
        int max = 0;

        for (Town town: towns){
            if (town.getId().equalsIgnoreCase(temperature.getId()) && town.getTemperature() > max){
                max = town.getTemperature();
            }
            if (town.getId().equalsIgnoreCase(temperature.getId()) && town.getTemperature() < min){
                min = town.getTemperature();
            }
        }

        temperature.setTempRange(String.valueOf(max - min));
    }

    private static Temperature getMidTemperature(String id){
        double temp = 0.0;
        int index = 0;
        String[] targetTimes = {"01", "07", "13", "19"};
        for (Town town: towns){
            for (String targetTime : targetTimes) {
                if (town.getId().equalsIgnoreCase(id) && town.getTime().substring(0, 2).equals(targetTime)) {
                    temp += town.getTemperature();
                    index++;
                }
            }
        }

        return new Temperature(id, index > 0 ? String.valueOf(Math.round(temp / index)): "NA");
    }

    private static List<String> getTowns(){
        List<String> townIds = new ArrayList<>();

        for (Town town: towns){
            if (!townIds.contains(town.getId())){
                townIds.add(town.getId());
            }
        }
        return townIds;
    }

    private static String formatTime(String time){
        return time.substring(0,2) + ":" + time.substring(2,4);
    }

}
