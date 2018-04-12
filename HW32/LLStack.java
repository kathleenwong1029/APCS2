// Kathleen Wong
// APCS2 pd2
// HW32 -- Leon Leonwood Stack
// 2018-04-11

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE>{

  private LinkedList<PANCAKE> _link;

  public LLStack() {
 _link = new LinkedList<PANCAKE>();
   }

  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){
    return _link.size()==0;
  };

  //Return top element of stack without popping it.
  public PANCAKE peek(){
    PANCAKE retVal = _link.getLast();
    return retVal;
  };

  //Pop and return top element of stack.
  public PANCAKE pop(){
    if(isEmpty()){
      return null;
    }
    PANCAKE retVal = peek();
    _link.removeLast();
    return retVal;
  };

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ){
    _link.add(x);
  }
}
