import java.util.Scanner;

public class GameEnvironment {
    Scanner scan = new Scanner(System.in);
    public boolean alive;

    //game setup
    public int gameLength;
    public Farm gameFarm;

    public GameEnvironment() {
        alive = true;
        System.out.println("select game length (1~5)");
        String days = scan.nextLine();
        gameLength = Integer.parseInt(days);
        System.out.println(this.gameLength);   
        Farmer playerFarmer = new Farmer();
        setFarmType(playerFarmer); 
    }

    public void setFarmType(Farmer playerFarmer) {
        System.out.println("Please select a farm type");
        System.out.println("A - Normal");
        System.out.println("B - Rich");
        String type = scan.nextLine();
        Farm farm = new Farm(playerFarmer, type);
        gameFarm = farm;
    }
    //main game
    public void mainGame() {
   
        System.out.println("What would you like to do?");
        System.out.println("A. Check on farm");
        System.out.println("B. Check bank balance");
        System.out.println("C. Go to General Store");
        System.out.println("D. Quit\n");
        String option = scan.nextLine();

        if (option.equals("D")) {
            this.alive = false;
        } else if (option.equals("B")) {
            checkBalance();
        } else if (option.equals("A")) {
            checkCrops();
        }
        
    }

    public void checkCrops() {
        int count = 1;

        for (Crop crop : gameFarm.getCrops()) {
            System.out.println(count + ". " + crop);
            count += 1;
        }

    }


    //Money Stuff
    public void checkBalance() {
        System.out.println("Your current balance is $" + Integer.toString(gameFarm.getBank()) + "\n");
    }

    public static void main(String[] args) {
        GameEnvironment instance = new GameEnvironment();
        while (instance.alive == true) {
            instance.mainGame();

        }
	}
}