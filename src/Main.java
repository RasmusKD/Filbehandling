import java.io.*;
import java.util.Scanner;

public class Main {
    private static final Scanner input = new Scanner(System.in);
    private static File f;

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("1. Opret fil");
            System.out.println("2. Slet fil");
            System.out.println("3. Læs fil");
            System.out.println("4. Skriv til fil");
            System.out.println("0. Luk Program");

            while (!input.hasNextInt()) {
                System.out.println("Indtast venligst et gyldigt tal.");
                input.next();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1 -> createFile();
                case 2 -> deleteFile();
                case 3 -> readFile();
                case 4 -> writeFile();
            }
        } while (choice != 0);
    }

    public static void deleteFile() {
        System.out.print("Indtast filnavn: ");
        String fileName = input.nextLine();
        f = new File(fileName);

        if (f.delete()) {
            System.out.println("Fil slettet.");
        } else {
            System.out.println("Kunne ikke slette filen. Kontroller at filen eksisterer.");
        }
    }

    public static void createFile() {
        try {
            System.out.print("Indtast filnavn: ");
            String fileName = input.nextLine();

            f = new File(fileName);
            if (f.createNewFile()) {
                System.out.print("Indtast indhold: ");
                String content = input.nextLine();

                FileWriter writer = new FileWriter(f);
                writer.write(content);
                writer.close();

                System.out.println("Fil oprettet med succes.");
            } else {
                System.out.println("Filen eksisterer allerede.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void readFile() {
        try {
            System.out.print("Indtast filnavn: ");
            String fileName = input.nextLine();

            f = new File(fileName);
            FileReader reader = new FileReader(f);
            BufferedReader bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }

            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFile() {
        try {
            System.out.print("Indtast filnavn: ");
            String fileName = input.nextLine();

            f = new File(fileName);
            FileWriter writer = new FileWriter(f, true);

            System.out.print("Indtast indhold: ");
            String content = input.nextLine();

            writer.write(content);
            writer.close();

            System.out.println("Indhold skrevet til fil.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
