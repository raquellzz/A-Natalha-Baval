package br.ufrn.imd.controller;

import br.ufrn.imd.model.*;

public class Game {
    Game() {
        tableP1 = new Table(10);
        tableP2 = new Table(10);
        player1 = new Player("");
        player2 = new Player("");
    }

    private Table tableP1;
    private Table tableP2;
    private Player player1;
    private Player player2;

    // bool addShip(Ship ship) {
    // table.addShip(ship);
    // }

    void startTables() {
        tableP1.clear();
        tableP2.clear();
    }
}
