public class QuickSortTester {

    public static void getTime(int[] arr) {
	long startTime = 0;
	long totalTime = 0;
	long averageTime = 0;

	startTime = System.nanoTime();

	QuickSort.qsort( arr );


	totalTime = System.nanoTime() - startTime;
	averageTime = totalTime / 1000;

	  // System.out.println("Total time: " + totalTime);
	  // System.out.println("\nAverage time: " + averageTime);

	System.out.println(arr.length + "," + averageTime );
    }

    public static void main(String[] args) {
	// test case

	System.out.println("Array Length, Average Time");
	for (int i = 1000 ; i <= 10000 ; i += 50) {
	    int[] example = QuickSort.buildArray(i,100);
	    getTime(example);
	}
    }

}
