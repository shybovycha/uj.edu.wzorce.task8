package state;

import java.util.List;

/**
 * Created by shybovycha on 11.05.15.
 */
public class GameEngine {
    public GameEngine() {}

    public void startGame() {
        System.out.printf("[ENGINE] Game starts...\n");
    }

    public void setPlayers(List<String> playersNames) {
        System.out.printf("[ENGINE] Starting game with: %s\n", playersNames);
    }

    public void deactivatePlayer(String playerName) {
        System.out.printf("[ENGINE] `%s` was kicked\n", playerName);
    }

    public void win(String playerName) {
        System.out.printf("[ENGINE] `%s` won!\n", playerName);
    }

    public void dispose() {
        System.out.printf("[ENGINE] Game stopped\n");
    }
}
