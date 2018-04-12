//Kathleen Wong
//APCS2 pd2
//HW17 -- So So FastSelect
//2018-03-12

public class FastSelect{

/* FastSelect first uses partition with the left bound at the first element of
the array, the right bound at the end of the array, and the pivot at the middle.
If the value returned is greater than where the location of the yth number
would be, partitition continues for the numbers left of the pivot. Otherwise,
partition continues on the numbers on the right of the pivot.*/

public static int fastSelect(int[] arr, int y){
  int leftPos= 0;
  int rightPos= arr.length -1;
  //use midpoint of range as pivot
  int mid = (leftPos+rightPos)/2;
  //final location of yth biggest number would be in arr[y-1];
  int pos = y - 1;

  while (partition(arr,leftPos,rightPos,mid)!=pos) {
    //if partition returns a value greater than y-1, continue partition
    //on left of pivot
    if(partition(arr,leftPos,rightPos,mid) > pos) {
      leftPos=0;
      rightPos= mid;
      mid = (leftPos+rightPos)/2;
      partition(arr,leftPos,rightPos,mid);
    }
    //otherwise, continue partition on right of pivot
    else{
      leftPos=mid;
      rightPos=arr.length-1;
      mid = (leftPos+rightPos+1)/2;
     partition(arr,leftPos,rightPos,mid);
    }
  }
  return arr[pos];
}

//partition method
public static int partition (int[] arr, int left , int right , int pvtPos){
    int v = arr[pvtPos];
    swap(arr, pvtPos,right);
    int s = left;
    for (int i = left; i<right; i++){
      if(arr[i]<v){
        swap(arr,s,i);
        s+=1;
      }
    }
    swap(arr,right,s);
    return s;
  }
//swap helper method for partition
  public static void swap ( int[] arr, int x, int y ) {
	int temp = arr[x];
	arr[x] = arr[y];
	arr[y] = temp;
}
public static void main(String[] args) {
  int[] testtest= {3,4,7,2,6};
  System.out.println(partition(testtest,0,4,2));
  System.out.println(fastSelect(testtest,1));//2
  System.out.println(fastSelect(testtest,3));//4

  /*Best Case: O(n) : The best case would be when the yth smallest value is
  already at arr[y-1] because only one partition would be necessary. One
  partition is O(n) becasue there is only one for loop iterating from the left
  bound to right bound.*/
  int[] bestCase = { 1,2,3,4,5};
  System.out.println(fastSelect(bestCase,3));//3

  /*Worse Case: O(nlogn):The worst case would be when the yth element is the smallest
  or largest number ,and either are already at their respective ends, because
  fastSelect would have to continue to partitition half the array until it reaches one end.
  */
  int[] worstCase={1,2,3,4,5};
  System.out.println(fastSelect(worstCase,1));//1
  System.out.println(fastSelect(worstCase,5));//5
}
}
