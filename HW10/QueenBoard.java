//Kathleen Wong
//APCS2 pd2
//HW10 -- [Freddie Mercury, Brian May, Roger Taylor, John Deacon] x n
//2018-02-28

/***
 * class QueenBoard
 * Generates solutions for N-Queens problem.
 */

public class QueenBoard
{
  private int[][] _board;

  public QueenBoard( int size )
  {
    _board = new int[size][size];
  }


  /***
   * precondition: board is filled with 0's only.
   * postcondition:
   * If a solution is found, board shows position of N queens,
   * returns true.
   * If no solution, board is filled with 0's,
   * returns false.
   */
  public boolean solve()
  {
    if(solveH(0)){
      printSolution();
      return true;
    }

    return false;
  }


  /**
   *Helper method for solve.
   */
  private boolean solveH( int col )
  {
    if(col==_board.length){
      return true;
    }
    //start at top left corner, moving downard for possible locations
    for(int r =0; r<_board.length;r++){
      if(addQueen(r,col)){
        addQueen(r,col);
      if(solveH(col+1)){
        return true;
      }
      //go back and remove queen if solution cannot be found for next column
      removeQueen(r,col);
      }
    }
    return false;
  }


  public void printSolution()
  {
    /** Print board, a la toString...
        Except:
        all negs and 0's replaced with underscore
        all 1's replaced with 'Q'
    */
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        if(_board[r][c]==1){
          ans+="Q"+"\t";
        }
        else{
          ans+="_"+"\t";
        }
	    }
	    ans += "\n";
    }
    System.out.println(ans);
  }



  //================= YE OLDE SEPARATOR =================

  /***
   * Displays the location of the queen and the locations that the next
   queen can be placed.
   * precondition: Board has at least one row and column.
    The next queen will always be placed to the right of the queen before.
   * postcondition: If the board does not exist, return false.
    If the board is at least 1x1, returns true and places a 1 at the location
    of the queen and a -1 at the rest of the row and diagonals to the right
    of the queen.
   */
  private boolean addQueen(int row, int col){
    //return false if the board does not exist
    if(_board[row][col] != 0){
	    return false;
    }
    //places a 1 in the location of the queen
    _board[row][col] = 1;
    int offset = 1;

    while(col+offset < _board[row].length){
      //adds -1 to the rest of the row to the right
      _board[row][col+offset]--;
      //adds -1 to the rest of the downward diagonal
	    if(row - offset >= 0){
        _board[row-offset][col+offset]--;
	    }
      //adds -1 to the upward diagonal
	    if(row + offset < _board.length){
        _board[row+offset][col+offset]--;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * Removes a queen from the board and the locations that it could
   have been moved to.
   * precondition: Queen must already exist at that location.
   * postcondition: Queen is removed from the board and adds 1 back to the
   locations that it could have moved to.
   */
  private boolean removeQueen(int row, int col){
    //return false if there is no queen at the location
    if ( _board[row][col] != 1 ) {
	    return false;
    }
    _board[row][col] = 0;
    int offset = 1;

    while( col+offset < _board[row].length ) {
	    _board[row][col+offset]++;
	    if( row - offset >= 0 ) {
        _board[row-offset][col+offset]++;
	    }
	    if( row + offset < _board.length ) {
        _board[row+offset][col+offset]++;
	    }
	    offset++;
    }
    return true;
  }


  /***
   * <General description>
   * precondition:
   * postcondition:
   */
  public String  toString()
  {
    String ans = "";
    for( int r = 0; r < _board.length; r++ ) {
	    for( int c = 0; c < _board[0].length; c++ ) {
        ans += _board[r][c]+"\t";
	    }
	    ans += "\n";
    }
    return ans;
  }


  //main method for testing...
  public static void main( String[] args )
  {
    QueenBoard b = new QueenBoard(5);
    System.out.println(b);
    // b.addQueen(3,0);
    // b.addQueen(0,1);
    // System.out.println(b);
    // b.removeQueen(3,0);
    // System.out.println(b);
    b.solve();

    QueenBoard c = new QueenBoard(8);
    System.out.println(c);
    c.solve();
  }

}//end class
