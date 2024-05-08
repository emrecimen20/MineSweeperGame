import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // I used "Scanner" to get the matrix size from the user.
        Scanner input=new Scanner(System.in);
        System.out.println("==Welcome to MineSweeper==");
        System.out.println("Enter the number of rows and columns to determine the difficulty");

        System.out.print("Enter the number of rows :");
        int rows=input.nextInt();
        System.out.print("Enter the number of columns :");
        int cols=input.nextInt();

        // I stipulated that it should have a size of 2x2 and above.
        if(rows<2 || cols<2){
            System.out.println("Minimum size allowed is 2x2. Please try again.");
            return;
        }

        // I created an object called "game" and sent the row and column values entered by the user.
        MineSweeper game=new MineSweeper(rows,cols);
        game.printBoard(game.mineBoard);
    }
}