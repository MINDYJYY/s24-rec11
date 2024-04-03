package edu.cmu.cs.cs214.rec11.plugin;

import edu.cmu.cs.cs214.rec11.framework.core.GameFramework;
import edu.cmu.cs.cs214.rec11.framework.core.GamePlugin;
import edu.cmu.cs.cs214.rec11.games.TicTacToe;

public class TTTPlugin implements GamePlugin<String> {
    private static final String GAME_NAME = "Tic Tac Toe";
    private static final String GAME_START_FOOTER = "You are playing Tic Tac Toe!";

    private GameFramework framework;
    private TicTacToe ttt;

    @Override
    public String getGameName() {
        return GAME_NAME;
    }

    @Override
    public int getGridWidth() {
        return TicTacToe.SIZE;
    }

    @Override
    public int getGridHeight() {
        return TicTacToe.SIZE;
    }

    @Override
    public void onRegister(GameFramework f) {
        framework = f;
    }

    @Override
    public void onNewGame() {
        framework.setFooterText(GAME_START_FOOTER);
        ttt = new TicTacToe();
    }

    @Override
    public void onNewMove() {} // Nothing to do here.

    @Override
    public boolean isMoveValid(int x, int y) {
        return ttt.isValidPlay(x, y);
    }

    @Override
    public boolean isMoveOver() {
        return ttt.isOver();
    }

    @Override
    public void onMovePlayed(int x, int y) {
        framework.setSquare(x, y, ttt.currentPlayer().toString());
        ttt.play(x, y);
    }

    @Override
    public boolean isGameOver() {
        return ttt.isOver();
    }

    @Override
    public String getGameOverMessage() {
        return ttt.winner().toString();
    }

    @Override
    public void onGameClosed() { } // Nothing to do here.

    @Override
    public String currentPlayer() {
        return ttt.currentPlayer().toString();
    }
}
