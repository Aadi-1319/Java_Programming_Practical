import java.util.Scanner;

public class shortdata {
    static int converttoshort(int num) {
        int res = num % 65536;
        if (res < -32767) {
            return res + 65536;
        } else if (res > 32767) {
            return res - 65536;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int result = converttoshort(value);
        System.out.println(result);
    }
}
