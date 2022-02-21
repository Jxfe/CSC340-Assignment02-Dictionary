/****************************************************************
*
* File: Assignment02.java
* By: Jeffrey Ma
* Date: 02/17/2022
*
* Description: Enums are loaded from Dictionary.java, User runs program and gets an interative dictionary.
* Displays results dependent on given paramters from user.(Parts of Speech, Reverse, Distinct)
*
****************************************************************/

import java.util.*;

public class Assignment02 {
    public static void main(String [] args) {
        int cmdCount = 0;      //Tracks amount of inputs from user to make Search[cmdCount] Work
        int keywords = 0;      //Tracks amount of words fed into the Hashmap
        int definitions = 0;   //Tracks amount of defiitions fed into the Hashmap
        boolean running = true;//Used to determine if loop should continue running
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<Dictionary>> hmap = new HashMap<String, ArrayList<Dictionary>>(); //HashMap to replicate dictionary where string holds words and the Arraylist holds definitins such as Word,PartsOfSpeech,Descriptions
        ArrayList<String> partOfSpeeches = new ArrayList<String>(Arrays.asList("noun", "verb", "adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection")); //Holds ArrayList of parts of speech to compare to

        System.out.println("! Loading data..."); 

        for (Dictionary entry : Dictionary.values()) { //Loop for Enum to be copied into the Hashmap
            String word = entry.getWord().toLowerCase();
            ArrayList<Dictionary> defs;

            if(hmap.containsKey(word)) {               //Checks if word is already in Dictonary(HashMap)
                defs = hmap.get(word);
                defs.add(entry);
            }
            else {                                     // If it is adds definitions and increases keyword count
                defs = new ArrayList<Dictionary>();
                defs.add(entry);
                keywords++;
            }
            hmap.put(word, defs);
            definitions++;
        }    

        System.out.println("! Loading completed..." + "\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + keywords); 
        System.out.println("----- Definitions: " + definitions + "\n"); 

        do {                       // Loop to allow interactive search
            String userInput;      //Used to store user input with word and params
            String word;           //Stores word only
            String param;          //Stores paramters such as Parts of Speech, Distinct, Reverse
            String[] cmdSplit;     //Splits up userInput to allow easy access to params
            boolean shouldPrint = true;
            cmdCount++;

            System.out.print("Search [" + cmdCount + "]: ");
            userInput = in.nextLine();
            cmdSplit = userInput.split(" ");
            if(cmdSplit.length > 0) {   //Checks to make sure the length is larger then 0
                word = cmdSplit[0].toLowerCase();
            }
            else {                      //Else itll just assign user the one word
                word = userInput.toLowerCase();
            }

            if(userInput.equalsIgnoreCase("!help") || userInput.equals("") || userInput.equals(" ")) {  //Checks if userinput requests help or is blank
                System.out.println("   |");
                System.out.println("   PARAMETER HOW-TO, please enter:" + "\n"
                + "   1. A search key -then 2. An optional part of speech -then" + "\n" 
                + "   3. An optional 'distinct' -then 4. An optional 'reverse'"
                );
                System.out.println("   |");
            }
            else if(userInput.equalsIgnoreCase("!q") || userInput.equalsIgnoreCase("!quit")) {          //Check to end program
                running = false;
                System.out.println("-----THANK YOU-----");
                break;
            }
            else if(hmap.containsKey(word)) {                                                           //Checks to ensure word is in the Hashmap
                ArrayList<Dictionary> pull = hmap.get(word);                                            //Pulls the defiitions and stores in new ArrayList 

                if(cmdSplit.length > 4) {                                                               //Checks if there is more then 4 parameters 
                    System.out.println("   |");
                    System.out.println("   PARAMETER HOW-TO, please enter:" + "\n"
                    + "   1. A search key -then 2. An optional part of speech -then" + "\n" 
                    + "   3. An optional 'distinct' -then 4. An optional 'reverse'"
                    );
                    System.out.println("   |");
                    shouldPrint = false;                                                                //Sets shouldPrint so that the following statements will not be fun and wil not print definitions.
                }
                if(cmdSplit.length > 1 && shouldPrint == true) {                                        //Checks if there is more thwn 2 parameters
                    param = cmdSplit[1].toLowerCase();

                    if(partOfSpeeches.contains(param)) {                                                //Modfies list to inputted parts of speech
                        pull = returnSamePartsOfSpeech(pull, param);
                    }
                    if(param.contains("reverse")) {                                                     //Modfies list to reverse the ArrayList
                        pull = reverseList(pull);
                    }
                    if(param.contains("distinct")) {                                                    //Modfies list to remove all duplicate values
                        pull = distinctRemoval(pull);
                    }
                    else if(!partOfSpeeches.contains(param) && !param.contains("reverse") && !param.contains("distinct")) {//if it does not contain any of the given parameters it will return errors and disregard it
                        System.out.println("   |");
                        System.out.println("   <The entered 2nd parameter '" + param + "' is NOT a part of speech.>");
                        System.out.println("   <The entered 2nd parameter '" + param + "' is NOT 'distinct'.>");
                        System.out.println("   <The entered 2nd parameter '" + param + "' is NOT 'reverse'.>");
                        System.out.println("   <The entered 2nd parameter '" + param + "' was disregarded.>");
                        System.out.println("   <The 2nd parameter should be a part of speech or 'distinct' or 'reverse'.>");
                        System.out.println("   |");
                    }
                }
                if(cmdSplit.length > 2 && shouldPrint == true) {                                        //Checks to make sure its only Distinct or Reverse
                    param = cmdSplit[2].toLowerCase();
                    if(param.contains("reverse")) {
                        pull = reverseList(pull);
                    }
                    if(param.contains("distinct")) {
                        pull = distinctRemoval(pull);
                    }
                    else if(!param.contains("reverse") && !param.contains("distinct")) {
                        System.out.println("   |");
                        System.out.println("   <The entered 3rd parameter '" + param + "' is NOT 'distinct'.>");
                        System.out.println("   <The entered 3rd parameter '" + param + "' is NOT 'reverse'.>");
                        System.out.println("   <The entered 3rd parameter '" + param + "' was disregarded.>");
                        System.out.println("   <The 3rd parameter should be 'distinct' or 'reverse'.>");
                        System.out.println("   |");
                    }
                }
                if(cmdSplit.length > 3 && shouldPrint == true) {                                        //Checks to make sure its only Reverse 
                    param = cmdSplit[3].toLowerCase();
                    if(param.contains("reverse")) {
                        pull = reverseList(pull);
                    }
                    else if(!param.contains("reverse")) {
                        System.out.println("   |");
                        System.out.println("   <The entered 4th parameter '" + param + "' was disregarded.>");
                        System.out.println("   <The 4th parameter should be 'reverse'.>");
                        System.out.println("   |");
                    }
                }
                
                if(!pull.isEmpty() && shouldPrint == true) {                                            //Checks to make sure arraylist isnt empty
                    System.out.println("   |");
                    for(Dictionary data : pull) {                                                       //Loops through the ArrayList for the definitions and prints them
                        System.out.println("   " + data);
                    }
                    System.out.println("   |");
                }
                else if(pull.isEmpty() && shouldPrint == true) {                                        //If empty prints default msg
                    System.out.println("   |");
                    System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
                    System.out.println("   |");
                    System.out.println("   |");
                    System.out.println("   PARAMETER HOW-TO, please enter:" + "\n"
                    + "   1. A search key -then 2. An optional part of speech -then" + "\n" 
                    + "   3. An optional 'distinct' -then 4. An optional 'reverse'"
                    );
                    System.out.println("   |");
                }
            }
            else if(!hmap.containsKey(word)) {                                                          //If word is not in Hashmap it will print not found
                System.out.println("   |");
                System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
                System.out.println("   |");
                System.out.println("   |");
                System.out.println("   PARAMETER HOW-TO, please enter:" + "\n"
                + "   1. A search key -then 2. An optional part of speech -then" + "\n" 
                + "   3. An optional 'distinct' -then 4. An optional 'reverse'"
                );
                System.out.println("   |");
            }
        }while(running);
    }

    public static ArrayList<Dictionary> distinctRemoval(ArrayList<Dictionary> data) {      
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        ArrayList<Dictionary> temp;
        ArrayList<String> partOfSpeeches = new ArrayList<String>(Arrays.asList("noun", "verb", "adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection")); //Holds ArrayList of parts of speech to compare to
        for(String list : partOfSpeeches) {
            temp = new ArrayList<Dictionary>();
            temp = returnSamePartsOfSpeech(data, list);
            temp = removesDuplicates(temp);
            sortedData.addAll(temp);
        }
        Collections.sort(sortedData);
        return sortedData;    
    }

    public static ArrayList<Dictionary> removesDuplicates(ArrayList<Dictionary> data) {                               //Removes all duplicate definitions from given list
        ArrayList<Dictionary> sortedData;
        String defs;
        HashMap<String, Dictionary> hmap = new HashMap<String, Dictionary>();

        for(Dictionary list : data) {
            defs = list.getDefinition();
            if(!hmap.containsKey(defs)) {
                hmap.put(defs, list);
            }
        }
        sortedData = new ArrayList<Dictionary>(hmap.values());
        Collections.sort(sortedData);
        return sortedData;
    }

    public static ArrayList<Dictionary> returnSamePartsOfSpeech(ArrayList<Dictionary> data, String partOfSpeech) {  //Returns all definitions with same parts of speech
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        for(Dictionary list : data) {
            if(list.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) { 
                sortedData.add(list);
            }
        }
        return sortedData;
    }

    public static ArrayList<Dictionary> reverseList(ArrayList<Dictionary> data) {                                   //Reverses all values in the given list
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        for(int i = data.size() -1 ; i >= 0 ; i--) {
            sortedData.add(data.get(i));
        }
        return sortedData;
    }
}
