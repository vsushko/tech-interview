package arrays;

import java.util.ArrayList;
import java.util.List;

public class MergeIntervals {

    public static void main(String[] args) {
        List<Tuple<Integer, Integer>> intervals = new ArrayList<>();
        intervals.add(new Tuple<>(1, 5));        intervals.add(new Tuple<>(3, 7));        intervals.add(new Tuple<>(4, 6));
        intervals.add(new Tuple<>(6, 8));        intervals.add(new Tuple<>(10, 12));        intervals.add(new Tuple<>(11, 15));

        for (Tuple<Integer, Integer> interval : intervals) {
            System.out.print("(" + interval.x + "," + interval.y + "), ");
        }
        System.out.println();
        List<Tuple<Integer, Integer>> mergedIntervals = mergeIntervals(intervals);

        for (Tuple<Integer, Integer> interval : mergedIntervals) {
            System.out.print("(" + interval.x + "," + interval.y + "), ");
        }
    }
    private static List<Tuple<Integer, Integer>> mergeIntervals(
            List<Tuple<Integer, Integer>> v1) {
        if (v1 == null || v1.size() == 0) {
            return null;
        }
        ArrayList<Tuple<Integer, Integer>> v2 = new ArrayList<>();
        v2.add(new Tuple<>(v1.get(0).x, v1.get(0).y));

        for (int i = 1; i < v1.size(); i++) {
            int x1 = v1.get(i).x;
            int y1 = v1.get(i).y;
            int x2 = v2.get(v2.size() - 1).x;
            int y2 = v2.get(v2.size() - 1).y;

            if (y2 >= x1) {
                v2.get(v2.size() - 1).y = Math.max(y1, y2);
            } else {
                v2.add(new Tuple<>(x1, y1));
            }
        }
        return v2;
    }
}
class Tuple<X, Y> {
    public X x;
    public Y y;

    Tuple(X x, Y y) {
        this.x = x;
        this.y = y;
    }
}