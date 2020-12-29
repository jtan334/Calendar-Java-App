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
public class Events extends Entries {

    /**
     * the date that the event ends at
     */
    private int endDate;
    /**
     * the arraylist that contains entries, which the add event uses
     */
    private ArrayList<Entries> entries;
    /**
     * the entry number of events which is 1
     */
    private final int entryNumber = 1;

    /**
     * Creates the event object that includes all of the fields of entries and
     * an end date
     *
     * @param entryNumber entry number denoting the type of entry which is 1 for
     * events
     * @param typeName the type name which is Event
     * @param name the name of the event
     * @param details the details of the event
     * @param date the start date of the event
     * @param endDate the end date of the event
     */
    public Events(int entryNumber, String typeName, String name, String details, int date, int endDate) {
        super(entryNumber, typeName, name, details, date);
        this.endDate = endDate;
    }

    /**
     * Gets the end date
     *
     * @return the end date of the event
     */
    public int getEndDate() {
        return endDate;
    }

    /**
     * sets the end date
     *
     * @param endDate the end date of the event
     */
    public void setEndDate(int endDate) {
        this.endDate = endDate;
    }

    /**
     * Overrides the print function in a format that makes sense for events
     */
    @Override
    public void print() {

        System.out.println("The Event: " + getName() + " \nStart Date: June " + getDate() + " \nEnd Date: June " + getEndDate() + " \nDetails: " + getDetails());
        System.out.println("");
    }

    /**
     * Overrides the print to txt file in the event format
     *
     * @return formatted fields for the txt file
     */
    @Override
    public String printToTxt() {

        return (getEntryType() + "," + getTypeName() + "," + getName() + "," + getDetails() + "," + getDate() + "," + getEndDate());

    }

    /**
     * adds an event to the entry list
     *
     * @param e an event
     */
    public void addEntry(Entries e) {
        entries.add(e);
    }

    /**
     * removes an event on the entry list
     *
     * @param e an event
     */
    public void removeEntry(Entries e) {
        entries.remove(e);
    }

}
