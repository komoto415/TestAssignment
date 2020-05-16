package gui;

import chess.ChessGame;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class BoardPanel extends JPanel {
    public static final int TILE_SIZE = View.MARGIN;
    public static final int PANEL_WIDTH = Frame.FRAME_WIDTH - TILE_SIZE * 2;
    public static final int PANEL_HEIGHT = Frame.FRAME_HEIGHT - TILE_SIZE * 2;
    private static final int START_Y;
    private static final int START_X = START_Y = TILE_SIZE / 2;
    private static final Color LIGHT_SQUARE = new Color(232, 235, 239);
    private static final Color DARK_SQUARE = new Color(125, 135, 150);
    private static final Color WHITE_PIECE = new Color(242, 242, 242);
    private static final Color BLACK_PIECE = new Color(0, 0, 0);
    static Map<Integer, Character> colToFile;
    static Map<Integer, Character> rowToRank;
    static {
        colToFile = new HashMap<>();
        colToFile.put(0, 'A');
        colToFile.put(1, 'B');
        colToFile.put(2, 'C');
        colToFile.put(3, 'D');
        colToFile.put(4, 'E');
        colToFile.put(5, 'F');
        colToFile.put(6, 'G');
        colToFile.put(7, 'H');
    }

    static {
        rowToRank = new HashMap<>();
        rowToRank.put(0, '8');
        rowToRank.put(1, '7');
        rowToRank.put(2, '6');
        rowToRank.put(3, '5');
        rowToRank.put(4, '4');
        rowToRank.put(5, '3');
        rowToRank.put(6, '2');
        rowToRank.put(7, '1');
    }
    private Engine engine;
    private ChessGame game;

    public BoardPanel(Engine engine) {
        super();
//        this.setBackground(A1);
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.engine = engine;
        this.repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(LIGHT_SQUARE);
        g.fillRect(START_X, START_Y, PANEL_WIDTH, PANEL_HEIGHT);
        for (int i = START_Y; i <= PANEL_HEIGHT; i += TILE_SIZE * 2) {
            for (int j = START_X; j <= PANEL_WIDTH; j += TILE_SIZE * 2) {
                g.setColor(DARK_SQUARE);
                g.fillRect(j, i, TILE_SIZE, TILE_SIZE);
            }
        }
        for (int i = START_Y + TILE_SIZE; i <= PANEL_HEIGHT + TILE_SIZE; i += TILE_SIZE * 2) {
            for (int j = START_X + TILE_SIZE; j <= PANEL_WIDTH; j += TILE_SIZE * 2) {
                g.setColor(DARK_SQUARE);
                g.fillRect(j, i, TILE_SIZE, TILE_SIZE);
            }
        }
        for (int i = START_Y; i <= PANEL_HEIGHT; i += TILE_SIZE) {
            for (int j = START_X; j <= PANEL_WIDTH; j += TILE_SIZE) {
                g.setColor(Color.BLACK);
                String str = String.format("%s%s", colToFile.get(j / TILE_SIZE), rowToRank.get(i / TILE_SIZE));

                // Centered
                g.drawString(str, j + TILE_SIZE / 2 - str.length() * 4 + 1, i + TILE_SIZE / 2 + TILE_SIZE / 20);

                // Top Left Corner
//                g.drawString(str, j + 2, i + 12);
            }
        }
    }
}
