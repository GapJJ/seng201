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
        System.out.println("1 - Normal");
        System.out.println("2 - Rich");
        String type = scan.nextLine();
        Farm farm = new Farm(playerFarmer, type);
        gameFarm = farm;
    }


    //main game
    public void mainGame() {
   
        System.out.println("What would you like to do?");
        System.out.println("1. Perform an action");
        System.out.println("2. Check on farm");
        System.out.println("3. Check bank balance");
        System.out.println("4. Go to General Store");
        System.out.println("5. End the day");
        System.out.println("6. Quit\n");
        String option = scan.nextLine();

        if (option.equals("6")) {
            this.alive = false;
        } else if (option.equals("2")) {
            checkFarm();
        } else if (option.equals("3")) {
            checkBalance();
        } else if (option.equals("4")) {
            goGeneralStore();
        } else if (option.equals("5")) {
            endDay();
        } else if (option.equals("1")) {
            actions();
        }
        
    }
    //Z. Perform an action
    public void actions() {
        System.out.println("1. Tend to crops");
        System.out.println("2. Feed animals");
        System.out.println("3. Play with animals");
        System.out.println("4. Tend to the farm land");
        System.out.println("5. Cancel\n");
        String option = scan.nextLine();

        if (option.equals("1")) {
            tendCrop();
        } else if (option.equals("2")) {
            feedAnimals();
        } else if (option.equals("3")) {
            System.out.println("A. Corn");
        } else if (option.equals("4")) {
            System.out.println("A. Corn");
        } else if (option.equals("5")) {
            System.out.println("A. Corn");
        }      
    }

    public void tendCrop() {
        String selection = "";
        System.out.println("What crop to tend to");
        System.out.println("1. Corn");
        System.out.println("2. Carrot");
        System.out.println("E. Cancel\n");

        String option = scan.nextLine();
        if (option.equals("1")) {
            selection = "Corn";
        } else if (option.equals("2")) {
            selection = "Carrot";
        }

        String cropAction = cropActionSelector();
        if (cropAction.equals("Water")){
            gameFarm.tendCrop(selection);
        } else if (cropAction.equals("Nutrient Water")){
            Item item = gameFarm.remove(new NutrientWater());
            gameFarm.tendCrop(selection, item);
        }
    }

    public void feedAnimals() {
        gameFarm.feedAllAnimals();     
    }

    public void playAnimals() {
        gameFarm.playAllAnimals();
    } 
     
    public String cropActionSelector() {
        System.out.println("What would you like to use for your crops?");
        System.out.println("1. Water");
        System.out.println("2. Item");
        System.out.println("3. Cancel\n");
        String option = scan.nextLine();

        if (option.equals("1")) {
            return "Water";
        } else if (option.equals("2")) {
            return cropItemSelector();
        } else {
            return "Water";
        }
    }

    public Item cropItemSelector() {
        System.out.println("Which item would you like to use?");

        int count = 1;
        for (Item item : gameFarm.getItems()) {

            if (item instanceof CropItem) {
                System.out.println(count + ". " + item.getName());
                count += 1;
            }
        }
        String option = scan.nextLine();
        
        count = 0;
        for (Item item : gameFarm.getItems()) {
            if (item instanceof CropItem) {
                if (Integer.toString(count).equals(option)){
                    console.log(item.getName());
                    return item;
                }
                count += 1;
            }
        }
        return option;
    }


    //A. Check on farm
    public void checkFarm() {
        System.out.println("What would you like to do?");
        System.out.println("1. Check on crops");
        System.out.println("2. Check on animals\n");
        String option = scan.nextLine();

        if (option.equals("1")) {
            checkCrops();
        } else if (option.equals("2")) {
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
        System.out.println("\n");
    }



    //B. Check bank balance
    public void checkBalance() {
        System.out.println("Your current balance is $" + Integer.toString(gameFarm.getBank()) + "\n");
    }

    //C. Go to General Store
    public void goGeneralStore() {

        System.out.println("What would you like to do?");
        System.out.println("1. View Inventory");
        System.out.println("2. View Shop\n");
        String option = scan.nextLine();

        if (option.equals("1")) {
            viewInventory();
        } else if (option.equals("2")) {
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

        System.out.println("Congratulations on finishing! You managed to earn $" + Integer.toString(instance.gameFarm.getBank()));

    }	
}
