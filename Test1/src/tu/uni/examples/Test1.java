//import java.util.*;
package tu.uni.examples;

public class Test1 {

    public static void printArr(int[] b, String a) {
        System.out.printf("%s = [", a);
        for (int i : b) {
            System.out.printf("%d ", i);
        }
        System.out.printf("]\n");
    }

    public static void printMatrix(int[][] b, String a) {
        System.out.printf("%s = \n", a);
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.printf("%2d ", b[i][j]);
            }
            System.out.println();
        }
    }

    public static void prime1to100() {
        for (int i = 1; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j <= Math.sqrt(i); j++) {
                if (i % j == 0) {
                    isPrime = !isPrime;
                    break;
                }
            }
            if (isPrime)
                System.out.printf("%d ", i);
            isPrime = true;
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int[] a = new int[10];
        int[] b = new int[10];
        int[] c = new int[10];
        int[] d = new int[10];
        int sum = 0;

        for (int i = 0; i < a.length; i++) {
            a[i] = i;
            b[i] = b.length - 1 - i;
            c[i] = a[i] + b[i];
            d[i] = a[i] - b[i];
            sum += a[i] * b[i];
        }

        int[][] aa = new int[4][6];
        int[][] bb = new int[4][6];
        int[][] cc = new int[4][6];

        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[i].length; j++) {
                aa[i][j] = 10 * i + j;
                bb[i][j] = 10 * (aa.length - 1 - i) + (aa[i].length - 1 - j);
            }
        }
        for (int i = 0; i < aa.length; i++) {
            for (int j = 0; j < aa[i].length; j++) {
                cc[i][j] = aa[i][j] + bb[i][j];
            }
        }

        printArr(a, "a");
        printArr(b, "b");
        printArr(c, "c");
        printArr(d, "d");
        System.out.printf("a * b = %d\n", sum);
        printMatrix(aa, "aa");
        printMatrix(bb, "bb");
        printMatrix(cc, "cc");

        for (int i = 0; i <= 20; i += 2) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        prime1to100();
    }
}
