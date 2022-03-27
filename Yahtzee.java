
/*
 * Kevin Feng (kfeng58)
 * This program is responsible for taking die rolls using a separate class "Dice.java",
 * calculating the number of number rolled, using that to list the available scores in
 * an array, and returning the highest available score along with its index. The class
 * can also compare 2 different dice roll arrays, and return the numbers rolled in a
 * formatted string.
 */

public class Yahtzee {
	private Dice[] dice;
	
	//Constructor #1 - Responsible for initializing a new dice object and filling each of the indices so that it isn't null.
	public Yahtzee() {
		dice = new Dice[5];
		for (int i = 0; i < 5; i ++) {
			dice[i] = new Dice();
			dice[i].roll();
		}
	}
	
	//Constructor #2 - Acts as a setter.
	public Yahtzee(Dice[] dice) {
		this.dice = dice;
	}
	
	//Counting the number of numbers rolled.
	public int[] getValueCount() {
		int numAmount[] = {0, 0, 0, 0, 0, 0};
		for (int i = 0; i < 5; i ++) {
			if (this.dice[i].getValue() == 1) {
				numAmount[0] ++;
			}
			else if (this.dice[i].getValue() == 2) {
				numAmount[1] ++;
			}
			else if (this.dice[i].getValue() == 3) {
				numAmount[2] ++;
			}
			else if (this.dice[i].getValue() == 4) {
				numAmount[3] ++;
			}
			else if (this.dice[i].getValue() == 5) {
				numAmount[4] ++;
			}
			else if (this.dice[i].getValue() == 6) {
				numAmount[5] ++;
			}
		}
		return numAmount;
	}
	
	//Using the getValueCount method to calculate the scores for each of the 13 conditions.
	public int[] getScoreOptions() {
		int[] values = getValueCount();
		int[] scores = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		int total = 0;
		int aVar = 0;
		
		//Assigning the scores for individual numbers at their respected indices.
		scores[0] = 1 * values[0];
		scores[1] = 2 * values[1];
		scores[2] = 3 * values[2];
		scores[3] = 4 * values[3];
		scores[4] = 5 * values[4];
		scores[5] = 6 * values[5];
		
		//Calculating the total and assigning the value to the 12th index. The variable will also be assigned to indices corresponding to .
		for (int i = 1; i < values.length + 1; i ++) {
			total = total + i * values[i - 1];
		}
		scores[12] = total;
		
		//Counting the number of repeated numbers there are and determining if there are any possible options to be calculated. Assigning them to their corresponding index if there is.
		for (int j = 0; j < 6; j ++) {
			if (values[j] >= 3) {
				scores[6] = total;
				for (int a = 0; a < 6; a ++) {
					if (values[a] == 2) {
						scores[8] = 25;
					}
				}
			}
			if (values[j] >= 4) {
				scores[7] = total;
			}
			if (values[j] == 5) {
				scores[11] = 50;
			}
			
			//Counting the amount of consecutive numbers there are to determine if a straight exists in the array. Adding the corresponding score to its index if one exists.
			if (values[j] != 0) {
				aVar ++;
				if (aVar >= 4) {
					scores[9] = 30;
				}
				if (aVar >= 5) {
					scores[10] = 40;
				}
			}
			else {
				aVar = 0;
			}
		}
		return scores;
	}
	
	//Returning an index containing the max value scored as well as its index.
	public int[] score() {
		int[] scores = getScoreOptions();
		int[] maxScores = {0, 0};
		maxScores[0] = scores[0];
		maxScores[1] = 0;
		for (int i = 0; i < scores.length; i ++) {
			if (maxScores[0] < scores[i]) {
				maxScores[0] = scores[i];
				maxScores[1] = i;
			}
		}
		return maxScores;
	}
	
	//Determining if 2 dice roll arrays are the same.
	public boolean equals(Yahtzee other) {
		for (int i = 0; i < 5; i ++) {
			if (this.getValueCount()[i] == (other.getValueCount()[i])) {
			}
			else {
				return false;
			}
		}
		return true;
	}
	
	//Returning a string with formatted dice values.
	public String toString() {
		String a = "Dice: " + "{" + this.dice[0].getValue() + ", " + this.dice[1].getValue() + ", " + this.dice[2].getValue() + ", " + this.dice[3].getValue() + ", " + this.dice[4].getValue() + "}";
		return a;
	}
}
