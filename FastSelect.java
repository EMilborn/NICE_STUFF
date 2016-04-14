	    
//Elias Milborn
//APCS2 pd09
//HW31 -- Fast Selection
//2016-04-13   

public class FastSelect{

    public static void swap(int[] arr, int ind1, int ind2){
	int new1 = arr[ind2];
	arr[ind2] = arr[ind1];
	arr[ind1] = new1;
    }

    public static int partition(int[] arr, int pivPos, int left, int right){
	int savPos = left;
	swap(arr, pivPos, right);
	for (int i = left; i < right; i++){
	    if (arr[i] < arr[right]){
		swap (arr, savPos, i);
		savPos+=1;
	    }
	}

	swap( arr, right, savPos);
	return savPos;   	
    } 

    public static int FSel(int[] arr, int k, int lo, int hi){
	int ret;
	if (lo >= hi)
	    ret = arr[k-1];
	
	else {
	    int i = partition(arr, hi, lo, hi);
	    if (i == k-1)
		ret = arr[i];
	    else if (i > k-1)
		ret = FSel(arr, k, lo, i-1);
	    else
		ret = FSel(arr, k, i + 1, hi);	    
	}
	return ret;
    }
    public static int FastSelect(int[] arr, int k){
	return FSel(arr, k, 0, arr.length - 1);
    }

    public static String arrToString(int[] arr){
	String ret = "";
	for (int i : arr)
	    ret += i + " ";
	return ret;
    }
    
    public static void main(String[] args){
	int k = Integer.parseInt(args[0]);
	System.out.println("k is " + k);
	int[] arr = new int[args.length-1];
	for (int i = 0; i < arr.length; i++){
	    arr[i] = Integer.parseInt(args[i+1]);
	}
	System.out.println(arrToString(arr));

	System.out.println(FastSelect(arr, k));
    }
}
