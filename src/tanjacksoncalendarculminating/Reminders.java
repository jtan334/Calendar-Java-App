/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanjacksoncalendarculminating;

import java.util.ArrayList;

/**
 *
 * @author Jackson
 */
public class Reminders extends Entries {

    /**
     * String that denotes the status of the reminder
     */
    private String Complete = "Incomplete";
    /**
     * Arraylist of entries
     */
    private ArrayList<Entries> entries;

    /**
     * Creates a reminder object that includes all the fields of entries but
     * includes the complete string
     *
     * @param entryType the type of entry reminder is as an integer which is 2
     * for reminders
     * @param typeName the type name of the entry which is reminder
     * @param name the name of the reminder
     * @param details the details of the reminder
     * @param date the date the reminder is set for
     * @param Complete the status of the reminder
     */
    public Reminders(int entryType, String typeName, String name, String details, int date, String Complete) {
        super(entryType, typeName, name, details, date);
        this.Complete = Complete;
    }

    /**
     * Completion function that completes the reminder
     *
     * @param Complete Completion as string
     * @return
     */
    public String Complete(String Complete) {
        return Complete = "Completed";

    }

    /**
     * getter for complete
     *
     * @return Completion as a String
     */
    public String getComplete() {
        return Complete;
    }

    /**
     * Overrides the print function to print the reminder in a user friendly way
     */
    @Override
    public void print() {

        System.out.println("The Reminder: " + getName() + " \nDue Date: June " + getDate() + " \nDetails: " + getDetails() + " \nCompletion: " + Complete);
        System.out.println("");
    }

    /**
     * Adds a reminder to the array list
     *
     * @param e an entry
     */
    public void addEntry(Entries e) {
        entries.add(e);
    }

    /**
     * Removes an entry from the array list
     *
     * @param e an entry
     */
    public void removeEntry(Entries e) {
        entries.remove(e);
    }

    /**
     * Overrides the print to txt formatting for a reminder
     *
     * @return Strings that will be written to the file
     */
    @Override
    public String printToTxt() {
        return (getEntryType() + "," + getTypeName() + "," + getName() + "," + getDetails() + "," + getDate() + "," + getComplete());
    }
}
