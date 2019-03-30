package com.flipkart.tetris.tetriminos;

public class ITetrimino implements Tetriminos {
  
  int x, y;
  public enum Orientation {
    VERTICAL,
    HORIZONTAL
  }
  Orientation orientation;
  
  
  public ITetrimino(int x, int y, Orientation orientation) {
    this.x = x;
    this.y = y;
    this.orientation = orientation;
  }
  
  @Override
  public boolean addToGrid(int grid[][], int m, int n) {
    if(this.x < m && this.x >= 3 || (this.y < n && this.y + 4 < n)) {
      int i = this.x - 3, j = this.y;
      
      switch(orientation) {
        case  VERTICAL :
          while(i <= this.x) {
            grid[i][this.y] = 1;
            i++;
          }
          break;
        case HORIZONTAL:
          while(j < this.y + 4) {
            grid[this.x][j] = 1;
            j++;
          }
          break;
      }
      return true;
    }
    return false;
  }
  
  @Override
  public void removeFromGrid(int grid[][], int m, int n) {
    int i = x, j = y;
    switch(orientation) {
      case  VERTICAL :
        while(i > x - 4) {
          grid[i][this.y] = 0;
          i--;
        }
        break;
      case HORIZONTAL:
        while(j < y + 4) {
          grid[this.x][j] = 0;
          j++;
        }
        break;
    }
  }
  
  
  @Override
  public boolean run(int grid[][], int m, int n) {

    if(x == m - 1)
      return true;

    int i = x;
    int j = y;
    
    if(orientation.equals(Orientation.HORIZONTAL)) {
      while(i + 1 < m && grid[i + 1][j] == 0 && grid[i + 1][j + 1] == 0 && grid[i + 1][j + 2] == 0 && grid[i + 1][j + 3] == 0) {
        i++;
      }
      this.removeFromGrid(grid, m, n);
      this.x = i;
    } else {
      while(i < m - 1 && grid[i + 1][j] == 0) {
         i++; 
      }
      this.removeFromGrid(grid, m, n);
      this.x = i;
      
    }
    return this.addToGrid(grid, m, n);
  }
  
}