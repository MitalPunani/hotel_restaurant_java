import java.util.Scanner;

class booking {
    int totalbill = 0;

    int calculatebill() {
        System.out.println("Booking bill...");
        return 0;

    }
}

class tablebooking extends booking {
    String[] name = new String[8];
    int[] member = new int[5];
    String[] datetime = new String[15];
    int priceperperson = 200;

    // overriding method
    int calculatebill() {
        Scanner sc = new Scanner(System.in);
        int totalprice;
        int n;

        System.out.print("How many table booking you want : ");
        n = sc.nextInt();
        sc.nextLine(); // buffer clear

        for (int i = 0; i < n; i++) {
            System.out.println("\n Enter details for booking : " + (i + 1));
            System.out.print("Enter  Name : ");
            name[i] = sc.nextLine();
            System.out.print("Enter Number of Member : ");
            member[i] = sc.nextInt();
            sc.nextLine();// buffer clear
            System.out.print("Enter booking date & time : ");
            String datetime = sc.nextLine();

            totalprice = member[i] * priceperperson;
            System.out.println();
            // Bill Display
            System.out.println("\n----- TABLE BOOKING BILL -----");
            System.out.println("Name             : " + name[i]);
            System.out.println("Members          : " + member[i]);
            System.out.println("Date & Time      : " + datetime);
            System.out.println("Price per Person : " + priceperperson);
            System.out.println("Total Amount     : " + totalprice);
            System.out.println("------------------------------");
        }

        return 0;

    }
}

class foodbooking extends booking {

    String foodname[] = { "Pizza", "Pasta", "Dosa" };
    String spice[] = { "Medium", "High", "Low" };
    int price[] = { 250, 180, 120 };

    // overriding method
    int calculatebill() {

        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("------Food Menu------");

        for (int i = 0; i < foodname.length; i++) {
            System.out.println((i + 1) + ". "
                    + foodname[i] + " | Spice: "
                    + spice[i] + " | Price: "
                    + price[i]);
        }

        System.out.println();

        System.out.print("Enter Food Number : ");
        int choice = sc.nextInt();

        System.out.print("Food Quantity : ");
        int qty = sc.nextInt();

        System.out.println();

        if (choice >= 1 && choice <= foodname.length) {

            int index = choice - 1;
            int total = price[index] * qty;

            System.out.println("------Food Bill------");
            System.out.println("Food Name : " + foodname[index]);
            System.out.println("Spice Level : " + spice[index]);
            System.out.println("Price : " + price[index]);
            System.out.println("Quantity : " + qty);
            System.out.println("Total Bill : " + total);

            return total; // ✅ Return total here
        } else {
            System.out.println("Invalid Food Selection!");
            return 0; // return 0 if invalid
        }
    }
}

class roombooking extends booking {
    // overriding method
    int calculatebill() {
        Scanner sc = new Scanner(System.in);

        // array(room type + price)
        String roomtype[] = { "AC", "non-AC", "Deluxe" };
        int roomprice[] = { 2000, 1200, 3500 };

        // Extra items array
        String extraitem[] = { "Extra Bad", "Heater", "Breakfast" };
        int extraprice[] = { 500, 300, 400 };

        System.out.println();
        // user input
        System.out.println("|------ Room Booking ------|");

        System.out.print("Enter number of members : ");
        int member = sc.nextInt();
        System.out.print("Enter number of rooms : ");
        int room = sc.nextInt();

        System.out.println();
        // Display roomtype
        System.out.println("\n Select room type: ");
        for (int i = 0; i < roomtype.length; i++) {
            System.out.println((i + 1) + "." + roomtype[i] + " - Rs." + roomprice[i]);
        }

        System.out.println();
        System.out.print("Enter room choice : ");
        int roomchoice = sc.nextInt();

        // Selected rooms detail
        String selectedroom = roomtype[roomchoice - 1];
        int selectedroomprice = roomprice[roomchoice - 1];

        System.out.println();
        // Display extra items
        System.out.println("Selectes extra items : ");
        for (int i = 0; i < extraitem.length; i++) {
            System.out.println((i + 1) + "." + extraitem[i] + " -Rs." + extraprice[i]);
        }

        System.out.println();
        System.out.print("Enter extra Item choice : ");
        int extrachoice = sc.nextInt();

        String selectedextra = extraitem[extrachoice - 1];
        int selectedextraprice = extraprice[extrachoice - 1];

        System.out.println();
        // Date & time input
        sc.nextLine();// buffer clear
        System.out.print("Enter booking date & time : ");
        String datetime = sc.nextLine();

        // Bill calculation
        int roomtotal = selectedroomprice * room;
        int grandtotal = roomtotal + selectedextraprice;

        // Store in totalBill
        int totalBill = grandtotal;

        System.out.println();
        // Display final bill
        System.out.println("|------ Room Booking Bill ------|");
        System.out.println("Members : " + member);
        System.out.println("Rooms booked : " + room);
        System.out.println("Room Type : " + selectedroom);
        System.out.println("Room Price : " + selectedroomprice);
        System.out.println("Extra Items : " + selectedextra);
        System.out.println("Extra Price : " + selectedextraprice);
        System.out.println("Booking Datetime : " + datetime);

        System.out.println("---------------------------------");
        System.out.println("Room Total : Rs. " + roomtotal);
        System.out.println("Grand Total : Rs. " + grandtotal);
        System.out.println("---------------------------------");

        return grandtotal;
    }
}

class bothbooking extends booking {

    int calculatebill() {

        foodbooking food = new foodbooking();
        roombooking room = new roombooking();

        System.out.println("\n===== FOOD BOOKING =====");
        // food.calculatebill();
        int foodTotal = food.calculatebill();

        // System.out.println("\n===== ROOM BOOKING =====");
        // // room.calculatebill();
        int roomTotal = room.calculatebill();

        int totalbill = foodTotal + roomTotal;
        // int totalbill = foodTotal;

        System.out.println("\n===============================");
        System.out.println("FINAL COMBINED BILL = Rs." + totalbill);
        System.out.println("===============================");

        return 0;
    }
}

class vehicalbooking extends booking {
    // array
    String vehicaltype[] = { "bike", "car", "van" };
    int priceperkm[] = { 10, 25, 40 };

    int calculatebill() {
        Scanner sc = new Scanner(System.in);

        // member input
        System.out.print("Enter number of members : ");
        int members = sc.nextInt();

        System.out.println("");
        // vehical manu display
        System.out.println("------ Select Vehical Type ------");
        for (int i = 0; i < vehicaltype.length; i++) {
            System.out.println((i + 1) + "." + vehicaltype[i] + "(price per KM : " + priceperkm[i] + ")");
        }

        System.out.println("");
        // user choice
        System.out.print("Enter vehical choice : ");
        int choice = sc.nextInt();

        // velidation
        if (choice < 1 || choice > vehicaltype.length) {
            System.out.println("Invalid choice!");
            return 0;
        }

        System.out.println("");
        // distance input
        System.out.print("Enter distance from hotal (in Km) : ");
        int distance = sc.nextInt();

        // location input
        sc.nextLine(); // buffer clear
        System.out.print("Enter pickup location : ");
        String location = sc.nextLine();

        // bill calculation
        int totalbill = distance * priceperkm[choice - 1];

        System.out.println("");
        // display bill
        System.out.println("|------ Vehical Booking Bill ------|");
        System.out.println("Members : " + members);
        System.out.println("Vehical type : " + vehicaltype[choice - 1]);
        System.out.println("Distance : " + distance + "KM");
        System.out.println("Pickup location : " + location);
        System.out.println("-----------------------------");
        System.out.println("Total bill : " + totalbill);
        System.out.println("-----------------------------");
        return 0;
    }

}

class parking extends booking {
    int calculatebill() {
        Scanner sc = new Scanner(System.in);

        String[] vehicaltype = { "bike", "car", "bus" };
        int[] parkingprice = { 20, 50, 100 };

        System.out.println("------ Parking Type ------");
        for (int i = 0; i < vehicaltype.length; i++) {
            System.out.println((i + 1) + "." + vehicaltype[i] + "- Rs." + parkingprice[i]);
        }
        System.out.println("");
        System.out.print("Enter vehical type : ");
        int choice = sc.nextInt() - 1;

        System.out.print("Enter number of vehical : ");
        int noofvehical = sc.nextInt();

        int totalbill = parkingprice[choice] * noofvehical;

        System.out.println("");
        System.out.println("------ parking bill ------");
        System.out.println("Vehical type : " + vehicaltype[choice]);
        System.out.println("no. of Vehical : " + noofvehical);
        System.out.println("Total parking charge : Rs. " + totalbill);
        return 0;
    }
}

public class hotel_restaurant {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice;

        // print Manu
        System.out.println("|-------Hotal Manu-------|");
        System.out.println("1.Table Booking .");
        System.out.println("2.Food Manu .");
        System.out.println("3.Room Booking .");
        System.out.println("4.Combine Food & Room .");
        System.out.println("5.Vehical Booking .");
        System.out.println("6.parking Charge .");
        System.out.println("0. Exit ");
        System.out.println("");
        System.out.print("Enter your choice :");
        choice = sc.nextInt();

        // switch
        switch (choice) {
            case 1:
                System.out.println("Table booking selected .");
                booking b = new tablebooking(); // Parent reference
                b.calculatebill(); // Runtime Polymorphism
                break;
            case 2:
                System.out.println("Food Manu selected .");
                booking f = new foodbooking();
                f.calculatebill();
                break;
            case 3:
                System.out.println("Room booking selected .");
                booking r = new roombooking();
                r.calculatebill();
                break;
            case 4:
                System.out.println("Food & Room booking selected .");
                booking c = new bothbooking();
                c.calculatebill();
                break;
            case 5:
                System.out.println("Vehical booking selected .");
                booking v = new vehicalbooking();
                v.calculatebill();
                break;
            case 6:
                System.out.println("Parking charge .");
                booking p = new parking();
                p.calculatebill();
                break;
            case 0:
                System.out.println("Thank you! Visit again.");
                break;
            default:
                System.out.println("Invalid choice! Try again.");
                break;
        }

    }
}
