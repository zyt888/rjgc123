package Game;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class Map extends JFrame implements ActionListener,MouseListener{
    
	private int xOffset=100;
	private int yOffset=100;
	
	private int size=10;
	private int gridSize=30;
	
	private boolean[][] world=new boolean[size][size];
	
	JButton startButton;
	
	
	public boolean[][] getWorld(){
		return world;
	}
	public Map(){
		this.setBounds(500,500,510,510);
		this.setTitle("…˙√¸”Œœ∑");
		this.setLayout(null);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		
		startButton=new JButton("Start");
		startButton.setBounds(400,400,80,30);
		startButton.addActionListener(this);
		this.addMouseListener(this);
		startButton.setVisible(true);
		this.add(startButton);
		
	}
	public void paint(Graphics g){
		g.clearRect(0, 0, 500, 500);
		size=world.length;
		for(int i=0;i<=size;i++){
			g.drawLine(xOffset,yOffset+i*gridSize,xOffset+size*gridSize, yOffset+i*gridSize);
		}
		for(int i=0;i<=size;i++){
			g.drawLine(xOffset+i*gridSize,yOffset,xOffset+i*gridSize,yOffset+size*gridSize);
		}
		for(int x=0;x<size;x++){
			for(int y=0;y<size;y++){
				if(world[x][y]){
					g.fillRect(xOffset+x*gridSize,yOffset+y*gridSize,gridSize-1,gridSize-1);
				}
			}
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		new Timer(this).start();
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int x=(e.getX()-xOffset)/gridSize;
		int y=(e.getY()-yOffset)/gridSize;
		System.out.println(x+" "+y);
		try{
			world[x][y]=!world[x][y];
		}catch(Exception ex){
			startButton.doClick();
		}
		this.repaint();
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
