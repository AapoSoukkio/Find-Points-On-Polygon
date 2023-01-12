package main;

import java.io.IOException;
import java.io.FileWriter;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		int[][] polygonPoints = { { 1, 2 }, { 3, 4 }, { 5, 4 }, { 6, 3 }, { 3, 1 } };

		try {
			FileWriter myWriter = new FileWriter("polygoni.txt");

			for (int i = 0; i < polygonPoints.length; i++) {
				if (i > 0)
					myWriter.write("\n");
				for (int k = 0; k < polygonPoints[i].length; k++) {
					myWriter.write(polygonPoints[i][k] + " ");
				}
			}
			myWriter.close();
			System.out.println("Successfully wrote to the polygoni.txt file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		int[][] randomPoints = new int[5][2];
		Random random = new Random();

		//Generoidaan random kordinaatit "pisteille"
		for (int i = 0; i < randomPoints.length; i++) {
			for (int j = 0; j < randomPoints[i].length; j++) {
				randomPoints[i][j] = random.nextInt(1, 10); 
			}
		}

		try {
			FileWriter myWriter = new FileWriter("pisteet.txt");

			for (int i = 0; i < randomPoints.length; i++) {
				if (i > 0)
					myWriter.write("\n");
				for (int k = 0; k < randomPoints[i].length; k++) {
					myWriter.write(randomPoints[i][k] + " ");
				}
			}
			myWriter.close();
			System.out.println("Successfully wrote to the pisteet.txt file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

		Points compareObj = new Points();
		compareObj.readFiles();

	}
}
