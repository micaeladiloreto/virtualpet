package virtual_pet;

import java.util.ArrayList;
import java.util.Scanner;

public class VirtualPetShelter {

    ArrayList<VirtualPet> petStorage = new ArrayList<VirtualPet>();

    public void alreadyInShelter(VirtualPet pet) {
        petStorage.add(new VirtualPet(pet.getPetName(), pet.getHungerLevel(), pet.getThirstLevel(), pet.getBoredomLevel(), pet.getTiredness(), pet.getDescription(), pet.getIsAlive()));
    }

    public ArrayList<VirtualPet> showAllPetStats() {
        return petStorage;
    }

    public String showPetName() {
        for (VirtualPet findPetName : petStorage) {
            return findPetName.getPetName();
        }
        return null;
    }

    public void feedAll() {
        for (VirtualPet petsNeedFood : petStorage) {
            petsNeedFood.giveFood();
        }

        System.out.println("\nYou give all the animals some grub!");
    }

    public void waterAll() {
        for (VirtualPet petsNeedWater : petStorage) {
            petsNeedWater.giveWater();
        }

        System.out.println("\nYou fill up the animals' water bowls!");
    }

    public void napAll() {
        for (VirtualPet petsNeedSleep : petStorage) {
            petsNeedSleep.giveSleep();
        }

        System.out.println("You tuck all the animals in for the night. ZZzZZzzzzZZzz");
    }

    public void admit(String admittedAnimalName, String admittedAnimalDescription) {
        petStorage.add(new VirtualPet(admittedAnimalName, 50, 50, 50, 50, admittedAnimalDescription, true));
    }

    public void adopt(String petToAdopt) {
        petStorage.removeIf(pet -> pet.getPetName().equalsIgnoreCase(petToAdopt));
    }

    public void tickAll() {
        for (VirtualPet turnTick : petStorage) {
            turnTick.tick();
        }
    }

    public void allPetStatLimiter() {
        for (VirtualPet statNormalize : petStorage) {
            statNormalize.petStatLimiter();
        }
    }


}
