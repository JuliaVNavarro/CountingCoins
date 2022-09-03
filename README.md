# CountingCoins

This is a Java program that follows the rules of a game played by two players.

One player will create a grid of coins with different heights and the second player must add the minimum number of coins to the piles by following these restrictions:
1. For any given row x, assume that the maximum height of a pile in that row occurs in column y. Then the heights of the piles must be decreasing outward from column y in row x. Mathematically, for all i < j <= y; h(x, i) <= h(x, j) and for all i > j >= y, h(x, i) <= h(x, j)
2. For any given column x, assume that the maximum height of a pile in that column occurs in row y. Then the heights of the piles must be decreasing outward from row y in column x. Mathematically, for all i < j <= y, h(i, x) <= h(j, x) and for all i > j >= y, h(i, x) <= h(j, x).
