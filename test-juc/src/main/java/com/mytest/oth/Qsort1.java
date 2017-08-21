package com.mytest.oth;

import java.util.Arrays;
import java.util.Random;

public class Qsort1 {

	private static int ppp = 0;
	
	public static void qsort(int []ar,int start,int end){
		
		if(start>=end){
			return ;
		}
		
		int i =  start;
		int j = end;
		int x = ar[start];
		boolean flag = false;
		while(i < j){
			if( !flag ){
				if(ar[j]< x){
					swap(ar, i, j);
					flag = true;
				}else{
					  j--;
					  continue;
				}
			}else{
				  if(ar[i] > x){
		            	swap(ar, i, j);
		            	flag = false;
		            }else{
		            	i++;
		            	continue;
		            }
			}
		}
		qsort(ar, start, j-1);
		qsort(ar, j+1, end);
	} 
	
	public static void swap(int []ar,int i,int j){
		int temp = ar[i];
		ar[i] = ar[j];
		ar[j] = temp;
//		ppp++;
	}
	
	public static void main(String[] args) {
		int ar[] = new int[10000];
//		System.out.println(Arrays.toString(ar));
		Random r = new Random();
		for(int i=0;i< ar.length;i++){
			ar[i] = r.nextInt(1000000);
		}
		long t1 = System.currentTimeMillis();
		Arrays.sort(ar);
		System.out.println(System.currentTimeMillis()-t1);
		
		long t = System.currentTimeMillis();
		qsort(ar, 0, ar.length-1);
		System.out.println(System.currentTimeMillis()-t);
		
		
	
		
		//		System.out.println(Arrays.toString(ar));
	}
}
