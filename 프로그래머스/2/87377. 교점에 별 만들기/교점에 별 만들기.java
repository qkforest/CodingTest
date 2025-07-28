import java.util.*;
class Solution {
    private static class Point {
        public final long x, y;
        
        private Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
        double x = (double) (b1 * c2 - c1 * b2) / (a1 * b2 - b1 * a2);
        double y = (double) (c1 * a2 - a1 * c2) / (a1 * b2 - b1 * a2);
        
        if(x % 1 != 0 || y % 1 != 0) {
            return null;
        }
        
        return new Point((long) x, (long) y);
    }
    private Point getMinimumPoint(List<Point> points) {
        long x = Long.MAX_VALUE;
        long y = Long.MAX_VALUE;
        
        for(Point p : points) {
            x = Math.min(x, p.x);
            y = Math.min(y, p.y);
        }
        return new Point(x, y);
    }
    
    private Point getMaximumPoint(List<Point> points) {
        long x = Long.MIN_VALUE;
        long y = Long.MIN_VALUE;
        
        for(Point p : points) {
            x = Math.max(x, p.x);
            y = Math.max(y, p.y);
        }
        return new Point(x, y);
    }
    
    public String[] solution(int[][] line) {
        List<Point> points = new ArrayList<>();
        
        for(int i = 0; i < line.length; i++) {
            for(int j = i+1; j < line.length; j++) {
                Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
                if(intersection != null) {
                    points.add(intersection);
                }
            }
        }
        Point min = getMinimumPoint(points);
        Point max = getMaximumPoint(points);

        int c = (int) (max.x - min.x + 1);
        int r = (int) (max.y - min.y + 1);

        char[][] arr = new char[r][c];
        
        for(int i = 0; i < r; i++) {
            Arrays.fill(arr[i], '.');
        }

        for(Point p : points) {
            arr[(int) (max.y - p.y)][(int) (p.x - min.x)] = '*';
        }
        
        String[] answer = new String[r];
        for(int i = 0; i < r; i++) {
            answer[i] = new String(arr[i]);
        }
            
        return answer;
    }
}