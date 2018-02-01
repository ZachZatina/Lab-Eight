import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*
 * Zachariah Zatina
 */
public class LabEight {
	
	public static void main(String[] args) {
		// Variable Loop
		Scanner scnr = new Scanner(System.in);
		int[][] batterInfo;
		int numBatters;
		int numAtBats;
		double batAvg;
		double slugPerc;
		BigDecimal[] batterAvg;
		BigDecimal[] sluggerPerc;
		BigDecimal batterAverage;
		BigDecimal sluggerPercentage;
		
		// Prompts the user to enter how many batters they are going to enter information for using validator class
		numBatters = Validator.getInt(scnr, "How many batters do you want to enter information for?: ");
		// initializes the size of arrays (or the first dimension of the batter info array) by using how many batters the user wants to input information for
		batterInfo = new int[numBatters][];
		batterAvg = new BigDecimal[numBatters];
		sluggerPerc = new BigDecimal[numBatters];
		
		// loop to cycle through each row of the 2D array
		for (int i = 0; i < numBatters; i++) {
			// gets the amount of times the 'i' batter has batted
			numAtBats = Validator.getInt(scnr, "How many at bats does batter #" + (i+1) + " have?:");
			// assigns a size of the columns for each different row is based on the number of hits the respective batter has
			batterInfo[i] = new int[numAtBats];
			System.out.println("");
			// lets the user know what values to input for respective types of hits.
			System.out.println("0=out, 1=single, 2=double, 3=triple, 4=home run");
			
			// for loop to get the values for each row per column
			for (int j = 0; j < numAtBats; j++) {
				// users validator class again to get int values within a specified range.
				batterInfo[i][j] = Validator.getInt(scnr, "Result for at bat " + (j + 1) + ": ", 0, 4);
				
			}
			// pushes each row to the method and returns a double value for the average.
			batAvg = getBatAvg(batterInfo[i]);
			// converts the double to BigDecimal to prevent numbers with 9 digits after the decimal
			batterAverage = returnResult(batAvg);
			// writes the big decimal to a new array that holds all the batters's averages
			batterAvg[i] = batterAverage;
			// pushes each row to a new method that returns a value for the slugging percentage
			slugPerc = getSlugPerc(batterInfo[i]);
			// converts the double from the slugging percentage method to BigDecimal
			sluggerPercentage = returnResult(slugPerc);
			// pushes the slugging percentage decimals to a 3rd array.
			sluggerPerc[i] = sluggerPercentage;
			
		}
		
		// for loop to output the average and slugging percentage for each batter.
		for (int i = 0; i < numBatters; i++) {
			System.out.println("Batter " + (i + 1) + " average: " + batterAvg[i] + "     slugging percentage: " + sluggerPerc[i]);
		}
		scnr.close();
	}
	// method for converting arrays to batter average
	public static double getBatAvg(int[] batterInfo) {
		int j = 0;
		for (int i = 0; i < batterInfo.length; i++) {
			if (batterInfo[i] != 0)
				j++;
		}
		double avg = (double)(j) / (double)(batterInfo.length);
		
		return avg;
	}
	
	// method for convertint arrays to slugging percentage
	public static double getSlugPerc(int[] batterInfo) {
		double sum = 0;
		for (int i = 0; i < batterInfo.length; i++) {
			if (batterInfo[i] == 0) {
				continue;
			}
			else {
				sum = sum + batterInfo[i];
			}
		}
		double avg = sum / (double)(batterInfo.length);
		
		return avg;
	}
	
	// method for converting doubles to BigDecimal.
	public static BigDecimal returnResult(double avg) {
		BigDecimal a = new BigDecimal(avg);
		BigDecimal a2 = a.setScale(3, RoundingMode.UP);
		return a2;
	}

}
