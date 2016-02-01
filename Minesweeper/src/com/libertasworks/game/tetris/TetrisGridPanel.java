package com.libertasworks.game.tetris;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import com.libertasworks.game.minesweeper.BombButtonPanel;
import com.libertasworks.game.tetris.block.BlockInterface;
import com.libertasworks.game.tetris.block.shape.BlockShapeInterface;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class TetrisGridPanel extends JPanel {

	private int ix;
	private int iy;
	private BasisPanel[][] gridPanels;
	private final int PANEL_LENGTH = 10;
	private final int TIME_INTERVAL = 1000;
	private Timer timer = null;
	private BlockInterface movingBlock;

	/**
	 * This method initializes
	 *
	 */
	public TetrisGridPanel(int x, int y) {
		super();
		ix = x;
		iy = y;
		initialize();
		initTimer();
	}

	/**
	 * This method initializes this
	 *
	 */
	private void initialize() {
        GridLayout gridLayout = new GridLayout(iy, ix);
        this.setLayout(gridLayout);

        gridPanels = new BasisPanel[ix][iy];
		for (int y = 0; y < iy; y++){
			for (int x = 0; x < ix; x++){
				gridPanels[x][y] = new BasisPanel();
				gridPanels[x][y].setPreferredSize(new Dimension(PANEL_LENGTH, PANEL_LENGTH));
				this.add(gridPanels[x][y]);
			}
		}
		gridPanels[1][1].inBlock(Color.BLUE);
		gridPanels[2][2].inBlock(Color.ORANGE);
		gridPanels[2][3].inBlock(Color.RED);
	}

	private void initTimer() {
		timer = new Timer(TIME_INTERVAL, new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {

				moveBlock();
			}

		});

	}

	public void startGame(){
		timer.start();
	}

	private void newBlock(BlockInterface block){
		movingBlock = block;
	}

	private void moveBlock() {


	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(new TetrisGridPanel(10, 20));
		frame.show();
		frame.pack();

	}

}
