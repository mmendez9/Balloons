package p1;
/*
    * Mayra Mendez
    * CIS 150-401
    *Balloon Demo (Create, Destroy, & Inflate Balloons)
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Balloon[] Balloons = new Balloon[5];
        char c;

        do {
            // Print Menu
            String[] menu = {"[C]reate", "[D]estroy", "[I]nflate", "[Q]uit"};
            Scanner input = new Scanner(System.in);
            for (String each : menu) System.out.println(each);

            // Prompt the user to create, destroy or inflate a balloon
            System.out.print("Choose an action: ");
            String choose = input.next();
            choose = choose.toUpperCase();
            c = choose.charAt(0);

            // Test the chosen option
            //Create a balloon
            if (c == 'C') {
                System.out.print("How many balloon do you want to create? ");
                int n = input.nextInt();
                Balloons = new Balloon[n];
                for (int i = 0; i < Balloons.length; i++) {
                    System.out.print("Balloon " + i + "\n");
                    int size;
                    String color;
                    do {
                        //Ask the user for a size
                        System.out.print("Enter a size (6, 8, 10, 12): ");
                        size = input.nextInt();
                        Balloon.getSize(size);

                        // Validate the size
                        System.out.println(Balloon.IsValidSize(size));
                    } while (Balloon.IsValidSize(size).equals("Invalid size"));

                    do {
                        //Ask the user for a color
                        System.out.print("Enter a color (red, blue, green, yellow): ");
                        color = input.next();
                        Balloon.getColor(color);

                        // Validate the color
                        System.out.println(Balloon.IsValidColor(color));
                    } while (Balloon.IsValidColor(color).equals("Invalid color"));

                    System.out.println(Balloons[i] = new Balloon(size, color));
                }
                System.out.println("\nWe have made " + Balloon.getQuantity() + " balloons");
                for (Balloon each : Balloons) {
                    System.out.println(each);
                }
                System.out.println();
            }
            // Destroy a balloon
            else if (c == 'D') {
                System.out.println();
                // Print all balloons
                for (Balloon each : Balloons)
                    System.out.println(each);

                System.out.print("\nEnter a number starting from zero \nWhich balloon do you want to destroy? ");
                int ans = input.nextInt();

                // Validate if Balloon exists
                if (Balloon.IsValidBalloon(Balloons[ans]) == true) {
                    // Destroy a balloon
                    Balloon.destroy(ans, Balloons);
                }
                else System.out.println("Balloon doesn't exist");

                // Print all balloons including destroyed ones
                for (Balloon each : Balloons) {
                    if (each != null)
                    System.out.println(each);
                    else System.out.println("Balloon destroyed");
                }
                System.out.println();
            }
            // Inflated a balloon
            else if (c == 'I') {
                System.out.println();
                // Print all balloons
                for (Balloon each : Balloons) {
                    System.out.println(each);
                }

                System.out.print("\nEnter a number starting from zero \nWhich balloon do you want to inflate? ");
                int ans = input.nextInt();

                // Validate if Balloon exists
                if (Balloon.IsValidBalloon(Balloons[ans]) == true) {
                    if (Balloon.IsBalloonInflated(ans, Balloons) == false)
                        Balloon.inflate(ans, Balloons);
                    else System.out.println("Balloon is inflated");
                } else System.out.println("Balloon doesn't exist");

                // Print all balloons including inflated ones
                for (Balloon each : Balloons) {
                    if (each != null)
                        System.out.println(each);
                    else System.out.println("Balloon destroyed");
                }
                System.out.println();
            }
        } while (c != 'Q');
        System.out.println();
        // Print all balloons
        for (Balloon each : Balloons) {
            if (each != null)
                System.out.println(each);
            else System.out.println("Balloon destroyed");
        }
        System.out.println("We already have " + Balloon.getQuantity() + " balloon(s)");
    }
}

class Balloon {
    private int size;
    private String color;
    boolean inflated;
    private static int quantity = 0;

    // Constructor receives size and color
    Balloon(int s, String c) {
        size = s;
        color = c;
        quantity++;
    }

    // Return the size
    public static int getSize(int s) {
        Balloon.IsValidSize(s);
        return s;
    }

    // Return the color
    public static String getColor(String c) {
        Balloon.IsValidColor(c);
        return c;
    }

    // Return quantity
    static int getQuantity() {
        return quantity;
    }

    //Validate the size
    static String IsValidSize(int s) {
        if (s == 6 || s == 8 || s == 10 || s == 12)
            return "Valid size";
        else
            return "Invalid size";
    }

    //Validate the color
    static String IsValidColor(String c) {
        if (c.equalsIgnoreCase("red") || c.equalsIgnoreCase("blue")
                || c.equalsIgnoreCase("green") || c.equalsIgnoreCase("yellow"))
            return "Valid color";
        else
            return "Invalid color";
    }

    // Balloon exists
    public static boolean IsValidBalloon(Balloon arg) {
        if (arg != null)
            return true;
        else
            return false;
    }

    // Destroy a balloon
    public static void destroy(int d, Balloon[] arg) {
        quantity--;
        arg[d] = null;
    }

    // Is Balloon inflated
    public static boolean IsBalloonInflated(int i, Balloon[] arg) {
        if (arg[i].inflated == true)
            return true;
        else
            return false;
    }

    // Inflate a balloon
    public static void inflate(int i, Balloon[] arg) {
        arg[i].inflated = true;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "size=" + size +
                ", color='" + color + '\'' +
                ", inflated=" + inflated +
                '}';
    }
}