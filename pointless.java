/* ****************************************************
Author: Faris Javaid
version: 3
----------------------

This program is a short quiz that rewards the 
user (with points) based of the answer that 
the fewest people said.

The total score is kept track of and is printed 
at the end of the quiz, as well as at the end 
of every question.

More than one user can play at a time, and their
respective scores are kept track of independently.

Question 5 uses details in file 'q5.txt' to define
each field of the type 'question'. By changing the
values in the text file, the question asked, its 
answer, the wrong answers and how many points its 
worth, as well as a few other details, are all 
changed.

At the end of the program, a file called 
'scoreboard.txt' is saved with the final scores of
each player.

   
******************************************************/

import java.util.Scanner;
import java.io.*;



class pointless
{
	//MAIN METHOD/MAIN METHOD/MAIN METHOD/MAIN METHOD/MAIN METHOD/
	public static void main(String [] args)
	throws IOException //Some of the method calls in this method refer to methods where I/O is used
	{
		welcome(); //Method that welcome + rules
		//creates temporary storage space to move player types around - used in sort()
		player temp = new player();
		temp = create_player();
		//Used to ask how many people are playing and create an array (player-type) of that size 
		final int number = player_number(); //will record how many people are playing
		player[] player_array = new player[number]; //array size equal to how man poeple are playing
		new_player(player_array, number);//Initialises elements in the array
		initial_players(number, player_array);//Initialised the records in each element
		
		//Used to create an array of questons
		final int max = 5;//Number of questions
		question[] question_array = new question[max];//Initialises elements in the array
		
		//Sets and asks questions
		for(int i = 0; i<5; i++)//Loop to ask 5 questions
		{
			question_dir(question_array, player_array, i, number, temp);//method that initialises the question_array[] array + calls methods that ask the questions
		}
		
		summary(player_array, number, temp);//prints winner + scoreboard, and saves txt file with it
		
		System.exit(0);
		
	}//END of MAIN METHOD
	
	public static int player_number()
	{
		int number = inputint("How many people are playing?");
		return number;//int-type
	}
	
	public static void initial_players(int number, player[] player_array)
	{
		for(int i=0;i<number;i++)//number is how many players there are
		{
			set_name(i, player_array);
		}
		print("\nThe names and scores of the players are:");
		print_all_info(player_array, number);//prints the name and scores of every player
		
	}
	
/*******************************************************************************
Making Questions. The following methods are used to create all details for each 
question in the question_array array, using ADT's. 
******************************************************************************/	
//makes a call to each question method in order from 1 to 5 (index 0-4)
	public static void question_dir(question[] question_array, player[] player_array, int i, int number, player temp)
	throws IOException
	{
		if (i==0)
		{
			set_question1(question_array, player_array, number, i, temp);
		}
		else if (i==1)
		{
			set_question2(question_array, player_array, number,  i, temp);
		}
		else if (i==2)
		{
			set_question3(question_array, player_array, number, i, temp);
		}
		else if (i==3)
		{
			set_question4(question_array, player_array, number,i, temp);
		}
		else if (i==4)
		{
			set_question5(question_array, player_array,number, i, temp);
		}
	}
	
/*****************************************************************************
	The following methods define each field of the data type 'question'. They 
	then make a call to a method that asks the user the question.
*****************************************************************************/
	public static void set_question1(question[] question_array, player[] player_array, int number, int i, player temp)
	{
		question_array[0] = new question();//record initialised
		question_array[0].question = "Name a British Prime Minister?";
		question_array[0].answer = "Stanley Baldwin";
		question_array[0].wrong1 = "Harold Wilson";
		question_array[0].wrong1_stat = "22 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[0].wrong2 = "John Major";
		question_array[0].wrong2_stat = "65 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[0].points = 13;
		question_array[0].right_stat = "13 People chose this option, well done! This was the best option.";
		
		ask_question(question_array, player_array, number, i, temp);//method that actually asks the question
		
	}
	

	public static void set_question2(question[] question_array, player[] player_array, int number, int i,player temp)
	{
		question_array[1] = new question();
		question_array[1].question = "Name a famous mathematician";
		question_array[1].answer = "Pierre de Fermat";
		question_array[1].wrong1 = "Srinivasa Ramanujan";
		question_array[1].wrong1_stat = "40 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[1].wrong2 = "Leonhard Euler";
		question_array[1].wrong2_stat = "45 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[1].points = 15;
		question_array[1].right_stat = "15 People chose this option, well done! This was the best option.";
		
		ask_question(question_array, player_array, number, i, temp);//method that actually asks the question
		
	}
	public static void set_question3(question[] question_array, player[] player_array, int number, int i,player temp)
	{
		question_array[2] = new question();
		question_array[2].question = "Name a famous grandmaster in chess.";
		question_array[2].answer = "Fabiano Caruana";
		question_array[2].wrong1 = "Bobby Fischer";
		question_array[2].wrong1_stat = "45 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[2].wrong2 = "Garry Kasparov";
		question_array[2].wrong2_stat = "47 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[2].points = 8;
		question_array[2].right_stat = "8 People chose this option, well done! This was the best option.";
		
		ask_question(question_array, player_array, number, i, temp);//method that actually asks the question	
	}
		public static void set_question4(question[] question_array, player[] player_array, int number, int i,player temp)
	{
		question_array[3] = new question();
		question_array[3].question = "Name a living European Monarch";
		question_array[3].answer = "King Philippe";
		question_array[3].wrong1 = "Queen Elizabeth II";
		question_array[3].wrong1_stat = "87 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[3].wrong2 = "King Felipe VI";
		question_array[3].wrong2_stat = "9 People chose this option. This wasn't the best option. 100 is added to your score.";
		question_array[3].points = 4;
		question_array[3].right_stat = "4 People chose this option, well done! This was the best option.";
		
		ask_question(question_array, player_array, number, i, temp);//method that actually asks the question
		
	}
/***************************************************************************************
This method uses values is file 'q5.txt' to fill in the fields of record. The text file
must have all the fields defined in class question. These values are then passed on to 
be the values of each field in the record of the array.
****************************************************************************************/
	public static void set_question5(question[] question_array, player[] player_array, int number, int i,player temp)
	throws IOException
	{
		BufferedReader inputStream = 
		new BufferedReader(new FileReader("q5.txt"));
		
		String input_question = inputStream.readLine();//stores this line into the variable 'input_question'
		String input_answer = inputStream.readLine();//stores this line into the variable 'input_answer'
		String input_wrong1 = inputStream.readLine();//stores this line into the variable 'input_wrong1'
		String input_wrong1_stat = inputStream.readLine();//stores this line into the variable 'input_wrong1_stat'
		String input_wrong2 = inputStream.readLine();//stores this line into the variable 'input_wrong2'
		String input_wrong2_stat = inputStream.readLine();//stores this line into the variable 'input_wrong2_stat'
		String input_points = inputStream.readLine();//stores this line into the variable 'input_points'
		int input_points_int = Integer.parseInt(input_points);//converts String to int
		String input_right_stat = inputStream.readLine();//stores this line into the variable 'input_right_stat'
		inputStream.close();
	
	//The fields in the file 'q5.txt' are passed onto to define each field in the array 'question_array[4]'
		question_array[4] = new question();
		question_array[4].question = input_question;
		question_array[4].answer = input_answer;
		question_array[4].wrong1 = input_wrong1;
		question_array[4].wrong1_stat = input_wrong1_stat;
		question_array[4].wrong2 = input_wrong2;
		question_array[4].wrong2_stat = input_wrong2_stat;
		question_array[4].points = input_points_int;
		question_array[4].right_stat = input_right_stat;
		
		
		
		ask_question(question_array, player_array, number, i, temp);
	}
	
	
/*******************************************************************************
Asks question, checks the answer that the user entered with the correct answer 
and two wrong ones. Determines which branch in the if statments to take based off
this, and prints the appropriate values stored in the fields of that array.

The final two branches are if the user types 'rules' or 'score' in which case 
method calls are made to provide that information.

While loop is so that an unrecognized input can prompt a try-again message and 
print the question and detiails again.

For loop is used to ask the question for each player, e.g. 5 players means 
question is asked 5 times.
******************************************************************************/	
	public static void ask_question(question[] question_array, player[] player_array, int number, int i, player temp)
	{
		int bad_ans = 100;
		String x = "go";
		print("********************************************************************************");
		while(x.equals("go"))
		{
			//is used here to identify which question is being asked
			for(int j = 0; j<number;j++)//loop used to ask question for each player
			{
				print("********************************************************************************");
				print("QUESTION " + (i+1) + " for " + get_player_name(player_array, j) + ":");//(i + 1) is so that question 1-5 is printed rather thatn question 0-4. 
				print(get_question(question_array,i));
				print("1.\t" + get_answer(question_array,i));
				print("2.\t" + get_wrong1(question_array,i));
				print("3.\t" + get_wrong2(question_array,i));
				String ans = input("Please choose the answer that the fewest people chose");
				

			if(ans.equals(get_answer(question_array,i)) | (ans.equals("1")))
				{
					print(get_right_stat(question_array, i));
					set_points(j, player_array, get_points(question_array, i));
					print("You're score is now " + get_player_points(player_array, j) + ".");
					x = "stop";//stops the while loop
				}
			else if(ans.equals(get_wrong1(question_array,i)) | (ans.equals("2")))
				{
					print(get_wrong1_stat(question_array, i));
					set_points(j, player_array, bad_ans);
					print("You're score is now " + get_player_points(player_array, j) + ".");
					x = "stop";//stops the while loop
				}
			else if(ans.equals(get_wrong2(question_array,i)) | (ans.equals("3")))
				{
					print(get_wrong2_stat(question_array, i));
					set_points(j, player_array, bad_ans);
					print("You're score is now " + get_player_points(player_array, j) + ".");
					x = "stop";//stops the while loop
				}
				
			else if(ans.equals("rules"))
				{
					rules();
					x = "go";//makes the while loop repeat
				}
			else if(ans.equals("score"))
				{
					sort(player_array, number, temp);
					print_all_info(player_array, number);
					x = "go";//makes the while loop repeat
				}
				
			else//catch-all else branch ofr unrecognized input
				{
					print("Sorry that answer is not recognised, please chose an option from the list.\nPlease try again.");

					x = "go";//makes the while loop repeat
				}
			}
		}
			
	}// End of Method
	
	
/*******************************************************************************
Sorts the the array player_array[] by score so that player_array[0] stores the details
of the person with the smallest score (less is better).
********************************************************************************/
	public static void sort(player[] player_array, int number, player temp)
	{
		for(int pass = 0; pass<(number-1); pass++)
		{
		
			for(int i = 0; i<(number-1); i++) //[0] will store smallest and [number-1] will store biggest
			{
				if (player_array[i].points > player_array[i+1].points)//compares adjacent elements
				{
					swap(player_array, temp, i);//will swap positions of adjacent elements
				}
			}
		}
		
	}
//Will swap the positions of player_array[i] and player_array[i+1]
	public static void swap(player[] player_array, player temp, int i)
	{
		temp = player_array[i]; // player_array[number] temporarily holds the value of the array
		player_array[i] = player_array[i+1]; //swapping positions
		player_array[i+1] = temp;//element i is now stored in (i+1)
	}
				

/*******************************************************************************
******************************************************************************/	
//miscellaneous methods
	public static void welcome()
	{
		print("\nWelcome to: \n");	
		print("PPPPPPPPPPPPPPPPP                      iiii                             tttt          lllllll ");                                                                                      
		print("P::::::::::::::::P                    i::::i                         ttt:::t          l:::::l    ");                                                                                     
		print("P::::::PPPPPP:::::P                    iiii                          t:::::t          l:::::l    ");                                                                                    
		print("PP:::::P     P:::::P                                                 t:::::t          l:::::l     ");                                                                                   
		print("  P::::P     P:::::P   ooooooooooo   iiiiiii nnnn  nnnnnnnn    ttttttt:::::ttttttt     l::::l     eeeeeeeeeeee        ssssssssss       ssssssssss ");                                    
		print("  P::::P     P:::::P oo:::::::::::oo i:::::i n:::nn::::::::nn  t:::::::::::::::::t     l::::l   ee::::::::::::ee    ss::::::::::s    ss::::::::::s   ");                                 
		print("  P::::PPPPPP:::::P o:::::::::::::::o i::::i n::::::::::::::nn t:::::::::::::::::t     l::::l  e::::::eeeee:::::eess:::::::::::::s ss:::::::::::::s   ");                                
		print("  P:::::::::::::PP  o:::::ooooo:::::o i::::i nn:::::::::::::::ntttttt:::::::tttttt     l::::l e::::::e     e:::::es::::::ssss:::::ss::::::ssss:::::s  ");                                
		print("  P::::PPPPPPPPP    o::::o     o::::o i::::i   n:::::nnnn:::::n      t:::::t           l::::l e:::::::eeeee::::::e s:::::s  ssssss  s:::::s  ssssss   ");                                
		print("  P::::P            o::::o     o::::o i::::i   n::::n    n::::n      t:::::t           l::::l e:::::::::::::::::e    s::::::s         s::::::s         ");                               
		print("  P::::P            o::::o     o::::o i::::i   n::::n    n::::n      t:::::t           l::::l e::::::eeeeeeeeeee        s::::::s         s::::::s      ");                               
		print("  P::::P            o::::o     o::::o i::::i   n::::n    n::::n      t:::::t    tttttt l::::l e:::::::e           ssssss   s:::::s ssssss   s:::::s     ");                              
		print("PP::::::PP          o:::::ooooo:::::oi::::::i  n::::n    n::::n      t::::::tttt:::::tl::::::le::::::::e          s:::::ssss::::::ss:::::ssss::::::s    ");                              
		print("P::::::::P          o:::::::::::::::oi::::::i  n::::n    n::::n      tt::::::::::::::tl::::::l e::::::::eeeeeeee  s::::::::::::::s s::::::::::::::s   ....    ");                       
		print("P::::::::P           oo:::::::::::oo i::::::i  n::::n    n::::n        tt:::::::::::ttl::::::l  ee:::::::::::::e   s:::::::::::ss   s:::::::::::ss   .::::.  ");                         
		print("PPPPPPPPPP             ooooooooooo   iiiiiiii  nnnnnn    nnnnnn          ttttttttttt  llllllll    eeeeeeeeeeeeee    sssssssssss      sssssssssss      .... ");  
		
		rules();
		print("*If at any point you are stuck you can print the rules by typing in 'rules'.");
		print("********************************************************************************");
		print("\nGood Luck!\n");
	}
	public static void rules()
	{
		print("\nRULES:");
		print("*******************************************************************************");
		print("*For each question type pick the option that you think the fewest people chose.");
		print("*You can do this by typing in that option exactly, or by refering to the number ");
		print(" or by referring to the number associated with that option (there's 3 options so");
		print(" it'll be 1,2 or 3.\n");
		print("*You'll be given 100 points for choosing an answer that wasn't the best option.");
		print("*If you pick the best option the points rewarded will be equal to how many poeple");
		print(" chose that option.");
		print(" A SMALLER SCORE IS BETTER."); 
		print("*During the game you can also print the current scores of each player by");
		print(" typing 'score'.");
	}
/******************************************************************************************
This method prints the player with best score (least), along with the final scores of 
every player. 
Makes a call to sort method and then save method which saves the scoreboard.
******************************************************************************************/
	public static void summary(player[] player_array, int number, player temp)
		throws IOException
	{
		int winner = 0;
		print("********************************************************************************");
		print("********************************************************************************");
		print("********************************************************************************");
		print("\nYou've reached the end of the Quiz.");
		sort(player_array, number, temp);//sorts the scores
		int check = 0;//used to check equal scores
		
		for(int i = 0;i<(number-1); i++)//branch is two or more scores are equal
		{
			if(player_array[i].points == player_array[i+1].points)
			{
				print("It is a draw between " + get_player_name(player_array, i) + " and " + get_player_name(player_array, (i+1)));
				check = check + 1;
			}
			
		}
		if(check==0)//branch for only one winner
		{
			print("\nThe person with the most points is " + get_player_name(player_array, winner) + ".");	
		}
		print("\nScoreboard:");
		print_all_info(player_array, number);//prints now sorted scoreboard
		
		save_score(player_array, number);//saves scores in a file
	}
	
//exports score and saves it in file 'scoreboard.txt'
	public static void save_score(player[] player_array, int number) 
		throws IOException
	{
		
		print("\nA text file has been saved storing the scoreboard called 'Scoreboard'."); 
		
		PrintWriter score = new PrintWriter(new FileWriter("Scoreboard.txt"));//scorebaord saved in 'scoreboard.txt.' 
		for(int i=0;i<number;i++)
		{
			score.println(get_player_name(player_array, i));
			score.println(get_player_points(player_array, i));
			score.println("");//creates space between scores
			
		}
		score.close();
	
		
	}
/*******************************************************************************
An abstract data type for getting question details
Type: question
* 
Operations:
* Get question's correct answer 
* Get question's wrong answers (2 of them)
* Get the number points that the right answer is worth
* Get the statistic for both wrong answers
* Get statistic for the right answer
******************************************************************************/			
	public static String get_question(question[] question_array, int i)//returns question
	{
		return question_array[i].question;
	}
	
	public static String get_answer(question[] question_array, int i)//returns answer
	{
		return question_array[i].answer;
	}
	
	public static String get_wrong1(question[] question_array, int i)//returns wrong answer
	{
		return question_array[i].wrong1;
	}
	
	public static String get_wrong2(question[] question_array, int i)//returns wrong answer
	{
		return question_array[i].wrong2;
	}
	
	public static String get_wrong1_stat(question[] question_array, int i)//returns statistic for wrong answer
	{
		return question_array[i].wrong1_stat;
	}
	
	public static String get_wrong2_stat(question[] question_array, int i)//returns statistic for wrong answer
	{
		return question_array[i].wrong2_stat;
	}
	public static String get_right_stat(question[] question_array, int i)//returns statistic for right answer
	{
		return question_array[i].right_stat;
	}
	
	public static int get_points(question[] question_array, int i)//returns the amount of points that the right answer is worth
	{
		return question_array[i].points;	
	}
	

/*******************************************************************************
An abstract data type for setting and getting player details
Type: player
* 
Operations:
* Initialise a player
* Get player's points (integer)
* Get player's name (String)
* set player's points (an int)
* set the player's name (a String)
******************************************************************************/			
	public static void new_player(player[] player_array, int number)
	{
		for(int i = 0; i<number; i++)//loop used to initialise values in question_array
										 //an extra element made to move around positioning of elements, by functioning as a temporary storage.
		{
			player_array[i] = create_player();//each element is initialized
		}
	}
	public static player create_player()//initializes each field in this record
	{
		player p = new player();
		p.name = "";
		p.points = 0;
		return p;
	}
	public static void print_all_info(player[] player_array, int number)//prints every players names with points
	{
		for(int i=0;i<number;i++)
		{
			print(get_player_name(player_array, i));
			printint(get_player_points(player_array, i));
			print("");//creates space between each player's details
		}
	}
	
	/////////////////////////////////////////////////////////
	//set methods
	public static void set_name (int i, player[] player_array)//sets the name
	{
		player_array[i].name = ask_name(i);
	}
	
	public static void set_points(int i, player[] player_array, int points) //sets the points
	{
		player_array[i].points = player_array[i].points + points;//will add old points with points gained
	}
	/////////////////////////////////////////////////////////////
	
	//Get methods
	public static String get_player_name(player[] player_array, int i)//returns name
	{
		return player_array[i].name;
	}
	
	public static int get_player_points(player[] player_array, int i)//returns points
	{
		return player_array[i].points;	
	}
	/////////////////////////////////////////////////////////////
		
	
	public static String ask_name(int i)
	{
		String name = input("Name player " + (i+1) + ".");//(i+1) so that player 0 isn't a thing
		return name;
	}
	
	/**************************************************
	Input Methods - These methods are used to take 
	input from the user.
	**************************************************/
	public static String input(String message) // takes String-type values
	{
		String answer;
		Scanner scanner = new Scanner(System.in);
		print(message);
		answer = scanner.nextLine();
		
		return answer;
	}
	
	public static int inputint(String message) // takes integer-type values
	{
		String answer0;
		Scanner scanner = new Scanner(System.in);
		print(message);
		answer0 = scanner.nextLine();
		int answer = Integer.parseInt(answer0);
		
		return answer;//answer is an integer value
	}
	/*************************************************
	**************************************************/
	
	/**************************************************
	Print methods - these are for printing String/int 
	valures
	**************************************************/
	public static void print(String message)//to print a String
	{
		System.out.println(message);
	}
	
	public static void printint(int message)//to print an integer-value
	{
		System.out.println(message);
	}
	/*************************************************
	**************************************************/

}//END of class


	
	
class question // record created to store correct answers and the points they are worth
{
	String question;
	String answer;
	String wrong1;
	String wrong1_stat;
	String wrong2;
	String wrong2_stat;
	String right_stat;
	int points;
}//END of class

class player //record for players
{
	String name;
	int points;
}//END of class

	
	
	
	
	
	
	
	
	
	
	
	
	



	
