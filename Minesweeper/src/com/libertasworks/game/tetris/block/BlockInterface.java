package com.libertasworks.game.tetris.block;

import com.libertasworks.game.tetris.block.shape.BlockShapeInterface;

public interface BlockInterface {
	/**
	 * 回転させてブロックの形状を取得する
	 * @return ブロックの形状
	 */
	public BlockShapeInterface getNextBlockShape();
	/**
	 * 回転させずにブロックの形状を取得する
	 * @return ブロックの形状
	 */
	public BlockShapeInterface getNowBlockShape();
}
