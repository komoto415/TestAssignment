package gui;

import javax.swing.*;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class View extends JPanel implements ActionListener {

    public static final int MARGIN = Frame.FRAME_WIDTH / 10;

    BoardPanel boardPanel;
    Engine chessEngine;
    ChangeListener chessEngineListener;

    public View(Engine chessEngine) {
        super();
        this.setPreferredSize(new Dimension(Frame.FRAME_WIDTH - MARGIN, Frame.FRAME_HEIGHT - MARGIN));
        this.setLayout(new BorderLayout());
        this.chessEngine = chessEngine;

        chessEngineListener = e -> update();
        chessEngine.addChangeListener(chessEngineListener);

        init();
    }

    private void init() {
        boardPanel = new BoardPanel(chessEngine);
        this.add(boardPanel);
    }

    private void update() {
        repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
