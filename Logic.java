package Game;

public class Logic {
	boolean[][] world;
	public boolean[][] getWorld(){
		return world;
	}
	public void setWorld(boolean[][] world){
		this.world=world;
	}
	public boolean [][] cellStateChange(){
		boolean[][] copy=getWorld();
		for(int i=0;i<world.length;i++){
			for(int j=0;j<world[i].length;j++){
				int count=getNeighbors(i,j);
				
				if(count==3){
					copy[i][j]=true;
				}else if(count==2){
					
				}else {
					copy[i][j]=false;
				}
			}
		}
		world=copy;
		return copy;
	}
	public int getNeighbors(int x,int y){
		int count=0;
		for(int i=x-1;i<=x+1;i++){
			for(int j=y-1;j<=y+1;j++){
				if(i<0||i>=world.length||j<0||j>=world.length){
					continue;
				}
				if(world[i][j]){
					count++;
				}
			}
		}
		if(world[x][y]){
			count--;
		}
		System.out.println(count);
		return count;
	}
}
