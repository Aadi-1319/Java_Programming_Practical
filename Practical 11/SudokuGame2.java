import java.util.*;

class SudokuGame2{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rnd = new Random();

        System.out.print("Enter Sudoku grid size (e.g., 1, 2, 3...): ");
        int size = sc.nextInt();

        int[][] solGrid = new int[size][size];
        int[][] playGrid = new int[size][size];
        boolean[][] canEdit = new boolean[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                solGrid[i][j] = rnd.nextInt(size) + 1;
                playGrid[i][j] = solGrid[i][j];
            }
        }

        int totalCells = size * size;
        int toHide = (int)(totalCells * 0.4);
        while (toHide > 0) {
            int x = rnd.nextInt(size);
            int y = rnd.nextInt(size);
            if (playGrid[x][y] != 0) {
                playGrid[x][y] = 0;
                canEdit[x][y] = true;
                toHide--;
            }
        }

        boolean run = true;
        while (run) {
            System.out.println("\nSudoku Puzzle:");
            printGrid(playGrid, size);

            System.out.println("\nChoose an action:");
            System.out.println("1. Add a number");
            System.out.println("2. Remove a number");
            System.out.println("3. Submit solution");
            System.out.print("Your choice: ");
            int opt = sc.nextInt();

            switch (opt) {
                case 1:
                    System.out.print("Row (1 to " + size + "): ");
                    int r1 = sc.nextInt();
                    System.out.print("Column (1 to " + size + "): ");
                    int c1 = sc.nextInt();
                    System.out.print("Value (1 to " + size + "): ");
                    int val1 = sc.nextInt();

                    if (isInside(r1, c1, size) && canEdit[r1 - 1][c1 - 1]) {
                        playGrid[r1 - 1][c1 - 1] = val1;
                    } else {
                        System.out.println("⚠️ Invalid input or non-editable cell.");
                    }
                    break;

                case 2:
                    System.out.print("Row (1 to " + size + "): ");
                    int r2 = sc.nextInt();
                    System.out.print("Column (1 to " + size + "): ");
                    int c2 = sc.nextInt();

                    if (isInside(r2, c2, size) && canEdit[r2 - 1][c2 - 1]) {
                        playGrid[r2 - 1][c2 - 1] = 0;
                    } else {
                        System.out.println("⚠️ Invalid input or non-editable cell.");
                    }
                    break;

                case 3:
                    System.out.println("\n🔍 Checking your solution...");
                    if (isSame(playGrid, solGrid)) {
                        printGrid(playGrid, size);
                        System.out.println("✅ Well done! Puzzle solved correctly.");
                    } else {
                        System.out.println("❌ Incorrect solution. Here's the correct one:");
                        printGrid(solGrid, size);
                    }
                    run = false;
                    break;

                default:
                    System.out.println("❗ Please select a valid option.");
            }
        }

        sc.close();
    }

    static boolean isInside(int x, int y, int lim) {
        return x >= 1 && x <= lim && y >= 1 && y <= lim;
    }

    static boolean isSame(int[][] a, int[][] b) {
        int len = a.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    static void printGrid(int[][] g, int sz) {
        int w = 3;
        String line = " ";
        for (int i = 0; i < sz; i++) {
            line += "-".repeat(w) + " ";
        }

        for (int i = 0; i < sz; i++) {
            System.out.println(line);
            for (int j = 0; j < sz; j++) {
                System.out.print("|");
                if (g[i][j] == 0) {
                    System.out.print(" ".repeat(w));
                } else {
                    System.out.printf("%" + w + "d", g[i][j]);
                }
            }
            System.out.println("|");
        }
        System.out.println(line);
    }
}

