package pacman;

public class PacManNavigatorImpl_Skeleton extends PacManMaze implements PacManNavigator {
    private Direction[] tracker;
    private int points;

    public PacManNavigatorImpl_Skeleton(String maze, int maxTurns) {
        super(maze);
        tracker = new Direction[maxTurns];
        points = 0;
    }

    @Override
    public void move(Direction direction) {
        throw new RuntimeException("NOT YET IMPLEMENTED!!");
    }

    @Override
    public int movesLeft() {
        throw new RuntimeException("NOT YET IMPLEMENTED!!");
    }

    @Override
    public boolean noMorePelletsToGather() {
        throw new RuntimeException("NOT YET IMPLEMENTED!!");
    }

    public String toString() {
        return super.toString();
    }
}
