package virtual_pet;

public class VirtualPet {

    private String petName;
    private int hungerLevel;
    private int thirstLevel;
    private int boredomLevel;
    private int tiredness;
    private String description;
    private boolean isAlive;

    public VirtualPet(String petName, String description) {
        this.petName = petName;
        this.description = description;
    }

    public VirtualPet(String petName, int hungerLevel, int thirstLevel, int boredomLevel, int tiredness, String description, boolean isAlive) {
        this.petName = petName;
        this.hungerLevel = hungerLevel;
        this.thirstLevel = thirstLevel;
        this.boredomLevel = boredomLevel;
        this.tiredness = tiredness;
        this.description = description;
        this.isAlive = isAlive;
    }

    public String getPetName() {
        return petName;
    }

    public int getHungerLevel() {
        return hungerLevel;
    }

    public int getThirstLevel() {
        return thirstLevel;
    }

    public int getBoredomLevel() {
        return boredomLevel;
    }

    public int getTiredness() {
        return tiredness;
    }

    public String getDescription() {
        return description;
    }

    public boolean getIsAlive(){
        return isAlive;
    }

    public void giveFood() {
        hungerLevel -=  20;
    }

    public void giveWater() {
        thirstLevel -= 20;
    }

    public void giveLove() {
        boredomLevel -= 20;
    }

    public void giveSleep() {
        tiredness -= 20;
    }

    public void tick() {
        hungerLevel += 7;
        thirstLevel += 7;
        boredomLevel += 3;
        tiredness += 7;
    }

    public void petStatLimiter() {
        if (hungerLevel < 0) {
            hungerLevel = 0;
        }
        if (thirstLevel < 0) {
            thirstLevel = 0;
        }
        if (boredomLevel < 0) {
            boredomLevel = 0;
        }
        if (tiredness < 0) {
            tiredness = 0;
        }
    }
}

