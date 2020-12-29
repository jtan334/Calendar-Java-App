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
/**
 *
 */
abstract class Entries {

    /**
     * The type of entry denoted by 1 for events or 2 for reminders
     */
    int entryType;
    /**
     * The type of entry
     */
    String typeName;
    /**
     * Name of the entry
     */
    String name;
    /**
     * Details of the entry
     */
    String details;
    /**
     * Start date of the entry
     */
    int date;

    /**
     * Creates an object called entries that include all of the fields listed
     * above
     *
     * @param entryType the type of entry reminder or event as an integer 1 or 2
     * @param typeName the type of entry in string
     * @param name the name of the entry
     * @param details the details of the entry
     * @param date the date of the entry
     */
    public Entries(int entryType, String typeName, String name, String details, int date) {
        this.entryType = entryType;
        this.typeName = typeName;
        this.name = name;
        this.details = details;
        this.date = date;

    }

    /**
     * returns the start date of an entry
     *
     * @return the start date of the entry as an int
     */
    public int getDate() {
        return date;
    }

    /**
     * returns the entry type as an int
     *
     * @return entry type as a 1 or a 2
     */
    public int getEntryType() {
        return entryType;
    }

    /**
     * returns the name of the entry
     *
     * @return entry name as a string
     */
    public String getName() {
        return name;
    }

    /**
     * returns the details of the entry
     *
     * @return String details of an
     */
    public String getDetails() {
        return details;
    }

    /**
     * returns the title of event or reminder
     *
     * @return the type of entry name as a string
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * Prints the entry in a user friendly way
     */
    public abstract void print();

    /**
     * Prints to the txt file
     *
     * @return a formatted String to print in the txt file
     */
    public abstract String printToTxt();

}
