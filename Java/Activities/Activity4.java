package activities;

import java.util.Arrays;

public class Activity4 {

	public static void main(String[] args) {
		int a[]= {4,8,1,88,65,456,-24};
		int n=a.length;
		System.out.println("Array before sorting: "+Arrays.toString(a));
		
		
		for(int i=0;i<n-1;i++) {    //No. of passes
			
			for(int j=0;j<n-1;j++) {  //Iteration in each pass
				
				if(a[j]>a[j+1]) {
					
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
				
			}
						
		}
		
		//Arrays.parallelSort(a);
		//Arrays.sort(a);
		//Integer b[]= {4,8,1,88,65,456,-24};
		//Arrays.sort(b, Collections.reverseOrder());
		//System.out.println("Array after sorting: "+Arrays.toString(b));
		System.out.println("Array after sorting: "+Arrays.toString(a));
	}

	}


