package aud3;

class Point{
    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(Point b){
        return Math.sqrt((this.x-b.x) * (this.x-b.x) +(this.y-b.y) * (this.y-b.y));
    }
}

public class Space2D {

    private Point[] points;

    public Space2D(Point[] points) {
        this.points = points;
    }

    public double minDistance(){
        double min = 10000000;
        for(int i = 0;i<(points.length-1); i++){
            for(int j=i+1; j<points.length; j++){
                min = Math.min(min, points[i].distance(points[j]));
            }
        }
        return min;
    }

    public static void main(String[] args) {
        Point point1 = new Point(4,5.5);
        Point point2 = new Point(1.2,12.5);
        Point point3 = new Point(1.2,5.5);
        Point point4 = new Point(1,5.5);

        Point[] points = {point1,point2,point3,point4};
        Space2D space2D = new Space2D(points);
        System.out.printf("%.2f\n",space2D.minDistance());

    }
}
