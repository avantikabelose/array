import java.util.ArrayList;
import java.util.Scanner;

class IceCream
{
    private ArrayList<String> flavors;
    private ArrayList<Double> flavorPrices;
    private ArrayList<String> toppings;
    private ArrayList<Double> toppingPrices;
    private int numScoops;
    private int numCups;
    private int numCones;
    private int numWaffles;

    public IceCream() 
    {
        this.flavors = new ArrayList<>();
        this.flavorPrices = new ArrayList<>();
        this.toppings = new ArrayList<>();
        this.toppingPrices = new ArrayList<>();
        this.numScoops = 0;
        this.numCups = 0;
        this.numCones = 0;
        this.numWaffles = 0;
    }

    public void addFlavor(String flavor, double price)
    {
        flavors.add(flavor);
        flavorPrices.add(price);
    }

    public void addTopping(String topping, double price) 
    {
        toppings.add(topping);
        toppingPrices.add(price);
    }

    public void setNumScoops(int num) 
    {
        this.numScoops = num;
    }

    public void setNumCups(int num) 
    {
        this.numCups = num;
    }

    public void setNumCones(int num) 
    {
        this.numCones = num;
    }

    public void setNumWaffles(int num) 
    {
        this.numWaffles = num;
    }

    public double calculateTotal(double scoopPrice, double cupPrice, double conePrice, double wafflePrice)
    {
        double total = 0;
        for (double price : flavorPrices) 
        {
            total += price;
        }
        total += (numScoops * scoopPrice);
        total += (numCups * cupPrice);
        total += (numCones * conePrice);
        total += (numWaffles * wafflePrice);
        for (double price : toppingPrices)
        {
            total += price;
        }
        return total;
    }

    public void printReceipt() 
    {
        System.out.println("----- Receipt -----");
        System.out.println("Flavors:");
        for (int i = 0; i < flavors.size(); i++) {
            System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, flavors.get(i), flavorPrices.get(i));
        }

        if (numScoops > 0) 
        {
            double scoopTotal = numScoops * 20;
            System.out.printf("Scoops: %d (%.2f Rs.)\n", numScoops, scoopTotal);
        }
        if (numCups > 0) 
        {
            double cupTotal = numCups * 30;
            System.out.printf("Cups: %d (%.2f Rs.)\n", numCups, cupTotal);
        }
        if (numCones > 0) 
        {
            double coneTotal = numCones * 40;
            System.out.printf("Cones: %d (%.2f Rs.)\n", numCones, coneTotal);
        }
        if (numWaffles > 0)
        {
            double waffleTotal = numWaffles * 50;
            System.out.printf("Waffles: %d (%.2f Rs.)\n", numWaffles, waffleTotal);
        }

        System.out.println("Toppings:");
        for (int i = 0; i < toppings.size(); i++) 
        {
            System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, toppings.get(i), toppingPrices.get(i));
        }

        double total = calculateTotal(20, 30, 40, 50);
        System.out.printf("Total Cost: %.2f Rs.\n", total);
        System.out.println("-------------------");
    }
}

class IceCreamClient 
{
    private static int customerCount = 0;
    private static final int MAX_CUSTOMERS = 100;

    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);

        String[] flavors = {"Vanilla", "Chocolate", "Strawberry", "Butterscotch", "Mint", "Mango", "Coffee", "Black Currant", "Bubble Gum", "Cookies & Cream"};
        double[] flavorPrices = {100, 200, 150, 200, 120, 180, 160, 220, 190, 250};

        String[] toppings = {"Nuts", "Sprinkles", "Chocolate Chips", "Caramel", "Whipped Cream", "Cherry Crush", "Oreo Crumbles", "Jelly", "Fruits", "Coconut Flakes"};
        double[] toppingPrices = {75, 55, 60, 45, 70, 75, 65, 50, 70, 55};

        while (customerCount < MAX_CUSTOMERS)
        {
            System.out.println("\nCustomer " + (customerCount + 1) + " - Welcome to the Ice Cream Parlour!");
            IceCream iceCream = new IceCream();

            // Choose flavors
            System.out.println("Choose flavors (0 to stop):");
            for (int i = 0; i < flavors.length; i++) 
            {
                System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, flavors[i], flavorPrices[i]);
            }
            while (true)
            {
                int flavorChoice = scanner.nextInt();
                if (flavorChoice == 0) break;
                if (flavorChoice > 0 && flavorChoice <= flavors.length) 
                {
                    iceCream.addFlavor(flavors[flavorChoice - 1], flavorPrices[flavorChoice - 1]);
                } 
                    else 
                    {
                    System.out.println("Invalid choice. Please select again.");
                    }
            }

            // Set scoops, cups, cones, waffles
            System.out.println("How many scoops? (20 Rs. per scoop):");
            iceCream.setNumScoops(scanner.nextInt());

            System.out.println("How many cups? (30 Rs. per cup):");
            iceCream.setNumCups(scanner.nextInt());

            System.out.println("How many cones? (40 Rs. per cone):");
            iceCream.setNumCones(scanner.nextInt());

            System.out.println("How many waffles? (50 Rs. per waffle):");
            iceCream.setNumWaffles(scanner.nextInt());

            // Choose toppings
            System.out.println("Choose toppings (0 to stop):");
            for (int i = 0; i < toppings.length; i++) 
            {
                System.out.printf("%d. %s (%.2f Rs.)\n", i + 1, toppings[i], toppingPrices[i]);
            }
            while (true)
            {
                int toppingChoice = scanner.nextInt();
                if (toppingChoice == 0) break;
                if (toppingChoice > 0 && toppingChoice <= toppings.length)
                {
                    iceCream.addTopping(toppings[toppingChoice - 1], toppingPrices[toppingChoice - 1]);
                } 
                    else 
                    {
                    System.out.println("Invalid choice. Please select a valid topping.");
                    }
            }

            // Print the receipt                                                            
            iceCream.printReceipt();
	    System.out.println("Thank you for your purchase!");
            customerCount++;
        }

        System.out.println("Maximum customer limit reached. Thank you for visiting!");
        scanner.close();
    }
}
