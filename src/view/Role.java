package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.Direction;
import model.Game;

public class Role extends JPanel implements ActionListener {
	JButton up,rigth,down,left;
	Game game;
	
	Role(Game game){
		this.setBackground(Color.RED);
		up=new JButton("Up");
		up.addActionListener(this);
		rigth=new JButton("rigth");
		rigth.addActionListener(this);
		down=new JButton("down");
		down.addActionListener(this);
		left=new JButton("left");
		left.addActionListener(this);
		this.add(up);
		this.add(rigth);
		this.add(down);
		this.add(left);
		this.game=game;
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==up){
			System.out.println("up");
			game.changeSnakeDirection(Direction.Up);
		}
		if(e.getSource()==rigth){
			System.out.println("rigth");
			game.changeSnakeDirection(Direction.Right);
		}
		if(e.getSource()==down){
			System.out.println("down");
			game.changeSnakeDirection(Direction.Down);
		}
		if(e.getSource()==left){
			System.out.println("left");
			game.changeSnakeDirection(Direction.Left);
		}
	}
}
