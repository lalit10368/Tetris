package com.flipkart.tetris;

import com.flipkart.tetris.grid.Grid;
import com.flipkart.tetris.tetriminos.ITetrimino;
import com.flipkart.tetris.tetriminos.OTetrimino;
import com.flipkart.tetris.tetriminos.Tetriminos;

public class Application {
  
  
  
  public static void main(String ...args) {

    Grid grid = new Grid(10, 10);
    
    Tetriminos iTetrimino = new ITetrimino(0, 0, ITetrimino.Orientation.HORIZONTAL);
    Tetriminos o1Tetrimino = new OTetrimino(1, 2);
    Tetriminos oTetrimino = new OTetrimino(1, 4);
    Tetriminos o2Tetrimino = new OTetrimino(1, 6);
    Tetriminos o3Tetrimino = new OTetrimino(1, 8);
    try {
      grid.addTetrimino(oTetrimino);
      grid.printCurrentState();
      grid.runTetrimino(oTetrimino);

      grid.addTetrimino(o2Tetrimino);
      grid.printCurrentState();
      grid.runTetrimino(o2Tetrimino);

      grid.addTetrimino(o3Tetrimino);
      grid.printCurrentState();
      grid.runTetrimino(o3Tetrimino);
      grid.printCurrentState();
      
      grid.addTetrimino(o1Tetrimino);
      grid.printCurrentState();
      grid.runTetrimino(o1Tetrimino);

      grid.addTetrimino(iTetrimino);
      grid.printCurrentState();
      grid.runTetrimino(iTetrimino);

      
      grid.printCurrentState();
    } catch (Exception e) {
      System.out.println("Error in Initialization");
      e.printStackTrace();
    }
  }
}