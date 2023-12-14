package br.ufrn.imd.controller;

import br.ufrn.imd.model.*;

public class Game {
    private Table tableP1;
    private Table tableP2;
    private Player player1;
    private Player player2;
    private Player turn;

    public Game() {
        this.tableP1 = new Table(10);
        this.tableP2 = new Table(10);
        this.player1 = new Player("");
        this.player2 = new Player("");
    }

    // bool addShip(Ship ship) {
    // table.addShip(ship);
    // }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void startTables() {
        tableP1.clear();
        tableP2.clear();
    }

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

    public void swapTurn() {
        if (turn == player1)
            turn = player2;
        else
            turn = player1;
    }

    public void restart() {
        tableP1.clear();
        tableP2.clear();
        player1 = new Player("");
        player2 = new Player("");
    }

    public void setPlayer1(String name) {
        player1 = new Player(name);
    }

    public void setPlayer2(String name) {
        player2 = new Player(name);
    }

    public void setTurn(Player player) {
        turn = player;
    }

    public Player getTurn() {
        return turn;
    }

    public Table getTableP1() {
        return tableP1;
    }

    public Table getTableP2() {
        return tableP2;
    }

    public void setTableP1(Table tableP1) {
        this.tableP1 = tableP1;
    }

    public void setTableP2(Table tableP2) {
        this.tableP2 = tableP2;
    }



}
