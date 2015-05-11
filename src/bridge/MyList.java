package bridge;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by shybovycha on 11.05.15.
 */
public class MyList {
    protected List<Integer> data;

    public MyList(int n) {
        this.data = new ArrayList<Integer>();

        Random rnd = new Random();

        for (int i = 0; i < n; i++) {
            this.data.add(rnd.nextInt(10));
        }
    }

    public void sort() {
        for (int i = 0; i < data.size(); i++) {
            for (int t = 0; t < data.size(); t++) {
                if (data.get(i) < data.get(t)) {
                    Integer tmp = data.get(i);
                    data.set(i, data.get(t));
                    data.set(t, tmp);
                }
            }
        }
    }

    public String toString() {
        String res = "";

        for (int i = 0; i < data.size(); i++) {
            res += data.get(i);

            if (i < data.size() - 1) {
                res += ", ";
            }
        }

        return res;
    }
}
