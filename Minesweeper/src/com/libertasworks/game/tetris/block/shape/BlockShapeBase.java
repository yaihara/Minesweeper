package com.libertasworks.game.tetris.block.shape;

/**
 * �u���b�N�̈��2�������W�������ۃN���X
 * �u���b�N�͂��̒��ۃN���X���p������
 * �N���X�𕡐������A���݂̏�Ԃ�\���N���X��ς��邱�Ƃ�
 * ��]�ɑΉ�����B
 * @author Yas
 *
 */
public abstract class BlockShapeBase {

	abstract public BlockShapeBase getInstance();
	/**
	 * �`�������2�������W��Ԃ��B
	 * @return ���W [2][4]�ƂȂ�B
	 * (x1,y1),(x2,y2)...4��4�̃u���b�N�̊e���W�������B
	 */
	abstract public int[][] getShapeCoodinate();
}
