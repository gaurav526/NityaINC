package inc.nitya;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Assignment2 {
	public static String folderPath;
	public Assignment2() {}

	public static int getFileCreatedMonth(String fileName) {
		File file = new File(folderPath + "\\\\" + fileName);
		Path filePath = file.toPath();
		BasicFileAttributes attributes = null;
		int month = 0;
		try {
			attributes = Files.readAttributes(filePath, BasicFileAttributes.class);
		} catch (IOException exception) {
			exception.getMessage();
		}
		long milliseconds = attributes.creationTime().to(TimeUnit.MILLISECONDS);
		if ((milliseconds > Long.MIN_VALUE) && (milliseconds < Long.MAX_VALUE)) {
			Date creationDate = new Date(attributes.creationTime().to(TimeUnit.MILLISECONDS));
			month = creationDate.getMonth() + 1;
		}
		return month;
	}
	// Method to scan all file in given directory
	public static List<Integer> scanFilesForFolder(final File folder) {
		List<Integer> monthsList = new ArrayList<>();
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				scanFilesForFolder(fileEntry);
			} else {
				int month = getFileCreatedMonth(fileEntry.getName());
				monthsList.add(month);
			}
		}
		return monthsList;
	}
	// Method to get input folder Name
	public static void executeProgram() {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Foler Path should be like--> drive name://folder name");
		System.out.println("Example--> D://Read");
		System.out.println("");
		System.out.print("Enter folder path: ");
		folderPath = scanner.next();
		List<Integer> monthsList = null;
		try {
			File folder = new File(folderPath);
			monthsList = scanFilesForFolder(folder);
		} catch (Exception e) {
			System.out.println("folder not found!");
			System.out.println("");
			executeProgram();
		}
		if (monthsList != null) {
			int jan = 0, feb = 0, mar = 0, apr = 0, may = 0, jun = 0, jul = 0, aug = 0, sep = 0, oct = 0, nov = 0,
					dec = 0;
			for (Iterator<Integer> iterator = monthsList.iterator(); iterator.hasNext();) {
				Integer month = (Integer) iterator.next();
				switch (month) {
				case 1:
					jan++;
					break;
				case 2:
					feb++;
					break;
				case 3:
					mar++;
					break;
				case 4:
					apr++;
					break;
				case 5:
					may++;
					break;
				case 6:
					jun++;
					break;
				case 7:
					jul++;
					break;
				case 8:
					aug++;
					break;
				case 9:
					sep++;
					break;
				case 10:
					oct++;
					break;
				case 11:
					nov++;
					break;
				case 12:
					dec++;
					break;
				default:
					break;
				}
			}
			System.out.println("---------------Files Creation Months Count----------");
			System.out.println("January   " + jan);
			System.out.println("February  " + feb);
			System.out.println("March     " + mar);
			System.out.println("April     " + apr);
			System.out.println("May       " + may);
			System.out.println("June      " + jun);
			System.out.println("July      " + jul);
			System.out.println("August    " + aug);
			System.out.println("September " + sep);
			System.out.println("October   " + oct);
			System.out.println("November  " + nov);
			System.out.println("December  " + dec);
			System.out.println();
		}
	}

	public static void main(String[] args) {
		executeProgram();
	}
}
