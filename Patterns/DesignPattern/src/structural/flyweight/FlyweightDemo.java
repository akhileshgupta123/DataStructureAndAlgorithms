
//In this refactoring, the "row" state is considered shareable (within each row anyways), and the "col" state has been externalized (it is supplied by the client when report() is called).

class SparseMatrix {

   private int row;

   public SparseMatrix( int theRow ) {

      row = theRow;

      System.out.println( "ctor: " + row );

   }

   void report( int theCol ) {

      System.out.print( " " + row + theCol );

}  }

 

class Factory {

   private SparseMatrix[] pool;

   public Factory( int maxRows ) {

      pool = new SparseMatrix[maxRows];

   }

   public SparseMatrix getFlyweight( int theRow ) {

      if (pool[theRow] == null)

         pool[theRow] = new SparseMatrix( theRow );

      return pool[theRow];

}  }

 

public class FlyweightDemo {

   public static final int ROWS = 6, COLS = 10;

 

   public static void main( String[] args ) {

      Factory theFactory = new Factory( ROWS );

      for (int i=0; i < ROWS; i++) {

         for (int j=0; j < COLS; j++)

            theFactory.getFlyweight( i ).report( j );

         System.out.println();

}  }  }