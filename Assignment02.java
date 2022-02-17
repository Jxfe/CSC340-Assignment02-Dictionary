import java.util.*;
import java.lang.*;

public class Assignment02 {
    public static void main(String [] args) {
        int cmdCount = 0;
        int keywords = 0;
        int definitions = 0;
        boolean running = true;
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<Dictionary>> hmap = new HashMap<String, ArrayList<Dictionary>>();
        ArrayList<String> partOfSpeeches = new ArrayList<String>(Arrays.asList("noun", "verb", "adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection"));

        System.out.println("! Loading data..."); 

        for (Dictionary entry : Dictionary.values()) {
            String word = entry.getWord().toLowerCase();
            ArrayList<Dictionary> defs;

            if(hmap.containsKey(word)) { //Checks if word is already in Dictonary(HashMap)
                defs = hmap.get(word);
                defs.add(entry);
            }
            else { // If it is adds definitions and increases keyword count
                defs = new ArrayList<Dictionary>();
                defs.add(entry);
                keywords++;
            }

            hmap.put(word, defs);
            definitions++;
        }    


        //Debug zone
        String code = "reverse";
        ArrayList<Dictionary> apple = hmap.get(code);
        for(Dictionary data : apple) { //Loops through the ArrayList for the definitions and prints them
            System.out.println("   " + data);
        }
        System.out.println("_____________");
        apple = reverseList(apple);
        for(Dictionary data : apple) { //Loops through the ArrayList for the definitions and prints them
            System.out.println("   " + data);
        }


        System.out.println("! Loading completed..." + "\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + keywords); //Needs variable to count keywords.
        System.out.println("----- Definitions: " + definitions + "\n"); 

        do { // Loop to allow interactive search
            String userInput;
            String word;
            String partOfSpeech;
            String[] cmdSplit;
            cmdCount++; //Increases count at beginning of loop to replicate Search [x]

            System.out.print("Search [" + cmdCount + "]: ");
            userInput = in.nextLine();
            cmdSplit = userInput.split(" ");
            if(cmdSplit.length > 0) {
                word = cmdSplit[0].toLowerCase();
            }
            else {
                word = userInput;
            }
            System.out.println("   |");

            if(userInput.equalsIgnoreCase("!help") || userInput.equals("") || userInput.equals(" ")) { // Blank or !help check
                System.out.println("PARAMETER HOW-TO, please enter:" + "\n"
                + "1. A search key -then 2. An optional part of speech -then" + "\n" 
                + "3. An optional 'distinct' -then 4. An optional 'reverse'"
                );
            }
            else if(userInput.equalsIgnoreCase("!q") || userInput.equalsIgnoreCase("!quit")) { //Check to end loop
                running = false;
                System.out.println("-----THANK YOU-----");
                break;
            }
            else if(hmap.containsKey(word)) { //Parts of Speech, Reverse, or Distinct
                ArrayList<Dictionary> pull = hmap.get(word); //Pulls the defs 

                if(cmdSplit.length > 1) { // Parts of Speech modifer 
                    partOfSpeech = cmdSplit[1].toLowerCase();

                    if(partOfSpeeches.contains(partOfSpeech)) { //Part of Speech Check
                        pull = returnSamePartsOfSpeech(pull, partOfSpeech);
                    }
                    if(partOfSpeeches.contains("reverse")) {    // Reverse Check
                        pull = reverseList(pull);
                    }
                    if(partOfSpeech.contains("distinct")) {
                        pull = distinctRemoval(pull);
                    }
                }
                if(cmdSplit.length > 2) { // Distinct or Reverse
                    partOfSpeech = cmdSplit[2].toLowerCase();
                    if(partOfSpeeches.contains("reverse")) {
                        pull = reverseList(pull);
                    }
                    if(partOfSpeech.contains("distinct")) {
                        pull = distinctRemoval(pull);
                    }
                }
                if(cmdSplit.length > 3) { // Reverse only
                    partOfSpeech = cmdSplit[3].toLowerCase();
                    if(partOfSpeech.contains("reverse")) {
                        pull = reverseList(pull);
                    }
                }

                if(!pull.isEmpty()) { //Checks to make sure arraylist isnt empty
                    for(Dictionary data : pull) { //Loops through the ArrayList for the definitions and prints them
                        System.out.println("   " + data);
                    }
                }
                else { //If empty prints default msg
                    System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
                }
            }
            else if(!hmap.containsKey(word)) { // does this if hmap doesnt have it
                System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
            }

            System.out.println("   |");
        }while(running);
    }

    public static ArrayList<Dictionary> distinctRemoval(ArrayList<Dictionary> data) { //Working removes all duplicates not for part of speech tho
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

    public static ArrayList<Dictionary> returnSamePartsOfSpeech(ArrayList<Dictionary> data, String partOfSpeech) { // Returns just nouns or w,e -Working
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        for(Dictionary list : data) {
            if(list.getPartOfSpeech().equalsIgnoreCase(partOfSpeech)) { 
                sortedData.add(list);
            }
        }
        return sortedData;
    }

    public static ArrayList<Dictionary> reverseList(ArrayList<Dictionary> data) { //Reverses the list and returns reversed list -Not Working bc its sorting by fucking part of speech
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        //Collections.sort(data); //Sorts it before it reverse loops and add to list sorts by part of speech
        for(int i = data.size() -1 ; i >= 0 ; i--) { //Loops through ArrayList from the end and adds it to new list
            sortedData.add(data.get(i));
        }
        return sortedData;
    }
}
