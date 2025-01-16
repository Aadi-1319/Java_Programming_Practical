import java.util.Scanner;

public class getNumbers {

    static int getNumber(int num, String type) {
        int result = 0;
        if (type.equalsIgnoreCase("byte")) {
            // by using the classname . functionname we can directly access static function
            // of that class but it should be in same directories
            result = getbyte.converttobyte(num);
            return result;
        } else if (type.equalsIgnoreCase("short")) {
            result = shortdata.converttoshort(num);
            return result;
        } else {
            return result;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value");
        int value = sc.nextInt();
        System.out.println("Enter the type to convert :");
        String type = sc.next();
        int result = getNumber(value, type);
        System.out.println("result :" + result);
    }
}
