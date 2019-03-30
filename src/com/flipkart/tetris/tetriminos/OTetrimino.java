package com.flipkart.tetris.tetriminos;

public class OTetrimino implements Tetriminos {
  
  int x, y;
  
  public OTetrimino(int x, int y) {
    this.x = x;
    this.y = y;
  }
  
  @Override
  public boolean addToGrid(int grid[][], int m, int n) {
    if ((this.x < m && this.x - 1 > 0 ) || (this.y < n && this.y + 1 < n)) {
      int i = this.x, j = this.y;
      grid[i][j] = 1;
      grid[i - 1][j] = 1;
      grid[i][j + 1] = 1;
      grid[i - 1][j + 1] = 1;
      return true;
    }
    return false;
  }

  @Override
  public void removeFromGrid(int grid[][], int m, int n) {
    if ((x < m && x - 1 > 0 ) || (y < n && y + 1 < n)) {
      int i = x, j = y;
      grid[i][j] = 0;
      grid[i - 1][j] = 0;
      grid[i][j + 1] = 0;
      grid[i - 1][j + 1] = 0;
    }
  }

  @Override
  public boolean run(int grid[][], int m, int n) {
    if(x == m - 1)
      return true;
    int i = x;
    int j = y;
    while(i < m - 1 && grid[i + 1][j] == 0 && grid[i + 1][j + 1] == 0)
      i++;
    this.removeFromGrid(grid, m, n);
    this.x = i;
    return this.addToGrid(grid, m, n);
  }
  
}