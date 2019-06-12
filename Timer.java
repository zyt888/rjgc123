package Game;

public class Timer extends Thread{
	Logic lifeGame=new Logic();
	Map worldMap;
	
	public Timer(Map wp){
		this.worldMap=wp;
		this.lifeGame.setWorld(worldMap.getWorld());
	}
	public void run(){
		
		while(true){
			lifeGame.cellStateChange();
			
			worldMap.repaint();
			try{
				Thread.sleep(1000);
			}catch(InterruptedException e){
				e.printStackTrace();
			}
		}
	}
}