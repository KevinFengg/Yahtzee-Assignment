
public class ATESTER {
	
	private Dice[] aDice;
	public static void main(String[] args) {
		Yahtzee game2;
		Dice[] dice2 = new Dice[] {new Dice(2), new Dice(5), new Dice(3), new Dice(5), new Dice(6)};
		game2 = new Yahtzee(new Dice[] {new Dice(2), new Dice(5), new Dice(3), new Dice(5), new Dice(6)});
		int[] anArray = {2, 1, 0, 0, 1, 1};
		int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int total = 0;
		int straight = 0;
		int aVar = 0;
		int[] maxScores = {0, 0};
		
		for (int i = 0; i < 5; i ++) {
			dice2[i].roll();
			//System.out.println(dice2[i].getValue());
			//System.out.println(anArray[i]);
		}
		
		scores[0] = 1 * anArray[0];
		scores[1] = 2 * anArray[1];
		scores[2] = 3 * anArray[2];
		scores[3] = 4 * anArray[3];
		scores[4] = 5 * anArray[4];
		scores[5] = 6 * anArray[5];
		
		for (int k = 1; k < 7; k ++) {
			total = total + k * anArray[k - 1];
		}
		
		//This is all for 3, 4, and 5 dice of same value + full house.
		for (int j = 0; j < 6; j ++) {
			if (anArray[j] == 3) {
				for (int a = 0; a < 6; a ++) {
					if (anArray[a] == 2) {
						scores[8] = 25;
					}
				}
				scores[6] = total;
			}
			if (anArray[j] == 4) {
				scores[7] = total;
			}
			if (anArray[j] == 5) {
				scores[11] = total;
			}
			
			if (anArray[j] != 0) {
				aVar ++;
			}
			else {
				aVar = 0;
			}
		}
		
		if (aVar >= 4) {
			scores[9] = 30;
		}
		if (aVar >= 5) {
			scores[10] = 40;
		}
		
		scores[12] = total;
		for (int b = 0; b < 13; b ++) {
			System.out.println(scores[b]);
		}
		
		System.out.println();
		
		maxScores[0] = scores[0];
		maxScores[1] = 0;
		for (int i = 0; i < scores.length; i ++) {
			if (scores[0] < scores[i]) {
				maxScores[0] = scores[i];
				maxScores[1] = i;
			}
		}
		
	}

}
