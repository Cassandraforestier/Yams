package Resources;
import java.util.Scanner;	
	public class DesLeo{
	int valeur, max, min, lancee;
		public DesLeo(int valeur, int max, int min, int lancee){
			this.valeur = valeur;
			this.max = max;
			this.min = min;
			this.lancee = lancee;
		}	

	public void des(int[] des) {
		lancee = 5;
		max = 6;
		min = 1;
		for(int i = 0; lancee>i ; i++) {
			des[i] = (int) (Math.random() * (max - min +1)) + min;
			System.out.println("D�s n� "+ (i+1) + " = " + des[i]);
			
		}
	}
	
	public void relance(int[] des) {
		int relance = 0, numerosDes = 0, babibase = 0;
		String relanceON;
		Scanner scanner1 = new Scanner (System.in);
		Scanner scanner2 = new Scanner (System.in);
		
		
			System.out.println("Voulez vous relancer les d�s ? O/N :");
			relanceON = scanner1.nextLine();
			
			if("O".equals(relanceON) || "o".equals(relanceON)) {  // si oui
				while(relance<3 && "O".equals(relanceON) || "o".equals(relanceON)) {
					relance++;
					System.out.println("Combien de d�s voulez vous relancer ?");
					int nbdes = scanner1.nextInt();
					for(int i=0; i<nbdes; i++) { // boucle pour le nombre de d�s que l'on veut relancer
						System.out.println("Quel d� ?");
						babibase = scanner1.nextInt();
						if(babibase>0 && 5>=babibase) {	//si c'est un chiffre
						babibase--;
						des[babibase] = (int) (Math.random() * (max - min +1)) + min;
						}
						else {	//si c'est une lettre ou sup�rieur � 5 d�s
							System.out.println("Il faut rentrer le num�ros du d� ! (entre 1 et 5)");
							i--;
						}
					}
				System.out.println("Voici votre r�sultat :");
					for(int i = 0; lancee>i ; i++) {
						System.out.println("D�s n� "+ (i+1) + " = " + des[i]);
					}
				}
			}	
			
			else if("N".equals(relanceON) || "n".equals(relanceON)) {	//si non
				System.out.println("Voici votre r�sultat :");
				for(int i = 0; lancee>i ; i++) {
					System.out.println("D�s n� "+ (i+1) + " = " + des[i]);
					relance = 5;
					}
				}
			
			else{
				while(!("O".equals(relanceON) || "o".equals(relanceON) || "N".equals(relanceON) || "n".equals(relanceON))) {	// si un mauvais charact�re est rentr�
					System.out.println("Il faut soit r�pondre O pour oui soit N pour non !\nVoulez vous relancer les d�s ? O/N :");
					relanceON = scanner1.nextLine();
				}
			}
			
		relance++;
		
		}			
	}	
	
	//TODO faire en sorte qu'il ne relance pas plusieurs fois le m�me d�.
