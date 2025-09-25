import java.util.Scanner;
import java.text.DecimalFormat;

public class App{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        CharacterStats character = new CharacterStats();
        CharacterStats displayCharacterStats = new CharacterStats();

        boolean gameRunning = true;
        boolean characterChosen = false;

        do{
            int inputEntered = 0;
            char gameDecision = 'c';

            displayCharacterStats.printCharacterStats();

            System.out.println("Character(s)");

            displayCharacterStats = new ChelseyStats(false); // Fill argument "isLocked = false"
            System.out.println("Chelsey " + displayCharacterStats.getIsLocked());

            displayCharacterStats = new NoelStats("Noel", "DPS", 75, 100, true);
            System.out.println("Noel - The Code Ace " + displayCharacterStats.getIsLocked());

            displayCharacterStats = new RemrieStats(); // Fill argument "isLocked = true"
            System.out.println("Remrie " + displayCharacterStats.getIsLocked());
            System.out.println();

            if(characterChosen)
            {
                System.out.println("Check skills? [Y/N]: ");
                gameDecision = sc.next().charAt(0);
                if(Character.toUpperCase(gameDecision) == 'Y')
                {
                    System.out.println("");
                }

                System.out.print("End game? [Y/N]: ");
                gameDecision = sc.next().charAt(0);
                if(Character.toUpperCase(gameDecision) == 'Y')
                {
                    gameRunning = false;
                }
                else
                {
                    characterChosen = false;
                }
            } 
            else
            {
                System.out.print("Choose your character: ");
                inputEntered = sc.nextInt();
                if(inputEntered >= 1 && inputEntered <= 3)
                {
                    characterChosen = true;
                }
            }

            switch(inputEntered)
            {
                case 1 -> character = new ChelseyStats(false); // fill the argument "isLocked = false"
                case 2 -> { character = new NoelStats("Noel", "DPS", 75, 100, true); 
                            displayCharacterStats = new NoelStats("Noel", "DPS", 75, 100, true); }
                case 3 -> character = new RemrieStats(); // fill the argument "isLocked = true"
                default -> character = new CharacterStats();
            }

        }while(gameRunning);

        
    }
}
