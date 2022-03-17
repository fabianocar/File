package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Product;

public class App {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String srcPath = sc.nextLine();

		File srcFile = new File(srcPath);
		String srcFolder = srcFile.getParent();

		boolean success = new File(srcFolder + "\\out").mkdir();

		String trgFile = srcFolder + "\\out\\sumary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(srcFile))) {

			String itemCsv = br.readLine();

			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				Double price = Double.parseDouble(fields[1]);
				Integer quantity = Integer.parseInt(fields[2]);

				list.add(new Product(name, price, quantity));

				itemCsv = br.readLine();

				try (BufferedWriter bw = new BufferedWriter(new FileWriter(trgFile))) {

					for (Product item : list) {
						bw.write(item.getName() + "," + String.format("%.2f", item.Total()));
						bw.newLine();
					}

					System.out.println(trgFile + " CREATED!");

				} catch (IOException e) {
					System.out.println("Error writing file: " + e.getMessage());
				}

			}
		} catch (IOException e) {
			System.out.println("Error reading file: " + e.getMessage());
		}
		
		System.out.println("------------------------------");

		try (BufferedReader br = new BufferedReader(new FileReader(trgFile))) {
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}

		sc.close();

	}
}
