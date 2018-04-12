//Kathleen Wong
//APCS2 pd2
//HW18 -- So So Quick
//2018-03-13t

/*****************************************************
 * class QuickSort
 * Implements quicksort algo to sort an array of ints in place
 *
 * 1. Summary of QuickSort algorithm:
 * QSort(arr):Quicksort first partiions the entire array using the
  midpoint as the pivot point. Then, it recursively partitions both sides
  of the pivot point.
 *
 * 2a. Worst pivot choice and associated runtime:
 * The worst choice would be either the first or last element because it is more like that
 those elements would be the smallest or largest elements, causing partition to be
  called n-1 times. O(n^2).

 * 2b. Best pivot choice and associated runtime:
 *The best choice would be the middle because the array would ideally be split
 in half with each partition. O(nlogn)

 * 3. Approach to handling duplicate values in array:
 *not too sure
 *partition only swaps the value if it is greater than the pivot point,
 so duplicate values are already grouped together?
 *****************************************************/

public class QuickSort
{
  //--------------v  HELPER METHODS  v--------------
  //swap values at indices x, y in array o
  public static void swap( int x, int y, int[] o ) {
    int tmp = o[x];
    o[x] = o[y];
    o[y] = tmp;
  }

  //print input array
  public static void printArr( int[] a ) {
    for ( int o : a )
	    System.out.print( o + " " );
    System.out.println();
  }

  //shuffle elements of input array
  public static void shuffle( int[] d ) {
    int tmp;
    int swapPos;
    for( int i = 0; i < d.length; i++ ) {
	    tmp = d[i];
	    swapPos = i + (int)( (d.length - i) * Math.random() );
	    swap( i, swapPos, d );
    }
  }

  //return int array of size s, with each element fr range [0,maxVal)
  public static int[] buildArray( int s, int maxVal ) {
    int[] retArr = new int[s];
    for( int i = 0; i < retArr.length; i++ )
	    retArr[i] = (int)( maxVal * Math.random() );
    return retArr;
  }

  //return location of arr[ pvtPos] if arr[] were sorted
  public static int partition (int[] arr, int left , int right , int pvtPos){
      int v = arr[pvtPos];
      swap(pvtPos,right,arr);
      int s = left;
      for (int i = left; i<right; i++){
        if(arr[i]<v){
          swap(s,i,arr);
          s+=1;
        }
      }
      swap(right,s,arr);
      return s;
    }
  //--------------^  HELPER METHODS  ^--------------

  /*****************************************************
   * void qsort(int[])
   * sorts array
   * @param d -- array of ints to be sorted in place
   *****************************************************/
  public static void qsort( int[] d )
  {
    qhelper(d,0,d.length-1);
  }

  /*****************************************************
   * void qsort(int[])
   * @param arr -- array of ints to be sorted in place
   * @param left -- starting index of array
   * @param right -- last index of array
   *****************************************************/
  public static void qhelper( int[] arr, int left, int right){

    if(left<right){
    int pvtPos= partition(arr,left,right,(left+right+1)/2);

    qhelper(arr,left,pvtPos-1);
    qhelper(arr,pvtPos+1,right);}

  }

  //main method for testing
  public static void main( String[] args )
  {

    //get-it-up-and-running, static test case:
    int [] arr1 = {7,1,5,12,3};
    System.out.println("\narr1 init'd to: " );
    printArr(arr1);

    qsort( arr1 );
    System.out.println("arr1 after qsort: " );
    printArr(arr1);

    // randomly-generated arrays of n distinct vals
    int[] arrN = new int[10];
    for( int i = 0; i < arrN.length; i++ )
    arrN[i] = i;

    System.out.println("\narrN init'd to: " );
    printArr(arrN);

    shuffle(arrN);
    System.out.println("arrN post-shuffle: " );
    printArr(arrN);

    qsort( arrN );
    System.out.println("arrN after sort: " );
    printArr(arrN);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/



    //get-it-up-and-running, static test case w/ dupes:
    int [] arr2 = {7,1,5,12,3,7};
    System.out.println("\narr2 init'd to: " );
    printArr(arr2);

    qsort( arr2 );
    System.out.println("arr2 after qsort: " );
    printArr(arr2);


    // arrays of randomly generated ints
    int[] arrMatey = new int[20];
    for( int i = 0; i < arrMatey.length; i++ )
    arrMatey[i] = (int)( 48 * Math.random() );

    System.out.println("\narrMatey init'd to: " );
    printArr(arrMatey);

    shuffle(arrMatey);
    System.out.println("arrMatey post-shuffle: " );
    printArr(arrMatey);

    qsort( arrMatey );
    System.out.println("arrMatey after sort: " );
    printArr(arrMatey);
    /*~~~~s~l~i~d~e~~~m~e~~~d~o~w~n~~~~~~~~~~~~~~~~~~~~ (C-k, C-k, C-y)
    ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/

  }//end main

}//end class QuickSort
