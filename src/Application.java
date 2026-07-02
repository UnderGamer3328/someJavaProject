import java.io.*;
import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Application {
    private final Scanner scanner = new Scanner(System.in);
    private final Random rnd = new Random();
    private final Controller admin = new Controller(18, "Ruslan", 552844, 1, false, 700);
    private ArrayList<Satellite> satellitesList = new ArrayList<>();
    private ArrayList<Person> userList = new ArrayList<>();
    private ArrayList<Receiver> receiverList = new ArrayList<>();
    private ArrayList<String> ruslansZachetka = new ArrayList<>();

    public Application() {
        //Satellites
        satellitesList.add(new Satellite("SpaceX", 547.47, 48500, 'L', "9/10", true, new ArrayList<>()));

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
        ruslansZachetka.add("Англійська мова (сумарно за 1 і 2 семестри): 42FX");

        var ruslan = new Student(18, "Ruslan", 52487746, 1, ruslansZachetka, "Cafeteria", 95.0);

        userList.addFirst(ruslan);

        //Receivers
        var r1 = new Receiver(1, 24.9, "AES-256", true);
        receiverList.add(r1);
    }

    public void start(){
        mainMenu();
    }

    private void mainMenu(){
        try{
            while (true){
                System.out.println("\n---Main menu---");
                System.out.println("Page 1");
                System.out.println("1. Object creation");
                System.out.println("2. Change object settings");
                System.out.println("3. Delete object");
                System.out.println("4. Connect to a satellite");
                System.out.println("9. Admin menu ->");
                System.out.println("0. Exit\n");
                System.out.print("Enter your choice: ");

                var choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        objectCreation();
                        break;
                    case 2:
                        objectSettings();
                        break;
                    case 3:
                        deleteObject();
                        break;
                    case 4:
                        satConn();
                        break;
                    case 9:
                        adminMenu();
                        break;
                    case 0:
                        System.exit(0);
                        return;
                    default:
                        System.out.println("Enter valid operation: ");
                }
            }
        } catch (Exception e) {
            System.out.println("[SYSTEM]::{ERROR}: Invalid input format! Resetting menu...");
            scanner.nextLine();
        }
    }

    private void adminMenu(){
        try{
            while (true){
                System.out.println("1. Buy Satellite");
                System.out.println("2. Save zachetka to file");
                System.out.println("3. Save all data");
                System.out.println("4. Load all data");
                System.out.println("5. List zachetka");
                System.out.println("9. List inventory items");
                System.out.println("0. <- Go back");
                System.out.print("Enter your choice: ");
                var choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice){
                    case 1:
                        buySat();
                        break;
                    case 2:
                        saveZachetkaToFile(ruslansZachetka, "objects.txt");
                        break;
                    case 3:
                        saveAllData();
                        break;
                    case 4:
                        loadAllData();
                        break;
                    case 5:
                        listZachetka();
                        break;
                    case 9:
                        listInventory();
                        break;
                    case 0:
                        return;
                }
            }
        } catch (Exception e) {
            System.out.println("[SYSTEM]::{ERROR}: Invalid input format! Resetting menu...");
            scanner.nextLine();
        }
    }

    private void saveZachetkaToFile(ArrayList<String> zachetka, String fileName) {
        try {
            var writer = new FileWriter(fileName, false);

            writer.write("--- ЗАЛІКОВА КНИЖКА ---\n");
            writer.write("Всього предметів: " + zachetka.size() + "\n");
            writer.write("-----------------------\n");

            for (var subject : zachetka) {
                writer.write(subject + "\n");
            }

            writer.close();
            System.out.println("[SYSTEM]: Data successfully saved to " + fileName);
        } catch (IOException e) {
            System.out.println("[SYSTEM]::{ERROR}: Cannot write to file.");
            e.printStackTrace();
        }
    }

    private void objectCreation(){
        try{
            while (true){
                System.out.println("1. Create new User (w/parameters)");
                System.out.println("2. Create new Student (w/parameters)");
                System.out.println("3. Create new Satellite (w/parameters)");
                System.out.println("4. Create new Receiver (w/parameters)");
                System.out.println("5. Create new Default User");
                System.out.println("6. Create new Default Controller");
                System.out.println("7. Create new Default Satellite");
                System.out.println("8. Create new Default Receiver");
                System.out.println("0. <- Go back");
                System.out.print("Enter your choice: ");

                var choice = scanner.nextInt();
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
                        var user1 = new Person();
                        userList.add(user1);
                        break;
                    case 6:
                        var contrl = new Controller();
                        userList.add(contrl);
                        break;
                    case 7:
                        var sat1 = new Satellite();
                        satellitesList.add(sat1);
                        break;
                    case 8:
                        var rec = new Receiver();
                        receiverList.add(rec);
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Enter valid operation: ");
                }
            }
        }catch (Exception e){
            System.out.println("[SYSTEM]::{ERROR}: Invalid data format entered. Returning to creation menu...");
            scanner.nextLine();
        }
    }

    private void createNewPerson(){
        System.out.print("Age: ");
        var age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        var name = scanner.nextLine();

        System.out.print("Phone number: ");
        var number = scanner.nextInt();
        scanner.nextLine();

        userList.add(new Person(age, name, number));
        System.out.println("[SYSTEM]: User created successfully!");
    }

    private void createNewStudent(){
        System.out.print("Age: ");
        var age = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Name: ");
        var name = scanner.nextLine();

        System.out.print("Phone number: ");
        var number = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Kurs: ");
        var kurs = scanner.nextInt();
        scanner.nextLine();

        var newZachetka = new ArrayList<String>();
        System.out.print("How many subjects to add to Zachetka?: ");
        var subjectsCount = scanner.nextInt();
        scanner.nextLine();
        for(var i = 0; i < subjectsCount; i++){
            System.out.printf("Enter subject %d (e.g., OOP: 95A): ", i + 1);
            var subject = scanner.nextLine();
            newZachetka.add(subject);
        }

        System.out.print("Location: ");
        var location = scanner.nextLine();

        System.out.print("Health: ");
        var health = scanner.nextDouble();
        scanner.nextLine();

        userList.add(new Student(age, name, number, kurs, newZachetka, location, health));
        System.out.println("[SYSTEM]: User created successfully!");
    }

    private void createNewSat(){
        System.out.print("Name: ");
        var satName = scanner.nextLine();

        System.out.print("Frequency: ");
        var frequency = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Symbol rate: ");
        var sr = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Polarisation: ");
        var pol = scanner.next().charAt(0);
        scanner.nextLine();

        System.out.print("FEC: ");
        var fec = scanner.nextLine();

        System.out.print("Power: ");
        var isOn = scanner.nextBoolean();
        scanner.nextLine();

        satellitesList.add(new Satellite(satName, frequency, sr, pol, fec, isOn, new ArrayList<>()));
        System.out.println("[SYSTEM]: Satellite created successfully!");
    }

    private void createNewReceiver(){
        System.out.print("Channel: ");
        var channel = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Frequency: ");
        var receiverFrequency = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Encryption type: ");
        var encType = scanner.nextLine();

        System.out.print("Power: ");
        var power = scanner.nextBoolean();
        scanner.nextLine();

        receiverList.add(new Receiver(channel, receiverFrequency, encType, power));
        System.out.println("[SYSTEM]: Receiver created successfully!");
    }

    private void listInventory(){
        System.out.println("[SYSTEM]: Listing all objects");

        System.out.println("Satellites:");
        for(var s : satellitesList){
            System.out.println("  " + s);
        }

        System.out.println("-----------");

        System.out.println("Users:");
        for(var p : userList){
            System.out.println("  " + p);
        }

        System.out.println("-----------");

        System.out.println("Receivers:");
        for(var r : receiverList){
            System.out.println("  " + r);
        }
    }

    private void listZachetka(){
        System.out.println();
        System.out.println("Залікова книжка");
        for(var s : ruslansZachetka){
            System.out.println(s);
        }
        System.out.println();
    }

    private void buySat(){
        System.out.print("\n--- Satellite Purchase Process ---\n");
        System.out.printf("Controller %s has initial wealth: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status before purchase: %b\n", admin.isHasAccess());

        admin.buySat(450);
        System.out.print("\n[SYSTEM]: Purchase completed successfully!\n\n");

        System.out.printf("Controller %s has wealth after purchase: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status after purchase: %b\n", admin.isHasAccess());
    }

    private void saveAllData() {
        try {
            var fileOut = new FileOutputStream("backup.dat");
            var objectOut = new ObjectOutputStream(fileOut);

            objectOut.writeObject(userList);
            objectOut.writeObject(satellitesList);
            objectOut.writeObject(receiverList);
            objectOut.writeObject(ruslansZachetka);

            objectOut.close();
            fileOut.close();
            System.out.println("[SYSTEM]: All data collections successfully serialized to backup.dat");
        } catch (IOException e) {
            System.out.println("[SYSTEM]::{ERROR}: Serialization failed.");
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    private void loadAllData () {
        try{
            var fileIn = new FileInputStream("backup.dat");
            var objectIn = new ObjectInputStream(fileIn);

            userList = (ArrayList<Person>) objectIn.readObject();
            satellitesList = (ArrayList<Satellite>) objectIn.readObject();
            receiverList = (ArrayList<Receiver>) objectIn.readObject();
            ruslansZachetka = (ArrayList<String>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            System.out.println("[SYSTEM]: All data collections successfully loaded from backup.dat");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("[SYSTEM]::{ERROR}: Deserialization failed. Backup file might not exist yet.");
            e.printStackTrace();
        }
    }

    //TBA
    private void objectSettings(){

    }

    private void deleteObject(){

    }

    //To be refactored
    private void satConn(){
//        if (receiverList.isEmpty() || satellitesList.isEmpty()){
//            System.out.printf("[SYSTEM]: You need at least one Receiver and Satellite to make it work...\n");
//            return;
//        }
//
//        System.out.printf("\n---Satellite connection---\n");
//        Receiver receiver = receiverList.getFirst();
//
//        boolean found = false;
//        for(Satellite s : satellitesList){
//            if ((Math.abs(s.getFrequency() - receiver.getFrequency()) < 0.5)) {
//                System.out.printf("\n[SYSTEM]: Connected successfully with satellite: %s!\n", s.getName());
//                s.performSelfTest();
//                s.transmitSignal();
//                found = true;
//                break;
//            }
//        }
//        if (!found){
//            System.out.println("[SYSTEM]: Failed! No satellite found on this frequency. Try changing receiver/satellite settings.");
//        }
//        System.out.println("");
    }
}