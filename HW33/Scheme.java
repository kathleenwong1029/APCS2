//Kathleen Wong
//APCS2 pd2
//HW33-- What a Racket
//2018-04-13

/*****************************************************
 * class Scheme
 * Simulates a rudimentary Scheme interpreter
 *
 * ALGORITHM for EVALUATING A SCHEME EXPRESSION:
 *   1. Steal underpants.
 *   2. ...
 *   5. Profit!
 *
 * STACK OF CHOICE: LLStack by the library
 * b/c keeps a pointer to both the head and tail node,
 so push and pull can be changed to function on either end if necessary
 ******************************************************/

public class Scheme
{
  /******************************************************
   * precond:  Assumes expr is a valid Scheme (prefix) expression,
   *           with whitespace separating all operators, parens, and
   *           integer operands.
   * postcond: Returns the simplified value of the expression, as a String
   * eg,
   *           evaluate( "( + 4 3 )" ) -> 7
   *	         evaluate( "( + 4 ( * 2 5 ) 3 )" ) -> 17
   ******************************************************/
  public static String evaluate( String expr )
  {
    Stack<String> pancakes = new LLStack<String>();
    String[] splitty = expr.split("\\s+");
    String result="" ;
    //start from end of string
    int index=splitty.length-1;

    while(index >= 0){
      if(!((splitty[index].equals("(")))) {
        pancakes.push(splitty[index]);
      }
      //when reaching closing parentheses, perform operation
     if(splitty[index].equals("(")){
        String op = pancakes.pop();
        if(op.equals("+")){
        pancakes.push(unload(1,pancakes));

        }
        else if(op.equals("-")){
        pancakes.push(unload(2,pancakes));

        }
        else if(op.equals("*")){
        pancakes.push(unload(3,pancakes));

        }
     }
      index--;
    }
    result=pancakes.pop();
    return result;
  }//end evaluate()


  /******************************************************
   * precond:  Assumes top of input stack is a number.
   * postcond: Performs op on nums until closing paren is seen thru peek().
   *           Returns the result of operating on sequence of operands.
   *           Ops: + is 1, - is 2, * is 3
   ******************************************************/
  public static String unload( int op, Stack<String> numbers )
  {
    //start with first number
    int answer=Integer.parseInt(numbers.pop());

    //perform operations
    while( !( numbers.peek().equals(")"))) {
      if( op == 1 ){
		answer += Integer.parseInt(numbers.pop());}

	    else if( op == 2 ){
		answer -= Integer.parseInt(numbers.pop());}

	    else if( op == 3 ){
		answer *= Integer.parseInt(numbers.pop());
    }
  }
    //get rid of  ")"
    if( numbers.peek().equals(")") ) {
	    numbers.pop();
	   }
    return answer + "";
  }//end unload()



  //optional check-to-see-if-its-a-number helper fxn:
  public static boolean isNumber( String s ) {
  try {
  Integer.parseInt(s);
  return true;
	}
  catch( NumberFormatException e ) {
  return false;
	}
  }



  //main method for testing
  public static void main( String[] args )
  {


      String zoo1 = "( + 4 3 )";
      System.out.println(zoo1);
      System.out.println("zoo1 eval'd: " + evaluate(zoo1) );
      //...7

      String zoo2 = "( + 4 ( * 2 5 ) 3 )";
      System.out.println(zoo2);
      System.out.println("zoo2 eval'd: " + evaluate(zoo2) );
      //...17

      String zoo3 = "( + 4 ( * 2 5 ) 6 3 ( - 56 50 ) )";
      System.out.println(zoo3);
      System.out.println("zoo3 eval'd: " + evaluate(zoo3) );
      //...29

      String zoo4 = "( - 1 2 3 )";
      System.out.println(zoo4);
      System.out.println("zoo4 eval'd: " + evaluate(zoo4) );
      //...-4
      /*v~~~~~~~~~~~~~~MAKE MORE~~~~~~~~~~~~~~v
      ^~~~~~~~~~~~~~~~AWESOME~~~~~~~~~~~~~~~^*/
  }//main

}//end class Scheme
