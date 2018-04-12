//Kathleen Wong
//APCS2 pd2
//HW31--Stack: What Is It Good For?
//2018-04-11

/*****************************************************
 * skeleton for class LatKtS
 * Driver class for Latkes.
 * Uses a stack to reverse a text string, check for sets of matching parens.
 *****************************************************/


public class LatKtS
{

  /**********************************************************
   * precondition:  input string has length > 0
   * postcondition: returns reversed string s
   *                flip("desserts") -> "stressed"
   **********************************************************/
  public static String flip( String s )
  {
    //add leters into stack
    Latkes flipped = new Latkes(s.length());
    for(int i = 0 ;i< s.length(); i++){
      String letter = s.substring(i,i+1);
      flipped.push(letter);
    }
    String retStr= "";
    //pop out in reverse
    while(! flipped.isEmpty() ){
      retStr+= flipped.pop();
    }
    return retStr;

  }//end flip()


  /**********************************************************
   * precondition:  s contains only the characters {,},(,),[,]
   * postcondition: allMatched( "({}[()])" )    -> true
   *                allMatched( "([)]" )        -> false
   *                allMatched( "" )            -> true
   **********************************************************/
  public static boolean allMatched( String s )
  {
    if(s.length()==0){
      return true;
    }
    //uneven characters means String cannot be matched
    if(s.length()% 2 !=0 ){
      return false;
    }

    Latkes match = new Latkes(s.length());
    for(int i = 0 ;i< s.length(); i++){
      String letter = s.substring(i, i+1);

      if(letter.equals("(")||letter.equals("[")||letter.equals("{")){
      match.push(letter);}

      //check if matching symbol was used
      if (letter.equals(")")){
        if(!match.pop().equals("("))
          return false;
      }
      if (letter.equals("]")){
        if(!match.pop().equals("["))
          return false;
      }
      if (letter.equals("}")){
        if(!match.pop().equals("{"))
          return false;
      }
    }

    return true;

  }//end allMatched()


  //main method to test
  public static void main( String[] args )
  {
    System.out.println(flip("stressed"));
    System.out.println(allMatched( "({}[()])" )); //true
    System.out.println(allMatched( "([)]" ) ); //false
    System.out.println(allMatched( "(){([])}" ) ); //true
    System.out.println(allMatched( "](){([])}" ) ); //false
    System.out.println(allMatched( "(){([])}(" ) ); //false
    System.out.println(allMatched( "()[[]]{{{{((([])))}}}}" ) ); //true
    /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }

}//end class LatKtS
