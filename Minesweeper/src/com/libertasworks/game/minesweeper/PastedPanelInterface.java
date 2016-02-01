package com.libertasworks.game.minesweeper;

public interface PastedPanelInterface {
	/**
	 * 爆弾以外のボタンクリック時に呼ばれるメソッド
	 * @param x ボタンのX座標
	 * @param y ボタンのY座標
	 */
	public void buttonClicked(int x, int y);
	/**
	 * 爆弾を押した際に呼ばれるメソッド
	 */
	public void bursted();
}
