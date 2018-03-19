package miscellaneous;

import java.util.ArrayList;
import java.util.List;

/**
 * Given N people on MxM grid, find the point that requires the least
 * total distance covered by all the ​people to meet at that point.
 * <p>
 * Solution #1
 * Runtime Complexity: Cubic, O(n^3).
 * If number of people 'n' is equal to size of the grid 'm',
 * the time complexity becomes cubic.
 * In the worst case, if there is a person on each point of the grid,
 * the complexity would become O(n4).
 * <p>
 * Memory Complexity: Linear, O(n).
 * 'n' is the number of people on the grid.
 * <p>
 * Solution #2
 * Runtime Complexity: Linear, O(n).
 * Here 'n' is the number of people on the grid.
 * Memory Complexity: Linear, O(n).
 * Here 'n' is the number of people on the grid.
 */
public class ClosestMeetingPoint {

    public static void main(String[] args) {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 1));
        points.add(new Point(1, 2));
        points.add(new Point(1, 3));
        points.add(new Point(1, 4));
        points.add(new Point(1, 5));
        points.add(new Point(2, 1));
        points.add(new Point(2, 2));
        points.add(new Point(2, 3));
        points.add(new Point(2, 4));
        points.add(new Point(2, 5));
        points.add(new Point(3, 1));
        points.add(new Point(3, 2));
        points.add(new Point(3, 3));
        points.add(new Point(3, 4));
        points.add(new Point(3, 5));
        points.add(new Point(4, 1));
        points.add(new Point(4, 2));
        points.add(new Point(4, 3));
        points.add(new Point(4, 5));
        points.add(new Point(5, 1));
        points.add(new Point(5, 2));
        points.add(new Point(5, 3));
        points.add(new Point(5, 4));
        points.add(new Point(5, 5));

        Distance distance = new Distance();
        int amountOfPeople = 3;
        System.out.println("shortestDistanceTravelled= " + distance.shortestDistanceTravelled(amountOfPeople, points));
        System.out.println("shortestDistanceTraveled2= " + distance.shortestDistanceTraveled2(amountOfPeople, points));
    }
}

class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double calculateDistance(Point p) {
        return Math.sqrt(
                (p.x - this.x) * (p.x - this.x) + (p.y - this.y) * (p.y - this.y));
    }

    public double calculateSumOfDistances(List<Point> points) {
        double distanceSum = 0;
        for (Point point : points) {
            distanceSum += this.calculateDistance(point);
        }
        return distanceSum;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

class Distance {
    public Point shortestDistanceTravelled(int m, List<Point> points) {
        Point pt = new Point(1, 1);
        double minDistance = pt.calculateSumOfDistances(points);
        Point minPt = new Point(pt.getX(), pt.getY());

        double distance;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= m; j++) {
                pt.setX(i);
                pt.setY(j);
                distance = pt.calculateSumOfDistances(points);

                if (distance < minDistance) {
                    minDistance = distance;
                    minPt.setX(pt.getX());
                    minPt.setY(pt.getY());
                }
            }
        }
        return minPt;
    }

    public Point shortestDistanceTraveled2(int m, List<Point> points) {
        Point minPt = new Point(0, 0);
        double x = 0;
        double y = 0;

        // calculate the centroid
        Point centroid = new Point(0, 0);
        for (Point point : points) {
            x += point.getX();
            y += point.getY();
        }
        centroid.setX((int) Math.round(x / points.size()));
        centroid.setY((int) Math.round(y / points.size()));

        // initialize the minPt to centroid
        minPt.setX(centroid.getX());
        minPt.setY(centroid.getY());

        double minDistance = minPt.calculateSumOfDistances(points);

        // checking points surrounding the potential centroid
        for (int i = minPt.getX() - 1; i < minPt.getX() + 2; i++) {
            for (int j = minPt.getY() - 1; j < minPt.getY() + 2; j++) {
                if (i < 1 || j > m) {
                    continue;
                }
                Point pt = new Point(i, j);
                double distance = pt.calculateSumOfDistances(points);
                if (distance < minDistance) {
                    minDistance = distance;
                    minPt.setX(pt.getX());
                    minPt.setY(pt.getY());
                }
            }
        }
        return minPt;
    }
}