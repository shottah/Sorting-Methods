/**
 * @description:	This program sorts a given array a[n] 
 * 					using 1 of 2 quicksort algorithms:
 * 						1. Lomuto
 * 						2. Hoare
 */
public class QuickSortTest {
	
	static int sz;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [] a = {9,8,7,6,5,4,3,2,1,10,0,11,19,15,13,12,14,18,17,16};
		sz = a.length;
		
		quickSort(a,0,sz);
		
		for (int i:a) {
			System.out.print(i+",");
		}
	}
	
	private static void printArray(int [] a) {
		System.out.print("[");
		for (int i:a)
			System.out.print(i+",");
		System.out.print("]\n");
	}

	private static void quickSort(int[] a, int i, int j) {
		if (i<j) {
			int pIndex = partitionLomuto(a,i,j);
			quickSort(a,i,pIndex-1);
			quickSort(a,pIndex+1,j);
		}
	}
	
	@SuppressWarnings("unused")
	private static int partition(String str, int[] a, int L, int e) {
		int p;
		switch(str){
		case "Lomuto":
			p = partitionLomuto(a,L,e);
			break;
		case "Hoare":
			p = partitionHoare(a,L,e);
			break;
		default:
			p = partitionLomuto(a,L,e);
			break;
		}
		return p;
	}

	private static int partitionHoare(int[] a, int L, int e) {
		int pivot = a[L];
		int i = L, j = e, x = 0;
		
		while (i < j) {
			x++;
			System.out.println("i: "+i);
			System.out.println("j: "+j);
			System.out.println("x: "+x);
			do {
				i++;
			} while (a[i]<pivot);
			do {
				j--;
			} while (a[j]>pivot);
			
			if (i < j) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		
		int temp = a[L];
		a[L] = a[j];
		a[j] = temp;
		
		return j;
	}

	private static int partitionLomuto(int[] a, int L, int e) {
		int pivot = a[L];
		int s = L;
		System.out.println("Pivot = "+pivot);
		for (int i = L+1; i < e; i++) {
			if (a[i] < pivot) {
				L++;
				if (L!=i) {
					System.out.println("Swapping "+a[L]+" and "+a[i]+"\n");
					int temp = a[L];
					a[L] = a[i];
					a[i] = temp;
				}
			}
			printArray(a);
		}
		System.out.println("Swapping "+a[L]+" and "+a[s]);
		
		int temp = a[L];
		a[L] = a[s];
		a[s] = temp;
		
		return s;
	}

}
