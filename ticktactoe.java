package Game;

import java.util.Scanner;

public class ticktactoe {


    public static void main(String[] args) {
        
        // Things to have:
        char[][] board = new char[3][3];
        // Set all the places of board as empty:
        for (int row=0; row<board.length; row++)
        {
            for (int col = 0; col<board[0].length; col++)
            {
                board[row][col] = ' ';
            }
        }

        char Player = 'X';
        boolean gameWon = false;
        Scanner sc = new Scanner(System.in);

        while(!gameWon)
        {
            // Print the board so that user can see where to place:
            displayBoard(board);
            // Ask user where to place:
            System.out.println();
            int row = sc.nextInt();
            int col = sc.nextInt();
            // Place the player at specific position:
            board[row][col]  = Player;
            // After Placing the player , we check if the game is won by any player or not , if not then we continue but with the next Player.
            if (hasWon(board, Player))
            {
                displayBoard(board);
                gameWon = true;
            }
            else
            {
                if (Player == 'X')
                {
                    Player = 'O';
                }
                else
                {
                    Player = 'X';
                }
            }

        }

        
        System.out.println("Player " + Player + " has won the game!");


    }


    public static boolean hasWon(char[][] board, char Player)
    {
        // Three Cases:

        // Case 1 : Check for each Col;
        for (int col = 0; col<board[0].length; col++)
        {
            if (board[0][col] == Player && board[1][col] == Player && board[2][col] == Player)
            {
                return true;
            }
        }

        // Case 2: Check for  each row:
        for (int row = 0; row<board[0].length; row++)
        {
            if (board[row][0] == Player && board[row][1] == Player && board[row][2] == Player)
            {
                return true;
            }
        }

        // Case 3 : check diagonaly:
        if (board[0][0] == Player && board[1][1] == Player && board[2][2] == Player) // We have traversed the diagonal
        {
            return true;
        }

        // Case 4 : check diagonaly oppositly:
        if (board[0][2] == Player && board[1][1] == Player && board[2][0] == Player) // We have traversed the diagonal
        {
            return true;
        }


        return false;
    }

    public static void displayBoard(char[][] board)
    {
        for (int row=0; row<board.length; row++)
        {
            for (int col = 0; col<board[0].length; col++)
            {
                System.out.print(board[row][col] + " | ");
            }

            System.out.println();
        }

    }
    
}