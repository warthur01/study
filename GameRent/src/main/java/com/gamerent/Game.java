package com.gamerent;

import java.util.UUID;

public class Game {
    private final UUID gameId = UUID.randomUUID();
    private final String title;

    public Game(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getGameId() {
        return gameId.toString();
    }

    @Override
    public String toString() {
        return "ID: " + this.getGameId() + " | Title: " + this.getTitle();
    }
}
