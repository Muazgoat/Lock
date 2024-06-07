package com.muaz;
/**
 * @author Muaz Abdulhafiz
 * @date 06/07/2024
 * a lock program that gives the user attempts to unlock the lock and if they get it wrong multiple times the alarm sets off
 */

public class Lock {
    // Private instance variables

    /** The combination required to unlock the lock. */
    private String combination;
    
    /** The number of incorrect attempts to unlock the lock. */
    private int incorrectAttempts;
    
    /** Represents whether the lock is currently unlocked. */
    private boolean unlocked;

    // Default constructor

    /**
     * Constructs a lock with the default combination "0000".
     */
    public Lock() {
        this.combination = "0000";
        this.incorrectAttempts = 0;
        this.unlocked = false;
    }

    // Overloaded constructor

    /**
     * Constructs a lock with a specified combination.
     * 
     * @param combination The combination required to unlock the lock.
     */
    public Lock(String combination) {
        this.combination = combination;
        this.incorrectAttempts = 0;
        this.unlocked = false;
    }

    // Accessors method

    /**
     * Checks if the lock is currently unlocked.
     * 
     * @return true if the lock is unlocked, false otherwise.
     */
    public boolean isUnlocked() {
        return unlocked;
    }

    // Attempts to unlock the lock

    /**
     * Attempts to unlock the lock with a provided combination.
     * If the combination matches, the lock is unlocked.
     * If the combination is incorrect, the number of incorrect attempts is tracked.
     * If the incorrect attempts exceed a threshold, an alarm is triggered.
     * 
     * @param combo The combination attempted to unlock the lock.
     */
    public void attemptUnlock(String combo) {
        if (combo.equals(combination)) {
            unlocked = true;
            incorrectAttempts = 0;
            System.out.println("Click.");
        } else {
            incorrectAttempts++;
            if (incorrectAttempts >= 3) {
                System.out.println("Alarm!");
            }
        }
    }

    // Changes the combination of the lock

    /**
     * Changes the combination of the lock if it is currently unlocked.
     * 
     * @param newCombo The new combination to set for the lock.
     * @return true if the combination was successfully changed, false otherwise.
     */
    public boolean changeCombo(String newCombo) {
        if (unlocked) {
            combination = newCombo;
            lock(); // locks the lock after changing the combination
            return true;
        } else {
            return false;
        }
    }

    // Locks the lock

    /**
     * Locks the lock.
     * Sets the unlocked status to false.
     */
    public void lock() {
        unlocked = false;
    }
}
