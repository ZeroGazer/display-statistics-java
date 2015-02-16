package hk.ust.isom3320.assignment.Statistics

import java.util.Scanner;
import java.io.File;

public class assignment{
	public static void main(String[] args) throws Exception{
		System.out.print("Please input the path of the file: ");
		Scanner filePathInput = new Scanner(System.in);
		String filePath = filePathInput.next();
		File file = new File(filePath);
		filePathInput.close();
		Scanner fileInput = new Scanner(file);
		String row = new String(fileInput.nextLine());
		int numberOfColumn = 1;
		for (int i = 0; i < row.length() - 1; i++) {
			if (row.charAt(i) == ',')
				++numberOfColumn;
		}
		int numberOfRow = 1;
		while (fileInput.hasNextLine()) {
			++numberOfRow;
			fileInput.nextLine();
		}
		fileInput.close();
		fileInput = new Scanner(file);
		fileInput.useDelimiter("[,\n]");
		String[][] matrix = new String[numberOfRow][numberOfColumn];
		for (int i = 0; i < numberOfRow; i++)
			for (int j = 0; j < numberOfColumn; j++)
				matrix[i][j] = new String(fileInput.next());
		fileInput.close();
		for (int i = 0; i < numberOfRow; i++)
			for (int j = 0; j < numberOfColumn; j++)
				if (matrix[i][j].length()>15)
					matrix[i][j]=matrix[i][j].substring(0, 15);
		for (int i = 0; i < numberOfRow; i++) {
			for (int j = 0; j < numberOfColumn; j++)
				System.out.printf("%-20s", matrix[i][j]);
			System.out.println();
		}
		System.out.println();
		System.out.printf("%-20s", "Store");
		for (int i = 1; i < numberOfColumn; i++)
			System.out.printf("%-20s", matrix[0][i]);
		System.out.println();
		System.out.printf("%-20s", "Total");
		double locationMax=-1;
		double locationMin=-1;
		for (int i = 1; i < numberOfColumn; i++) {
			double total = 0;
			for (int j = 1; j < numberOfRow; j++)
				total += Double.parseDouble(matrix[j][i]);
			if (total > locationMax)
				locationMax = total;
			if ((total < locationMin) || (locationMin == -1))
				locationMin = total;
			System.out.printf("%-20.2f", total);
		}
		System.out.println();
		System.out.printf("%-20s", "Average");
		for (int i = 1; i < numberOfColumn; i++) {
			double total = 0;
			for (int j = 1; j < numberOfRow; j++)
				total += Double.parseDouble(matrix[j][i]);
			double average = total / (numberOfRow - 1);
			System.out.printf("%-20.2f", average);
		}
		System.out.println("\n");
		System.out.printf("%-20s", "Item");
		for (int i = 1; i < numberOfRow; i++)
			System.out.printf("%-20s", matrix[i][0]);
		System.out.println();
		System.out.printf("%-20s", "Total");
		double itemMax=-1;
		double itemMin=-1;
		for (int i = 1; i < numberOfRow; i++) {
			double total = 0;
			for (int j = 1; j < numberOfColumn; j++)
				total += Double.parseDouble(matrix[i][j]);
			if (total > itemMax)
				itemMax = total;
			if ((total < itemMin) || (itemMin == -1))
				itemMin = total;
			System.out.printf("%-20.2f", total);
		}
		System.out.println();
		System.out.printf("%-20s", "Average");
		for (int i = 1; i < numberOfRow; i++) {
			double total = 0;
			for (int j = 1; j < numberOfColumn; j++)
				total += Double.parseDouble(matrix[i][j]);
			double average = total / ( numberOfColumn - 1);
			System.out.printf("%-20.2f", average);
		}
		System.out.println();
		System.out.printf("%s", "Best selling store(s):");
		for (int i = 1; i < numberOfColumn; i++) {
			double total = 0;
			for (int j = 1; j < numberOfRow; j++)
				total += Double.parseDouble(matrix[j][i]);
			if (locationMax == total)
				System.out.printf("%-15s", matrix[0][i]);
		}
		System.out.println();
		System.out.printf("%s", "Least selling store(s):");
		for (int i = 1; i < numberOfColumn; i++) {
			double total = 0;
			for (int j = 1; j < numberOfRow; j++)
				total += Double.parseDouble(matrix[j][i]);
			if(locationMin == total)
				System.out.printf("%-15s", matrix[0][i]);
		}
		System.out.println();
		System.out.printf("%s", "Best selling item(s):");
		for (int i = 1; i < numberOfRow; i++) {
			double total = 0;
			for(int j = 1; j < numberOfColumn; j++)
				total += Double.parseDouble(matrix[i][j]);
			if(itemMax == total)
				System.out.printf("%-15s", matrix[i][0]);
		}
		System.out.println();
		System.out.printf("%s", "Least selling item(s):");
		for (int i = 1; i < numberOfRow; i++) {
			double total = 0;
			for(int j = 1; j < numberOfColumn; j++)
				total += Double.parseDouble(matrix[i][j]);
			if(itemMin == total)
				System.out.printf("%-15s", matrix[i][0]);
		}
	}
}