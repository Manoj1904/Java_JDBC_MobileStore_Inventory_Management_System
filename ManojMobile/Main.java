package com.ManojMobile;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Mobile m;
        Inventory i = new Inventory();
        Login l = new Login();
        User u;
        int op, con;
        String name, id, brand, u_name, pwd;
        float price;
        do {
        	System.out.println("_______________Welcome to Mobile Store Inventory Management System_______________");
            System.out.println("Login Details ");
            System.out.println("Enter User Name: ");
            u_name = scan.next();
            System.out.println("Enter Password: ");
            pwd = scan.next();
            u = new User(u_name, pwd);
            int lc = l.checkUser (u);

            if (lc == 1) {
                do {
                    System.out.println("1-Add\n2-Update\n3-Remove\n4-Search\n5-Display\n6-Exit");
                    System.out.println("Enter Option: ");
                    int option = scan.nextInt();

                    switch (option) {
                        case 1:
                            System.out.println("Enter ID: ");
                            id = scan.next();
                            System.out.println("Enter Name: ");
                            name = scan.next();
                            System.out.println("Enter Brand: ");
                            brand = scan.next();
                            System.out.println("Enter Price: ");
                            price = scan.nextFloat();
                            i.add(new Mobile(id, name, brand, price));
                            break;

                        case 2:
                            System.out.println("Enter ID: ");
                            id = scan.next();
                            i.update(id);
                            break;

                        case 3:
                            System.out.println("Enter ID: ");
                            id = scan.next();
                            i.remove(id);
                            break;

                        case 4:
                            System.out.println("Enter ID: ");
                            id = scan.next();
                            m = i.search(id);
                            if (m != null) {
                                System.out.println(m);
                            } else {
                                System.out.println("Mobile not found!");
                            }
                            break;

                        case 5:
                            i.show();
                            break;

                        case 6:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid Option!");
                            break;
                    }
                    System.out.println("Enter 1 to continue or -1 to logout");
                    op = scan.nextInt();
                } while (op != -1);
            } else if (lc == 2) {
                do {
                    System.out.println("1-Display\n2-Buy\n3-Exit");
                    System.out.println("Enter Option: ");
                    int option = scan.nextInt();

                    switch (option) {
                        case 1:
                            i.show();
                            break;

                        case 2:
                            System.out.println("Enter ID of the mobile you want to buy: ");
                            id = scan.next();
                            m = i.search(id);
                            if (m != null) {
                                System.out.println("Mobile details: " + m);
                                System.out.println("Price: " + m.getPrice());
                                System.out.println("Do you want to buy this mobile? (yes/no)");
                                String choice = scan.next();
                                if (choice.equalsIgnoreCase("yes")) {
                                    System.out.println("Mobile Ordered successfully!");
                                    i.remove(id);
                                } else {
                                    System.out.println("Purchase cancelled.");
                                }
                            } else {
                                System.out.println("Mobile not found!");
                            }
                            break;

                        case 3:
                            System.out.println("Exiting...");
                            return;

                        default:
                            System.out.println("Invalid Option!");
                            break;
                    }

                    System.out.println("Enter 1 to continue or -1 to logout");
                    op = scan.nextInt();

                } while (op != -1);

            } else {
                System.out.println("Invalid Login. Showing Inventory.");
            }

            System.out.println("Enter 1 to login again or -1 to exit");
            con = scan.nextInt();

        } while (con != -1);

        scan.close();
    }
}