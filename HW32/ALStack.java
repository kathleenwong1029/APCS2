import java.util.ArrayList;
public class ALStack<PANCAKE> implements Stack<PANCAKE>{

  private ArrayList<PANCAKE> _array;

  public ALStack() {
 _array = new ArrayList<PANCAKE>();
   }
  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){
    return _array.size()==0;
  };

  //Return top element of stack without popping it.
  public PANCAKE peek(){
    PANCAKE retVal = _array.get(_array.size()-1);
    return retVal;
  };

  //Pop and return top element of stack.
  public PANCAKE pop(){
    if(isEmpty()){
      return null;
    }
    PANCAKE retVal = peek();
    _array.remove(_array.size()-1);
    return retVal;

  };

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ){
    _array.add(x);
  }
}
