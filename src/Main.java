import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        byte x, y;
        Scanner scan = new Scanner(System.in);
        byte figure = 1;
        boolean retry = true;

        while (retry) {
            Board board = new Board();
            System.out.println("Welcome! Enter coords of your figure to start the game.");
            while (!board.endGame()) {
                x = scan.nextByte();
                y = scan.nextByte();
                if (board.makeMove(x, y, figure)) {
                    if (board.checkWinner(figure))
                        break;
                    figure *= -1;
                } else
                    continue;
                board.printBoard();
            }
            if (board.checkWinner(figure) && figure == 1)
                System.out.println("Congratulations! X wins!");
            else if (board.checkWinner(figure) && figure == -1)
                System.out.println("Congratulations! O wins!");
            else
                System.out.println("Draw!");
            board.printBoard();
            System.out.println("Retry? (true for retry, false for exit)");
            retry = scan.nextBoolean();
        }
        scan.close();
    }
}
