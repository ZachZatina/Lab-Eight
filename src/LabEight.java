import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

/*
 * Zachariah Zatina
 */
public class LabEight {
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int[][] batterInfo;
		int numBatters;
		int numAtBats;
		int baseEarned;
		double batAvg;
		double slugPerc;
		BigDecimal[] batterAvg;
		BigDecimal[] sluggerPerc;
		BigDecimal batterAverage;
		BigDecimal sluggerPercentage;
		
		numBatters = Validator.getInt(scnr, "How many batters do you want to enter information for?: ");
		batterInfo = new int[numBatters][];
		batterAvg = new BigDecimal[numBatters];
		sluggerPerc = new BigDecimal[numBatters];

		for (int i = 0; i < numBatters; i++) {
			numAtBats = Validator.getInt(scnr, "How many at bats does batter #" + (i+1) + " have?:");
			batterInfo[i] = new int[numAtBats];
			System.out.println("");
			System.out.println("0=out, 1=single, d=double, 3=triple, 4=home run");
			
			for (int j = 0; j < numAtBats; j++) {
				batterInfo[i][j] = Validator.getInt(scnr, "Result for at bat " + (j + 1) + ": ", 0, 4);
				
			}
			batAvg = getBatAvg(batterInfo[i]);
			batterAverage = returnResult(batAvg);
			batterAvg[i] = batterAverage;
			slugPerc = getSlugPerc(batterInfo[i]);
			sluggerPercentage = returnResult(slugPerc);
			sluggerPerc[i] = sluggerPercentage;
			
		}
		
		for (int i = 0; i < numBatters; i++) {
			System.out.println("Batter " + (i + 1) + " average: " + batterAvg[i] + "     slugging percentage: " + sluggerPerc[i]);
		}
		
	}
	
	public static double getBatAvg(int[] batterInfo) {
		int j = 0;
		for (int i = 0; i < batterInfo.length; i++) {
			if (batterInfo[i] != 0)
				j++;
		}
		double avg = (double)(j) / (double)(batterInfo.length);
		
		return avg;
	}
	
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
	
	public static BigDecimal returnResult(double avg) {
		BigDecimal a = new BigDecimal(avg);
		BigDecimal a2 = a.setScale(3, RoundingMode.UP);
		return a2;
	}

}
