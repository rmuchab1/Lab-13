package com.company;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.UUID;
import java.util.Scanner;

public class NameList {
    static UUID rawID = UUID.randomUUID();
    static ArrayList<String> nameWithLastName = new ArrayList<>();
    static String input;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void NameInput() throws IOException {
        String name, lastname, ID;

        System.out.println("Welcome to name input system.");
        System.out.println("You can now register your name into the database.");
        System.out.print("Name: ");
        name = br.readLine();
        System.out.print("Lastname: ");
        lastname = br.readLine();
        ID = rawID.toString().substring(5);

        nameWithLastName.add(String.format("Name: %s, Lastname: %s, ID: %s",
                name, lastname, ID));
        System.out.println("Do you want to continue? (Y/N) ");
        input = br.readLine().toUpperCase();
        if (input.equals("N")) {
            input = "EXIT";
        } else {
            Start();
        }
    }

    public static void ReadName() throws IOException {
        Scanner sn = new Scanner(nameWithLastName.toString());
        try {
            while (sn.hasNextLine()) {
                System.out.println(sn.nextLine() + "\n");
            }
            System.out.println("Collection size: " + nameWithLastName.size());
            System.out.print("Do you want to go back? (Y/N)");
            input = br.readLine().toUpperCase();
            if (input.equals("N")) {
                input = "EXIT";
            } else {
                Start();
            }
        } catch (IOException e) {
            System.out.println("There are no lists that you're looking for!");
        }
    }

    public static void Start() throws IOException {
        System.out.println("Welcome to our register system.");
        System.out.println("Please choose your choice of operation.");
        System.out.print("Register new user (N) / Read existed users (O)");
        input = br.readLine().toUpperCase();

        try {
            while (true) {
                switch (input) {
                    case "N":
                        NameInput();
                        continue;
                    case "O":
                        ReadName();
                        continue;
                    case "EXIT":
                        break;
                    default:
                        System.out.println("There is no operation system that you're using!");
                        break;
                }
            }
        } catch (IOException e) {
            System.out.println("There are no list that you're looking for!");
        }
    }
}
