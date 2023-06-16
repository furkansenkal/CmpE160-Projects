
package question;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;  
import java.util.*;

public class CityNavigator
{  

	public static int pathFinder(String startCity, String targetCity) 
	{
		
		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
		ArrayList<String> list = new ArrayList<String>();
		try
		{
			//the file to be opened for reading
			FileInputStream fis=new FileInputStream("cities_and_distances.txt");
			Scanner sc=new Scanner(fis); //file to be scanned
			//returns true if there is another line to read
			while(sc.hasNextLine())
			{
				String line = sc.nextLine();
				list.add(line);
			}
			sc.close(); //closes the scanner
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
		int number = 0;
		ArrayList<String> startCityLst = new ArrayList<String>();
		ArrayList<String> targetCityLst = new ArrayList<String>();
		if (startCity.equals(targetCity))
			return 0;
		
		for (String i : list) 
		{
			String[] subList = i.split("");
		
			if (startCity.equals(subList[0].strip())) 
			{
				
				if(targetCity.equals(subList[2].strip())) 
				{
				
					try
					{
			            number = Integer.valueOf(subList[4].strip());
			            
			            
			        }
					
			        catch (NumberFormatException ex)
					{
			            ex.printStackTrace();
			        }
					
					
				}
				else
				{
					startCityLst.add(i);
				}
				
			}
			else if (targetCity.equals(subList[2].strip()))
			{
				targetCityLst.add(i);
			}
			
			if (startCity.equals(subList[2].strip())) 
			{
				
				if(targetCity.equals(subList[0].strip())) 
				{
				
					try
					{
			            number = Integer.valueOf(subList[4].strip());
			            
			            
			        }
					
			        catch (NumberFormatException ex)
					{
			            ex.printStackTrace();
			        }
					
					
				}
				else
				{
					startCityLst.add(i);
				}
				
			}
			else if (targetCity.equals(subList[0].strip()))
			{
				targetCityLst.add(i);
			}
			else
			{
				continue;
			}
			
		}
		
		if ((number == 0) && (targetCityLst.size() != 0) && (startCityLst.size() != 0))
		{
			boolean flag = true;
			boolean flag2 = true;
			boolean flag3 = true;
			int incVar = 0;
			int incVar2 = 0;
			int incVar3 = 0;
			while (flag)
			{
				String[] subList2 = startCityLst.get(incVar).split("");
				String[] subList3 = targetCityLst.get(incVar).split("");
				ArrayList<String> middleCityLst = new ArrayList<String>();
				ArrayList<String> middleCityLst2 = new ArrayList<String>();
				ArrayList<String> lastList = new ArrayList<String>();
				
				
				
				if(startCity.equals(subList2[0].strip())) 
				{
				
					middleCityLst.add(subList2[2]);
					
				}
				else 
				{
					middleCityLst.add(subList2[0]);
					
				}
				
				
				
				
					if(targetCity.equals(subList3[incVar3].strip())) 
					{
					
						middleCityLst2.add(subList3[2]);
						flag3 = true;
					}
					else 
					{
						middleCityLst2.add(subList3[0]);
						flag3 = true;
					}
					
						
				
				
				for (int i = 0; i < middleCityLst.size(); i++) 
				{
					for (int j = 0; j < middleCityLst2.size(); j++) 
					{
						if (middleCityLst2.get(j).equals(middleCityLst.get(i))) 
						{
							lastList.add(startCityLst.get(i));
							lastList.add(targetCityLst.get(j));
							System.out.println(lastList);
							String[] subList4 = startCityLst.get(i).split("");
							String[] subList5 = targetCityLst.get(j).split("");
							int firstNumber = 0;
							int secondNumber = 0;
							try
							{
					            firstNumber = Integer.valueOf(subList4[4].strip());
					            
					            
					        }
							
					        catch (NumberFormatException ex)
							{
					            ex.printStackTrace();
					        }
							try
							{
					            secondNumber = Integer.valueOf(subList5[4].strip());
					            
					            
					        }
							
					        catch (NumberFormatException ex)
							{
					            ex.printStackTrace();
					        }
							number = firstNumber + secondNumber;
							
							
							flag = false;
						}
						else 
						{
							for (String k : list)
							{
								String[] subList6 = k.split("");
								if ((middleCityLst2.get(j).equals(subList6[0]) && middleCityLst.get(i).equals(subList6[2])) || (middleCityLst2.get(j).equals(subList6[2]) && middleCityLst.get(i).equals(subList6[0])))
								{
									lastList.add(startCityLst.get(i));
									lastList.add(list.get(list.indexOf(k)));
									lastList.add(targetCityLst.get(j));
									System.out.println(lastList);
									String[] subList4 = startCityLst.get(i).split("");
									String[] subList5 = targetCityLst.get(j).split("");
									int firstNumber = 0;
									int secondNumber = 0;
									int thirdNumber = 0;
									try
									{
							            firstNumber = Integer.valueOf(subList4[4].strip());
							            
							            
							        }
									
							        catch (NumberFormatException ex)
									{
							            ex.printStackTrace();
							        }
									try
									{
							            secondNumber = Integer.valueOf(subList6[4].strip());
							            
							            
							        }
									
							        catch (NumberFormatException ex)
									{
							            ex.printStackTrace();
							        }
									
									try
									{
							            thirdNumber = Integer.valueOf(subList5[4].strip());
							            
							            
							        }
									
							        catch (NumberFormatException ex)
									{
							            ex.printStackTrace();
									}
									number = firstNumber + secondNumber + thirdNumber;
									flag = false;
								}
							}
							
							continue;
						}	
					}	
				}
				
				incVar++;	
			}	
		}
					
		return number;
				

		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	}
	public static void main(String[] args) {
		int a = pathFinder("A", "A");
		System.out.println("At least, I tried. O7");
		System.out.println(a);
	}

}  

