package Resources;

import java.util.ArrayList;

public class Des implements Comparable<Des>{

	private int id;
	private int valeur;
	private int retry;
	private static final int MIN = 1;
	private static final int MAX = 6;

	public Des(int id) {
		this.id = id;
		this.valeur = lanceDes();
		this.retry = 0;
	}

	public int lanceDes() {
		retry++;
		if(retry <4) {
			return (int) ((Math.random() * (MAX - MIN +1)) + MIN);			
		}else {
			System.out.println("Vous ne pouvez pas relancer de dès");
			return this.valeur;
		}
	}
	
	public int getValeur() {
		return valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public int getRetry() {
		return retry;
	}

	public void setRetry(int retry) {
		this.retry = retry;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	 * Trie le tableau par ordre croissant des valeurs du des
	 */
	  @Override
	  public int compareTo(Des des) {
	    return Integer.compare(this.getValeur(), des.getValeur());
	  }
}
