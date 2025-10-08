//Characters
import Characters.CharacterSkills;
import Characters.CharacterStats;
import Characters.ChelseyStats;
import Characters.NoelStats;
import Characters.RemrieStats;

//Enemies
import Entities.EntitySkills;
import Entities.EntityStats;
import Entities.CodechumBug;
import Entities.CramZombie;
import Entities.DeadlineGhost;
import Entities.ExceptionPhantom;
import Entities.FirewallGuardian;
import Entities.KhaiBreaker;
import Entities.KhaiOS;
import Entities.LagDemon;
import Entities.PopQuizGoblin;
import Entities.SyntaxSerpent;
import Entities.SysAdmin;

//Libraries
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    //Locked or Unlocked state of character
    static boolean noelIsLocked = true;
    static boolean remrieIsLocked = true;

    static ArrayList<CharacterStats> character = new ArrayList<>();
    static ArrayList<ArrayList<CharacterSkills>> characterSkills = new ArrayList<>();
    static {
        character.add(new ChelseyStats(false)); // Character 1
        character.add(new NoelStats(noelIsLocked)); // Character 2
        character.add(new RemrieStats(remrieIsLocked)); // Character 3

        characterSkills.add(new ArrayList<>(List.of( // Character 1 Skill
            addSkill("Flowchart Blast", 1, 3, 15, "Shows a highly advanced flowchart that confuses the enemy"),
            addSkill("Pseudo Shield", 30, 4, 20, "Enemy has just seen a pseudocode for the first time and weakened their attack"),
            addSkill("Debug Cheer", 20, 3, 15, "You cheered too much. It motivated your teammates")
        )));

        characterSkills.add(new ArrayList<>(List.of( // Character 2 Skill
            addSkill("Speedrun Slash", 5, 0, 15, "Endless attack but consumes your physical, mental, emotional health. But her feelings for you weren't endless"),
            addSkill("Syntax Storm", 50, 2, 45, "Gives everything you got but drains your energy. Like how your energy was drained by losing her"),
            addSkill("Compile & Crash", 50, 0, 2, "\"Deals too much damage that it made you unconscious. Like how unconscious her feelings were to you\"")
        )));

        characterSkills.add(new ArrayList<>(List.of( // Character 3 Skill
            addSkill("Frustration Smash", 100, 2, 10, "Breaks the system. Has a chance to kill an enemy instantly"),
            addSkill("Help Request", 20, 3, 15, "Care package dropping and inside it are endless Google searches"),
            addSkill("Research Mode", 15, 2, 12, "Research on enemy weak points")
        )));
    }

    private static CharacterSkills addSkill(String name, int dmg, int cooldown, int manaConsumes, String desc){
        CharacterSkills skill = new CharacterSkills(name, dmg, cooldown, manaConsumes);
        skill.setDescription(desc);
        return skill;
    }

    //Enemies
    static ArrayList<ArrayList<EntityStats>> enemy = new ArrayList<>();
    static {
        enemy.add(new ArrayList<EntityStats>());//World 1
        enemy.add(new ArrayList<EntityStats>());//World 2
        enemy.add(new ArrayList<EntityStats>());//World 3

        enemy.get(0).add(new CramZombie());
        enemy.get(0).add(new DeadlineGhost());
        enemy.get(0).add(new PopQuizGoblin());

        enemy.get(1).add(new CodechumBug());
        enemy.get(1).add(new ExceptionPhantom());
        enemy.get(1).add(new SyntaxSerpent());
        enemy.get(1).add(new KhaiBreaker());

        enemy.get(2).add(new LagDemon());
        enemy.get(2).add(new FirewallGuardian());
        enemy.get(2).add(new SysAdmin());
        enemy.get(2).add(new KhaiOS());
    }

    //TODO: HAVE INVENTORY FOR SHOP

    //Able to move or not;
    static boolean playerMove = true;
    static boolean enemyMove = true;

    //Game Loop
    static boolean gameRunning = true; 

    //Global Variable
    static boolean characterChosen = false;
    static int gameCurrency = 10;
    int characterCtr = 1; //Defaults to 1 as starting available placement

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        showTitleScreen();

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


        while (gameRunning) {

            mainMenu();

        }

        sc.close();
    }


    static void showTitleScreen(){
        System.out.println("\n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        System.out.println(" _____   _____  ");
        System.out.println("|_   _| |_   _| ");
        System.out.println("  | |     | |   ");
        System.out.println("  | |     | |   QUEST");
        System.out.println("  | |     | |   ");
        System.out.println(" _| |_    | |   ");
        System.out.println("|_____|   |_|   ");
        System.out.println("\n/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\/\\");
        System.out.println();
    }


    static void printStory(String message, int delay){
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


    static int DisplayChoice(){//Returns the precedence of the chosen multiplechoie:D
        Scanner sc = new Scanner(System.in);
        int precedence = 0;
        while(precedence == 0){
            System.out.println("------------------------------------------------------------------------------");
            System.out.println("        [1]Show Heroes  -  Who will save you from KhaiOS?");
            System.out.println("        [2]Show Enemies -  Who will hinder you");
            System.out.println("        [3]Show worlds  -  The journey you have to take");
            System.out.println("        [4]Show Shops   -  Whatever you may need to help you");
            System.out.println("        [5]Start Game!  -  Are you brave enough to defeat KhaiOS?");
            System.out.println("        [6]Exit         -  Coward");
            System.out.println("------------------------------------------------------------------------------");
            boolean properInput = false;
            while(!properInput){
                try {
                    System.out.print("Enter Choice: ");
                    precedence = sc.nextInt();
                    if(precedence >= 1 && precedence <= 6)
                    {
                        properInput = true;
                    }
                    else
                    {
                        System.out.println("Invalid input must be only [1 - 6]");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("CHOOOOSEEE A. NUNBEREJRAOIDHJOSAHDOIASHJDIOHAIOFHO");
                    sc.next();
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException es) {
                        Thread.currentThread().interrupt();
                    }
                    precedence = 0;
                }
            }
        }
        return precedence;
    }


    static void mainMenu(){
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        int chosenPrecedence = DisplayChoice();
        switch(chosenPrecedence){
            case 1 -> {
                characterChosen = false;
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
                        //TODO: MAKE THE PLAYER CHOSE TO SWITCH CHARACTER
                        //TODO: MAKE THE PLAYER ADD/APPEND A NEW CHARACTER
                        //TODO: HAVE A POSITION TO SET PLACEMENT
                        //TODO: HAVE A AVAILABLE HERO PLACEMENT STARTS WITH 1 MAX IS 3
                    }
                }
            }
            case 2 -> {
                showEnemies();
            }
            case 3 -> {
                if(characterChosen){
                    System.out.println("YIPEEE");
                } else {
                    System.out.println("No characters chosen.");
                }
                //TODO: SHOW MAP AND HAVE ENEMIES SET TO THEM
            }
            case 4 -> {
                System.out.println("YIPPEEEEEE");
                //TODO: SHOW ITEMS AND SELL THEM
            }
            case 5 -> {
                System.out.println("YIPPEE");
                //TODO: START GAME BUT LET THE PLAYER CHOOSE THEIR MAP
                //DEFAULTS TO WORLD 1 AVAILABLE AND OTHERS ARE LOCKED
            }
            case 6 -> {
                System.out.println("-----------------------------");
                System.out.println();
                System.out.println("        Exting...");
                System.out.println();
                System.out.println("-----------------------------");
                gameRunning = false;
            }
        }
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
    }

    //TODO: Change every called array to arraylist AND properly print everything to their same spot with Chelsey being first, Noel in the middle, and Remrie last
    //REMINDER: DO NOT REMOVE THREADINGS, TRY - CATCH, is all:>
    //Returns the order of the character
    static int chooseCharacter(){
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
                
                while (characterChosen) {
                    System.out.println("[F] : CHOOSE CHARACTER ");
                    System.out.println("[R] : CHECK SKILLS ");
                    System.out.println("[E] : CHANGE CHARACTER ");
                    System.out.print("ENTER CHOICE: ");
                    gameDecision = sc.next().charAt(0);
                    System.out.println();
                    switch (Character.toUpperCase(gameDecision)) {
                        case 'R' -> {
                            if (character.getName().equalsIgnoreCase("Chelsey"))
                            {
                                System.out.println(YELLOW + "*" + RED + "*" + YELLOW + "*" + RED + "*"+ YELLOW + "*" + RESET + "  --------------------------------");
                                System.out.println(YELLOW + "*****" + RESET + "  Chelsey - The System Thinker");
                                System.out.println(YELLOW + " *** " + RESET + "  Chelsey has survived cram sessions by turning chaos into pseudocodes. She believes that with proper planning they can outsmart ");
                            } 
                            else if (character.getName().equalsIgnoreCase("Noel")) 
                            {
                                System.out.println(GREEN + " " + RED + "*" + GREEN + "*" + RED + "*"+ GREEN + " " + RESET + "  --------------------------------");
                                System.out.println(GREEN + "*****" + RESET + "  Noel - The Code Ace");
                                System.out.println(GREEN + " *** " + RESET + "  Known as the “Legend of the Leaderboard”, Noel never misses a challenge. He wants to prove he can defeat KhaiOS faster than anyone. ");
                            } 
                            else if (character.getName().equalsIgnoreCase("Remrie")) 
                            {
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
                        case 'E' -> characterChosen = false;
                        case 'F' -> {
                            characterChosen = false;
                            characterChoosing = false;
                            break;
                        }
                        default -> {

                        }
                    }
                }
            } 
            else
            {
                boolean properInput = false;
                    try {
                        System.out.print("CHOOSE YOUR CHARACTER: ");
                        inputEntered = sc.nextInt();
                        if(inputEntered >= 1 && inputEntered <= 3)
                        {
                            characterChosen = true;
                            properInput = true;
                        } 
                        else 
                        {
                            System.out.println("Invalid input must be only [1 - 3]");
                        }
                    } catch (InputMismatchException e){
                        System.out.println("AAAAAAAHHHH ANNOYYINGGG THE SYSSTEEMMMM");
                        try {
                            Thread.sleep(1500);
                        } catch (InterruptedException es){
                            Thread.currentThread().interrupt();
                        }
                        sc.next();
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
                                (noelIsLocked); 
                                displayCharacterStats = new NoelStats
                                (noelIsLocked); }
                    case 3 -> { character = new RemrieStats
                                (remrieIsLocked);
                                displayCharacterStats = new RemrieStats
                                (remrieIsLocked); }
                    default -> { character = new CharacterStats(); 
                                displayCharacterStats = new CharacterStats(); }
                }
            }
        }while(characterChoosing);
    }

    static void showEnemies(){
        Scanner sc = new Scanner(System.in);

        ArrayList<EntityStats> entityStats = new ArrayList<>();
        entityStats.add(new CramZombie());
        entityStats.add(new PopQuizGoblin());
        entityStats.add(new DeadlineGhost());
        entityStats.add(new CodechumBug());
        entityStats.add(new ExceptionPhantom());
        entityStats.add(new SyntaxSerpent());
        entityStats.add(new KhaiBreaker());
        entityStats.add(new LagDemon());
        entityStats.add(new FirewallGuardian());
        entityStats.add(new SysAdmin());
        entityStats.add(new KhaiOS());

        for(EntityStats eS : entityStats){
            System.out.println();
            System.out.println("-----------------------------------------");
            System.out.println("    " + eS.getName());
            System.out.println("-----------------------------------------");
            eS.printModel();
            System.out.println("Description -");
            System.out.println("    " + eS.getDescription());
            eS.printStats();
            System.out.println();
        }
        System.out.print("Enter anything to continue: ");
        sc.next();
    }
}