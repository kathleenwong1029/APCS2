public class bunnyEars{
  public int bunnyEars(int bunnies) {
  if (bunnies>0){
    return 2 + bunnyEars(bunnies-1);
  }
  return 0;
}

public static void main(String[] args) {
  System.out.println(bunnyEars(0));  //→ 0
  System.out.println(bunnyEars(1)); //→ 2
  System.out.println(bunnyEars(2)); // → 4
}
}
