package br.ufrn.imd.controller;

import br.ufrn.imd.model.*;

/**
 * The Game class represents a game of Natalha Baval.
 * It manages the tables, players, and turns of the game.
 */
public class Game {
    private Table tableP1;
    private Table tableP2;
    private Player player1;
    private Player player2;
    private Player turn;

    /**
     * Constructs a new Game object with default values.
     */
    public Game() {
        this.tableP1 = new Table(10);
        this.tableP2 = new Table(10);
        this.player1 = new Player("");
        this.player2 = new Player("");
    }


    /**
     * Returns the player 1 object.
     * 
     * @return The player 1 object.
     */
    public Player getPlayer1() {
        return player1;
    }

    /**
     * Returns the player 2 object.
     * 
     * @return The player 2 object.
     */
    public Player getPlayer2() {
        return player2;
    }

    /**
     * Clears the tables of both players.
     */
    public void startTables() {
        tableP1.clear();
        tableP2.clear();
    }

    /**
     * Shoots at the specified coordinates on the opponent's table.
     * 
     * @param x The x-coordinate of the target.
     * @param y The y-coordinate of the target.
     * @return true if the shot was successful, false otherwise.
     */
    public boolean shoot(int x, int y) {
        if (turn == player1 && !tableP2.getField()[x][y].getHit()) {
            tableP2.getField()[x][y].setHit(true);
            return true;
        } else {
            if (!tableP1.getField()[x][y].getHit()) {
                tableP1.getField()[x][y].setHit(true);
                return true;
            }
        }
        return false;
    }

    /**
     * Swaps the turn between player 1 and player 2.
     */
    public void swapTurn() {
        if (turn == player1)
            turn = player2;
        else
            turn = player1;
    }

    /**
     * Restarts the game by clearing the tables and creating new player objects.
     */
    public void restart() {
        tableP1.clear();
        tableP2.clear();
        player1 = new Player("");
        player2 = new Player("");
    }

    /**
     * Sets the name of player 1.
     * 
     * @param name The name of player 1.
     */
    public void setPlayer1(String name) {
        player1 = new Player(name);
    }

    /**
     * Sets the name of player 2.
     * 
     * @param name The name of player 2.
     */
    public void setPlayer2(String name) {
        player2 = new Player(name);
    }

    /**
     * Sets the current turn to the specified player.
     * 
     * @param player The player who will take the turn.
     */
    public void setTurn(Player player) {
        turn = player;
    }

    /**
     * Returns the player who has the current turn.
     * 
     * @return The player who has the current turn.
     */
    public Player getTurn() {
        return turn;
    }

    /**
     * Returns the table of player 1.
     * 
     * @return The table of player 1.
     */
    public Table getTableP1() {
        return tableP1;
    }

    /**
     * Returns the table of player 2.
     * 
     * @return The table of player 2.
     */
    public Table getTableP2() {
        return tableP2;
    }

    /**
     * Sets the table of player 1.
     * 
     * @param tableP1 The table of player 1.
     */
    public void setTableP1(Table tableP1) {
        this.tableP1 = tableP1;
    }

    /**
     * Sets the table of player 2.
     * 
     * @param tableP2 The table of player 2.
     */
    public void setTableP2(Table tableP2) {
        this.tableP2 = tableP2;
    }
}
