import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.HashMap;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static Random rnd = new Random();
    static Controller admin = new Controller(18, "Ruslan", 552844, 1, false, 700);
    public static void main(String[] args){

        //Sat creation and controlling block
        ArrayList<Satellite> satellitesList = new ArrayList<>();

        satellitesList.add(new Satellite("SpaceX", 547.47, 48500, 'L', "9/10", true));

        System.out.printf("\n---Starting Transmissions---\n\n");
        for(Satellite sat : satellitesList){
            sat.transmitSignal();
            System.out.println();
            }

        //Controller and User blocks
        ArrayList<User> userList = new ArrayList<>();
        userList.add(admin);
        userList.add(new User(20, "Roma", 65830));

        //Receiver block
        ArrayList<Receiver> receiverList = new ArrayList<>();
        Receiver r1 = new Receiver(1, 24.9, "AES-256", true);
        receiverList.add(r1);

        mainMenu();
    }

    static void createNewUser(){
        System.out.println("Enter new age: ");
        int age = scanner.nextInt();
        System.out.println("Enter new name: ");
        String name = scanner.nextLine();
        System.out.println("Enter new phone number: ");
        int number = scanner.nextInt();
    }

    static void createNewController(){

    }

    static void createNewSat(){

    }

    static void createNewReceiver(){

    }

    static void buySat(){
        System.out.printf("\n--- Satellite Purchase Process ---\n");
        System.out.printf("Controller %s has initial wealth: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status before purchase: %b\n", admin.isHasAccess());

        admin.buySat(450);
        System.out.printf("\n[System]: Purchase completed successfully!\n\n");

        System.out.printf("Controller %s has wealth after purchase: %.2f\n", admin.getName(), admin.getWealth());
        System.out.printf("Access status after purchase: %b\n", admin.isHasAccess());
    }

    static void mainMenu(){
        int choice = 0;

        while (true){
            System.out.println("---Main menu---");
            System.out.println("Page 1");
            System.out.println("1. Create new User (w/parameters)");
            System.out.println("2. Create new Controller (w/parameters)");
            System.out.println("3. Create new Satellite (w/parameters)");
            System.out.println("4. Create new Receiver (w/parameters)");
            System.out.println("5. Create new Default User");
            System.out.println("6. Create new Default Controller");
            System.out.println("7. Create new Default Satellite");
            System.out.println("8. Create new Default Receiver");
            System.out.println("9. Next page ->");
            System.out.println("0. Exit\n");
            System.out.printf("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice){
                case 1:
                    createNewUser();
                    break;
                case 2:
                    createNewController();
                    break;
                case 3:
                    createNewSat();
                    break;
                case 4:
                    createNewReceiver();
                    break;
                case 5:
                    User user1 = new User();
                    break;
                case 6:
                    Controller contrl = new Controller();
                    break;
                case 7:
                    Satellite sat1 = new Satellite();
                    break;
                case 8:
                    Receiver rec = new Receiver();
                    break;
                case 9:
                    nextPage();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter valid operation: ");
            }
        }
    }

    static void nextPage(){
        int choice1 = 0;

        while (true){
            System.out.println("---Main menu---");
            System.out.println("Page 2");
            System.out.println("1. Buy Satellite");
            System.out.println("9. <- Go back");
            System.out.println("0. Exit\n");
            System.out.printf("Enter your choice: ");
            choice1 = scanner.nextInt();
            switch (choice1){
                case 1:

                    break;
                case 9:
                    mainMenu();
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Enter valid operation: ");
            }
        }
    }
}