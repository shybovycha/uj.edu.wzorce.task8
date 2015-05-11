package state;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shybovycha on 11.05.15.
 */
abstract class IState {
    protected GameManager manager;

    public IState(GameManager mgr) {
        this.manager = mgr;
    }

    public abstract void addPlayer(String playerName);

    public abstract void removePlayer(String playerName);
}

class WaitingForPlayers extends IState {
    public WaitingForPlayers(GameManager mgr) {
        super(mgr);
    }

    @Override
    public void addPlayer(String playerName) {
        if (this.manager.players.size() == this.manager.maxPlayers) {
            throw new RuntimeException("Too much players");
        }

        this.manager.players.add(playerName);
    }

    @Override
    public void removePlayer(String playerName) {
        if (this.manager.players.size() == 1) {
            this.manager.dispose();
        }

        this.manager.players.remove(playerName);
    }
}

class Playing extends IState {
    public Playing(GameManager mgr) {
        super(mgr);
    }

    @Override
    public void addPlayer(String playerName) {
        throw new RuntimeException("Could not add player to a running game session");
    }

    @Override
    public void removePlayer(String playerName) {
        // throw new RuntimeException("Could not remove player from a running game session");
        if (this.manager.players.size() == 1) {
            this.manager.dispose();
        }

        this.manager.players.remove(playerName);

        if (this.manager.players.size() == 1) {
            this.manager.state = new Win(this.manager);
            this.manager.engine.win(playerName);
        } else {
            this.manager.engine.deactivatePlayer(playerName);
        }
    }
}

class Win extends IState {
    public Win(GameManager mgr) {
        super(mgr);
    }

    @Override
    public void addPlayer(String playerName) {
        throw new RuntimeException("Could not add player to a closed game session");
    }

    @Override
    public void removePlayer(String playerName) {
        throw new RuntimeException("Could not remove player from a closed game session");
    }
}

class Idle extends IState {
    public Idle(GameManager mgr) {
        super(mgr);
    }

    @Override
    public void addPlayer(String playerName) {
        throw new RuntimeException("No game session");
    }

    @Override
    public void removePlayer(String playerName) {
        throw new RuntimeException("No game session");
    }
}

public class GameManager {
    protected GameEngine engine;
    protected List<String> players;
    protected int minPlayers, maxPlayers;
    protected IState state;

    public GameManager() {
        this.players = new ArrayList<String>();
        this.state = new Idle(this);
    }

    public void createGame(int minPlayers, int maxPlayers) {
        this.minPlayers = minPlayers;
        this.maxPlayers = maxPlayers;
        this.state = new WaitingForPlayers(this);

        this.engine = new GameEngine();
    }

    public void addPlayer(String playerName) {
        this.state.addPlayer(playerName);
    }

    public void removePlayer(String playerName) {
        this.state.removePlayer(playerName);
    }

    public void startGame() {
        this.state = new Playing(this);
        this.engine.setPlayers(this.players);
        this.engine.startGame();
    }

    public void dispose() {
        this.engine.dispose();
    }
}
