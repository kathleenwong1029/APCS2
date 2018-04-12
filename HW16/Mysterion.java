//Kathleen Wong
//APCS2 pd2
//HW16 -- About Face
//2018-03-08

public class Mysterion{
  /* The function take int c, and rearranges the array, so that numbers
  smaller than c are moved to the left of it and numbers larger are moved to
  the right. int a 0 to represent the first number of the array and b is
  the size of the array -1 to represnt the last number. The int returned
  is the location of the original arr[c] after the array has been rearranged.*/

  public static int divider (int[] arr, int first , int last , int divide){
    int v = arr[divide];
    swap(arr, divide,last);
    int s = first;
    for (int i = first; i<last; i++){
      if(arr[i]<v){
        swap(arr,s,i);
        s+=1;
      }
    }
    swap(arr,last,s);
    return s;
  }

  public static void swap ( int[] arr, int x, int y ) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
}

  public static void main(String[] args) {
    int[] test1= {10,2,44,23,67};
    System.out.println(divider(test1,0,4,2));//3
    int[] test2= {1,4,9,3,7};
    System.out.println(divider(test2,0,4,2));//4
    int[] test3= {17,4,9,3,7};
    System.out.println(divider(test3,0,4,2));//4
  }
}
