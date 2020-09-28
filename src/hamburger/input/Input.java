package hamburger.input;

import hamburger.calc.Order;

import java.util.Scanner;

public class Input {

    private static Scanner scanner = new Scanner(System.in);
    private static Order order = new Order();


    public static void InputMenu() {
        printWelcome();
        boolean quit = false;
        while (!quit) {
            printMainMenu();
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 1:
                    createOrder();
                    break;
                case 0:
                    scanner.close();
                    quit = true;
                    System.out.println("\n\t\t\tThank you!\n");
                    System.out.println("\t\t\tSubmitted By: \n\t\t\t- Karanveer Singh \n\t\t\t- Piyush Kapoor \n\t\t\t- Gaurav Khatri");
                    break;

            }
        }
    }

    private static void createOrder() {
        printMenu();
        int choice = scanner.nextInt();
        scanner.nextLine();
        printBurgerConfirm(choice);
        switch (choice) {
            case 1:
            case 2:
            case 3:
                String meat = selectMeatType();
                String bun = selectBunType(choice);
                addMenuItem(choice, meat, bun);

                order.printReceipt();
                order.getTotalPrice();

                break;

            case 4:

                break;

            case 0:
                break;
        }
    }

    private static String selectMeatType()
    {
        System.out.print("\t\tEnter meat type: " );

        while(scanner.hasNextInt())
        {
            System.out.print("\t\t\tPlease enter a valid meat type: ");
            scanner.nextLine();
        }
        return scanner.nextLine();
    }

    private static String selectBunType(int i) {
        if (i != 2)
        {
            System.out.print("\t\tEnter bun type: " );
            while(scanner.hasNextInt()) {
                System.out.print("\t\t\tPlease enter a valid bun type: ");
                scanner.nextLine();
            }
            return scanner.nextLine();
        }
        return null;
    }

    private static int selectSide(int i) {
        int ans;
        do {
            System.out.print("\t\tSide " + i + ": ");
            while(!scanner.hasNextInt())
            {
                System.out.print("\t\t\tPlease select the number associated with the side(Additional): ");
                scanner.next();
            }
            ans = scanner.nextInt();
        }while (ans < 0 && ans > i);

        return  ans;
    }

    private static void addMenuItem(int i, String meat, String bun) {
        order.createOrder();


        if (i == 1) {
            printSides();
            System.out.print("\n\t\tHow many sides do you want ? ( Up to 4 sides): ");
            int sides = scanner.nextInt();
            order.addBurgerToOrder(1000, meat, bun);
            for (int j = 0; j < sides; j++) {
                order.addSideToOrder(selectSide(j + 1));
            }
        }
        if (i == 2) {
            printSides();
            printHealthySides();
            System.out.print("\n\t\tHow many sides do you want ? ( Up to 6 sides): ");
            int sides = scanner.nextInt();
            order.addBurgerToOrder(1001, meat, bun);
            for (int j = 0; j < sides; j++) {
                order.addSideToOrder(selectSide(j + 1));
            }
        }
        if (i == 3) {
            order.addBurgerToOrder(1002, meat, bun);
            order.addSideToOrder(12);
            order.addSideToOrder(14);
        }
    }


    private static void printWelcome() {
        System.out.println("\n\t\t\tWELCOME TO SHAMIM'S BURGERS! ");
        System.out.println("\t\t\t============================ ");
    }

    private static void printMainMenu() {
        System.out.println(" ");
        System.out.println("\t\tWhat would you like to order today? ");
        System.out.println(" ");
        System.out.println("\t\t[1] Create new order");
        System.out.println("\t\t[0] Exit");
        System.out.print("\n\t\tENTER YOUR CHOICE: ");
    }

    private static void printMenu() {
        System.out.println("\n\t\t======= OUR SPECIALITIES =======");
        System.out.println("\t\t[1] Classic Burger [$7]");
        System.out.println("\t\t[2] Healthy Burger with some additional sides [$12] ");
        System.out.println("\t\t[3] Deluxe Burger with large Coke and large fries [$13]");
        System.out.println("\t\t[0] Cancel");
        System.out.print("\n\t\tENTER YOUR CHOICE: ");
    }

    private static void printBurgerConfirm(int i) {
        if (i == 1) {
            System.out.println("\n\t\tClassic Burger selected");
            System.out.println("\t\t-----------------------\n");
        }
        if (i == 2) {
            System.out.println("\n\t\tHealthy Burger selected");
            System.out.println("\t\t-----------------------\n");

        }
        if (i == 3) {
            System.out.println("\n\t\tDeluxe Burger selected (Large Coke and Large Fries included*)");
            System.out.println("\t\t-------------------------------------------------------------\n");

        }
    }

    private static void printSides() {
        System.out.println("\n\t\tSelect side dishes: ");
        System.out.println(" ");
        System.out.println("\t\t[1]Cheese [$2]");
        System.out.println("\t\t[2]Lettuce [50c]");
        System.out.println("\t\t[3]Tomato [50c]");
        System.out.println("\t\t[4]Extra Secret Sauce [$1]");


        /*System.out.println("[11]Small Coke [$3]");
        System.out.println("[12]Large Coke [$5]");
        System.out.println("[13]Small Fries [$2.50]");
        System.out.println("[14]Large Fries [$4]");
        System.out.println(" ");*/
    }

    private static  void printHealthySides()
    {
        System.out.println("\t\t[5]Pickles [50c]");
        System.out.println("\t\t[6]Onion [50c]");
        System.out.println(" ");
    }
}