package com.libertasworks.game.tetris.block;

import com.libertasworks.game.tetris.block.shape.BlockShapeInterface;

public interface BlockInterface {
	/**
	 * ��]�����ău���b�N�̌`����擾����
	 * @return �u���b�N�̌`��
	 */
	public BlockShapeInterface getNextBlockShape();
	/**
	 * ��]�������Ƀu���b�N�̌`����擾����
	 * @return �u���b�N�̌`��
	 */
	public BlockShapeInterface getNowBlockShape();
}
