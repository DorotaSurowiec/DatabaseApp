package studentdatabaseapp;

public interface MenuStrategy {
	
	public boolean accept(int choosenOperation);
	
	public void run();
	
}
