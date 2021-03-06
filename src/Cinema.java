import java.util.Scanner;

public class Cinema {
    private static char[][] cinemaHall;
    private static final int priceNotMore60Number = 10;
    private static final int priceFrontHalf = 10;
    private static final int priceBackHalf = 8;

    private static final char s = 'S';
    private static final char b = 'B';

    private static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        createCinemaHall();
        printCinemaHall(cinemaHall);
        takeTicket(cinemaHall);
        printCinemaHall(cinemaHall);
    }

    public static void createCinemaHall() {
        System.out.println("Enter the number of rows:");
        int numberOfRows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = sc.nextInt();

        cinemaHall = new char[numberOfRows][numberOfSeats];
        for (int i = 0; i < numberOfRows; i++) {
            for (int j = 0; j < numberOfSeats; j++) {
                cinemaHall[i][j] = s;
            }
        }
    }
    public static void printCinemaHall(char[][] cinemaHall) {
        System.out.println("Cinema:");
        System.out.print(" ");
        for (int i = 1; i <= cinemaHall[0].length; i++) {
            System.out.print(" " + i);
        }
        System.out.println();
        for (int i = 0; i < cinemaHall.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < cinemaHall[0].length; j++) {
                System.out.print(" " + cinemaHall[i][j]);
            }
            System.out.println();
        }
    }
    public static void takeTicket(char[][] cinemaHall){
        int totalNumberOfSeats = cinemaHall.length * cinemaHall[0].length;

        System.out.println("Enter a row number:");
        int seatRow = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();

        int priceTicket;

        if (totalNumberOfSeats <= 60) {
            priceTicket = priceNotMore60Number;
        } else {
            int frontHalfOfRows = cinemaHall.length / 2;
            if (seatRow <= frontHalfOfRows) {
                priceTicket = priceFrontHalf;
            } else {
                priceTicket = priceBackHalf;
            }
        }

        System.out.println("Ticket price: $" + priceTicket);
        cinemaHall[seatRow - 1][seatNumber - 1] = b;
    }
}
