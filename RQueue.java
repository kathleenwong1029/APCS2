/* 
Team Calico Jack - Jude Grodesky, Kathleen Wong, Oliver Frank
APCS2 pd02
HW36 -- Now Lets Consider You Lot at Fake Terry's
2018-04-18w
 */

/*****************************************************
 * class RQueue
 * A linked-list-based, randomized queue
 * (a collection with FIIDKO property)
 *
 *       -------------------------------
 *   end |  --->   Q U E U E   --->    | front
 *       -------------------------------
 *
 *  linkages point opposite direction for O(1) en/dequeuing
 *            N <- N <- ... <- N <- N
 *      _end -^                     ^- _front
 *
 ******************************************************/


public class RQueue<T> implements Queue<T>
{
  //instance variables
  private LLNode<T> _front, _end;
  private int _size;


  // default constructor creates an empty queue
  public RQueue() 
  {
      _front = null;
      _end = null;
      _size = 0;
  }//end default constructor


    // add a node with the provided value to the end of the queue
  public void enqueue( T enQVal ) 
  {
      LLNode<T> newNode = new LLNode<T>(enQVal, null);
      if (isEmpty()){
	  _front = newNode;
      }
      else {
	  _end.setNext(newNode);
      }
      _end = newNode;
      _size++;
  }//end enqueue()


  // remove and return thing at front of queue
  // assume _queue ! empty
  public T dequeue() 
  {
      if ( isEmpty() ) {return null;}

      sample();	  //randomize the queue before removing the top node. Return its value

      T retVal = peekFront();
      if (_size == 1) {
	  _front = null;
	  _end = null;
      }
      else {
	  _front = _front.getNext();
      }
      _size--;
      return retVal;
  }//end dequeue()


    //return the value of the top node
  public T peekFront() 
  {
      if ( isEmpty() ) {
	  return null;}
      return _front.getValue();
  }


  /******************************************
   * void sample() -- a means of "shuffling" the queue
   * Algo:
   * 1.Remove the first node and enqueue it onto the back of the array 
   * 2.Repeat 1 n times, where n is between 0 and size;
   ******************************************/
  public void sample () 
  {
      if (_size >= 2){
	  int rand = (int)(Math.random() * _size);
	  for (int i = 0; i <= rand; i++) {
	      T retVal = peekFront();
	      if (_size == 1) {
		  _front = null;
		  _end = null;
	      }
	      else {
		  _front = _front.getNext();
	      }
	      _size--;
	      enqueue(retVal);
	  }
      }
  }//end sample()


  public boolean isEmpty() 
  {
      return _size == 0;
  } //O(1)


    // print each node, separated by spaces
  public String toString() 
  { 
      String ret = "_front -->";
      LLNode<T> temp = _front;
      while (temp != null) {
	  ret += " " + temp.getValue();
	  temp = temp.getNext();
      }
      return ret;
  }//end toString()



  //main method for testing
  public static void main( String[] args )
  {


      Queue<String> PirateQueue = new RQueue<String>();

      System.out.println("\nnow enqueuing..."); 
      PirateQueue.enqueue("Dread");
      PirateQueue.enqueue("Pirate");
      PirateQueue.enqueue("Robert");
      PirateQueue.enqueue("Blackbeard");
      PirateQueue.enqueue("Peter");
      PirateQueue.enqueue("Stuyvesant");

      System.out.println("\nnow testing toString()..."); 
      System.out.println( PirateQueue ); //for testing toString()...

      System.out.println("\nnow dequeuing..."); 
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );
      System.out.println( PirateQueue.dequeue() );

      

      System.out.println("\nnow dequeuing fr empty queue..."); 
      System.out.println( PirateQueue.dequeue() );



  }//end main

}//end class RQueue
