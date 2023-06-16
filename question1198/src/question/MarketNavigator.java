
package question;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;  
import java.util.*;

public class MarketNavigator
{  
	
	/* Method that gives the distance between two points */
	public static double distanceFinder(int x1, int y1, int x2, int y2) {
		return Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
	}

	public static int pathFinder(String filename) {
		
		/* Find the smallestTotalDistance */
		double smallestTotalDistance = 0;
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		
		ArrayList<House> houses = new ArrayList<>();
		// ArrayList for houses other than migros.
		House migros = new House("Migros", 0, 0);
		// Temporarily defined the "Migros" at 0,0 coordinates.
		try 
		{
			File myObj = new File(filename);
		    Scanner myReader = new Scanner(myObj);
		    while (myReader.hasNextLine())
		    // File reading.
		    {
		    	String data = myReader.nextLine();
		    	String[] dataArray = data.split(" ");
		    	String houseName = dataArray[0];
		    	String xCoordinateStr = dataArray[1];
		    	String yCoordinateStr = dataArray[2];
		    	// Converted each line into array and defined their index's to name and x,y coordinates sequentially.
		    	try
		        {
		    		Integer xCoordinate = Integer.valueOf(xCoordinateStr);
		    		Integer yCoordinate = Integer.valueOf(yCoordinateStr);
		    		// Converted string coordinates to integers.
		    		if(houseName.equals("Migros")) 
		    		{
		    			migros.setX(xCoordinate);
		    			migros.setY(yCoordinate);
		    			// If the name of house is "Migros", it is our starting point so I setted x,y coordinates of migros object that I defined before.
		    		}
		    		houses.add(new House(houseName, xCoordinate, yCoordinate));
		    		// Else, I just added house to the houses arraylist.
		        }
		         
		        catch (NumberFormatException ex)
		        {
		        	ex.printStackTrace();
		        }	
		    }
		    myReader.close();
		}  
		
		catch (FileNotFoundException e) 
		{
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
		
		ArrayList<ArrayList<House>> allPathsLst = permutator(houses);
		// Used permutator method that I coded below to make a arraylist consisting arraylists of permutations of houses arraylist.
		ArrayList<Double> totalDistancesLst = new ArrayList<Double>();
		// Created a arraylist in order to add distances of all permutations and find the minimum of them later.
		
		for(ArrayList<House> path : allPathsLst) 
		{
			// For each one of the all permutations,
			double totalDistance = 0;
			totalDistance += distanceFinder(migros.getX(), migros.getY(), path.get(0).getX(), path.get(0).getY());
			// Calculates distance from "Migros" to first element of our path and adds to the totalDistance.
			for(int i = 0; i <= path.size() - 2; i++) 
			{
				totalDistance += distanceFinder(path.get(i).getX(), path.get(i).getY(), path.get(i+1).getX(), path.get(i+1).getY());
				// Calculates distance from "i"th element to "i+1"th one until the path is finished and adds all of them one by one to the totalDistance.
			}
			totalDistance += distanceFinder(path.get(path.size() - 1).getX(), path.get(path.size() - 1).getY(), migros.getX(), migros.getY());
			// Calculates distance from last element of our path to "Migros" and adds to the totalDistance.
			totalDistancesLst.add(totalDistance);
			// Adds totalDistance to ArrayList of totalDistances
		}
		
		double currentSmallest = totalDistancesLst.get(0);
		for (int i = 1; i <= totalDistancesLst.size() - 1; i++) 
		{
			if(currentSmallest > totalDistancesLst.get(i)) 
			{
				currentSmallest = totalDistancesLst.get(i); 
			}
		}
		smallestTotalDistance = currentSmallest;
		// Calculates the smallest totalDistance in the totalDistances arraylist.
		
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
		
		int roundedValue = (int) Math.round(smallestTotalDistance);
		return roundedValue;
		
	}
	
	public static ArrayList<ArrayList<House>> permutator(ArrayList<House> inputLst)
	{
		// A method for finding permutations of any given arraylist, I used it to find permutations of houses arraylist.
		if (inputLst.size() == 0 ) 
		{
			ArrayList<ArrayList<House>>	returnLst = new ArrayList<ArrayList<House>>();
			returnLst.add(new ArrayList<House>());
			return returnLst;
			// If given arraylist's size equals to 0 there is only one permutation.
		}
		
		ArrayList<ArrayList<House>> returnList = new ArrayList<ArrayList<House>>();
		// Created arraylist that I will return consisting arraylist of houses (permutations).
		House firstHouse = inputLst.remove(0);
		ArrayList<ArrayList<House>> recursiveLst = permutator(inputLst);
		// There is a recursion
		for(ArrayList<House> lst : recursiveLst) 
		{
			for (int i = 0; i <= lst.size(); i++) 
			{
				ArrayList<House> tempLst = new ArrayList<House>(lst);
				tempLst.add(i, firstHouse);
				returnList.add(tempLst);
			}
			// Finding the permutations of arraylist thanks to recursion.
		}
		return returnList;
		// returns the arraylist consisting arraylist of houses (permutations).
	}

	public static void main(String[] args) {
		
		/* This part is for you to test your method, no points will be given from here */
		String path = MarketNavigator.class.getProtectionDomain().getCodeSource().getLocation().getPath() + File.separator + ".." + File.separator+"coordinates.txt";
		
		int distance = pathFinder("coordinates.txt");
		
		System.out.println("Smallest distance:" + distance);
	}
	
}  

