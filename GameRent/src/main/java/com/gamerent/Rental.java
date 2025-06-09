package com.gamerent;

public class Rental {
    private final Client client;
    private final Game game;

    public Rental(Client client, Game game) {
        this.client = client;
        this.game = game;
    }

    public String toString() {
        return client.getName() + " rented " + game.getTitle();
    }
}
