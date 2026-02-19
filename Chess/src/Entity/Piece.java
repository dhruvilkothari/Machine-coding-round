package Entity;

import Entity.Enum.PieceType;
import Strategy.MovementStrategy;

public abstract class Piece {
    public PieceType pieceType;
    public boolean isKilled;
    public final boolean isWhite;
    private MovementStrategy movementStrategy;
    private Cell cell;

    public Piece( boolean isWhite, MovementStrategy movementStrategy, PieceType pieceType, Cell cell) {
        this.isKilled = false;
        this.isWhite = isWhite;
        this.movementStrategy = movementStrategy;
        this.pieceType = pieceType;
        this.cell = cell;

    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public boolean isKilled() {
        return isKilled;
    }

    public void setKilled(boolean killed) {
        isKilled = killed;
    }

    public boolean isWhite() {
        return isWhite;
    }
    public MovementStrategy getMovementStrategy() {
        return movementStrategy;
    }

    public void setMovementStrategy(MovementStrategy movementStrategy) {
        this.movementStrategy = movementStrategy;
    }
}
