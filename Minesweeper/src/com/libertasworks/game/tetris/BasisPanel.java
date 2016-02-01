package com.libertasworks.game.tetris;

import java.awt.Color;

import javax.swing.JPanel;

public class BasisPanel extends JPanel {

	private boolean bBlock = false;

	public boolean isBlock(){
		return bBlock;
	}

	public void inBlock(Color color){
		bBlock = true;
		this.setBackground(color);
	}

	public void outBlock(){
		bBlock = false;
		this.setBackground(null);
	}
}
