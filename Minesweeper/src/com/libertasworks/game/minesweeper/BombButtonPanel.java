package com.libertasworks.game.minesweeper;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.OverlayLayout;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;

public class BombButtonPanel extends JPanel {

	private JButton bombButton;
	private boolean bOpen = false;
	private boolean bBomb;
	private int number_bomb;
	private int x;
	private int y;
	private boolean bGurd = false;
	private PastedPanelInterface pastedPanel;

	/**
	 * ボタンの上に被せてクリック出来ないようにするパネル
	 */
	private JPanel coverPanel = null;
	/**
	 * ボタンを乗せるパネル
	 */
	private JPanel buttonPanel = null;
	private JPanel labelPanel = null;
	private JLabel numberLabel = null;
	/**
	 * 外部からロックしてクリックできないようにするパネル
	 */
	private JPanel lockPanel = null;

	private JButton getJButton() {
		if (bombButton == null){
			bombButton = new JButton();
			bombButton.setFocusable(false);
			bombButton.setMargin(new Insets(0, 0, 0, 0));
			bombButton.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					bombButtonMouseMouseClicked(e);
				}
			});
		}
		return bombButton;
	}

	/**
	 * 画面初期化
	 */
	private void initComponents() {
		setLayout(new OverlayLayout(this));
		this.add(getLockPanel(), null);
		this.add(getCoverPanel(), null);
		this.add(getButtonPanel(), null);
		this.add(getLabelPanel(), null);
		this.setBorder(new LineBorder(Color.LIGHT_GRAY));
	}

	/**
	 * コンストラクタ
	 */
	public BombButtonPanel() {
		initComponents();
	}

	/**
	 * This method initializes coverPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getCoverPanel() {
		if (coverPanel == null){
			coverPanel = new JPanel();
			coverPanel.setFocusable(false);
			coverPanel.setLayout(new GridBagLayout());
			coverPanel.setOpaque(false);
			coverPanel.setVisible(false);
			coverPanel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					coverPanelMouseMouseClicked(e);
				}
			});
		}
		return coverPanel;
	}

	/**
	 * This method initializes buttonPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getButtonPanel() {
		if (buttonPanel == null){
			buttonPanel = new JPanel();
			buttonPanel.setFocusable(false);
			buttonPanel.setBorder(new LineBorder(Color.LIGHT_GRAY));
			buttonPanel.setLayout(new BorderLayout());
			buttonPanel.add(getJButton(), BorderLayout.CENTER);
		}
		return buttonPanel;
	}

	/**
	 * This method initializes labelPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getLabelPanel() {
		if (labelPanel == null){
			numberLabel = new JLabel();
			labelPanel = new JPanel();
			labelPanel.setOpaque(false);
			labelPanel.setLayout(new GridBagLayout());
			labelPanel.add(numberLabel);
		}
		return labelPanel;
	}

	/**
	 * This method initializes lockPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getLockPanel() {
		if (lockPanel == null){
			lockPanel = new JPanel();
			lockPanel.setLayout(new GridBagLayout());
			lockPanel.setVisible(false);
			lockPanel.setOpaque(false);
			lockPanel.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseClicked(java.awt.event.MouseEvent e) {
					//何もしない
				}
			});
		}
		return lockPanel;
	}

	/**
	 * ボタンを左クリックした時の動作
	 */
	public void openButton(){
		if (bOpen)
			return;

		bOpen = true;
		buttonPanel.setVisible(false);
		if (bBomb){
			pastedPanel.bursted();
		} else {
			pastedPanel.buttonClicked(x, y);
		}
	}

	/**
	 * このボタンが爆弾かどうかを返す
	 * @return true/false
	 */
	public boolean isBomb(){
		return bBomb;
	}
	/**
	 * このボタンは既に開いたかどうかを返す
	 * @return true/false
	 */
	public boolean isOpen(){
		return bOpen;
	}
	/**
	 * このボタンの周囲にある爆弾数を設定
	 * @param number
	 */
	public void setBombNumber(int number){
		this.number_bomb = number;
		numberLabel.setText(String.valueOf(number));
	}

	/**
	 * ボタンクリック時に呼ばれるメソッド
	 * @param event MouseEvent
	 */
	private void bombButtonMouseMouseClicked(MouseEvent event) {

		int button = event.getButton();
		switch (button) {
		case MouseEvent.BUTTON1:
			openButton();
			break;
		case MouseEvent.BUTTON3:
			coverPanel.setVisible(true);
			bombButton.setText("!");
			bGurd = true;
			break;
		default:
			break;
		}
	}

	/**
	 * クリックガード用パネルをクリックされたときに呼ばれるメソッド
	 * @param event MouseEvent
	 */
	private void coverPanelMouseMouseClicked(MouseEvent event) {

		int button = event.getButton();
		switch (button) {
		case MouseEvent.BUTTON1:
			//何もしない
			break;
		case MouseEvent.BUTTON3:
			coverPanel.setVisible(false);
			bombButton.setText("");
			bGurd = false;
			break;
		default:
			break;
		}
	}

	/**
	 * このボタンを爆弾として設定する
	 */
	public void setBomb(){
		this.bBomb = true;
		this.setBackground(Color.RED);
	}
	/**
	 * このボタン自身の座標、および貼り付けられているパネルを設定
	 * @param x X座標
	 * @param y Y座標
	 * @param panel 貼り付けられたパネル
	 */
	public void setXYPalent(int x, int y, PastedPanelInterface panel){
		this.x = x;
		this.y = y;
		this.pastedPanel = panel;
	}
	/**
	 * 現在クリックガードされているか
	 * @return true/false
	 */
	public boolean isGurd(){
		return bGurd;
	}
	/**
	 * ボタンを一切触れなくする<br>
	 * ゲーム終了時使用
	 */
	public void lock(){
		lockPanel.setVisible(true);
	}
	/**
	 * ゲームオーバー時の結果表示を行う
	 */
	public void markBomb() {
		if (bBomb && !bOpen && !bGurd){
			bombButton.setBackground(Color.ORANGE);
		} else if (!bBomb && bGurd){
			bombButton.setBackground(Color.CYAN);
		}

	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
