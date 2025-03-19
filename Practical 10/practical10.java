import java.util.Random;

class Practical10 {
    String[][] inData;
    String[][] sData;
    int n = 0;
    Random rand = new Random();

    Practical10(String size) {
        this.n = Integer.parseInt(size);
        this.inData = new String[this.n][this.n];
        this.sData = new String[this.n][this.n];

        for (int i = 0; i < this.n; i++) {
            for (int j = 0; j < this.n; j++) {
                sData[i][j] = "";
            }
        }
    }

    void genLayout(String[] input) {
        int idx = 0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (idx < input.length) {
                    inData[r][c] = input[idx++];
                }
            }
        }
    }

    void gridView(String[][] data) {
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                System.out.print("|");
                System.out.print(data[r][c].isEmpty() ? " " : data[r][c]);
                System.out.print("|");
            }
            System.out.println();
            if (r != n - 1) {
                for (int j = 0; j < n; j++) {
                    System.out.print("---");
                }
            }
            System.out.println();
        }
    }

    void genSudoku() {
        for (int i = 0; i < 2 * sData.length; i++) {
            int r = rand.nextInt(sData.length);
            int c = rand.nextInt(sData.length);
            sData[r][c] = " ".repeat(Integer.toString(sData.length).length());
        }

        gridView(sData);
    }

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Please provide a size for the Sudoku grid.");
            return;
        }

        int size = Integer.parseInt(args[0]);
        Practical10 p = new Practical10(args[0]);

        // Generating a simple grid with sequential numbers for testing purposes
        String[] input = new String[size * size];
        for (int i = 0; i < input.length; i++) {
            input[i] = Integer.toString(i + 1);
        }

        p.genLayout(input);
        System.out.println("Grid View As per Input Size:");
        p.gridView(p.inData);
        System.out.println();
        System.out.println("Sudoku box:");
        p.genSudoku();
    }
}

