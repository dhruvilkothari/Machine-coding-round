package Entity;

import Strategy.InitializeStrategy;

public class Board {
    public Cell[][]  board;
    public InitializeStrategy initializeStrategy;

    public Board(int size, InitializeStrategy initializeStrategy ){
        board = new Cell[size][size];
        this.initializeStrategy = initializeStrategy;
        initializeGame();
    }

    private void initializeGame() {
        initializeStrategy.initGame(board);
    }


}
