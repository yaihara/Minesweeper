package com.libertasworks.game.tetris.block.shape;

/**
 * �u���b�N�̈��2�������W�����C���^�[�t�F�[�X
 * �u���b�N�͂��̃C���^�[�t�F�[�X���p������
 * �N���X�𕡐������A���݂̏�Ԃ�\���N���X��ς��邱�Ƃ�
 * ��]�ɑΉ�����B
 * @author Yas
 *
 */
public interface BlockShapeInterface {

	/**
	 * �`�������2�������W��Ԃ��B
	 * @return ���W [2][4]�ƂȂ�B
	 *
	 * (x1,y1),(x2,y2)...4��4�̃u���b�N�̊e���W�������B
	 */
	public int[][] getShapeCoodinate();
}
