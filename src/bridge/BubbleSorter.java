package bridge;

import java.util.List;

/**
 * Created by shybovycha on 11.05.15.
 */
public class BubbleSorter implements ISorter {
    @Override
    public List<Integer> sort(List<Integer> src) {
        boolean fl = true;

        while (fl) {
            fl = false;

            for (int i = 0; i < src.size() - 1; i++) {
                int t = i + 1;

                if (src.get(i) > src.get(t)) {
                    Integer tmp = src.get(t);
                    src.set(t, src.get(i));
                    src.set(i, tmp);
                    fl = true;
                    break;
                }
            }
        }

        return src;
    }
}
