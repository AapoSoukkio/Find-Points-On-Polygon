package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Points {

	int x;
	int y;

	public void readFiles() {
		int[] polygonPointsX = new int[5];
		int[] polygonPointsY = new int[5];
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File("polygoni.txt"));
			int i = 0;
			int j = 0;
			while (scanner.hasNextInt()) {
				polygonPointsX[i++] = scanner.nextInt();
				polygonPointsY[j++] = scanner.nextInt();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		int[] randomPointsX = new int[5];
		int[] randomPointsY = new int[5];
		try {
			scanner = new Scanner(new File("pisteet.txt"));
			int i = 0;
			int j = 0;
			while (scanner.hasNextInt()) {
				randomPointsX[i++] = scanner.nextInt();
				randomPointsY[j++] = scanner.nextInt();
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		compare(polygonPointsX, polygonPointsY, randomPointsX, randomPointsY);

	}

	public void compare(int[] polygonPointsX, int[] polygonPointsY, int[] randomPointsX, int[] randomPointsY) {

		Points point = new Points();

		Arrays.sort(polygonPointsX);
		int polygonMaximumX = polygonPointsX[polygonPointsX.length - 1];
		int polygonMinimumX = polygonPointsX[0];
		Arrays.sort(polygonPointsY);
		int polygonMaximumY = polygonPointsY[polygonPointsY.length - 1];
		int polygonMinimumY = polygonPointsY[0];

		System.out.println("polygonin kaukaisin X piste: " + polygonMaximumX);
		System.out.println("polygonin lähinnä origoa oleva X piste: " + polygonMinimumX);
		System.out.println("polygonin kaukaisin Y piste: " + polygonMaximumY);
		System.out.println("polygonin lähinnä origoa oleva Y piste: " + polygonMinimumY);

		int[] hitsX = new int[5];
		int[] hitsY = new int[5];
		int[] missX = new int[5];
		int[] missY = new int[5];

		for (int i = 0; i < randomPointsY.length; i++) {
			point.x = randomPointsX[i];
			point.y = randomPointsY[i];
			if (point.x > polygonMaximumX || point.x < polygonMinimumX || point.y > polygonMaximumY
					|| point.y < polygonMinimumY) {
				System.out.println("(" + point.x + ", " + point.y + ") Ei ole polygonin sisällä");
				missX[i] = point.x;
				missY[i] = point.y;
			} else {
				System.out.println("(" + point.x + ", " + point.y + ") On polygonin sisällä tai hyvin lähellä");
				hitsX[i] = point.x;
				hitsY[i] = point.y;
			}

		}

		summary(hitsX, hitsY, missX, missY);

	}

	public void summary(int[] hitsX, int[] hitsY, int[] missX, int[] missY) {

		int hits = 0;
		int miss = 0;

		try {
			FileWriter myWriter = new FileWriter("selvitys.txt");

			for (int i = 0; i < hitsY.length; i++) {
				if (i < 1) {
					myWriter.write("Pisteet jotka osuvat hyvin lähelle polygonia tai sen sisälle: ");
				}
				if (hitsX[i] != 0) {
					myWriter.write("(" + hitsX[i] + "," + hitsY[i] + ") ");
					hits++;
				}
			}
			for (int i = 0; i < missY.length; i++) {
				if (i < 1) {
					myWriter.write("\n");
					myWriter.write("Pisteet jotka osuvat varmuudella polygonin ulkopuolelle: ");
				}
				if (missX[i] != 0) {
					myWriter.write("(" + missX[i] + "," + missY[i] + ") ");
					miss++;
				}
			}
			myWriter.write("\n");
			myWriter.write("\n");
			myWriter.write("Yhteenvetona huomaamme " + miss + " pisteistä menneen varmuudella ohitse polygonista ja \n"
					+ hits + " pisteistä osuneen polygonin sisälle, sen reunalle tai hyvin lähelle reunaa.");
			myWriter.close();
			System.out.println("Successfully wrote to the selvitys.txt file.");
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}
}
