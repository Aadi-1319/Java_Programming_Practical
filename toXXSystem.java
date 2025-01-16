import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class toXXSystem {

    String decimaltobinary(int value) {
        Stack<Integer> stack = new Stack<Integer>();

        while (value > 0) {
            stack.push(value % 2);
            value = value / 2;
        }
        StringBuilder decbin = new StringBuilder();
        while (stack.size() != 0) {
            decbin.append(stack.pop());

        }
        return decbin.toString();
    }

    String decimalToOctal(int value) {
        ArrayList<Integer> list = new ArrayList<>();
        while (value > 8) {
            list.add(value % 8);
            value = value / 8;
        }

        StringBuilder result = new StringBuilder();
        result.append(value);
        for (int i = list.size() - 1; i >= 0; i--) {
            result.append(list.get(i));
        }

        return result.toString();
    }

    // int binaryToOctal()

    int octaltodecimal(String octal) {
        int power = 0;
        int result = 0;
        for (int i = octal.length() - 1; i >= 0; i--) {
            result += Character.getNumericValue(octal.charAt(i)) * Math.pow(8, power);
            power++;
        }
        return result;
    }

    String decimaltoHexadecimal(int value) {
        String hexadecimal = "";
        char[] hexChars = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
                'A', 'B', 'C', 'D', 'E', 'F' };
        while (value > 0) {
            int remainder = value % 16;
            hexadecimal = hexChars[remainder] + hexadecimal;
            value = value / 16;
        }
        System.out.println("Hexadecimal: " + hexadecimal);

        return hexadecimal;
    }

    String hexaToDecimal(String value) {
        int decimal = 0;
        for (int i = 0; i < value.length(); i++) {
            char hexChar = value.charAt(i);
            int decimalValue = 0;
            if (hexChar >= '0' && hexChar <= '9') {
                decimalValue = hexChar - '0';
            } else if (hexChar == 'A' || hexChar == 'a') {
                decimalValue = 10;
            } else if (hexChar == 'B' || hexChar == 'b') {
                decimalValue = 11;
            } else if (hexChar == 'C' || hexChar == 'c') {
                decimalValue = 12;
            } else if (hexChar == 'D' || hexChar == 'd') {
                decimalValue = 13;
            } else if (hexChar == 'E' || hexChar == 'e') {
                decimalValue = 14;
            } else if (hexChar == 'F' || hexChar == 'f') {
                decimalValue = 15;
            } else {
                System.out.println("Invalid value input.");
            }
            decimal = decimal * 16 + decimalValue;
        }
        System.out.println("Decimal: " + decimal);
        return String.valueOf(decimal);
    }

    String hexaToBinary(String value) {
        StringBuilder binary = new StringBuilder();
        for (int i = 0; i < value.length(); i++) {
            char hexChar = value.charAt(i);

            String binaryValue = "";
            // Convert the current hex character to binary
            if (hexChar >= '0' && hexChar <= '9') {
                String arr = decimaltobinary(Character.getNumericValue(hexChar));
                binary.append(arr);
            } else if (hexChar == 'A' || hexChar == 'a') {
                binaryValue = "1010";
            } else if (hexChar == 'B' || hexChar == 'b') {
                binaryValue = "1011";
            } else if (hexChar == 'C' || hexChar == 'c') {
                binaryValue = "1100";
            } else if (hexChar == 'D' || hexChar == 'd') {
                binaryValue = "1101";
            } else if (hexChar == 'E' || hexChar == 'e') {
                binaryValue = "1110";
            } else if (hexChar == 'F' || hexChar == 'f') {
                binaryValue = "1111";
            } else {
                System.out.println("Invalid hexadecimal input.");
            }

            binary.append(binaryValue);
        }

        System.out.println("Binary: " + binary.toString());
        return binary.toString();
    }

    String hexatoOcal(String value) {
        String decimalValue = hexaToDecimal(value);
        String binaryvalue = decimaltobinary(Integer.parseInt(decimalValue));
        StringBuilder binaryvalues = new StringBuilder();
        binaryvalues.append(binaryvalue);

        return binaryvalues.toString();
    }

    String octlatobinary(String value) {
        StringBuilder octbin = new StringBuilder();
        String[] octToBinary = { "000", "001", "010", "011", "100", "101", "110", "111" };
        for (int i = 0; i < value.length(); i++) {
            int octDigit = Character.getNumericValue(value.charAt(i));
            octbin.append(octToBinary[octDigit]);
        }
        return octbin.toString();
    }

    String octaltohexa(String value) {
        int dec = octaltodecimal(value);
        String arr = decimaltoHexadecimal(dec);
        return arr;
    }

    String binarytodecimal(String value) {
        int result = 0;
        for (int i = 0; i < value.length(); i++) {
            if (value.charAt(i) == '1') {
                result += (int) Math.pow(2, value.length() - 1 - i);
            }
        }
        return String.valueOf(result);
    }

    String binarytoOctal(String value) {
        String decimalval = binarytodecimal(value);
        String octalval = decimalToOctal(Integer.parseInt(decimalval));
        return octalval;
    }

    String binarytohexa(String value) {
        String decimal = binarytodecimal(value);
        String hexaval = decimaltoHexadecimal(Integer.parseInt(decimal));
        return hexaval;
    }

    String typeOfInput(String input, String converttotype) {
        Scanner in = new Scanner(System.in);
        String output = "";
        String resulString = "";
        if (input.startsWith("0b")) {
            System.out.println("Input String is binary:");
            output = input.substring(2);
            if (converttotype.equalsIgnoreCase("d")) {
                resulString = binarytodecimal(output);
            } else if (converttotype.equalsIgnoreCase("h")) {
                resulString = binarytohexa(input);
            } else if (converttotype.equalsIgnoreCase("o")) {
                resulString = binarytoOctal(input);
            }
            return resulString;

        } else if (input.startsWith("0x")) {
            System.out.println("Input String is hexadecimal :");
            output = input.substring(2);
            if (converttotype.equalsIgnoreCase("b")) {
                resulString = hexaToBinary(output);
            } else if (converttotype.equalsIgnoreCase("d")) {
                resulString = hexaToDecimal(output);
            } else if (converttotype.equalsIgnoreCase("o")) {
                resulString = hexatoOcal(output);
            }
            return resulString;
        } else if (input.startsWith("0")) {
            System.out.println("Input String is ocatal :");
            output = input.substring(1);
            if (converttotype.equalsIgnoreCase("b")) {
                resulString = octlatobinary(output);
            } else if (converttotype.equalsIgnoreCase("h")) {
                resulString = octaltohexa(output);
            } else if (converttotype.equalsIgnoreCase("o")) {
                resulString = String.valueOf(octaltodecimal(output));
            }
            return resulString;
        } else {
            System.out.println("Input String is decimal :");

            if (converttotype.equalsIgnoreCase("b")) {
                resulString = decimaltobinary(Integer.parseInt(input));
            } else if (converttotype.equalsIgnoreCase("h")) {
                resulString = decimaltoHexadecimal(Integer.parseInt(input));
            } else if (converttotype.equalsIgnoreCase("o")) {
                resulString = decimalToOctal(Integer.parseInt(input));
            }
            return resulString;
        }
    }

    public static void main(String[] args) {
        toXXSystem d = new toXXSystem();
        Scanner in = new Scanner(System.in);
        System.out.println("Enter the number");
        String value = in.nextLine();
        System.out.println("Enter value to convert like(D , d = decimal) ");
        String converttotype = in.nextLine();

        String result = d.typeOfInput(value, converttotype);
        System.out.println("Converted result: " + result);

        // String arr = d.decimaltobinary(20);
        // System.out.println(arr);

        // ArrayList<Integer> octal = d.decimalToOctal(93);
        // for (int oct : octal) {
        // System.out.print(oct);
        // }

        // System.out.println(d.octaltodecimal("23"));

        // String result = d.decimaltoHexadecimal(459);
        // System.out.println(result);

        // int val = d.hexaToDecimal("1ABC");
        // System.out.println(val);

        // String Result = d.hexaToBinary("9BC");

        // String s = d.hexatoOcal("2BC");
        // System.out.println(s);

        // System.out.println(d.octaltohexa("12"));

        // System.out.println(d.binarytodecimal("101011"));

        // System.out.println(d.binarytoOctal("1010101"));

        // System.out.println(d.binarytohexa("0011101011101"));
        // System.out.println(type);

    }
}
