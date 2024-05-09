import java.util.Random;
import java.util.Scanner;

public class MineSweeper {

    public char[][] gameBoard;
    public char[][] mineBoard;
    public int rows;
    public int cols;
    public int totalMines;
    public int nonMine; // Places without mines.

    // Constructor method
    public MineSweeper(int rows,int cols){
        this.rows=rows;
        this.cols=cols;
        this.totalMines=(rows * cols)/4; // Determining the total mines according to the number of rows and columns.
        this.nonMine=(rows * cols)-this.totalMines;// I calculated the number of mine-free places.
        this.gameBoard=new char[rows][cols];
        this.mineBoard=new char[rows][cols];
        initializeBoard();
        placeMines();
    }

    // Method that prints my matrix.
    public void printBoard(char[][] board) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    // Create game board and mine board and I equalize elements '-'.
    public void initializeBoard(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                gameBoard[i][j]='-';
                mineBoard[i][j]='-';
            }
        }
    }

    // I used this method to place random mines.
    public void placeMines(){
        Random rand=new Random(); // I used the "Random" method to generate random numbers.
        int minesPlaced=0;

        // The loop will continue until the total number of mines.
        while (minesPlaced<totalMines){
            int randRow=rand.nextInt(rows);
            int randCol=rand.nextInt(cols);
            if(mineBoard[randRow][randCol]!='*'){
                mineBoard[randRow][randCol]='*';
                minesPlaced++;
            }
        }
    }

    // Method that checks the coordinates entered by the user.
    public boolean isValidMove(int row,int col){
        return row>=0 && row<rows && col>=0 && col<cols && gameBoard[row][col]=='-';
    }


    public void show(int row,int col){
        if(!isValidMove(row,col)) {
            return;
        }

        // If the user enters the coordinates of the mined cell, the game ends and the mined board is shown to the user.
        if(mineBoard[row][col]=='*'){
            System.out.println("Game Over ! You stepped on a mine!");
            printMineBoard();
            System.exit(0);
        }

        // When a cell without a mine is selected
        int minesAround =countMinesAround(row,col);
        gameBoard[row][col]=(char) (minesAround+'0');
        nonMine--;
    }

    // Method that calculates the number of mines around the selected cell.
    public int countMinesAround(int row,int col){
        int count=0;
        for(int i=row-1;i<=row+1;i++){
            for(int j=col-1;j<=col+1;j++){
                if(i>=0 && i<rows && j>=0 && j<cols && mineBoard[i][j]=='*'){
                    count++;
                }
            }
        }
        return count;
    }

    public void printMineBoard(){
        printBoard(mineBoard);
    }

    public void play(){
        Scanner input=new Scanner(System.in);
        printBoard(gameBoard);
        while (nonMine>0){
            System.out.print("Enter row :");
            int row=input.nextInt();
            System.out.print("Enter column :");
            int col=input.nextInt();

            // If the user enters the wrong code and enters the same coordinates, a warning is given.
            if(!isValidMove(row,col)){
                System.out.println("Invalid move !! Please enter valid row and column.");
                continue;
            }
            show(row,col);
            printBoard(gameBoard);
        }
        System.out.println("You Win !! You opened all safe cells!");

    }

}
