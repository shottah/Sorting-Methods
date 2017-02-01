/**
 * @date: Jan 31, 2017
 * @description: Using the mergesort algorithm on a given array.
 */
public class MergeSortTest {
		private static final int sz = 9;
		
		public static void main(String [] args) {
			
			int [] arr = {8,9,6,1,2,4,3,7,5};
			
			for (int i:arr)
				System.out.print(i+" ");
			
			mergeSort(arr,0,sz-1);
			System.out.println();
			
			for (int i:arr)
				System.out.print(i+" ");
		}
		
		private static void mergeSort(int [] a, int l, int r) {
			if (l < r) {
				int m = (l+r)/2;
				mergeSort(a,l,m);
				mergeSort(a,m+1,r);
				merge(a,l,m+1,r);
			}
		}
		
		private static void merge(int [] a, int lp, int rp, int re) {
			int [] t = new int [sz];
			
			int le = rp-1;
			int i = lp;
			int n = re - lp + 1;
			
			while (lp <= le && rp <= re) {
				if (a[lp] < a[rp])
					t[i++] = a[lp++];
				else 
					t[i++] = a[rp++];
			}
			
			while (lp <= le)
				t[i++] = a[lp++];
			
			while (rp <= re)
				t[i++] = a[rp++];
			
			for (int j = 0; j < n; j++, re--)
				a[re] = t[re];
		}
}