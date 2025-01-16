import java.util.Scanner;

public class getbyte {
    static int converttobyte(int num) {
        int res = num % 256;
        if (res < -128) {
            return res + 256;
        } else if (res > 127) {
            return res - 256;
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int result = converttobyte(value);
        System.out.println(result);
    }
}
