package com.libertasworks.game.tetris.block;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import com.libertasworks.game.tetris.block.shape.BlockShapeInterface;
import com.libertasworks.game.tetris.block.shape.LineBlockShape1;
import com.libertasworks.game.tetris.block.shape.LineBlockShape2;

public class LineBlock implements BlockInterface{

	private ArrayList<BlockShapeInterface> blockShapes = new ArrayList<BlockShapeInterface>();
	private int nowNumber;
	private int positionX;
	private int positionY;

	public LineBlock(){
		blockShapes.add(LineBlockShape1.getInstance());
		blockShapes.add(LineBlockShape2.getInstance());
		nowNumber = 0;
	}

	public  void setPosition(int x, int y){
		positionX = x;
		positionY = y;
	}

	@Override
	public BlockShapeInterface getNextBlockShape() {
		int tmpNumber = nowNumber++;
		if (tmpNumber == blockShapes.size()){
			tmpNumber = 0;
		}
		return blockShapes.get(tmpNumber);
	}

	@Override
	public BlockShapeInterface getNowBlockShape() {

		return blockShapes.get(nowNumber);
	}

	public void rotate(){
		nowNumber++;

		if (nowNumber == blockShapes.size()){
			nowNumber = 0;
		}
	}

	public int[][] convertPositionShape(){
		return null;
	}

}
