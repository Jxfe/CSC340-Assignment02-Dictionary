import java.util.*;

public class Assignment02 {
    public static void main(String [] args) {
        int cmdCount = 0;
        int keywords = 0;
        int definitions = 0;
        boolean running = true;
        Scanner in = new Scanner(System.in);
        HashMap<String, ArrayList<Dictionary>> hmap = new HashMap<String, ArrayList<Dictionary>>();
        String[] partOfSpeeches = {"noun", "verb", "adjective", "adverb", "pronoun", "preposition", "conjunction", "interjection"};

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


        System.out.println("! Loading completed..." + "\n");

        System.out.println("===== DICTIONARY 340 JAVA =====");
        System.out.println("----- Keywords: " + keywords); //Needs variable to count keywords.
        System.out.println("----- Definitions: " + definitions + "\n"); 

        do { // Loop to allow interactive search
            String userInput;
            String word;
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
            else if(hmap.containsKey(word)) { //Checks if hmap has the word
                ArrayList<Dictionary> pull = hmap.get(word); //Pulls the defs 

                //Reqs reverse dinstinct and parts of speech if statements here and modifies pull before it prints data out


                for(Dictionary data : pull) { //Loops through the ArrayList for the definitions and prints them
                    System.out.println("   " + data);
                }
            }
            else if(!hmap.containsKey(word)) { // does this if hmap doesnt have it
                System.out.println("   <NOT FOUND> To be considered for the next release. Thank you.");
            }

            System.out.println("   |");
        }while(running);
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

    public static ArrayList<Dictionary> distinctRemoval(ArrayList<Dictionary> data) { //Distinct - removes duplicates from output - prob needs work to not edit out diff parts of speech words
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        for(int i = 0; i < data.size(); i++) { 
            if(sortedData.contains(data.get(i))) {
                sortedData.add(data.get(i));
            }
        }
        return sortedData;
    }

    public static ArrayList<Dictionary> reverseList(ArrayList<Dictionary> data) { //Reverses the list and returns reversed list -Working
        ArrayList<Dictionary> sortedData = new ArrayList<Dictionary>();
        Collections.sort(sortedData); //Sorts it before it reverse loops and add to list
        for(int i = data.size() -1 ; i >= 0 ; i--) { //Loops through ArrayList from the end and adds it to new list
            sortedData.add(data.get(i));
        }
        return sortedData;
    }
}
