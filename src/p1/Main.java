package p1;
/*
    * Mayra Mendez
    * CIS 150-401
    *Balloon Demo (Create, Destroy, & Inflate)
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

            // Prompt the user to create, destroy or inflate a balloon
            for (String each : menu) System.out.println(each);
            System.out.print("Choose an action: ");
            String choose = input.next();
            choose = choose.toUpperCase();
            c = choose.charAt(0);

            // Test the chosen option
            //Create a balloon
            if (c == 'C') {
                for (int i = 0; i < Balloons.length; i++) {
                    System.out.print("Balloon " + (i + 1) + "\n");
                    int size;
                    String color;
                    Balloons[0] = new Balloon();
                    do {
                        System.out.print("Enter a size: ");
                        size = input.nextInt();
                        Balloon.getSize(size);
                        // Validate the size
                        System.out.println(Balloon.IsValidSize(size));
                        System.out.print("Enter a color: ");
                        color = input.next();
                        Balloon.getColor(color);
                        // Validate the color
                        System.out.println(Balloon.IsValidColor(color));
                    }
                    while ((Balloon.IsValidSize(size).equals("Invalid size")) || (Balloon.IsValidColor(color).equals("Invalid color")));
                    System.out.println(Balloons[i] = new Balloon(size, color));
                }
                for (Balloon each : Balloons) {
                    System.out.println(each);
                }
                System.out.println("We have made " + Balloon.getQuantity() + " balloons");
            }
            // Destroy a balloon
            else if (c == 'D') {
                // Print all balloons
                for (Balloon each : Balloons) {
                    for (int i = 0; i < Balloons.length; i++)
                        System.out.println(i + " " + each);
                }

                System.out.print("Which balloon do you want to destroy? ");
                int ans = input.nextInt();
                Balloon.destroy(ans, Balloons);

                // Print all balloons including destroyed ones
                for (Balloon each : Balloons) {
                    for (int i = 0; i < Balloons.length; i++)
                        System.out.println(i + " " + each);
                }
                System.out.println("We have " + Balloon.getQuantity() + " balloons");
            }
            // Inflated a balloon
            else if (c == 'I') {
                // Print all balloons
                for (Balloon each : Balloons) {
                    for (int i = 0; i < Balloons.length; i++)
                        System.out.println(i + " " + each);
                }

                System.out.print("Which balloon do you want to inflate? ");
                int ans = input.nextInt();
                Balloons[ans].inflated = true;

                // Print all balloons including inflated ones
                for (Balloon each : Balloons) {
                    for (int i = 0; i < Balloons.length; i++)
                        System.out.println(i + " " + each);
                }
            }
        } while (c != 'Q');
    }
}

class Balloon {
    private int size;
    private String color;
    boolean inflated;
    private static int quantity = 0;

    // Default constructor
    Balloon(){
        size = 10;
        color = "red";
        inflated = false;
    }
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

    // Destroy a balloon
    public static void destroy(int d, Balloon[] arg) {
        quantity--;
        arg[d] = null;
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