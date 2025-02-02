import java.util.Scanner;
class Practical7{
 void Name(int size) {
        int S1 = size;
        if (size % 2 == 0)
            S1 += 1;
        for (int ln = 1; ln <= size; ln++) {
            for (int col = 1; col <= size; col++) {
                if ((ln == 1 && col == 1) || (ln == 1 && col == size))
                    System.out.print(" ");
                else if (col == 1 || col == size || ln == size / 2 + 1 || ln == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print("   ");
            for (int col1 = 1; col1 <= size; col1++) {
                if ((ln == 1 && col1 == size) || (ln == size && size == col1))
                    System.out.print(" ");
                else if (ln == 1 || ln == size || col1 == 1 || col1 == size)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print(" ");
            for (int col2 = 1; col2 <= S1; col2++) {
                if (ln == 1 || col2 == size / 2 + 1 || ln == size)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print(" ");
            for (int col3 = 1; col3 <= S1; col3++) {
                if (ln == 1 || col3 == size / 2 + 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.print(" ");

            for (int col4 = 1; col4 <= S1; col4++) {
                if (ln <= size / 2 + 1) {
                    if (col4 == ln || col4 + ln == S1 + 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                } else {
                    if (col4 == size / 2 + 1)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
            }
            System.out.print(" ");
            for (int col5 = 1; col5 <= size; col5++) {
                if ((ln == 1 && col5 == 1) || (ln == 1 && col5 == size))
                    System.out.print(" ");
                else if (col5 == 1 || col5 == size || ln == size / 2 + 1 || ln == 1)
                    System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println("");

        }
    }
public static void main(String args[]){
Scanner sc = new Scanner(System.in);
Practical7 p = new Practical7();
int size = sc.nextInt();
p.Name(size);
}
}
