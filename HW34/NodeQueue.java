//Kathleen Wong
//APCS2 pd2
//HW34--The English Do Not Wait In Line
//2018-04-16

public class NodeQueue<Quasar> implements Queue<Quasar>{

  private LLNode<Quasar> _head,_tail;

  private NodeQueue(){
    _head=_tail=null;
  }

  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public Quasar dequeue(){
    //when trying to dequeue an empty queue
    if(isEmpty()){
      return null;
    }
    Quasar ret = _head.getValue();
    _head = _head.getNext();
    //if queue is empty afterward dequeueing
    if(isEmpty()){
      _tail=_head;
    }
    return ret;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( Quasar x ){
    //for first node added
    if(isEmpty()){
      _head=_tail= new LLNode<Quasar>(x,null);
    }
    //any other node
    else{
    _tail.setNext(new LLNode<Quasar>(x,null));
    _tail = _tail.getNext();}
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty(){
    return _head==null;
  }

  //Returns the first element of the queue without dequeuing it.
  public Quasar peekFront(){
    return _head.getValue();
  }

  //toString
  public String toString(){
    String retStr = "";
	  LLNode<Quasar> temp = _head;
	   while ( temp != null ) {
	    retStr += temp.getValue() + " ";
      temp = temp.getNext();
	   }
	    return retStr;
    }

  public static void main(String[] args) {
    NodeQueue<Integer> test = new NodeQueue<Integer>();
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
