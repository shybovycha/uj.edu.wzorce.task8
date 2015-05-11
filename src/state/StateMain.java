package state;

/**
 * Created by shybovycha on 11.05.15.
 */
public class StateMain {
    public static void main(String[] args) {
        GameManager mgr = new GameManager();

        mgr.createGame(3, 8);

        mgr.addPlayer("moo");
        mgr.addPlayer("foo");
        mgr.addPlayer("bar");
        mgr.addPlayer("boo");

        mgr.startGame();

        mgr.removePlayer("boo");
        mgr.removePlayer("bar");
        mgr.removePlayer("foo");
    }
}
