package javapoo.tictactoe;

public enum Piece {
    PLAYER1("X"),
    PLAYER2("O");

    private final String piece;

    Piece(String piece) {
        this.piece = piece;
    }

    public String getPiece() {
        return piece;
    }
}
