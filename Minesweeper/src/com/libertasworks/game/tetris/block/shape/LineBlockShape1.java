package com.libertasworks.game.tetris.block.shape;

public class LineBlockShape1 implements BlockShapeInterface{

	private static  BlockShapeInterface instance = null;
	private LineBlockShape1(){
	}

	public static BlockShapeInterface getInstance(){
		if (instance == null){
			instance = new LineBlockShape1();
		}
		return instance;
	}

	@Override
	public int[][] getShapeCoodinate() {
		return new int[][] {{0, 1}, {1, 1}, {2, 1}, {3,1}};
	}

}
