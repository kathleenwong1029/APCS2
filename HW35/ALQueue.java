/*

   Team Destiny's Child -- Angela Tom and Kathleen Wong
   APCS2 pd2
   HW35 -- ...Nor Do Aussies
   2018-04-16

*/

/*****************************************************
 * interface Queue
 * Includes only methods listed in AP subset of Java
 * (Local version, to override built-in Java implementation.)
 ******************************************************/


import java.util.ArrayList;
public class ALQueue<T> implements Queue<T>{

    ArrayList<T> AL;

    //constructor
    public ALQueue() {
	AL = new ArrayList<T>();
    }

  //Returns the first element of the queue without dequeuing it.
  //O(1)
    public T peekFront(){
	if(AL.isEmpty()){
	    return null;
	}
	return (T) AL.get(0);
    }

    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    //O(n)
    public T dequeue(){
	if(AL.isEmpty()){
	    return null;
	}
	T retVal = (T) AL.get(0);
	AL.remove(0);
	return retVal;
    }

    //means of adding an element to collection:
    //O(1)
    public void enqueue(T x){
	AL.add(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    //O(1)
    public boolean isEmpty(){
	return AL.size() == 0;
    }

    //toString
    public String toString(){
      return AL.toString();
    }

    public static void main(String[] args){
      ALQueue<Integer> test = new ALQueue<Integer>();
      test.enqueue(0);
      test.enqueue(1);
      test.enqueue(2);
      test.enqueue(3);
      System.out.println("Present Queue:" +test);
      System.out.println("Dequeing:" + test.dequeue());//0
      System.out.println("Dequeing:" + test.dequeue());//1
      System.out.println("Dequeing:" + test.dequeue());//2
      System.out.println("Dequeing:" + test.dequeue());//3
      System.out.println("Dequeing:" + test.dequeue());//null
    }
}
