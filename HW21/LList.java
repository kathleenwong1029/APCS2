//Kathleen Wong
//APCS2 pd2
//HW21c -- Rockin' Through the Night
//2018-03-20

public class LList implements List{

  //instance vars
  private int size;
  private LLNode car;

  //constructor
  public LList(){
    car= new LLNode(null,null);
  }

//add node to list, containing input String as its data
  public boolean add( String x ){
    LLNode first = car;
    while(first.getCargo() != null){
      first=first.getNext();
    }
    first.setCargo(x);
    first.setNext(new LLNode(null,null));
    size+=1;
    return true;
  }

  //return data in element at position i
  public String get( int i ){
    LLNode first=car;
    int a =0;
    while(a<i){
      first=first.getNext();
      a++;
    }
    return first.getCargo();
  }

      //overwrite data in element at position i
    public String set( int i, String x ){
      LLNode first = car;
      int a =0;
      while (a<i){
          first=first.getNext();
          a++;
      }
      String retString= first.getCargo();
      first.setCargo(x);
      return retString;
    }

    //return length of list
  public int size(){
  return size;
  }

//override inherited toString
public String toString(){
  String retStr="";
  LLNode temp =car;
  while(temp != null){
    retStr+=temp.getCargo() +" ";
    temp=temp.getNext();
  }
  return retStr;
}

public static void main(String[] args) {
  LList marauders= new LList();
  System.out.println("Marauders adding prongs:");
  marauders.add("prongs");
  System.out.println(marauders);
  System.out.println("Marauders adding padfoot:");
  marauders.add("padfoot");
  System.out.println(marauders);
  System.out.println("Marauders adding wormtail:");
  marauders.add("wormtail");
  System.out.println(marauders);
  System.out.println("Marauders size:" + marauders.size());
  System.out.println("Getting element 2 of Marauders: " +marauders.get(2));
  marauders.set(2,"moony");
  System.out.println("Replacing wormtail with moony:");
  System.out.println(marauders);
}
}
