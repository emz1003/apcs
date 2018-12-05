public class Matrix{

    public static void main(String [] args){
	new Matrix().run();
    }

    public void run(){
    	final int[] [] identity = { {1,0,0},
    				    {0,1,0},
    				    {0,0,1}};
    	System.out.println("3x3 Identity Matrix");
    	printMatrix(identity);
    	int[][] prod = scalarMult(5,identity);

    	System.out.println("Scalar Multiplication 5 x Identity");
    	printMatrix(prod);
    	System.out.println("3x3 Identity Matrix is unchanged");
    	printMatrix(identity);
    	int [][] A = {{1,4}, {7,12}, {9,0}};
    	int [][] B = {{3,-4}, {11,-10}, {12,4}};
    	System.out.println("3 x 2 Matrix A");
    	printMatrix(A);
    	System.out.println("3 x 2 Matrix B");
    	printMatrix(B);
    	System.out.println("A + B ");
    	printMatrix(addMat(A,B));
    	int [][] C = {{1,6},
    		      {4,3}};
    	int [][] D = {{2,-1},{5, 0}};

    	System.out.println("Square Matrix C");
    	printMatrix(C);
    	System.out.println("Square Matrix D");
    	printMatrix(D);
    	System.out.println("Square Matrix CD");
    	printMatrix(multMat(C,D));
    	System.out.println("Square Matrix DC");
    	printMatrix(multMat(D,C));
    }
    /* ********  COMPLETE THIS METHOD ********* */
    // Pre: A and B are square matrices.
    // Post: Computes AB with no side effects.
    int [][] multMat(int[][] a, int [] [] b){
      int[][] ans = new int[a.length][a.length];
      for(int row = 0; row < a.length; row++){
        for(int col = 0; col < a.length; col++){
          for(int index = 0; index < a.length; index++)
            ans[row][col] += a[row][index] * b[index][col];
        }
      }
      return ans;
    }

    // Pre  : A and B have the same dimensions
    private int [][] addMat(int[][] a , int [][] b){
         int[][] ans = new int[a.length][a[0].length];
	for (int row = 0 ; row < a.length; row++){
	    for (int col = 0; col < a[row].length; col++){
		ans[row][col] = a[row][col] + b[row][col];
	    }
	}
	return ans;
    }
    // Post : No side effects
    // Post: No side effects
    private int[][] scalarMult(int k , int[][] m){
  	int[][] ans = new int[m.length][m[0].length];
      for (int row = 0 ; row < m.length; row++){
    	  for (int col = 0; col < m[row].length; col++){
    		    ans[row][col] = k * m[row][col];
    	    }
    	}
      return ans;
    }
    // prints in row major form
    private void printMatrix(int [] [] m){
    	for (int row = 0 ; row < m.length; row++){
    	    for (int col = 0; col < m[row].length; col++){
    		       System.out.printf("%10d" , m[row][col] );
    	    }
    	    System.out.println();
    	}
    }
}
