import java.util.Scanner;

class MatrixProduct extends Thread {
      private int[][] A;
      private int[][] B;
      private int[][] C;
      private int row,col;
      private int dimen;

      public MatrixProduct(int[][] A,int[][] B,int[][] C,int row, int col,int dim_com)
      {
         this.A=A;
         this.B=B;
         this.C=C;
         this.row=row;
         this.col=col;
         this.dimen=dim_com;
      }

     public void run()
     {
         for(int i=0;i<dimen;i++){
               C[row][col]+=A[row][i]*B[i][col];
         }
          System.out.println("Thread "+row+","+col+" complete.");
     }
 }

 public class MatrixMultiplication {
       public static void main(String[] args)
      {
          Scanner In=new Scanner(System.in);

          System.out.print("Row of Matrix A: ");
          int rA=In.nextInt();
          System.out.print("Column of Matrix A: ");
          int cA=In.nextInt();
          System.out.print("Row of Matrix B: ");
          int rB=In.nextInt();
          System.out.print("Column of Matrix B: ");
          int cB=In.nextInt();
          System.out.println();

          if(cA!=rB)
          {
               System.out.println("No matrix product!");
               System.exit(-1);
          }
       System.out.println();
       int[][] A=new int[rA][cA];
       int[][] B=new int[rB][cB];
       int[][] C=new int[rA][cB];
       MatrixProduct[][] mat= new MatrixProduct[rA][cB];

       System.out.println("matrix A:");
       System.out.println();
        for(int i=0;i<rA;i++)
         {
          for(int j=0;j<cA;j++)
          {
              System.out.print(i+","+j+" = ");
              A[i][j]=In.nextInt();
          }
         }
         System.out.println();
         System.out.println("matrix B:");
         System.out.println();
          for(int i=0;i<rB;i++)
          {
           for(int j=0;j<cB;j++)
            {
            System.out.print(i+","+j+" = ");
            B[i][j]=In.nextInt();
            }
          }
          System.out.println();

        for(int i=0;i<rA;i++)
        {
         for(int j=0;j<cB;j++)
          {
            mat[i][j]=new MatrixProduct(A,B,C,i,j,cA);
            mat[i][j].start();
          }
        }

        for(int i=0;i<rA;i++)
        {
            for(int j=0;j<cB;j++)
            {
                try{
                    mat[i][j].join();
                }
            catch(InterruptedException e){}
            }
        }

        System.out.println();
        System.out.println("Result");
        System.out.println();
        for(int i=0;i<rA;i++)
        {
            for(int j=0;j<cB;j++)
            {
                System.out.print(C[i][j]+" ");
            }
            System.out.println();
        }
}
}
