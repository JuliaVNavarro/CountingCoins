class Main {
  public static void main(String[] args) {
    int[][] grid = generate_case(5);
    display_grid(grid);

    System.out.println();
    solve(grid);

    display_grid(grid);
}

public static int solve(int[][] grid) {
    int boyCoins_total = 0;
    int double_check = 0;
    do {
        boyCoins_total += row(grid);
        boyCoins_total += col(grid);
        double_check += 1;
    } while (double_check != 4);

    System.out.println("Total coins added: " + boyCoins_total);
    return boyCoins_total;
}

public static int[][] generate_case(final int N) {
    if (N > 0) {
        final int[][] grid = new int[N][N];

        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                grid[i][j] = (int) Math.round(Math.random() * N);
            }
        }

        return grid;
    } else {
        throw new IllegalArgumentException("Invalid grid size specified: " + Integer.toString(N));
    }
}

public static int col(int[][] grid) {
    int boyCoins_col = 0;

    // columns
    for (int a = 0; a < grid.length; a++) {
        for (int b = 0; b < grid.length; b++) {

            // generate a max #prev that comes before the current #a
            int maxPrev_col = 0;
            // iterate all #'s above the current #a
            for (int c = a - 1; c >= 0; c--) {
                // if prev #c is > current #a and max #prev is < previous #c
                if (grid[c][b] > grid[a][b] && maxPrev_col < grid[c][b]) {
                    // max #prev is now prev #c
                    maxPrev_col = grid[c][b];
                }
            }

            // generate a max #next that comes after the current #a
            int maxNext_col = 0;
            // iterate all numbers below the current #a
            for (int d = a + 1; d < grid.length; d++) {
                // if next #d is > current #a && max #next is < next #d
                if (grid[d][b] > grid[a][b] && maxNext_col < grid[d][b]) {
                    // max #next is now next #d
                    maxNext_col = grid[d][b];
                }
            }

            // if both max #prev AND max #next are > current #a
            if (maxPrev_col > grid[a][b] && maxNext_col > grid[a][b]) {
                // if max #prev >= max #next
                if (maxPrev_col >= maxNext_col) {
                    // calculate how many coins will be added by turning current #a to max #next
                    boyCoins_col += maxNext_col - grid[a][b];
                    grid[a][b] = maxNext_col;
                    // otherwise you will calculate how many coins will be added by turning current
                    // #a to max #prev
                } else {
                    boyCoins_col += maxPrev_col - grid[a][b];
                    grid[a][b] = maxPrev_col;
                }
            }
        }
    }

    return boyCoins_col;
}

public static int row(int[][] grid) {
    int boyCoins_row = 0;

    // rows
    for (int i = 0; i < grid.length; i++) {
        for (int j = 0; j < grid.length; j++) {

            // Generate a max #prev that comes before the current #j
            int maxPrev_row = 0;
            // iterate all #'s to the left of the current #j
            for (int k = j - 1; k >= 0; k--) {
                // if previous #k is > current #j AND max #prev is < previous #k
                if (grid[i][k] > grid[i][j] && maxPrev_row < grid[i][k]) {
                    // max #prev is now previous #k
                    maxPrev_row = grid[i][k];
                }
            }
            // Generate a max that comes after the current #j
            int maxNext_row = 0;
            // iterate all numbers to the right of the current #j
            for (int l = j + 1; l < grid.length; l++) {
                // if next #l is > current #j && max #next is < next #l
                if (grid[i][l] > grid[i][j] && maxNext_row < grid[i][l]) {
                    // max #next is now next #l
                    maxNext_row = grid[i][l];
                }
            }

            // if both max #prev AND max #next are > current #j
            if (maxPrev_row > grid[i][j] && maxNext_row > grid[i][j]) {
                // if max #prev is >= max #next
                if (maxPrev_row >= maxNext_row) {
                    // calculate how many coins will be added by turning current #j to max #next
                    boyCoins_row += maxNext_row - grid[i][j];
                    grid[i][j] = maxNext_row;
                    // otherwise you will calculate how many coins will be added by turning current
                    // #j to max #prev
                } else {
                    boyCoins_row += maxPrev_row - grid[i][j];
                    grid[i][j] = maxPrev_row;
                }
            }
        }
    }
    return boyCoins_row;
}

public static void display_grid(final int[][] grid) {
    for (final int[] element : grid) {
        String buffer = "";

        for (int j = 0; j < (element.length - 1); ++j) {
            buffer += Integer.toString(element[j]) + ", ";
        }
        buffer += Integer.toString(element[element.length - 1]);

        System.out.println(buffer);
    }
}
}