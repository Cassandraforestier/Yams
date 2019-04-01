package Resources;

import static Resources.Combinaison.nombreDes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

import com.sun.javafx.collections.MappingChange.Map;

abstract class Combinaison {

	HashMap<Integer, Des> listDes = initDes();
	HashMap<Integer, Integer> tableauCountDes = getTableauCountDes();
	public static final int nombreDes = 5;

	
	/*
	 * Somme des dés
	 */
	public int chance() {
		int score = 0;
		
		for (Entry<Integer, Des> entry : listDes.entrySet()) {
		    Des des = entry.getValue();
		    score = score + des.getValeur();
		}
		return score;
	}

	public HashMap<Integer, Des> initDes() {
		HashMap<Integer, Des> initlist = new HashMap<>();
		for (int i = 1; i <= nombreDes; i++) {
			initlist.put(i, new Des(i));
		}
		return initlist;
	}

	public HashMap<Integer, Integer> getTableauCountDes() {
		HashMap<Integer, Integer> tableauNombreDes = new HashMap<Integer, Integer>();
		
		for (Entry<Integer, Des> entry : listDes.entrySet()) {
			  Des des = entry.getValue();
			  //Si le tableau n'a pas cette valeur alors on l'ajoute
			if (!tableauNombreDes.containsKey(des.getValeur())) {
				tableauNombreDes.put(des.getValeur(), 1);
			} 
			//Sinon on ajout à la valeur déjà existante +1
			else {
				tableauNombreDes.put(des.getValeur(), tableauNombreDes.get(des.getValeur())+1);
			}
		}
		return tableauNombreDes;
	}
	

	public void relancerDes(Des de) {
		listDes.get(de.getId()).setValeur(de.lanceDes());
	}
	
	/*
	 * Chaque dès identique
	 * Si l'un des counts de dés est égale à la taille maximal de dès alors yams
	 */
	public int yams() {
		boolean same = true;
		if(!tableauCountDes.containsValue(listDes.size())){
			same = false;
		}
		if (same) {
			return 50;
		}
		return 0;
	}

	public int somme1() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 1) {
				score++;
			}
		}
		return score;
	}

	public int somme2() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 2) {
				score = score + 2;
			}
		}
		return score;
	}

	public int somme3() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 3) {
				score = score + 3;
			}
		}
		return score;
	}

	public int somme4() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 4) {
				score = score + 4;
			}
		}
		return score;
	}

	public int somme5() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 5) {
				score = score + 5;
			}
		}
		return score;
	}

	public int somme6() {
		int score = 0;
		for (int i = 0; i < listDes.size(); i++) {
			if (listDes.get(i).getValeur() == 6) {
				score = score + 6;
			}
		}
		return score;
	}

	public int paire() {
		int score = 0;
		for (Entry<Integer, Integer> entry : tableauCountDes.entrySet()) {
			if(entry.getValue() == 2) {
				if( score < entry.getKey()*2) {
					score = entry.getKey() * 2;
				}
			}
		}
		return score;
	}

	/*
	 * Modulo permet une évolutivité et flexibilité du code
	 */
	public int doublePaire() {
		int score = 0;
		int count = 0;

		for (Entry<Integer, Integer> entry : tableauCountDes.entrySet()) {
			if(entry.getValue() % 2 == 0) {
				score = score + (entry.getKey() * entry.getValue());
				count++;
			}
		}
		if(count == 2) {
			return score;
		}
		return 0;
	}
	
	public int brelan() {
		int score = 0;
		for (Entry<Integer, Integer> entry : tableauCountDes.entrySet()) {
			if(entry.getValue() == 3) {
				score = score + (entry.getKey() * entry.getValue());
			}
		}
		return score;
	}
	
	public int petitSuite() {
		if(tableauCountDes.size() == 5 && !tableauCountDes.containsKey(6)) {
			return 30;
		}
		return 0;
	}
	
	public int grandSuite() {
		if(tableauCountDes.size() == 5 && !tableauCountDes.containsKey(1)) {
			return  40;
		}
		return 0;
	}
	
	public int full() {
		if(paire() > 0 && brelan() > 0) {
			return 25;
		}
		return 0;
	}
}
