package hamburger.calc;

public class Calculate {


    public static double calculateTotalPrice(double[] priceList) {
        double totalPrice = 0;
        for (int i = 0; i < priceList.length; i++) {
            totalPrice += priceList[i];
        }
        System.out.print("\n\t\t-----------------------------");
        System.out.println("\n\t\t\tTotal price: $" + totalPrice);
        System.out.println("\t\t-----------------------------");
        return totalPrice;
    }
}
