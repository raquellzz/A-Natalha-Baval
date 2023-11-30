package br.ufrn.imd.controller;

import br.ufrn.imd.model.*;

public class Game {
    private Table tableP1;
    private Table tableP2;
    private Player player1;
    private Player player2;

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
}
