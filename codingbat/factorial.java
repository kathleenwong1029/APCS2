public class factorial{
  public int factorial(int n) {
  if (n>1){
    return n * factorial(n-1);
  }
  return 1;
}

public static void main(String[] args) {
  System.out.println(factorial(1)); // → 1
  System.out.println(factorial(2)); //→ 2
  System.out.println(factorial(3)); //→ 6
}
}
