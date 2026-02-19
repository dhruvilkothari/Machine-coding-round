package Strategy;

import Entity.Board;
import Entity.Cell;

public interface InitializeStrategy {
    public void initGame(Cell[][] board);
}
