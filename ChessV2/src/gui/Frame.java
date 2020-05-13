package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class Frame {
    public static final int FRAME_WIDTH = 800;
    public static final int FRAME_HEIGHT = 800;

    public static void main(String[] args) {
        Engine chessEngine = new Engine();
        View controller = new View(chessEngine);
        JFrame frame = new JFrame("Stack and Queue Gui Example -- Jeffrey Ng");
        frame.setLayout(new FlowLayout());
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        frame.getContentPane().add(controller);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setVisible(true);
    }
}
