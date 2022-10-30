package tu.uni.examples;
import java.util.Arrays;

public class Test3 {
	public static void fillPrintArr(int[][] A) {
		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				A[i][j] = (int) (Math.random() * 20 + 0.5);
			}
			System.out.println(Arrays.toString(A[i]));
		}
	}

	public static void from2Dto1D(int[][] A) {
		int[] B = new int[A.length * A[0].length];

		for (int i = 0; i < A.length; i++) {
			for (int j = 0; j < A[i].length; j++) {
				B[i * A[i].length + j] = A[i][j];
			}
		}
		System.out.println(Arrays.toString(B));
	}

	public static void main(String[] args) {
		int[][] A = new int[4][5];
		fillPrintArr(A);
		from2Dto1D(A);
	}
}
