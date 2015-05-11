package bridge;

/**
 * Created by shybovycha on 11.05.15.
 */
public class BridgeMain {
    public static void main(String[] args) {
        MyList a = new MyList(10);
        MyUberList b = new MyUberList(10);
        ISorter s1 = new BubbleSorter();
        ISorter s2 = new InsertionSorter();

        System.out.printf("Before (a): %s\n", a);
        System.out.printf("Before (b): %s\n", b);

        a.sort();
        b.sort(s1);

        System.out.printf("After (a1): %s\n", a);
        System.out.printf("After (b1): %s\n", b);

        b.sort(s2);

        System.out.printf("After (b2): %s\n", b);
    }
}
