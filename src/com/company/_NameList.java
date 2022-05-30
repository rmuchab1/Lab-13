package com.company;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.util.UUID;
import java.util.Scanner;

public class _NameList {
    static UUID rawID = UUID.randomUUID();
    static ArrayList<String> nameWithLastName = new ArrayList<String>();
    static String database = "./Task2/Database.txt", input,
            store = nameWithLastName.toString(), search;
    static File file = new File(database);
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

        // Creating file section
        try (FileWriter writer = new FileWriter(file)) {
            String cast = nameWithLastName.toString();
            writer.write(cast + "\n");
            System.out.print("Do you want to continue? (Y/N) ");
            input = br.readLine().toUpperCase();
            if (input.equals("N")) {
                input = "EXIT";
            } else {
                NameInput();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void ReadName() throws IOException, FileNotFoundException {
        Scanner sn = new Scanner(file);
        int index = 0;
        try {
            while (sn.hasNextLine()) {
                System.out.print("Do you want to search for a specific user? (Y/N) ");
                input = br.readLine().toUpperCase();
                if (input.equals("Y")) {
                    System.out.print("Name, last name or ID: ");
                    search = br.readLine();
                    if (store.contains(search)) {
                        System.out.println(store);
                    }
                } else {
                    index++;
                    System.out.println(store = store.concat(index + " " + sn.nextLine() + "\n"));
                }
            }
            System.out.print("Do you want to go back? (Y/N)");
            input = br.readLine().toUpperCase();
            if (input.equals("N")) {
                input = "EXIT";
            } else {
                Start();
            }
        } catch (FileNotFoundException e) {
            System.out.println("There are no files that you're looking for!");
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
        } catch (FileNotFoundException e) {
            System.out.println("There are no file that you're looking for!");
        }
    }
}
