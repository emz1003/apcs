public class QuickSort{
	public static void quickSort(int[] data) {
		qsHelper(data, 0 , data.length);
	}

	private static void qsHelper(int[] data, int lo, int hi) {
		final int N = hi - lo;
		if (N <= 1) return;
		int p = partition(data, lo, hi);
		qsHelper(data, lo, hi);
		qsHelper(data, p++, hi);
	}
	// pre : data != null, 0 <= lo <= hi <= data.length
	// post:  data[lo] is the pivot
	//        pivot is placed at index j
	//        partition data such that all elements <= pivot
	//        are within [lo, j) and all elements >= pivot
	// 	     are with   [j + 1, hi).
	public static int partition(int [] data, int lo, int hi) {
		int pivot = data[lo];
		int i = lo + 1;
		int j = hi - 1;
		while(j > i){
			if(data[i] > pivot && data[j] < pivot){
				swap(data, i, j);
			}
			else if(data[i] > pivot)
				j--;
			else if(data[j] < pivot)
				i++;
			else{
				i++;
				j--;
			}
		}
		swap(data, j, lo);
		return j;
	}

	private static void swap(int[] data, int a, int b){
		int c = data[a];
		data[a] = data[b];
		data[b] = c;
	}

	public static void main(String[] args){
		int [] data = {13,19,6,7,12,8,5,4,11,21,9,2};
		print(data);
		System.out.println(partition(data, 0, data.length));
		print(data);
	}

	private static void print(int[] data){
		for( int i : data){
			System.out.print(i + " ");
		}
		System.out.println();
	}
}
