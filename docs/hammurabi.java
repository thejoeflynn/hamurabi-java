
import java.util.Random;
import java.util.Scanner;

public class Hammurabi {
    Random random = new Random();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Hammurabi().playGame();
    }

    void playGame() {
        // game starting values
        int population = 100;
        int bushels = 2800;
        int acres = 1000;
        int landPrice = 19;

        for (int year = 1; year <= 10; year++) {
            System.out.println("Year " + year);
            printSummary (year, population, 0, 5, bushels, acres, landPrice, 3000, 3, 200);
        }
    }

    void printSummary(int year, int population, int starvation, int immigrants, int bushels, int acres, int landPrice, int harvest, int yield, int rats) {
        System.out.println("O Great Hammurabi!");
        System.out.println("You are in year [" + year + "] of your ten year rule.");
        System.out.println("In the previous year [" + starvation + "] people starved to death.");
        System.out.println("In the previous year [" + immigrants + "] people entered the kingdom.");
        System.out.println("The population is now [" + population + "]");
        System.out.println("We harvested [" + harvest + "] bushels per acre.");
        System.out.println("Rats destroyed [" + rats + "] bushels, leaving [" + bushels + "] in storage.");
        System.out.println("The city owns [" + acres + "] acres of land.");
        System.out.println("Land is currently worth [" + landPrice + "] bushels per acre.");

    }

    int getNumber(String message) {
        while (true) {
            System.out.println("message");
            try {
                return scanner.nextInt();
            } catch (Exception e) {
                System.out.println("\"" + scanner.next() + "\" isn't a number!");
            }
        }
    }

    int askHowManyAcresToBuy(int price, int bushels) {
        int acres = getNumber("O Great Hammurabi, how many acres do you wish to buy?");
        while (acres * price > bushels) {
            System.out.println("O Great Hammurabi, surely you jest! You only have " + bushels + " bushels!");
            acres = getNumber("O Great Hammurabi, how many acres do you wish to buy?");
        }
        return acres;
    }

    int askHowManyAcresToSell(int acresOwned) {
        int acres = getNumber("O Great Hammurabi, how many acres do you wish to sell? ");
        while (acres > acresOwned) {
            System.out.println("O Great Hammurabi, surely you jest! You only own " + acresOwned + " acres!");
            acres = getNumber("O Great Hammurabi, how many acres do you wish to sell? ");
        }
        return acres;
    }

    int askHowMuchGrainToFeedPeople(int bushels){
        int grain = getNumber("O Great Hammurabi, how many bushels do you wish to feed your people? ");
        while (grain > bushels) {
            System.out.println("O Great Hammurabi, surely you jest! You only have " + bushels + " bushels!");
            grain = getNumber("O Great Hammurabi, how many bushels do you wish to feed your people? ");
        }
        return grain;
    }

    int askHowManyAcresToPlant(int acresOwned, int population, int bushels) {
        int acres = getNumber("O Great Hammurabi, how many acres do you wish to plant? ");
        while (acres > acresOwned || acres * 2 > bushels || acres > population * 10) {
            if (acres > acresOwned) {
                System.out.println("O Great Hammurabi, surely you jest! You only own " + acresOwned + " acres!");
            } else if (acres * 2 > bushels) {
                System.out.println("O Great Hammurabi, surely you jest! You only have " + bushels + " bushels of grain!");
            } else if (acres > population * 10) {
            System.out.println("O Great Hammurabi, surely you jest! You only have " + population + " people to tend the fields!");
            }
            acres = getNumber("O Great Hammurabi, how many acres do you wish to plant? ");
    }
    return acres;
    }

    int plagueDeaths(int population) {
        if (random.nextInt(100) < 15) {
            return population / 2;
        }
        return 0;
    }

    int starvationDeaths (int population, int bushelsFedToPeople){
        int peopleFed = bushelsFedToPeople / 20;
        if (peopleFed >= population){
            return 0;
        }
        return population - peopleFed;
    }

    boolean uprising(int population, int howManyStarved){
        return howManyStarved > population * 0.45;
    }

    int immigrants(int population, int acresOwned, int grainInStorage) {
        return (20 * acresOwned + grainInStorage) / (100 * population) + 1;
    }

    int harvest(int acresPlanted){
        int yield = random.nextInt(6) + 1;
        return acresPlanted * yield;
    }

    int grainEatenByRats(int bushels) {
        if (random.nextInt(100) < 40){
            int percent = random.nextInt(21) + 10;
            return bushels * percent / 100;
        }
        return 0;
    }

    int newCostOfLand(){
        return random.nextInt(7) + 17;
    }
}
