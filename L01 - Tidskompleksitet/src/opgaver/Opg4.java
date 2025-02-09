package opgaver;

public class Opg4 {
    /*
       Lav en metode der kan beregne det n'te tal i fibonacci
       talfølgen. Metoden skal have lineær størrelsesorden af
       tidskompleksitet.
     */

    public static void main(String[] args) {
        System.out.println(fibIt(2));
    }

    public static long fibIt(int n) {
        if (n == 0 || n == 1)
            return 1;
        else {
            long fib_2 = 1;   // fib(n-2)
            long fib_1 = 1;   // fib(n-1)
            long fib = 2;     // fib(n)
            for (int i = 3; i <= n; i++) {
                fib_2 = fib_1;
                fib_1 = fib;
                fib = fib_1 + fib_2;
            }
            return fib;
        }
    }
}
