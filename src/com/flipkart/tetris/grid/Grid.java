package com.flipkart.tetris.grid;

import com.flipkart.tetris.tetriminos.Tetriminos;

public class Grid {
  int m, n;
  
  int[][] grid;
  
  public Grid(int m, int n) {
    this.m = m;
    this.n = n;
    grid = new int[m][n];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
         grid[i][j] = 0;
      }
    }
  }
  
  public boolean checkLine() {
    int i = m - 1;
    int j = 0;
    while(j < n) {
      if(grid[i][j] == 0) {
        return false;
      }
      j++;
    }
    return true;
  }
  
  public void shiftGrid() {
    for(int i = m - 1; i > 1; i--) {
      for(int j = 0; j < n; j++) {
        grid[i][j] = grid[i - 1][j];
        grid[i - 1][j] = 0;
      }
    }
  }
  
  public void printCurrentState() {
    System.out.println("Current State of Grid");
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        System.out.print(grid[i][j]);
        System.out.print(" ");
      }
      System.out.println();
    }
  }
  
  public void addTetrimino(Tetriminos tetrimino) throws Exception {
    if(!tetrimino.addToGrid(grid, m, n)) {
      throw new Exception("Unable to add Tetrimino");
    }
  }
  
  public void runTetrimino(Tetriminos tetrimino) {
    tetrimino.run(grid, m, n);
    while(checkLine()) {
      shiftGrid();
    }
  }
  
}