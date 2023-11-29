package br.ufrn.imd.model;

public class Table {
    int size = 10;
    Block[][] field;

    public Table(int size) {
        for(int i = 0; i < size; i++)
            for(int j = 0; j < size; j++){
                field[i][j] = new Block(i, j);
            }
    }



    void clear() {
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++){
                //field[i][j].setBlock(' ');
            }
    }
}
