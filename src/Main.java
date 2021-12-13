
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static int countOfWrongGuesses = 1;
    private static String RandomElementString;

    public static void main(String[] args) throws IOException {

        // for reading a file

        // bufferedReader is used to get string value from textFile
        BufferedReader bufferedReader = new BufferedReader(new FileReader("E:\\intellij projects\\HangMan\\src\\ListOfWords.txt"));

        // String value to store word from textFile
        String s;

        // creating arraylist
        ArrayList<String> ListOfWordsArrayList = new ArrayList<>();

        // whileLoop to loop through all values of textFile
        while ((s = bufferedReader.readLine()) != null) {
            //System.out.println(s);

            // adds text file values to arraylist
            ListOfWordsArrayList.add(s);

        } // end of while loop
        bufferedReader.close();

        // printing out value of arraylist
        System.out.println(ListOfWordsArrayList);
        // creating random value

        Random random = new Random();
        // creating integer to store random value
        int randomWord = random.nextInt(ListOfWordsArrayList.size());

        // convert randomWord into a String
        RandomElementString = ListOfWordsArrayList.get(randomWord);

        // printing out RandomElementString to see if it is String value
        System.out.println(RandomElementString);

        // char c = RandomElementString.charAt(0);// prints first letter
        // System.out.println("1st character is: " + c);

        // arraylist to store individual char values of random word selected
        ArrayList<Character> charValue = new ArrayList<>();


        for (int i = 0; i < RandomElementString.length(); i++) {
            charValue.add(RandomElementString.charAt(i));
        }

        System.out.println(charValue);


        Scanner scanner = new Scanner(System.in);
        int countOfCorrectGuesses = 0;

        // arraylist to store user input of characters to compare against randomly selected word
        ArrayList<Character> playerGuessesArrayList = new ArrayList<>();


        // this while loop will run while CountOfWrongGuesses is less than 8 meaning 7 tries before complete hangman
        // CountOfWrongGuesses starts of at 1
        // or program will run until CountOfCorrectGuesses equal length of charValue arraylist
        while (countOfWrongGuesses < 8 || countOfCorrectGuesses >= charValue.size()) {

            System.out.println("\nplease select a letter: ");
            // scanner for user input
            String userLetterGuess = scanner.nextLine();

            if (RandomElementString.contains(userLetterGuess)) {
                // checking if the RandomElementString contains user input
                // adding user input to playerGuessesArrayList
                playerGuessesArrayList.add(userLetterGuess.charAt(0));
                countOfCorrectGuesses++;
                System.out.println("correct count is " + countOfCorrectGuesses);
            } else {
                // check if user input does not match RandomElementString
                System.out.println("Wrong  answer  try again");
                // tell user the number of wrong guesses they have achieved
                System.out.println("your wrong answer count is: " + countOfWrongGuesses);

                // call hangman image method
                hangmanImage();
                // tell user how many tries they got left
                System.out.println("you have this amount of tries left" + (7 - countOfWrongGuesses));
                // increases count of wrong guesses variable
                countOfWrongGuesses++;
            } // end of else if statement


            if (playerGuessesArrayList.equals(charValue)) {
                // ends game if user has all correct letter of word guessed
                System.out.println("you won ");
                break;
            }

            for (int i = 0; i < charValue.size(); i++) {
                if (playerGuessesArrayList.contains(RandomElementString.charAt(i))) {
                    // if player guess correct adds user input to hangman grid
                    System.out.print(RandomElementString.charAt(i));

                } else {
                    // prints out hangman grid for remaining letters of word
                    System.out.print("_ ");

                } // end of if else statement
            } // end of for loop i

        } // while loop true

    } // end of public static void Main method


    public static void hangmanImage() {
        if (countOfWrongGuesses == 1) {
            System.out.println("Wrong guess, try again");
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println();
            System.out.println("___|___");
            System.out.println();
        }
        if (countOfWrongGuesses == 2) {
            System.out.println("Wrong guess, try again");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (countOfWrongGuesses == 3) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   | ");
            System.out.println("___|___");
        }
        if (countOfWrongGuesses == 4) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (countOfWrongGuesses == 5) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |");
            System.out.println("___|___");
        }
        if (countOfWrongGuesses == 6) {
            System.out.println("Wrong guess, try again");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |           |");
            System.out.println("   |           |");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
        }
        if (countOfWrongGuesses == 7) {
            System.out.println("GAME OVER!");
            System.out.println("   ____________");
            System.out.println("   |          _|_");
            System.out.println("   |         /   \\");
            System.out.println("   |        |     |");
            System.out.println("   |         \\_ _/");
            System.out.println("   |          _|_");
            System.out.println("   |         / | \\");
            System.out.println("   |          / \\ ");
            System.out.println("___|___      /   \\");
            System.out.println("GAME OVER! The word was: " + RandomElementString);
        }
    } // end of hangmanImage method


} // end of public class Main

// https://www.guru99.com/how-to-split-a-string-in-java.html
//https://www.codegrepper.com/code-examples/java/get+random+String+from+array+list
// https://stackoverflow.com/questions/7853502/how-to-convert-parse-from-string-to-char-in-java
// https://beginnersbook.com/2014/06/how-to-convert-char-to-string-and-a-string-to-char-in-java/


// https://www.javatpoint.com/java-string-to-char
// https://www.codegrepper.com/code-examples/java/java+char+arraylist


