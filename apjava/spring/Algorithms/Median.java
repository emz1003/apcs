public static double median(int[] data){
	Arrays.sort(data); 
	int n = data.length;
	if(n % 2 != 0)
		return data[n / 2] + datap[n / 2 - 1] / 2;
