import java.util.Scanner;

public class GameEnvironment {
    Scanner scan = new Scanner(System.in);
    public boolean alive;

    //game setup
    public int gameLength;
    public Farm gameFarm;
    public int day;
    public int actionsPerDay;

    public GameEnvironment() {
        alive = true;
        day = 0;
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
        System.out.println("Z. Perform an action");
        System.out.println("A. Check on farm");
        System.out.println("B. Check bank balance");
        System.out.println("C. Go to General Store");
        System.out.println("D. End the day");
        System.out.println("E. Quit\n");
        String option = scan.nextLine();

        if (option.equals("E")) {
            this.alive = false;
        } else if (option.equals("A")) {
            checkFarm();
        } else if (option.equals("B")) {
            checkBalance();
        } else if (option.equals("C")) {
            goGeneralStore();
        } else if (option.equals("D")) {
            endDay();
        } else if (option.equals("Z")) {
            actions();
        }
        
    }
    //Z. Perform an action
    public void actions() {
        System.out.println("A. Tend to crops");
        System.out.println("B. Feed animals");
        System.out.println("C. Play with animals");
        System.out.println("D. Tend to the farm land");
        System.out.println("E. Cancel\n");
        String option = scan.nextLine();

        if (option.equals("A")) {
            tendCrop();
        } else if (option.equals("B")) {
            feedAnimals();
        } else if (option.equals("C")) {
            System.out.println("A. Corn");
        } else if (option.equals("D")) {
            System.out.println("A. Corn");
        } else if (option.equals("E")) {
            System.out.println("A. Corn");
        }      
    }

    public void tendCrop() {
        String selection = "";
        System.out.println("What crop to tend to");
        System.out.println("A. Corn");
        System.out.println("B. Carrot");
        System.out.println("E. Cancel\n");

        String option = scan.nextLine();
        if (option.equals("A")) {
            selection = "Corn";
        } else if (option.equals("B")) {
            selection = "Carrot";
        }

        for (Crop crop : gameFarm.getCrops()) {
            if (crop.getCropType().equals(selection)) {
                crop.reduceDTH(1);
            }
        }
    }

    public void feedAnimals() {
        gameFarm.feedAllAnimals();     
    }

    public void playAnimals() {
        gameFarm.playAllAnimals();
    } 
     

    //A. Check on farm
    public void checkFarm() {
        System.out.println("What would you like to do?");
        System.out.println("A. Check on crops");
        System.out.println("B. Check on animals\n");
        String option = scan.nextLine();

        if (option.equals("A")) {
            checkCrops();
        } else if (option.equals("B")) {
            checkAnimals();
        }
    }

    public void checkCrops() {
        int count = 1;

        for (Crop crop : gameFarm.getCrops()) {
            System.out.println(count + ". " + crop);
            count += 1;
        }
    }

    public void checkAnimals() {
        int count = 1;

        for (Animal animal : gameFarm.getAnimals()) {
            System.out.println(count + ". " + animal);
            count += 1;
        }
    }



    //B. Check bank balance
    public void checkBalance() {
        System.out.println("Your current balance is $" + Integer.toString(gameFarm.getBank()) + "\n");
    }

    //C. Go to General Store
    public void goGeneralStore() {

        System.out.println("What would you like to do?");
        System.out.println("A. View Inventory");
        System.out.println("B. View Shop\n");
        String option = scan.nextLine();

        if (option.equals("A")) {
            viewInventory();
        } else if (option.equals("B")) {
            checkAnimals();
        }        
    }

    public void viewInventory() {
        int count = 1;

        checkBalance();
        System.out.println("Your items:");
        for (Item item : gameFarm.getItems()) {
            System.out.println(count + ". " + item);
            count += 1;
        }
    }


    public void viewShop() {
        System.out.println("uhhhhhhh");

    }


    //D. End the day
    public void endDay() {
        System.out.println("Going to bed\n");
        day += 1;

        endDayAnimals();
        endDayCrops();

        if (day == gameLength){
            alive = false;
        }
    }

    public void endDayAnimals() {
        int total = 0;
        for (Animal animal : gameFarm.getAnimals()) {
            total += animal.getMoneyGained();
        }
        gameFarm.addMoney(total);
    }

    public void endDayCrops() {
        gameFarm.reduceAllDTH(1);
    }

    //E. Quit


    //Game start
    public static void main(String[] args) {
        GameEnvironment instance = new GameEnvironment();
        while (instance.alive == true) {
            instance.mainGame();

        }
	}
}