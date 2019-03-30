package com.flipkart.tetris.tetriminos;

public interface Tetriminos {
  
  
  public boolean addToGrid(int[][] grid, int m, int n);
  
  public boolean run(int[][] grid, int m, int n);
  
  public void removeFromGrid(int[][] grid, int m, int n);
  
}