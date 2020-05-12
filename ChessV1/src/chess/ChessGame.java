package chess;

public interface ChessGame {
    public static final int ROW_COUNT = 8;
    public static final int COL_COUNT = 8;
    /*  Actual Board Grid
            A     B     C     D     E     F     G     H
         |-----|-----|-----|-----|-----|-----|-----|-----|
       8 |  R  |  N  |  B  |  K  |  Q  |  B  |  N  |  R  | 8
         |-----|-----|-----|-----|-----|-----|-----|-----|
       7 |  P  |  P  |  P  |  P  |  P  |  P  |  P  |  P  | 7
         |-----|-----|-----|-----|-----|-----|-----|-----|
       6 |     |     |     |     |     |     |     |     | 6
         |-----|-----|-----|-----|-----|-----|-----|-----|
       5 |     |     |     |     |     |     |     |     | 5
         |-----|-----|-----|-----|-----|-----|-----|-----|
       4 |     |     |     |     |     |     |     |     | 4
         |-----|-----|-----|-----|-----|-----|-----|-----|
       3 |     |     |     |     |     |     |     |     | 3
         |-----|-----|-----|-----|-----|-----|-----|-----|
       2 |  P  |  P  |  P  |  P  |  P  |  P  |  P  |  P  | 2
         |-----|-----|-----|-----|-----|-----|-----|-----|
       1 |  R  |  N  |  B  |  K  |  Q  |  B  |  N  |  R  | 1
         |-----|-----|-----|-----|-----|-----|-----|-----|
            A     B     C     D     E     F     G     H
     */

    /*  Array Representation Board Grid
            0     1     2     3     4     5     6     7
         |-----|-----|-----|-----|-----|-----|-----|-----|
       0 |  R  |  N  |  B  |  K  |  Q  |  B  |  N  |  R  | 0
         |-----|-----|-----|-----|-----|-----|-----|-----|
       1 |  P  |  P  |  P  |  P  |  P  |  P  |  P  |  P  | 1
         |-----|-----|-----|-----|-----|-----|-----|-----|
       2 |     |     |     |     |     |     |     |     | 2
         |-----|-----|-----|-----|-----|-----|-----|-----|
       3 |     |     |     |     |     |     |     |     | 3
         |-----|-----|-----|-----|-----|-----|-----|-----|
       4 |     |     |     |     |     |     |     |     | 4
         |-----|-----|-----|-----|-----|-----|-----|-----|
       5 |     |     |     |     |     |     |     |     | 5
         |-----|-----|-----|-----|-----|-----|-----|-----|
       6 |  P  |  P  |  P  |  P  |  P  |  P  |  P  |  P  | 6
         |-----|-----|-----|-----|-----|-----|-----|-----|
       7 |  R  |  N  |  B  |  K  |  Q  |  B  |  N  |  R  | 7
         |-----|-----|-----|-----|-----|-----|-----|-----|
            0     1     2     3     4     5     6     7
     */


    /*
            Precondition(s):
                A

            Postcondition(s):
                A
     */
    public Piece getPiece(GridPosition position);

    /*
            Precondition(s):
                A

            Postcondition(s):
                A
     */
    public void movePiece(GridPosition start, GridPosition end);
    //    public void movePiece(String start, String end);

    /*
            Precondition(s):
                True

            Postcondition(s):
                A
     */
    public boolean isValidMove(Piece piece, GridPosition end);

//    public boolean isCheckmated();
}
