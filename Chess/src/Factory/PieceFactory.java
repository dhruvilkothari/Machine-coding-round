package Factory;

import Entity.Cell;
import Entity.PieceType;
import Entity.Pawn;
import Entity.Piece;
import Strategy.MovementStrategy;

public class PieceFactory {
    public static Piece getPiece(boolean isWhite, MovementStrategy movementStrategy, PieceType pieceType, Cell cell){

        switch (pieceType){

            case PAWN -> {
                return new Pawn(isWhite, movementStrategy, cell);
            }
            default -> {
                return null;
            }
        }
    }
}
