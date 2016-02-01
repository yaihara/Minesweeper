package com.libertasworks.game.tetris.block.shape;

public class LineBlockShape2 implements BlockShapeInterface{

	private static BlockShapeInterface instance = null;

	private LineBlockShape2(){
	}

	public static BlockShapeInterface getInstance(){
		if (instance == null){
			instance = new LineBlockShape2();
		}
		return instance;
	}

	@Override
	public int[][] getShapeCoodinate() {
		return new int[][] {{1, 0}, {1, 1}, {1, 2}, {1,3}};
	}

}
