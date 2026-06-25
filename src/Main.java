import java.io.FileWriter;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.IOException;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Controller admin = new Controller(18, "Ruslan", 552844, 1, false, 700);
    static ArrayList<Satellite> satellitesList = new ArrayList<>();
    static ArrayList<Person> userList = new ArrayList<>();
    static ArrayList<Receiver> receiverList = new ArrayList<>();
    static ArrayList<String> ruslansZachetka = new ArrayList<>();

    static void saveZachetkaToFile(ArrayList<String> zachetka, String fileName) {
        try {
            FileWriter writer = new FileWriter(fileName, false);

            writer.write("--- ЗАЛІКОВА КНИЖКА ---\n");
            writer.write("Всього предметів: " + zachetka.size() + "\n");
            writer.write("-----------------------\n");

            for (String subject : zachetka) {
                writer.write(subject + "\n");
            }

            writer.close();
            System.out.println("[System]: Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("[System Error]: Cannot write to file.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        //Satellites
        satellitesList.add(new Satellite("SpaceX", 547.47, 48500, 'L', "9/10", true));

        //Persons, Students, Controllers
        userList.add(admin);
        userList.add(new Person(20, "Roma", 65830));

        ruslansZachetka.add("ООП: 97A");
        ruslansZachetka.add("КДМ: 96A");
        ruslansZachetka.add("ЛМВ: 90A");
        ruslansZachetka.add("УМПС: 91A");
        ruslansZachetka.add("ООП (Курсова робота): 75С");
        ruslansZachetka.add("Вища математика: 66D");
        ruslansZachetka.add("Фізика: 64D");
        ruslansZachetka.add("АМПС: 42FX");

        Person ruslan = new Student(18, "Ruslan", 52487746, 1, ruslansZachetka, "Cafeteria", 95.0);

        userList.addFirst(ruslan);

        for(String s : ruslansZachetka){
            System.out.println(s);
        }

        //Receivers
        Receiver r1 = new Receiver(1, 24.9, "AES-256", true);
        receiverList.add(r1);

        //Main menu
        saveZachetkaToFile(ruslansZachetka, "objects.txt");
        mainMenu();
    }

    static void createNewPerson(){
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        userList.add(new Person(age, name, number));
        System.out.println("[System]: User created successfully!");
    }

    static void createNewStudent(){
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Phone number: ");
        int number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Kurs: ");
        int kurs = scanner.nextInt();
        scanner.nextLine();

        ArrayList<String> newZachetka = new ArrayList<>();
        System.out.print("How many subjects to add to Zachetka?: ");
        int subjectsCount = scanner.nextInt();
        for(int i = 0; i < subjectsCount; i++){
            System.out.printf("Enter subject %d (e.g., OOP: 95A): ", i + 1);
            String subject = scanner.nextLine();
            newZachetka.add(subject);
        }

        System.out.print("Location: ");
        String location = scanner.nextLine();

        System.out.print("Health: ");
        double health = scanner.nextDouble();
        scanner.nextLine();

        userList.add(new Student(age, name, number, kurs, newZachetka, location, health));
        System.out.println("[System]: User created successfully!");
    }

    static void createNewSat(){
        System.out.print("Name: ");
        String satName = scanner.nextLine();

        System.out.print("Frequency: ");
        double frequency = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Symbol rate: ");
        int sr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Polarisation: ");
        char pol = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("FEC: ");
        String fec = scanner.nextLine();

        System.out.print("Power: ");
        boolean isOn = scanner.nextBoolean();
        scanner.nextLine();

        satellitesList.add(new Satellite(satName, frequency, sr, pol, fec, isOn));
        System.out.println("[System]: Satellite created successfully!");
    }

    static void createNewReceiver(){
        System.out.print("Channel: ");
        int channel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Frequency: ");
        double receiverFrequency = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Encryption type: ");
        String encType = scanner.nextLine();

        System.out.print("Power: ");
        boolean power = scanner.nextBoolean();
        scanner.nextLine();

        receiverList.add(new Receiver(channel, receiverFrequency, encType, power));
        System.out.println("[System]: Satellite created successfully!");
    }

    static void listInventory(){
        System.out.println("\n--- Current Inventory ---");
        System.out.println("Satellites count: " + satellitesList.size());
        System.out.println("Receivers count: " + receiverList.size());
        System.out.println("Users count: " + userList.size());
        System.out.println("-------------------------\n");
    }

    static void buySat(){
        System.out.print("\n--- Satellite Purchase Process ---\n");
        System.out.printf("Controller %s has initial wealth: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status before purchase: %b\n", admin.isHasAccess());

        admin.buySat(450);
        System.out.print("\n[System]: Purchase completed successfully!\n\n");

        System.out.printf("Controller %s has wealth after purchase: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status after purchase: %b\n", admin.isHasAccess());
    }

    static void mainMenu(){
        try{
            while (true){
                System.out.println("---Main menu---");
                System.out.println("Page 1");
                System.out.println("1. Create new User (w/parameters)");
                System.out.println("2. Create new Student (w/parameters)");
                System.out.println("3. Create new Satellite (w/parameters)");
                System.out.println("4. Create new Receiver (w/parameters)");
                System.out.println("5. Create new Default User");
                System.out.println("6. Create new Default Satellite");
                System.out.println("7. Create new Default Receiver");
                System.out.println("8. NULL");
                System.out.println("9. Next page ->");
                System.out.println("0. Exit\n");
                System.out.print("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        createNewPerson();
                        break;
                    case 2:
                        createNewStudent();
                        break;
                    case 3:
                        createNewSat();
                        break;
                    case 4:
                        createNewReceiver();
                        break;
                    case 5:
                        Person user1 = new Person();
                        userList.add(user1);
                        break;
                    case 6:
                        Controller contrl = new Controller();
                        userList.add(contrl);
                        break;
                    case 7:
                        Satellite sat1 = new Satellite();
                        satellitesList.add(sat1);
                        break;
                    case 8:
                        Receiver rec = new Receiver();
                        receiverList.add(rec);
                        break;
                    case 9:
                        nextPage();
                        break;
                    case 0:
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Enter valid operation: ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    static void nextPage(){
        try{
            while (true){
                System.out.println("---Main menu---");
                System.out.println("Page 2");
                System.out.println("1. Buy Satellite");
                System.out.println("9. List inventory items");
                System.out.println("0. <- Go back");
                System.out.print("Enter your choice: ");
                int choice1 = scanner.nextInt();
                scanner.nextLine();

                switch (choice1){
                    case 1:
                        buySat();
                        break;
                    case 9:
                        listInventory();
                        break;
                    case 0:
                        mainMenu();
                        return;
                    default:
                        System.out.println("Enter valid operation: ");
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}