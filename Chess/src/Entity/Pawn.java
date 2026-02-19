package Entity;

import Entity.Enum.PieceType;
import Strategy.MovementStrategy;

public class Pawn extends Piece {
    public Pawn(boolean isWhite, MovementStrategy movementStrategy, Cell cell) {
        super(isWhite, movementStrategy, PieceType.PAWN, cell );
    }
}
