//Kathleen Wong
//APCS2 pd2
//HW21b -- We Got a Little Ol’ Convoy...
//2018-03-20

/*****************************************************
 * class LLNode
 * Implements a node, for use in lists and other container classes.
 * Stores its data as a String
 *****************************************************/

public class LLNode
{
    //instance vars
    private String cargo;
    private LLNode next;

    // constructor
    public LLNode(String car, LLNode cdr){
      cargo= car;
      next=cdr;
    }


    //--------------v  ACCESSORS  v--------------
    public String getCargo()
    {return cargo;
    }

    public LLNode getNext()
    {return next;
    }
    //--------------^  ACCESSORS  ^--------------


    //--------------v  MUTATORS  v--------------
    public String setCargo(String newCargo)
    {cargo=newCargo;
      return cargo;
    }

    public LLNode setNext(LLNode newNext)
    {next=newNext;
      return next;
    }
    //--------------^  MUTATORS  ^--------------


    // override inherited toString
    public String toString()
    {
      return cargo.toString();
    }


    //main method for testing
    public static void main( String[] args )
    {
	//PROTIP: try creating a few nodes: traversible, connected...
	//note anything notable as you develop and test...

    //create node
    LLNode marauders = new LLNode("prongs", null);
    System.out.println(marauders.getCargo());//returns prongs
    //create next node
    marauders.setNext(new LLNode("padfoot", null));
    //see if accessors/mutators work
    System.out.println(marauders.getNext());//returns padfoot

    }//end main

}//end class LLNode
