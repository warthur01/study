package com.gamerent;

import java.util.UUID;

public class Game {
    private final UUID gameId = UUID.randomUUID();
    private final String title;
    private boolean available;

    public Game(String title) {
        this.title = title;
        this.available = true;
    }

    public String getTitle() {
        return title;
    }

    public String getGameId() {
        return gameId.toString();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "ID: " + this.getGameId() + " | Title: " + this.getTitle() + " | Available: " + (available ? "Yes" : "No");
    }
}
