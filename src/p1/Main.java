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
        String choose;
        String color = "red";
        int size;
        char c;

        // Print Menu
        String[] menu = {"[C]reate", "[D]estroy", "[I]nflate", "[Q]uit"};
        Scanner input = new Scanner(System.in);

        // Prompt the user to create, destroy or inflate a balloon
        for (String each : menu) System.out.println(each);
        System.out.print("Choose an action: ");
        choose = input.next();
        choose = choose.toUpperCase();
        c = choose.charAt(0);

        // Test the chosen option
        if (c == 'C') {
            for (int i = 0; i < Balloons.length; i++) {
                System.out.print("Balloon " + (i + 1) + " enter a size: ");
                size = input.nextInt();
                if (Balloons[i] != null) {
                    Balloons[i] = new Balloon(size, color);
                }
            }
            for (Balloon each : Balloons)
                System.out.println(each);
        }

    }
}

class Balloon {
    private int size;
    private String color;
    boolean inflated;
    private static int quantity = 0;

    // Constructor receives size and color
    Balloon(int s, String c) {
        s = size;
        c = color;
        quantity++;
    }

    // Return the size
    public int getSize(int s) {
        s = size;
        return size;
    }

    // Return the color
    public String getColor(String c) {
        c = color;
        return color;
    }

    @Override
    public String toString() {
        return "Balloon{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}';
    }
}