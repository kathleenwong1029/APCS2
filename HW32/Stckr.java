// Kathleen Wong
// APCS2 pd2
// HW32 -- Leon Leonwood Stack
// 2018-04-12
/*****************************************************
 * class Stckr
* driver/tester for Stack implementations (Linked-list-based, ArrayList-based)
 *****************************************************/

public class Stckr
{
public static void main( String[] args )
{
  Stack cakes = new ALStack();
  cakes.push("aoo");
  cakes.push("boo");
  cakes.push("coo");
  cakes.push("doo");
  cakes.push("eoo");
  cakes.push("foo");
  cakes.push("goo");
  cakes.push("hoo");
  cakes.push("ioo");
  cakes.push("joo");
  cakes.push("coocoo");
  cakes.push("cachoo");

  System.out.print("Testing ALStack");
  //cachoo
  System.out.println( cakes.pop() );
  //coocoo
  System.out.println( cakes.pop() );
  //joo
  System.out.println( cakes.pop() );
  //ioo
  System.out.println( cakes.pop() );
  //hoo
  System.out.println( cakes.pop() );
  //goo
  System.out.println( cakes.pop() );
  //foo
  System.out.println( cakes.pop() );
  //eoo
  System.out.println( cakes.pop() );
  //doo
  System.out.println( cakes.pop() );
  //coo
  System.out.println( cakes.pop() );
  //boo
  System.out.println( cakes.pop() );
  //aoo
  System.out.println( cakes.pop() );

  //stack empty by now; SOP(null)
  System.out.println( cakes.pop() );

  Stack cake = new LLStack();
  cake.push("aoo");
  cake.push("boo");
  cake.push("coo");
  cake.push("doo");
  cake.push("eoo");
  cake.push("foo");
  cake.push("goo");
  cake.push("hoo");
  cake.push("ioo");
  cake.push("joo");
  cake.push("coocoo");
  cake.push("cachoo");

  System.out.print("Testing LLStack");
  //cachoo
  System.out.println( cake.pop() );
  //coocoo
  System.out.println( cake.pop() );
  //joo
  System.out.println( cake.pop() );
  //ioo
  System.out.println( cake.pop() );
  //hoo
  System.out.println( cake.pop() );
  //goo
  System.out.println( cake.pop() );
  //foo
  System.out.println( cake.pop() );
  //eoo
  System.out.println( cake.pop() );
  //doo
  System.out.println( cake.pop() );
  //coo
  System.out.println( cake.pop() );
  //boo
  System.out.println( cake.pop() );
  //aoo
  System.out.println( cake.pop() );

  //stack empty by now; SOP(null)
  System.out.println( cake.pop() );

}

}//end class
