class Practical8 {
    
    
    void printPattern1(int currentLine, int size) {
        if (currentLine > size) return;
        printStars(currentLine);
        System.out.println();
        printPattern1(currentLine + 1, size);
        printStars(currentLine - 1);
        System.out.println();
    }
    void printPattern2(int totalLines, int currentLine) {
        if (currentLine > totalLines) {
            printSymbols(totalLines + 1, '+');
            return;
        }
        printSymbols(totalLines - currentLine, ' ');
        printSymbols(currentLine, '*');
        System.out.println();
        printPattern2(totalLines, currentLine + 1);
    }
    void printPattern3(int currentLine, int totalSize) {
        int mid = (int) Math.ceil(totalSize / 2f); 
    
        if (currentLine <= mid) {
            printSpaces(mid - currentLine);
            printStars(currentLine * 2 - 1);
            System.out.println();
            printPattern3(currentLine + 1, totalSize);
            if (currentLine < mid) {
                printSpaces(mid - currentLine);
                printStars(currentLine * 2 - 1);
                System.out.println();
            }
        }
    }
    void printCenterLine(int currentLine, int totalSize) {
        if (currentLine > totalSize) return;
        printSpaces(totalSize / 2);
        System.out.println("+");
        printCenterLine(currentLine + 1, totalSize);
    }
    void printStars(int count) {
        if (count > 0) {
            System.out.print("*");
            printStars(count - 1);
        }
    }
    void printSpaces(int count) {
        if (count > 0) {
            System.out.print(" ");
            printSpaces(count - 1);
        }
    }
    void printSymbols(int count, char symbol) {
        if (count > 0) {
            System.out.print(symbol);
            printSymbols(count - 1, symbol);
        }
    }
    public static void main(String[] args) {
        Practical8 p = new Practical8();

        System.out.println("Pattern 1:");
        p.printPattern1(1, 3);  // Print first pattern with 3 lines

        System.out.println("\nPattern 2:");
        p.printPattern2(3, 1);  // Print second pattern with 3 lines

        System.out.println("\nPattern 3:");
        p.printPattern3(1, 5);  // Print third pattern (diamond shape) with 5 lines
        p.printCenterLine(1, 5);  // Print center line of "+"
    }
}

