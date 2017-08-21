package com.mytest.oth;

import java.util.Arrays;

public class Main1 {

	// **
	// 比如计算 6789 – 123 = 6666。则A = [6,7,8,9], B = [1,2,3], 返回： [6,6,6,6]
	public static void main(String[] args) {
		int a[] = { 7, 8, 9, 1 };
		int b[] = { 2, 1, 9, 9 };
		System.out.println(Arrays.toString(subtract(a, b)));

	}

	static int[] subtract(int[] a, int[] b)

	{
		int al = a.length;
		int bl = b.length;
		// 从个位减
		int sa = al - 1;
		int sb = bl - 1;
		int subs[] = new int[al];
		Boolean flagBl = false;
		for (int i = 0; i <= sa; i++) {
			// 判断上次计算是否有借位
			if (flagBl) {
				if (a[sa] == 0) {
					a[sa] = 9;
					// 下次还需要借位
					flagBl = true;
				} else {
					a[sa] = a[sa] - 1;
				}
			}
			int btemp = 0;
			if (i <= sb) {
				btemp = b[sb - i];
			}
			// 判断下次是否有借位
			int subI = 0;
			if (a[sa - i] < btemp) {
				flagBl = true;
				subI = a[sa - i] + 10 - btemp;
			} else {
				subI = a[sa - i] - btemp;

			}
			subs[sa - i] = subI;
		}
		return subs;
	}
}
