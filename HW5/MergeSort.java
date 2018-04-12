//Kathleen Wong
//APCS2 pd2
//HW5 -- Step 1: Split, Step 2: ?, Step 3: Sorted!
//2018-02-07
/*======================================
  class MergeSort
  Implements mergesort on array of ints.

  Summary of Algorithm: Mergesort first sorts an array by splitting the array
  in half until it is sorted, or there is only one element. Then these sorted
  arrays are merged with the pair that they were split with, by comparing the first
  elements in each array and placing the smaller value in the new array first,
  until the original array is sorted.

  ======================================*/

public class MergeSort
{
  /******************************************************
   * int[] merge(int[],int[])
   * Merges two input arrays
   * Precond:  Input arrays are sorted in ascending order
   * Postcond: Input arrays unchanged, and
   * output array sorted in ascending order.
   ******************************************************/
  private static int[] merge( int[] a, int[] b )
  {
    int aLength= a.length;
    int bLength= b.length;
    int merged[] = new int[aLength+bLength];
    int x,y,z;
    x=y=z=0;
    //the "first" elements of each array are compared, and the smaller value
    //is added to the merged array
    while(x<aLength && z<bLength){
      if(a[x]<b[y]){
        merged[z]= a[x];
        x+=1;
        z+=1;
      }
      else{
        merged[z]= b[y];
        y+=1;
        z+=1;
      }
    }
    //if only one array still has elements remaining, they can be added to the
    //merged array in that order
    if (x<aLength){
      for(int i=x; i<aLength;i++){
        merged[z]=a[i];
        z++;
      }
    }
      if (y<bLength){
        for(int i=y; i<bLength;i++){
          merged[z]=b[i];
          z++;
        }
    }
    return merged;
  }//end merge()


  /******************************************************
   * int[] sort(int[])
   * Sorts input array using mergesort algorithm
   * Returns sorted version of input array (ascending)
   ******************************************************/
  public static int[] sort( int[] arr )
  {
    if (arr.length == 1){
    return arr;
  }
  //keep halfing the array if it is not of length one
  int oneYet = arr.length;
  int[] lHalf = new int[oneYet/ 2];
  for(int i = 0;i < oneYet / 2;i++){
    lHalf[i] = arr[i];
  }
  int[] rHalf = new int[oneYet - (oneYet/2)];
  for(int i = rHalf.length;i < arr.length / 2;i++){
      rHalf[i] = arr[i];
    }
    int n = 0;
    for (int i = oneYet/2; i < oneYet; i++){
      rHalf[n] = arr[i];
      n ++;
    }
    return merge(sort(lHalf),sort(rHalf));
  }//end sort()



  //-------------------HELPERS-------------------------
  //tester function for exploring how arrays are passed
  //usage: print array, mess(array), print array. Whaddayasee?
  public static void mess( int[] a ) {
    for( int i = 0 ; i<a.length; i++ )
      a[i] = 0;
  }

  //helper method for displaying an array
  public static void printArray( int[] a ) {
    System.out.print("[");
    for( int i : a )
      System.out.print( i + ",");
    System.out.println("]");
  }
  //---------------------------------------------------


  //main method for testing
  public static void main( String [] args ) {

      int[] arr0 = {0};
      int[] arr1 = {1};
      int[] arr2 = {1,2};
      int[] arr3 = {3,4};
      int[] arr4 = {1,2,3,4};
      int[] arr5 = {4,3,2,1};
      int[] arr6 = {9,42,17,63,0,512,23};
      int[] arr7 = {9,42,17,63,0,9,512,23,9};

      System.out.println("\nTesting mess-with-array method...");
      printArray( arr3 );
      mess(arr3);
      printArray( arr3 );

      System.out.println("\nMerging arr1 and arr0: ");
      printArray( merge(arr1,arr0) );

      System.out.println("\nMerging arr4 and arr6: ");
      printArray( merge(arr4,arr6) );

      System.out.println("\nSorting arr4-7...");
      printArray( sort( arr4 ) );
      printArray( sort( arr5 ) );
      printArray( sort( arr6 ) );
      printArray( sort( arr7 ) );
      /*~~~~~~~~~~~~~~ Ye Olde Tester Bar ~~~~~~~~~~~~~~
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }//end main()

}//end class MergeSort
