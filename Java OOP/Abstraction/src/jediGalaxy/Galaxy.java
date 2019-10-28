package jediGalaxy;

public class Galaxy {
    private Star[][] stars;
    private int row;
    private int col;

    public Galaxy(int row, int col) {
        this.row = row;
        this.col = col;
        this.stars = new Star[row][col];
        this.fillStars();
    }

    public void fillStars() {
        int value = 0;
        for (int i = 0; i < this.row; i++) {
            for (int j = 0; j < this.col; j++) {
                this.stars[i][j] = new Star(value++);
            }
        }
    }

    private boolean isInBounds(int playerX, int playerY) {
        return playerX >= 0 && playerX < this.stars.length &&
                playerY >= 0 && playerY < this.stars[playerX].length;
    }

    public int getPlayerSum(int playerX, int playerY) {
        int sum = 0;
        while (playerX >= 0 && playerY < this.stars[1].length) {
            if (isInBounds(playerX, playerY)) {
                sum += this.stars[playerX][playerY].getValue();
            }
            playerY++;
            playerX--;
        }
        return sum;
    }

    public void destroyCells(int evilX, int evilY) {
        while (evilX >= 0 && evilY >= 0) {
            if (isInBounds(evilX, evilY)) {
                this.stars[evilX][evilY] = new Star(0);
            }
            evilX--;
            evilY--;
        }
    }
}
