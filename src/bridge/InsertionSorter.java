package bridge;

import java.util.List;

/**
 * Created by shybovycha on 11.05.15.
 */
public class InsertionSorter implements ISorter {
    @Override
    public List<Integer> sort(List<Integer> src) {
        for (int i = 0; i < src.size(); i++) {
            for (int t = 0; t < src.size(); t++) {
                if (src.get(i) < src.get(t)) {
                    Integer tmp = src.get(t);
                    src.set(t, src.get(i));
                    src.set(i, tmp);
                }
            }
        }

        return src;
    }
}
