package gui;

import chess.ChessGame;
import chess.ChessGameImpl_Ng;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;

/**
 @author Jeffrey Ng
 @created 2020-05-13 */
public class Engine {
    private final ChangeEvent CHANGE_EVENT = new ChangeEvent(this);
    private ChessGame game;
    private EventListenerList eventListenerList;  // stores one or more event listener
    private String actionText;

    public Engine() {
        game = new ChessGameImpl_Ng();
        eventListenerList = new EventListenerList();
        actionText = "Game has started";
    }

    public String toString() {
        return game.toString();
    }

    public String getActionText() {
        return actionText;
    }

    //standard boilerplate method for change events
    public void addChangeListener(ChangeListener changeListener) {
        eventListenerList.add(ChangeListener.class, changeListener);
    }

    //standard boilerplate method for change events
    public void removeChangeListener(ChangeListener changeListener) {
        eventListenerList.remove(ChangeListener.class, changeListener);
    }

    //standard boilerplate method for change events
    // used when we need to notify the view that a change to the model has taken place
    // so that the view can update itself.
    public void fireChangeEvent(ChangeEvent changeEvent) {
        // Guaranteed to return a non-null array
        Object[] listeners = eventListenerList.getListenerList();
        // Process the listeners last to first, notifying
        // those that are interested in this event
        for (int i = listeners.length - 2; i >= 0; i -= 2) {
            if (listeners[i] == ChangeListener.class) {
                ((ChangeListener) listeners[i + 1]).stateChanged(changeEvent);
            }
        }
    }
}
