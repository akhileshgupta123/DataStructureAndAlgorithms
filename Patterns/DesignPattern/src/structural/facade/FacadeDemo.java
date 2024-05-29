class PointCarte {                           // 1. Subsystem

   private double x, y;

   public PointCarte( double xx, double yy ) { x = xx;   y = yy; }

   public void   move( int dx, int dy )      { x += dx;  y += dy; }

   public String toString()                  { return "(" + x + "," + y + ")"; }

   public double getX() { return x; }        public double getY() { return y; } 

}

 



 

class Point {                                // 1. Desired i/f: move(), rotate()

   private PointCarte pc;                    // 2. Design a "wrapper" class

   public Point( double xx, double yy ) { pc = new PointCarte( xx,yy ); }

   public String toString()             { return pc.toString(); }

   public void move( int dx, int dy )   { pc.move( dx,dy ); } // 4. Wrapper maps

 }

 

class Line {

   private Point o, e;

   public Line( Point ori, Point end )  { o = ori;  e = end; }

   public void   move( int dx, int dy ) { o.move( dx, dy );  e.move( dx, dy ); }

   public String toString()       { return "origin is " + o + ", end is " + e; }

}

 

class FacadeDemo {

   public static void main( String[] args ) {

      Line line1 = new Line( new Point(2,4), new Point(5,7) );  // 3. Client

      line1.move(-2,-4);                                        //    uses the

      System.out.println( "after move:   " + line1 );           //    Facade

      

}  }

 