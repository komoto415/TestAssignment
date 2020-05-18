package pacman;

public abstract class PacManMaze {
    private final int[] mazeDimensions;
    private final int initialPelletCount;
    protected String maze;

    public PacManMaze(String maze) {
        this.maze = maze;
        int mazeHeight = (int) maze.chars().filter(x -> x == '\n').count() + 1;
        int mazeWidth = maze.length() / mazeHeight;
        mazeDimensions = new int[] {mazeHeight, mazeWidth,};
        initialPelletCount = countPellets();
    }

    public int maxPotentialPoints() {
        int dotCount = countPellets(Pellet.DOT);
        int cherryCount = countPellets(Pellet.CHERRY);

        throw new RuntimeException("NOT IMPLEMENTED YET!!");
    }

    private int countPellets() {
        int count = 0;
        for (int i = 0; i < maze.length(); i++) {
            char ch_i = maze.charAt(i);
            if (Pellet.translate(ch_i) != null) {
                count += 1;
            }
        }

        return count;
    }

    private int countPellets(Pellet pellet) {
        int count = 0;
        for (int i = 0; i < maze.length(); i++) {
            char ch_i = maze.charAt(i);
            if (Pellet.translate(ch_i).equals(pellet)) {
                count += 1;
            }
        }

        return count;
    }

    public int[] getMazeDimensions() {
        return mazeDimensions;
    }

    public int getInitialPelletCount() {
        return initialPelletCount;
    }

    @Override
    public String toString() {
        return maze;
    }
}
