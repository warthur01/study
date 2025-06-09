package com.gamerent;

public class Game {
    private static int nextId = 1;
    private final int gameId;
    private final String title;

    public Game(String title) {
        this.gameId = nextId++;
        this.title = title;
    }

    public int getGameId() {
        return gameId;
    }

    public String getTitle() {
        return title;
    }

    public String toString() {
        return   title;
    }
}
