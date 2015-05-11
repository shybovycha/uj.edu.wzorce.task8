package bridge;

/**
 * Created by shybovycha on 11.05.15.
 */
public class MyUberList extends MyList {
    public MyUberList(int n) {
        super(n);
    }

    public void sort(ISorter sorter) {
        this.data = sorter.sort(this.data);
    }
}
