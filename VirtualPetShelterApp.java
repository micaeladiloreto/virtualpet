package virtual_pet;

import java.util.Scanner;

public class VirtualPetShelterApp {


    Scanner scan = new Scanner(System.in);
    VirtualPetShelter shelterPets;

    public VirtualPetShelterApp() {
        this.shelterPets = new VirtualPetShelter();
    }

    public void Play() {

        boolean playAgain = true;


        while (playAgain) {
            System.out.println("Welcome to the pet shelter! " +
                    "\nThis may be your first day on the job but you seem like you're cut out for it! " +
                    "\nLet me introduce you to the animals that live here!.");

            VirtualPet pet1 = new VirtualPet("Bruce", 50, 50, 50, 50, "He's a ghost cat that loves ghost mice.", true);
            VirtualPet pet2 = new VirtualPet("Wally", 50, 50, 50, 50, "A large parrot, won't stop talking.", true);
            VirtualPet pet3 = new VirtualPet("William", 50, 50, 50, 50, "A small goat who just tries to make friends.", true);
            VirtualPet pet4 = new VirtualPet("Fred", 50, 50, 50, 50, "An owl, very boring, just sits.", true);


            shelterPets.alreadyInShelter(pet1);
            shelterPets.alreadyInShelter(pet2);
            shelterPets.alreadyInShelter(pet3);
            shelterPets.alreadyInShelter(pet4);

            introducePets();

            while (winConditions(shelterPets)) {
                scoreBoard();
                userChoice(scan, shelterPets);
                shelterPets.tickAll();
                shelterPets.allPetStatLimiter();
            }
            playAgain = isPlayAgain();
        }
        System.out.println("Thank you for playing!");
    }

    private boolean winConditions(VirtualPetShelter shelterPets) {
        for (VirtualPet pet : shelterPets.petStorage) {
            if (pet.getHungerLevel() >= 100 || pet.getThirstLevel() >= 100 || pet.getTiredness() >= 100 || pet.getBoredomLevel() >= 100) {
                System.out.println(pet.getPetName() + " has died! You lose.");
                return false;
            }
        }
        if (shelterPets.petStorage.size() <= 0) {
            System.out.println("All of the pets have been adopted! You win!!!");
            return false;
        }
        return true;
    }

    private void userChoice(Scanner scan, VirtualPetShelter shelterPets) {
        System.out.println("Choose an option:");
        System.out.println("1. Feed pets in the shelter.");
        System.out.println("2. Water pets in the shelter.");
        System.out.println("3. Play with one of the pets.");
        System.out.println("4. Lay pets down for a nap.");
        System.out.println("5. Admit a new pet to the shelter.");
        System.out.println("6. Adopt a pet out to a home.");

        int careChoice = scan.nextInt();

        switch (careChoice) {
            case 1:
                shelterPets.feedAll();
                break;
            case 2:
                shelterPets.waterAll();
                break;
            case 3:
                playPet();
                break;
            case 4:
                shelterPets.napAll();
                break;
            case 5:
                admitPet();
                break;
            case 6:
                adoptPet();
                break;
        }
    }


    private void scoreBoard() {
        System.out.println("|-------------------------------------------------------------------------------|");
        System.out.println("|---------------|------------Current Shelter Stats--------------|---------------|");
        System.out.println("|\t  Pets\t\t|\t  Hunger\t|\t  Thirst\t|\t  Boredom\t|\t Tiredness\t|");
        System.out.println("|---------------|---------------|---------------|---------------|---------------|");

        for (VirtualPet shelterPet : shelterPets.showAllPetStats()) {
            System.out.println("|\t" + shelterPet.getPetName() + "\t\t|\t\t" +
                    shelterPet.getHungerLevel() + " \t\t|\t\t" +
                    shelterPet.getThirstLevel() + " \t\t|\t\t" +
                    shelterPet.getBoredomLevel() + " \t\t|\t\t" +
                    shelterPet.getTiredness() + " \t\t|");
        }

        System.out.println("|---------------|---------------|---------------|---------------|---------------|");
    }

    public void introducePets() {
        for (VirtualPet shelterPet : shelterPets.showAllPetStats()) {
            System.out.println(shelterPet.getPetName() + ". " + shelterPet.getDescription());
        }
    }

    private boolean isPlayAgain() {
        boolean playAgain;
        System.out.println("Would you like to play again? Y/N");
        scan.nextLine();
        String yOrN = scan.nextLine();

        if (yOrN.equalsIgnoreCase("Y")) {
            playAgain = true;
        } else {
            playAgain = false;
        }

        return playAgain;
    }

    private void playPet() {
        boolean petNotPlayedWith = true;
        System.out.println("Which pet would you like to play with?");
        while (petNotPlayedWith) {
            for (VirtualPet pet : shelterPets.showAllPetStats()) {
                System.out.println(pet.getPetName() + "  " + pet.getDescription());
            }
            String playPet = scan.nextLine();
            boolean foundPet = false;
            for (VirtualPet pet : shelterPets.petStorage) {
                if (pet.getPetName().equalsIgnoreCase(playPet)) {
                    pet.giveLove();
                    foundPet = true;
                    System.out.println("\nYou give some one-on-one time to " + playPet + ".");
                    petNotPlayedWith = false;
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that animal is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }
    }

    private void adoptPet() {
        System.out.println("Which animal are you looking to adopt?");

        while (true) {
            for (VirtualPet pet : shelterPets.showAllPetStats()) {
                System.out.println(pet.getPetName() + "  " + pet.getDescription());
            }

            String petToAdopt = scan.nextLine();
            boolean foundPet = false;
            for (VirtualPet pet : shelterPets.petStorage) {
                if (pet.getPetName().equalsIgnoreCase(petToAdopt)) {
                    foundPet = true;
                    shelterPets.adopt(pet.getPetName());
                    System.out.println("Thank you for adopting " + petToAdopt + ".");
                    break;
                }
            }
            if (!foundPet) {
                System.out.println("Sorry, that animal is not in our shelter.\nPlease choose from the pets listed below.");
            } else {
                break;
            }
        }

    }

    private void admitPet() {
        System.out.println("In order to admit an animal, please provide the following information as it is requested.");
        System.out.print("Animal Name: ");

        String admittedAnimalName = scan.nextLine();

        System.out.print("Animal species and a brief description: ");

        String admittedAnimalDescription = scan.nextLine();

        System.out.println("Thank you for admitting " + admittedAnimalName);

        shelterPets.admit(admittedAnimalName, admittedAnimalDescription);
    }


}