public class practical9 {
    static void performanceOfString(int size){
        long start = 0;
        long stop = 0;
        String teString = "";

        for(int i =0; i < size; i ++){
            start += System.nanoTime();

            teString = start+"";

            stop += System.nanoTime();
        }
        System.out.println("Avg Time for String is : " + (stop - start)/size);
    }
    static void performanceOfStringBuffer(int size){
        long start = 0;
        long stop = 0;
        StringBuffer teString = new StringBuffer();

        for(int i =0; i < size; i ++){
            start += System.nanoTime();

            teString.append(start);

            stop += System.nanoTime();
        }
        System.out.println("Avg Time for StringBuffer : " + (stop - start)/size);
    }

    static void performanceOfStringBuilder(int size){
        long start = 0;
        long stop = 0;
        StringBuilder teString = new StringBuilder();

        for(int i =0; i < size; i ++){
            start += System.nanoTime();

            teString.append(start);

            stop += System.nanoTime();
        }
        System.out.println("AvgTime for StringBuilder : " + (stop - start)/size);
    }
    static int calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    static void TimeForCalculateFactorialUsingForLoop(int size){
        long start = 0;
        long stop = 0;
        int factorial = 1;

        for(int i =0; i < size; i ++){
            start += System.nanoTime();

            for(int j = 1; j <= i; j++){
                factorial *= j;
            }

            stop += System.nanoTime();
        }
        System.out.println("Avg Time for Factorial using For Loop : " + (stop - start)/size);
    }

    static void TimeForCalculateFactorialUsingRecursion(int size){
        long start = 0;
        long stop = 0;
        int factorial = 1;

        for(int i =0; i < size; i ++){
            start += System.nanoTime();

            factorial = calculateFactorial(i);

            stop += System.nanoTime();
        }
        System.out.println("Avg Time for Factorial Program using Recursion is : " + (stop - start)/size);
    }

    
    public static void main(String[] args){
        performanceOfString(Integer.parseInt(args[0]));
        performanceOfStringBuffer(Integer.parseInt(args[0]));
        performanceOfStringBuilder(Integer.parseInt(args[0]));
        TimeForCalculateFactorialUsingForLoop(Integer.parseInt(args[0]));
        TimeForCalculateFactorialUsingRecursion(Integer.parseInt(args[0]));
    }
}
