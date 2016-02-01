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
	 * �{�^���̏�ɔ킹�ăN���b�N�o���Ȃ��悤�ɂ���p�l��
	 */
	private JPanel coverPanel = null;
	/**
	 * �{�^�����悹��p�l��
	 */
	private JPanel buttonPanel = null;
	private JPanel labelPanel = null;
	private JLabel numberLabel = null;
	/**
	 * �O�����烍�b�N���ăN���b�N�ł��Ȃ��悤�ɂ���p�l��
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
	 * ��ʏ�����
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
	 * �R���X�g���N�^
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
					//�������Ȃ�
				}
			});
		}
		return lockPanel;
	}

	/**
	 * �{�^�������N���b�N�������̓���
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
	 * ���̃{�^�������e���ǂ�����Ԃ�
	 * @return true/false
	 */
	public boolean isBomb(){
		return bBomb;
	}
	/**
	 * ���̃{�^���͊��ɊJ�������ǂ�����Ԃ�
	 * @return true/false
	 */
	public boolean isOpen(){
		return bOpen;
	}
	/**
	 * ���̃{�^���̎��͂ɂ��锚�e����ݒ�
	 * @param number
	 */
	public void setBombNumber(int number){
		this.number_bomb = number;
		numberLabel.setText(String.valueOf(number));
	}

	/**
	 * �{�^���N���b�N���ɌĂ΂�郁�\�b�h
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
	 * �N���b�N�K�[�h�p�p�l�����N���b�N���ꂽ�Ƃ��ɌĂ΂�郁�\�b�h
	 * @param event MouseEvent
	 */
	private void coverPanelMouseMouseClicked(MouseEvent event) {

		int button = event.getButton();
		switch (button) {
		case MouseEvent.BUTTON1:
			//�������Ȃ�
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
	 * ���̃{�^���𔚒e�Ƃ��Đݒ肷��
	 */
	public void setBomb(){
		this.bBomb = true;
		this.setBackground(Color.RED);
	}
	/**
	 * ���̃{�^�����g�̍��W�A����ѓ\��t�����Ă���p�l����ݒ�
	 * @param x X���W
	 * @param y Y���W
	 * @param panel �\��t����ꂽ�p�l��
	 */
	public void setXYPalent(int x, int y, PastedPanelInterface panel){
		this.x = x;
		this.y = y;
		this.pastedPanel = panel;
	}
	/**
	 * ���݃N���b�N�K�[�h����Ă��邩
	 * @return true/false
	 */
	public boolean isGurd(){
		return bGurd;
	}
	/**
	 * �{�^������ؐG��Ȃ�����<br>
	 * �Q�[���I�����g�p
	 */
	public void lock(){
		lockPanel.setVisible(true);
	}
	/**
	 * �Q�[���I�[�o�[���̌��ʕ\�����s��
	 */
	public void markBomb() {
		if (bBomb && !bOpen && !bGurd){
			bombButton.setBackground(Color.ORANGE);
		} else if (!bBomb && bGurd){
			bombButton.setBackground(Color.CYAN);
		}

	}
}  //  @jve:decl-index=0:visual-constraint="10,10"
