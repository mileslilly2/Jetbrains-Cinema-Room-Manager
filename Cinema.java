package cinema;
import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int seatNum = 0;
        int rowNum = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numRows = scanner.nextInt(); // get the number of rows
        System.out.println("Enter the number of seats in each row:");
        int numCols = scanner.nextInt(); // get the number of seats
        System.out.println();
        int totalSeats = numRows * numCols; // compute the total number of seats
        String[][] seatsGrid = new String[numRows][numCols]; // create a string array to hold the grid
        populateSeats(numRows, numCols, seatsGrid); // populated the string array with all of the right infomation
        printCin(numRows, numCols, seatNum, rowNum, seatsGrid);
        
        double[] stats = new double[4];
        stats[0] = 0; // create an array of doubles so I am able to hold
        stats[1] = 0;
        stats[2] = 720.0;
        int choice = -1;
        while (choice != 0) {
            System.out.println("1. Show the seats"); // print the menu 
            System.out.println("2. Buy a ticket"); 
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    printCin(numRows, numCols, seatNum, rowNum, seatsGrid); // output the rows
                    break;
                case 2:
                    getSeats(totalSeats, numRows, numCols, seatsGrid, scanner, stats); // allow the user get a seat
                    break;
                case 3:
                  stats(seatsGrid ,stats, totalSeats); // compute that stats
                case 0:
                    break;
                default:
                    break;
            }
        }
            
    }
       

      
    public static void stats(String[][] seatGrid, double stats[], int totalSeats) { // a method to compute and output the stats
        
        System.out.printf("Number of purchased tickets: %d\n", (int) stats[0]);
        double percent =  stats[0] / totalSeats * 100.0;
        System.out.printf("Percentage: %.2f%%\n", percent);
        System.out.printf("Current income: $%d\n", (int) stats[1]);
        System.out.printf("Total income: $%d\n\n", (int) stats[2]);
    }
    
    
    public static void getSeats(int totalSeats, int numRows, int numCol, String seatsGrid[][], Scanner scanner, double[] stats) {
      while (true) { // a method to allow the user to purchace seats
          System.out.println("Enter a row number:");
          int rowNum = scanner.nextInt();
          System.out.println("Enter a seat number in that row:");
          int seatNum = scanner.nextInt();
          if (rowNum > numRows || seatNum > numCol) {
            System.out.println("Wrong input!\n");
            continue;
          } else if (seatsGrid[rowNum - 1][seatNum - 1].equals(" B")) {
              System.out.println("That ticket has already been purchased!");
          } else {
            int half = numRows / 2;
            if (totalSeats >= 60) { 
                if (rowNum <= half) {
                    System.out.println("\nTicket price: $10\n");
                    stats[1] = stats[1] + 10;
                  
                } else {
                      System.out.println("\nTicket price: $8\n");
                      stats[1] = stats[1] + 8;
                    }
            } else {
                System.out.println("\nTicket price: $10\n");
            }
            stats[0] = stats[0] + 1;
          
             
            seatsGrid[rowNum - 1][seatNum - 1] = " B";
            break;
            
          }
      }
    }
    
    
    public static void populateSeats(int row, int seats, String seatsGrid[][]) {
         for (int i = 0; i < row; i++) {
            for (int j = 0; j < seats; j++) {
                seatsGrid[i][j] = " S";
            }
        }
    }
    
    public static void printCin(int row, int seats, int seatNum, int rowNum, String seatsGrid[][]) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= seats; i++) {
            System.out.printf(" %d", i);
        }
        System.out.println();
        for (int i = 1; i <= row; i++) {
            System.out.print(i);
            for (int j = 0; j < seats; j++) {
               System.out.print(seatsGrid[i - 1][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}