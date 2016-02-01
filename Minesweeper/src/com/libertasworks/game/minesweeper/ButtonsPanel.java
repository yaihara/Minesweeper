package com.libertasworks.game.minesweeper;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

public class ButtonsPanel extends JPanel implements PastedPanelInterface{

	private static final long serialVersionUID = 1L;
	private final int xGrid;
	private final int yGrid;
	private final int bombs;
	private BombButtonPanel[][] bombButtons;
	private int openedButton = 0;
	private int BUTTON_LENGTH = 20;

	/**
	 * コンストラクタ
	 *
	 * @param xGrid 横グリッド数
	 * @param yGrid 縦グリッド数
	 * @param bombs 爆弾数
	 */
	public ButtonsPanel(int xGrid, int yGrid,int bombs) {
		super();
		this.xGrid = xGrid;
		this.yGrid = yGrid;
		this.bombs = bombs;
		initialize();
		initBombs();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		GridLayout gridLayout = new GridLayout();
		gridLayout.setColumns(xGrid);
		gridLayout.setRows(yGrid);
		this.setLayout(gridLayout);
	}

	/**
	 * 爆弾ボタンの配置
	 */
	private void initBombs() {
		/*
		 * BombButtonPanel配列の初期化
		 */
		bombButtons = new BombButtonPanel[xGrid][yGrid];
		ArrayList<BombButtonPanel> tmpLinearArray = new ArrayList<BombButtonPanel>();
		for (int y = 0; y < yGrid; y++){
			for (int x = 0; x < xGrid; x++){
				bombButtons[x][y] = new BombButtonPanel();
				bombButtons[x][y].setXYPalent(x, y, this);
				bombButtons[x][y].setPreferredSize(new Dimension(BUTTON_LENGTH, BUTTON_LENGTH));
				this.add(bombButtons[x][y]);
				tmpLinearArray.add(bombButtons[x][y]);
			}
		}

		/*
		 * ランダムに爆弾をセット
		 */
		Collections.shuffle(tmpLinearArray);
		for (int i = 0; i < bombs; i++){
			tmpLinearArray.get(i).setBomb();
		}

	}

	@Override
	public void buttonClicked(int x, int y) {
		openedButton++;
		if (openedButton == (xGrid * yGrid - bombs))
			clearGame();

		int aroundBombs = searchAroundBombs(x, y);
		if (aroundBombs == 0){
			for (int iy = y - 1; iy <= y + 1; iy++){
				if (iy < 0 || iy >= yGrid)
					continue;

				for (int ix = x - 1; ix <= x + 1; ix++){
					if (ix < 0 || ix >= xGrid)
						continue;
					if (!bombButtons[ix][iy].isGurd())
						bombButtons[ix][iy].openButton();
				}
			}
		} else {
			bombButtons[x][y].setBombNumber(aroundBombs);
		}

	}

	/**
	 * ゲームクリア用メソッド
	 */
	private void clearGame() {
		for (int y = 0; y < yGrid; y++){
			for (int x = 0; x < xGrid; x++){
				bombButtons[x][y].lock();
			}
		}
		JOptionPane.showMessageDialog(this, "ゲームクリアです");

	}

	/**
	 * 指定された座標のボタンの周りの爆弾数を返す
	 * @param x X座標
	 * @param y Y座標
	 * @return 爆弾数
	 */
	private int searchAroundBombs(int x, int y){
		int sum = 0;
		for (int iy = y - 1; iy <= y + 1; iy++){
			if (iy < 0 || iy >= yGrid)
				continue;

			for (int ix = x - 1; ix <= x + 1; ix++){
				if (ix < 0 || ix >= xGrid)
					continue;

				if (bombButtons[ix][iy].isBomb()){
					sum++;
				}
			}
		}
		return sum;
	}

	@Override
	public void bursted() {
		for (int y = 0; y < yGrid; y++){
			for (int x = 0; x < xGrid; x++){
				bombButtons[x][y].markBomb();

				bombButtons[x][y].lock();
			}
		}

	}
}
