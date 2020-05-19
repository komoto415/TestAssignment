# Experimental Challenge
**Project Objective**: Design a challenge such that it can be administered as a
Component-Based Programming challenge and then reduxed in 
Algorithms and Data Structures.  

## Concepts  
- Chess
- Pac Man
- Enigma Machine
- Airport Connections

**Challenge Primary Goals**: 
- Enhancing Code Readability
- Enforcing Object Orientated Design
- Promotion of Multi-Class solutions

**Component-Based Programming** Effective-Restructuring:
Final challenge will be the experimental challenge

**Algorithms and Data Structures** Effective-Restructuring:
Bowling will be replaced with experimental challenge reduxed.  
In addition, depending on the selected design, there maybe be a part three introduced where
students will look at the AI behaviour application of their implementation.  
i.e:  
Chess -> Forward looking and game state evaluation  

Pac Man -> Pathfinders and point accumulation optimisation

### Chess
#### Part 1: Pieces and Simple Board Interaction  
Interaction with the board will remain minimal such as pieces just
moving on the board and checking the piece on a particular grid.
Additionally, the assumption made is that players of this particular
implementation will only ever made **valid and unambiguous** moves  

Piece components and methods
```
chess.piece.*
Piece Subclasses
    |-- King
    |-- Rook
    |-- Knight
    |-- Bishop
    |-- Queen
    |-- Pawn

Methods:
    public abstract int[][] getEndpointListFromCurrentPosition(GridPosition current);
    public abstract GridPosition[] getPath(GridPosition current, GridPosition end);
    public abstract boolean pathIsPossible(GridPosition current, GridPosition end);
```

Basic board interaction components and methods
```
chess.ChessGameImpl_Skeleton;
Methods:
    public Piece getPiece(GridPosition position);
    public void movePiece(Piece piece, char file, GridPosition end);
```

#### Part 2: Move Validation and Ambiguity  
Now students will need to contend with the validation of piece
movement such that it has partial dependence on the game state.  
The return of function overloading  
Board validation methods
```
chess.ChessGameImpl_Skeleton;
Methods: 
    public void movePiece(GridPosition end);
    public void movePiece(Piece piece, GridPosition end);
    public boolean isAmbiguousMove(GridPosition end);
    public boolean isAmbiguousMove(Piece piece, GridPosition end);
    public boolean isValidMove(GridPosition end);
    public boolean isValidMove(Piece piece, GridPosition end);
    public boolean isValidMove(Piece piece, char file, GridPosition end);
```

#### Part 3: AI, Game State Evaluation and Checkmates
And finally, the implementation must be able to evaluate the board start and declare 
whether a player is checked or has been checkmated or not
```
chess.ChessGameImpl_Skeleton;
Methods: 
    public void isChecked();
    public void isCheckmated();
```

### Pac Man
WIP

### Enigma Machine
#### Part 1:

#### Part 2:
WIP

### Airport Connections
WIP
