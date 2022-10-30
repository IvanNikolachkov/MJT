package tu.uni.examples;

import java.util.Arrays;

public class Test2 {
	
	public static void fillPrintArr(int[] asd) {
		for (int i = 0; i < asd.length; i++) {
			asd[i] = (int) (Math.random() * 20.0 + 0.5);
		}
		System.out.println("arr = " + Arrays.toString(asd));
	}

	public static void minmax(int[] asd) {
		int maxi = asd[0];
		int mini = asd[0];
		int maxIdx = 0;
		int minIdx = 0;
		for (int i = 0; i < asd.length; i++) {
			if (maxi < asd[i]) {
				maxi = asd[i];
				maxIdx = i;
			}
			if (mini > asd[i]) {
				mini = asd[i];
				minIdx = i;
			}
		}
		System.out.printf("maxIdx: %d maxEl: %d\nminIdx: %d minEl: %d\n", maxIdx, maxi, minIdx, mini);
	}

	public static void sortedArr(int[] asd) {
		int[] a = new int[20];
		int mini = asd[0];
		int idx = 0;
		for (int i = 0; i < asd.length; i++) {
			mini = asd[0];
			idx = 0;
			for (int j = 0; j < asd.length; j++) {
				if (mini > asd[j]) {
					mini = asd[j];
					idx = j;
				}
			}
			a[i] = mini;
			asd[idx] = 21;
		}
		System.out.println("a = " + Arrays.toString(a));
	}

	public static void suma(int[] asd) {
		int sum = 0;
		for (int i : asd) {
			sum += i;
		}
		System.out.println("sum = " + sum);
	}

	public static void product(int[] asd) {
		float prod = 1;
		for (int i : asd) {
			prod *= (float) i;
		}
		System.out.println("product = " + prod);
	}

	public static void main(String[] args) {
		// arr 20 elem celi chisla 0-20 s genereator na random chisla
		int[] asd = new int[20];
		fillPrintArr(asd);
		minmax(asd);
		sortedArr(asd);
		suma(asd);
		product(asd);
	}

}
