import java.util.Random;


public class MergeSort {

	//Basic merge sort that uses O(n) extra space
	public static void main(String[] args)
	{
		int a [] = new int[10];
		Random random = new Random();
		for(int i = 0; i<a.length;i++)
			a[i] = random.nextInt(100);
		
		
		System.out.println("Unsorted values...");
		for(int i:a)
			System.out.print(i+" ");
	
		System.out.println("\n\nSorted values...");
		
		for(int i:mergeSort(a))
			System.out.print(i+" ");
		
	}
	
	
	public static int[] mergeSort(int[] values)
	{	
		if(values.length==1) return values;
		int[] left = mergeSort(getLeftSplit(values));
		int[] right = mergeSort(getRightSplit(values));
		
		return merge(left,right);
		
	}
	
	
	private static int[] merge(int[] a, int[] b)
	{
		int[] sorted = new int[a.length+b.length];
		
		int aInd=0,bInd = 0,sInd = 0;
		
		while((aInd<a.length)&& (bInd<b.length))
		{
			if(a[aInd]<b[bInd])
			{
				sorted[sInd] = a[aInd];
				aInd++;
				sInd++;
			}
			else
			{
				sorted[sInd] = b[bInd];
				bInd++;
				sInd++;
			}
		}
		
		
		while(aInd<a.length)
		{
			sorted[sInd] = a[aInd];
			aInd++;
			sInd++;
		}
		while(bInd<b.length)
		{
			sorted[sInd] = b[bInd];
			bInd++;
			sInd++;
		}
		
		return sorted;
		
	}
	
	private static int[] getRightSplit(int[] orig)
	{
		int mid = orig.length/2;
		int[] rightHalf = new int[orig.length-mid];
		for(int i = 0; i<rightHalf.length;i++)
		{
			rightHalf[i] = orig[i+mid];
		}
		return rightHalf;
		
	}
	
	
	private static int[] getLeftSplit(int[] orig)
	{
		int[] leftHalf = new int[orig.length/2];
		for(int i = 0; i<leftHalf.length;i++)
			leftHalf[i] = orig[i];
		return leftHalf;
		
	}
	
	
}
