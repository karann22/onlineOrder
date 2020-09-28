package hamburger.output;

import hamburger.data.MenuItem;


public class Output {

    public static void printReceipt()
    {
        System.out.println("\n\t\t\tYour receipt:");
        System.out.println("\t\t\t-------------\n");
    }

    public static void printMeatAndBunType(String meatType, String bunType){
        System.out.println("\t\tSelected meat: " + meatType);
        System.out.println("\t\tSelected bun: " + bunType);
        System.out.println("");

    }

    public static void printItems(int i, MenuItem item) {
        String name = item.getName();
        double price = item.getPrice();
        i += 1;
        System.out.println("\t\tItem " + i + ": " + name + ", price: $" + price);
    }
}