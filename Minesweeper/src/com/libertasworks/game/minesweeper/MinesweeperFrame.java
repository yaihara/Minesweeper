package com.libertasworks.game.minesweeper;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class MinesweeperFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private ButtonsPanel buttonsPanel = null;
	private JPanel controlPanel = null;
	private JButton controlButton = null;
	private int BOMB_HEIGHT = 20;
	private int BOMB_WIDTH = 30;
	private int BOMB_NUMBER = 30;

	/**
	 * This method initializes buttonsPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private ButtonsPanel getButtonsPanel() {
//		if (buttonsPanel == null) {
			buttonsPanel = new ButtonsPanel(BOMB_WIDTH, BOMB_HEIGHT, BOMB_NUMBER);
			buttonsPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED));
//		}
		return buttonsPanel;
	}

	/**
	 * This method initializes controlPanel
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getControlPanel() {
		if (controlPanel == null) {
			GridBagConstraints gridBagConstraints = new GridBagConstraints();
			gridBagConstraints.insets = new Insets(5, 0, 5, 0);
			controlPanel = new JPanel();
			controlPanel.setLayout(new GridBagLayout());
			controlPanel.add(getControlButton(), gridBagConstraints);
		}
		return controlPanel;
	}

	/**
	 * This method initializes controlButton
	 *
	 * @return javax.swing.JButton
	 */
	private JButton getControlButton() {
		if (controlButton == null) {
			controlButton = new JButton();
			controlButton.setText("Retry");
			controlButton.setPreferredSize(new Dimension(60, 30));
			controlButton.setMargin(new Insets(0, 0, 0, 0));
			controlButton.addActionListener(new java.awt.event.ActionListener() {
				public void actionPerformed(java.awt.event.ActionEvent e) {
					resetGame();
				}
			});
		}
		return controlButton;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MinesweeperFrame thisClass = new MinesweeperFrame();
				thisClass.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				thisClass.setVisible(true);
			}
		});
	}

	/**
	 * This is the default constructor
	 */
	public MinesweeperFrame() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 *
	 * @return void
	 */
	private void initialize() {
		this.setSize(300, 200);
		this.setContentPane(getJContentPane());
		this.setTitle("Minesweeper");
		this.setResizable(false);
		this.pack();
	}

	/**
	 * This method initializes jContentPane
	 *
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getButtonsPanel(), BorderLayout.CENTER);
			jContentPane.add(getControlPanel(), BorderLayout.NORTH);
		}
		return jContentPane;
	}

	/**
	 * ゲームをリセットする
	 */
	private void resetGame() {
		jContentPane.remove(buttonsPanel);
		jContentPane.add(getButtonsPanel(), BorderLayout.CENTER);
		jContentPane.revalidate();
	}

}
