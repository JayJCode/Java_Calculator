package kalkulator;

public class Calculator {
	private int state = 0;
	private int memory = 0;
	
	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	public int getMem() {
		return memory;
	}
	
	public void setMem() {
		memory = state;
	}

	public void add(int value){
		state += value;
	}

	public void mult(int value){
		state *= value;
	}
	
	public void sub(int value){
		state -= value;
	}
	
	public void div(int value){
		try {
			state /= value;
		}
		catch(Exception e) {
			System.out.println("Nie dziel przez zero :)");
		}
	}
}
