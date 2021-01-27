import java.util.*;

public class TodoApp {
	
	public static void main(String[] args) {
		
		//Start the scanner Obj
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		//Declare Vars
	    boolean exit = false;                   //Use to exit the loop later
	    int userInputInt = 0;                   //Use in the loop for entered ints
	    String userInputString = "";            //Use in the loop for entered strings
	    boolean endLoop = false;
	    
	    //HashMap Test USING a number as the initial value.
	    HashMap<String,Todo> todoHash = new HashMap<String,Todo>();
		
	    //Print the Intro to the Program
	    System.out.println("Welcome to the To Do list MK2.");
	    
	    //Start the loop after the Intro
	    while (exit == false){
	    	
	        //Turn all inputs to default values
	        userInputInt = 0;
	        userInputString = "";
	        endLoop = false;
	        
	        
	        //Display text asking the user what they want to do
	        System.out.println("What would you like to do?");
	        System.out.println("1 - list items. 2 - Add an item. 3 - Remove an item. 4 - Mark a task as done. 5- Exit.");
	        
	        //Take the users input
	        try{
	            userInputInt = in.nextInt();
	        }
	        catch(Exception e){
	            System.out.println("Try Again.");
	        }
	        in.nextLine();
	        
	        //Start the switch
	        switch(userInputInt){                                       
	                case 1:                                             	//Case for displaying the list
	                	todoHash.entrySet().forEach(entry ->{
	                		System.out.println(entry.getValue());
	                	});
	                	
	                	//System.out.println(Arrays.asList(todoHash));
	                break;                                                  //Break out of the switch
	                
	                case 2:                                            		//Case for adding an item
	                	TodoBuilder todoBuilder = new TodoBuilder();
	                	System.out.println("What is the name of the task you would you like to add?");
	                	todoBuilder.setName(in.nextLine().toLowerCase());
	                	
	                	System.out.println("What is the description?");
	                	todoBuilder.setDescription(in.nextLine().toLowerCase());
	                	
	                	//Run a loop for the boolean. Only entry that the entered value really matters.
	                	while (endLoop == false) {
		                	System.out.println("Have you already done this task? Y / N");
		                	userInputString = in.nextLine();
		                	userInputString = userInputString.toUpperCase();
		                	
		                	//Check to make sure Y or N is entered
		                	if (userInputString.equals("Y")) {
		                		todoBuilder.setDone(true);
		                		//End the While
		                		endLoop = true;
		                	}
		                	else if (userInputString.equals("N")) {
		                		todoBuilder.setDone(false);
		                		//End the While
		                		endLoop = true;
		                	}
		                	else {
		                		System.out.println("You need to enter Y or N..");
		                		//Continue the While
		                	}
	                	}
	                	//End of While Loop
	                	
	                	//Build the todo obj
	                	Todo todo = todoBuilder.build();
	                	System.out.println(todo);

	                	//Put the todo obj in the hashmap
	                	todoHash.put(todo.getName(), todo);
	                	//Test
	                	//System.out.println(todoHash);
	                break;                                                  //Break out of the switch
	                
	                case 3: 												//Case for removing items
	                	while (endLoop == false) {
	                		//Display the list of tasks
		                	todoHash.entrySet().forEach(entry ->{
		                		System.out.println(entry.getValue());
		                	});
		                	
		                	//Ask the user what they want to remove
		                	System.out.println("What would you like to remove? Enter Q to leave");
		                	userInputString = in.nextLine().toLowerCase();
		                	
		                	if (todoHash.containsKey(userInputString)) {
		                		todoHash.remove(userInputString);

			                	System.out.println(userInputString + " has been removed.");
		                		endLoop = true;
		                	}
		                	else if (userInputString.equals("q")) {
		                		endLoop = true;
		                	}
		                	else {
			                	System.out.println(userInputString + " was not found.");
		                	}
	                	}
	                break;                                                  //Break out of the switch
		                
	                case 4:
	                	while (endLoop == false) {
	                		//Display the list of tasks
		                	todoHash.entrySet().forEach(entry ->{
		                		System.out.println(entry.getValue());
		                	});
		                	
		                	//Ask the user what they want to mark as done
		                	System.out.println("What task do you want to mark as done? Enter Q to leave");
		                	userInputString = in.nextLine().toLowerCase();

		                	if (todoHash.containsKey(userInputString)) {
		                		Todo temp = todoHash.get(userInputString);
		                		temp.setDone(true);

			                	System.out.println(userInputString + " Changed to done.");
		                	}
		                	else if (userInputString.equals("q")) {
		                		endLoop = true;
		                	}
		                	else {
			                	System.out.println(userInputString + " was not found.");
		                	}
	                	}
	                break;
	                	
	                case 5:                                             	//Case for exiting the program
	                exit = true;                                            //Change exit to true exiting the loop
	                break;                                                  //Break out of the switch
	            }
	        //After the Switch
	    }
	    //After the while loop
	}
	//After main method
}
//After class declaration
