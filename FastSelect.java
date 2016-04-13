	    
//Elias Milborn
//APCS2 pd09
//HW31 -- Fast Selection
//2016-04-13   

public class FastSelect{

    public static void swap(int[] arr, int ind1, int ind2){
	int new1 = ind2;
	arr[ind2] = ind1;
	arr[ind1] = new1;
    }

    public static int partition(int[] arr, int pivPos, int left, int right){
	int pivVal = arr[pivPos];
	int savPos = left;

	for (int i = left; i < right - 1; i++){
	    if (arr[i] < pivVal){
		swap (arr, savPos, i);
		savPos++;
	    }
	}

	swap( arr, right, savPos);
	return savPos;   	
    } 

    public static int FSel(int[] arr, int k, int lo, int hi){
	int ret;
	if (lo >= hi)
	    ret =  arr[lo];
	
	else {
	    int i = partition(arr, hi, lo, hi);
	    if (i == k)
		ret = arr[i];
	    else if (i < k)
		ret = FSel(arr, k, lo, i-1);
	    else 
		ret = FSel(arr, k, i + 1, hi);	    
	}
	return ret;
    }
    public static int FastSelect(int[] arr, int k){
	return FSel(arr, k, 0, arr.length - 1);
    }
    
}
