
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
}
