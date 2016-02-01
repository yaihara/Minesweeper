package com.libertasworks.game.tetris.block.shape;

/**
 * ブロックの一つの2次元座標を持つインターフェース
 * ブロックはこのインターフェースを継承した
 * クラスを複数持ち、現在の状態を表すクラスを変えることで
 * 回転に対応する。
 * @author Yas
 *
 */
public interface BlockShapeInterface {

	/**
	 * 形状を示す2次元座標を返す。
	 * @return 座標 [2][4]となる。
	 *
	 * (x1,y1),(x2,y2)...4つで4つのブロックの各座標を示す。
	 */
	public int[][] getShapeCoodinate();
}
