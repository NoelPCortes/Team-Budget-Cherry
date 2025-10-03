import java.util.Scanner;

import Characters.CharacterSkills;
import Characters.CharacterStats;
import Characters.ChelseyStats;
import Characters.NoelStats;
import Characters.RemrieStats;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        CharacterStats character = new CharacterStats();
        CharacterSkills [] characterSkills = new CharacterSkills[3];
        characterSkills[0] = new CharacterSkills();
        characterSkills[1] = new CharacterSkills();
        characterSkills[2] = new CharacterSkills();

        character = chooseCharacter();

        sc.close();
    }

    public static CharacterStats chooseCharacter(){
        Scanner sc = new Scanner(System.in);

        CharacterStats character = new CharacterStats();
        CharacterSkills [] characterSkills = new CharacterSkills[3];
        characterSkills[0] = new CharacterSkills();
        characterSkills[1] = new CharacterSkills();
        characterSkills[2] = new CharacterSkills();
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
                                    (false); // Fill argument "isLocked = false"
                System.out.println("[1] Chelsey - The System Thinker" + displayCharacterStats.getIsLocked());
                //Character 2
                displayCharacterStats = new NoelStats
                                    (true);
                System.out.println("[2] Noel - The Code Ace " + displayCharacterStats.getIsLocked());
                //Character 3
                displayCharacterStats = new RemrieStats
                                    (true); // Fill argument "isLocked = true"
                System.out.println("[3] Remrie - The Meticulous Researcher " + displayCharacterStats.getIsLocked());
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
                    characterSkills[0] = new CharacterSkills("Flowchart Blast", 5, 2, 10);//stun enemies for 1 turn
                    characterSkills[0].setDescription(
                        "Shows a highly advance flowchart that confuses the enemy"
                        );
                    characterSkills[1] = new CharacterSkills("Pseudo Shield", 10, 3, 15);// reduces dmg for enemies for 2 turn
                    characterSkills[1].setDescription(
                        "Enemy has just seen a psuedo-code for the first time and weakened their attack"
                        );
                    characterSkills[2] = new CharacterSkills("Debug Cheer", 10, 2, 10);//restores hp and mana to teammates
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
                            System.out.println(YELLOW + "*" + RED + "*" + YELLOW + "*" + RED + "*"+ YELLOW + "*" + RESET + " " + " Skill 1 : " + characterSkills[0].getNameOfSkill() + " - " + characterSkills[0].getDescription());
                            System.out.println(YELLOW + "*****" + RESET + " " + " Skill 2 : " + characterSkills[1].getNameOfSkill() + " - " + characterSkills[1].getDescription());
                            System.out.println(YELLOW + " *** " + RESET + " " + " Skill 3 : " + characterSkills[2].getNameOfSkill() + " - " + characterSkills[2].getDescription());
                        } else if (character.getName().equalsIgnoreCase("Noel")) {
                            System.out.println(GREEN + " " + RED + "*" + GREEN + "*" + RED + "*"+ GREEN + " " + RESET + " " + " Skill 1 : " + characterSkills[0].getNameOfSkill() + " - " + characterSkills[0].getDescription());
                            System.out.println(GREEN + "*****" + RESET + " " + " Skill 2 : " + characterSkills[1].getNameOfSkill() + " - " + characterSkills[1].getDescription());
                            System.out.println(GREEN + " *** " + RESET + " " + " Skill 3 : " + characterSkills[2].getNameOfSkill() + " - " + characterSkills[2].getDescription());
                        } else if (character.getName().equalsIgnoreCase("Remrie")) {
                            System.out.println(BLUE + "*" + RED + "*" + BLUE + "*" + RED + "*"+ BLUE + "*" + RESET + " " + " Skill 1 : " + characterSkills[0].getNameOfSkill() + " - " + characterSkills[0].getDescription());
                            System.out.println(BLUE + " *** " + RESET + " " + " Skill 2 : " + characterSkills[1].getNameOfSkill() + " - " + characterSkills[1].getDescription());
                            System.out.println(BLUE + "  *  " + RESET + " " + " Skill 3 : " + characterSkills[2].getNameOfSkill() + " - " + characterSkills[2].getDescription());
                        }
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

        System.out.println("Haluh na out");
        
        sc.close();
        return character;
    }
}