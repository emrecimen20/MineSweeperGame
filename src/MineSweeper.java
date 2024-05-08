import java.util.Random;

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
    }

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
            int randRow=rand.nextInt();
            int randCol=rand.nextInt();
            if(mineBoard[randRow][randCol]!='*'){
                mineBoard[randRow][randCol]='*';
                minesPlaced++;
            }
        }
    }

    public boolean isValidMove(int row,int col){
        return row>=0 && row<rows && col>=0 && col<cols && gameBoard[row][col]=='-';
    }


}
