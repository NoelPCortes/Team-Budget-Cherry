import java.util.Scanner;

import Characters.CharacterSkills;
import Characters.CharacterStats;
import Characters.ChelseyStats;
import Characters.NoelStats;
import Characters.RemrieStats;

import Entities.EntityStats;
import Entities.EntitySkills;

public class App {
    static CharacterStats character = new CharacterStats();
    static CharacterSkills [] characterSkills = new CharacterSkills[3];
    static {
        characterSkills[0] = new CharacterSkills();
        characterSkills[1] = new CharacterSkills();
        characterSkills[2] = new CharacterSkills();
    }
    static boolean noelIsLocked = true;
    static boolean remrieIsLocked = true;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        printStory("In the faraway land of CIT-U, students once lived in peace\n" + //
                        "Laughing in hallways, chilling at SM Seaside, and always sleeping \n" + //
                        "\n" + //
                        "But everything changed when a powerful force emerged\n" + //
                        "A force so feared it turned happy students into stressed zombies\n" + //
                        "\n" + //
                        "They call this force..... KhaiOS\n" + //
                        "\n" + //
                        "Armed with quizzes, endless CodeChum activities, and NetBeans tasks inside the freezing computer laboratory,\nKhaiOS threatens to fail the entire batch before Christmas break\n" + //
                        "\n" + //
                        "But now…. these brave heroes rise\n" + //
                        "Their quest? Defeat KhaiOS, survive the semester, and earn a peaceful Christmas break\n" + //
                        "\n" + //
                        "Will they make it.... or will they repeat this subject next year? \n" + //
                        "The fate of their grades rest in your hands!\n", 0); //Default set to 50, set it to 0 for faster print

        System.out.println("--------------------------------");
        System.out.println();
        System.out.println("          Start Game?");
        System.out.println("            [Y : N]");
        System.out.println();
        System.out.println("--------------------------------");
        System.out.print("Enter Choice: ");
        char runGame = sc.next().charAt(0);

        boolean characterChosen = false;
        
        boolean gameRunning = false; 
        if(Character.toUpperCase(runGame) == 'Y')
        {
            gameRunning = true;
        }
        while (gameRunning) {

            //Choosing characters
            while (!characterChosen) {
                chooseCharacter();
                if(character.getIsLocked())
                {
                    System.out.println("----------------------------------------------------------------");
                    System.out.println("           Character is locked choose someone else");
                    System.out.println("----------------------------------------------------------------");
                    System.out.println();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } 
                else 
                {
                    characterChosen = true;
                }
            }



            //Temporary solution to exit the game
            System.out.println("JUST EXIT MEN");
            char gameChoice = sc.next().charAt(0);
            if(Character.toUpperCase(gameChoice) == 'Y'){
                gameRunning = false;
            }
        }

        sc.close();
    }


    public static void printStory(String message, int delay){
        for(char c : message.toCharArray()){
            System.out.print(c);
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            }
        }
        System.out.println();
    }


    public static void chooseCharacter(){
        Scanner sc = new Scanner(System.in);

        CharacterStats displayCharacterStats = new CharacterStats();

        boolean characterChoosing = true;
        boolean characterChosen = false;

        do{
            int inputEntered = 0;
            char gameDecision = 'c';

            // Display Characters
            displayCharacterStats.printCharacterStats();
            if (!characterChosen)
            {
                System.out.println("Character(s)");
                //Character 1
                displayCharacterStats = new ChelseyStats
                                    (false); // Defaults to false
                System.out.println("[1] Chelsey - The System Thinker" + (displayCharacterStats.getIsLocked() ? "[Locked]" : ""));
                //Character 2
                displayCharacterStats = new NoelStats
                                    (noelIsLocked);
                System.out.println("[2] Noel - The Code Ace " + (displayCharacterStats.getIsLocked() ? "[Locked]" : ""));
                //Character 3
                displayCharacterStats = new RemrieStats
                                    (remrieIsLocked); 
                System.out.println("[3] Remrie - The Meticulous Researcher " + (displayCharacterStats.getIsLocked() ? "[Locked]" : ""));
                System.out.println();
            }

            if (characterChosen)
            {
                String RESET = "\u001B[0m";
                String RED = "\u001B[31m";
                String GREEN = "\u001B[32m";
                String YELLOW = "\u001B[33m";
                String BLUE = "\u001B[34m";
                
                
                if (character.getName().equalsIgnoreCase("Chelsey")) 
                {
                    characterSkills[0] = new CharacterSkills("Flowchart Blast", 1, 3, 15);//stun enemies for 1 turn
                    characterSkills[0].setDescription(
                        "Shows a highly advance flowchart that confuses the enemy"
                        );
                    characterSkills[1] = new CharacterSkills("Pseudo Shield", 30, 4, 20);// reduces dmg for 30% for allies for 2 turns
                    characterSkills[1].setDescription(
                        "Enemy has just seen a psuedo-code for the first time and weakened their attack"
                        );
                    characterSkills[2] = new CharacterSkills("Debug Cheer", 20, 3, 15);//restores hp and mana(hp/2) to teammates
                    characterSkills[2].setDescription(
                        "You cheered too much. It motivated your teammates"
                        );
                } 
                else if (character.getName().equalsIgnoreCase("Noel"))
                {
                    characterSkills[0] = new CharacterSkills("Speedrun Slash", 5, 0, 15); //[manaConsumed] consumes health
                    characterSkills[0].setDescription(
                        "Endless attack but consumes your physical, mental, emotional health. But her feelings to you wasnt endless"
                        );
                    characterSkills[1] = new CharacterSkills("Syntax Storm", 50, 2, 45);
                    characterSkills[1].setDescription(
                        "Gives everything you got but drains your energy. Like how your energy was drained by losing her"
                        );
                    characterSkills[2] = new CharacterSkills("Compile & Crash", 50, 0, 2); //[manaConsumed] stun for turns
                    characterSkills[2].setDescription(
                        "Deals too much damage that it made you unconscious. Like how unconscious her feelings is to you"
                        );
                } 
                else if (character.getName().equalsIgnoreCase("Remrie"))
                {
                    characterSkills[0] = new CharacterSkills("Frustration Smash", 100, 2, 10);
                    characterSkills[0].setDescription(
                        "Breaks the system. Has a chance to kill an enemy instantly"
                        );
                    characterSkills[1] = new CharacterSkills("Help Request", 20, 3, 15);
                    characterSkills[1].setDescription(
                        "Care package dropping and inside it are endless google search"
                        );
                    characterSkills[2] = new CharacterSkills("Research Mode", 15, 2, 12);
                    characterSkills[2].setDescription(
                        "Research on enemy weak points"
                        );
                }
                
                while(characterChosen) {
                    System.out.println("[F] : CHOOSE CHARACTER ");
                    System.out.println("[R] : CHECK SKILLS ");
                    System.out.println("[E] : CHANGE CHARACTER ");
                    System.out.print("ENTER CHOICE: ");
                    gameDecision = sc.next().charAt(0);
                    System.out.println();
                    if (Character.toUpperCase(gameDecision) == 'R')
                    {
                        if (character.getName().equalsIgnoreCase("Chelsey")){
                            System.out.println(YELLOW + "*" + RED + "*" + YELLOW + "*" + RED + "*"+ YELLOW + "*" + RESET + "  --------------------------------");
                            System.out.println(YELLOW + "*****" + RESET + "  Chelsey - The System Thinker");
                            System.out.println(YELLOW + " *** " + RESET + "  Chelsey has survived cram sessions by turning chaos into pseudocodes. She believes that with proper planning they can outsmart ");
                        } else if (character.getName().equalsIgnoreCase("Noel")) {
                            System.out.println(GREEN + " " + RED + "*" + GREEN + "*" + RED + "*"+ GREEN + " " + RESET + "  --------------------------------");
                            System.out.println(GREEN + "*****" + RESET + "  Noel - The Code Ace");
                            System.out.println(GREEN + " *** " + RESET + "  Known as the “Legend of the Leaderboard”, Noel never misses a challenge. He wants to prove he can defeat KhaiOS faster than anyone. ");
                        } else if (character.getName().equalsIgnoreCase("Remrie")) {
                            System.out.println(BLUE + "*" + RED + "*" + BLUE + "*" + RED + "*"+ BLUE + "*" + RESET + "  --------------------------------");
                            System.out.println(BLUE + " *** " + RESET + "  Remrie - The Task Breaker");
                            System.out.println(BLUE + "  *  " + RESET + "  Remrie takes assignments seriously, spending hours researching. But when problems persist frustration fuels his determination to break ");
                        }
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println("                        SKILL 1");
                        System.out.println(" " + characterSkills[0].getNameOfSkill());
                        System.out.println(" - " + characterSkills[0].getDescription());
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println("                        SKILL 2");
                        System.out.println(" " + characterSkills[1].getNameOfSkill());
                        System.out.println(" - " + characterSkills[1].getDescription());
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println("                        SKILL 3");
                        System.out.println("" + characterSkills[2].getNameOfSkill());
                        System.out.println(" - " + characterSkills[2].getDescription());
                        System.out.println("------------------------------------------------------------------------------------------------");
                        System.out.println();
                        System.out.print("Enter anything to go back: ");
                        sc.next();
                    }
                    else if (Character.toUpperCase(gameDecision) == 'E')
                    {
                        characterChosen = false;
                    } 
                    else if (Character.toUpperCase(gameDecision) == 'F')
                    {
                        characterChoosing = false;
                        break;
                    }
                }
            } 
            else
            {
                System.out.print("CHOOSE YOUR CHARACTER: ");
                inputEntered = sc.nextInt();
                if(inputEntered >= 1 && inputEntered <= 3)
                {
                    characterChosen = true;
                } else {
                    System.out.println("Invalid input must be only [1 - 3]");
                }
            }

            if(characterChoosing){
                switch (inputEntered)
                {
                    case 1 -> { character = new ChelseyStats
                                (false);
                                displayCharacterStats = new ChelseyStats
                                (false); }
                    case 2 -> { character = new NoelStats
                                (true); 
                                displayCharacterStats = new NoelStats
                                (true); }
                    case 3 -> { character = new RemrieStats
                                (true);
                                displayCharacterStats = new RemrieStats
                                (true); }
                    default -> { character = new CharacterStats(); 
                                displayCharacterStats = new CharacterStats(); }
                }
            }

        }while(characterChoosing);
    }
}