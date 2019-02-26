public class Board {
    private byte board[][] = new byte[3][3];

    private boolean checkCols(byte figure)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[i][j] != figure)
                    break;
                else if (j == 2)
                    return true;
            }
        }
        return false;
    }

    private boolean checkRows(byte figure)
    {
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (board[j][i] != figure)
                    break;
                else if (j == 2)
                    return true;
            }
        }
        return false;
    }

    private boolean checkCross(byte figure)
    {
        return (board[0][0] == figure && board[1][1] == figure && board[2][2] == figure) ||
                (board[2][0] == figure && board[1][1] == figure && board[0][2] == figure);
    }

    public boolean checkWinner(byte figure)
    {
        return (checkCols(figure) || checkRows(figure) || checkCross(figure));
    }

    public boolean makeMove(byte x, byte y, byte figure)
    {
        if ((x > 0 && x < 4) && (y > 0 && y < 4) && board[x - 1][y - 1] == 0)
        {
            board[x - 1][y - 1] = figure;
            System.out.println("Enter next coords: ");
            return true;
        }
        else
        {
            System.out.println("Error! Retry your turn with different coords!");
            return false;
        }
    }

    public void printBoard()
    {
        for (byte str[] : board)
        {
            for(byte c : str)
            {
                if (c == 1)
                    System.out.print('X' + " ");
                else if (c == -1)
                    System.out.print('O' + " ");
                else
                    System.out.print('.' + " ");
            }
            System.out.print('\n');
        }
    }

    public boolean endGame()
    {
        for (byte str[] : board)
        {
            for(byte c : str)
            {
                if (c == 0)
                    return false;
            }
        }
        return true;
    }
}
