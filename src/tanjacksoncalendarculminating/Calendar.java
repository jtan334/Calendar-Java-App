/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanjacksoncalendarculminating;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 *
 * @author Jackson
 */
public class Calendar {

    /**
     * An array list that contains all of the entries
     */
    ArrayList<Entries> entryList = new ArrayList();

    /**
     * A method that adds events to the entry list
     *
     * @param e Event object
     */
    public void addEvent(Events e) {
        boolean add = false;
        for (Entries t : entryList) {

            if (e.getName().equals(t.name) && e.getDate() == t.date) {
                System.out.println("This entry already exists!");
                add = false;
            } else {
                add = true;
            }
        }
        if (add == true) {
            entryList.add(e);
            System.out.println("The event has been added. ");
        }
    }

    /**
     * Adds a reminder object to the entry list
     *
     * @param r Reminder object
     */
    public void addReminder(Reminders r) {
        boolean add = false;
        for (Entries t : entryList) {

            if (r.getName().equals(t.name) && r.getDate() == t.date) {
                System.out.println("This entry already exists!");
                add = false;
            } else {
                add = true;
            }
        }
        if (add == true) {
            entryList.add(r);
            System.out.println("The reminder has been added");
        }
    }

    /**
     * Method that loads the entry list from the text file
     *
     * @param fileName the name of the file
     * @throws FileNotFoundException
     */
    public void loadsEntryList(String fileName) throws FileNotFoundException {
        Scanner s = new Scanner(new File("src\\tanjacksoncalendarculminating\\" + fileName));
        do {
            String[] entries = (s.nextLine()).split(",");

            for (int i = 0; i < entries.length; i++) {

            }
            if (Integer.parseInt(entries[0]) == 1) {
                entryList.add(new Events(Integer.parseInt(entries[0]), entries[1], entries[2], entries[3], Integer.parseInt(entries[4]), Integer.parseInt(entries[5])));
            } else if (Integer.parseInt(entries[0]) == 2) {
                entryList.add(new Reminders(Integer.parseInt(entries[0]), entries[1], entries[2], entries[3], Integer.parseInt(entries[4]), entries[5]));
            } else {
                entryList.add(new Events(0, "", "", "", 0, 0));
            }
        } while (s.hasNext());
    }

    /**
     * Method that sorts and lists by date closest to furthest
     */
    public void listAndSortByDate() {
        Collections.sort(entryList, (a, b) -> a.getDate() < b.getDate() ? -1 : a.getDate() == b.getDate() ? 0 : 1);
        for (Entries e : entryList) {

            e.print();
        }

    }

    /**
     * Method that sorts and lists entries alphabetically
     */
    public void listAndSortByName() {
        Collections.sort(entryList, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        for (Entries e : entryList) {

            e.print();

        }

    }

    /**
     * Search method that uses the start date of an entry
     *
     * @param userDate user data of the start date used to search the entry list
     */
    public void dateSearch(int userDate) {
        boolean found = false;
        for (Entries e : entryList) {
            if (userDate == e.getDate()) {
                e.print();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("No entry found. Make sure you correctly spelled the entry with correct spacing!");
            System.out.println("");
        }
    }

    /**
     * Search method that uses the user input of the name of the entry
     *
     * @param userName
     */
    public void nameSearch(String userName) {
        boolean found = false;
        for (Entries e : entryList) {
            if (userName.equalsIgnoreCase(e.getName())) {
                e.print();
                found = true;
            }
        }
        if (found == false) {
            System.out.println("No entry found. Make sure you correctly spelled the entry with correct spacing!");
            System.out.println("");
        }
    }

    /**
     * Prints all the entries in the entry list
     */
    public void printAllEntries() {

        for (Entries e : entryList) {
            e.print();
        }
    }

    /**
     * Saves the entries in the entry list into the txt file
     *
     * @param fileName the file name that will be written into
     * @throws IOException
     */
    public void saveEntriesList(String fileName) throws IOException {
        BufferedWriter r = new BufferedWriter(new FileWriter("src\\tanjacksoncalendarculminating\\" + fileName, false));

        for (Entries e : entryList) {
            r.write(e.printToTxt());
            r.newLine();

        }
        r.close();
    }

    /**
     * Removes an entry using the date and name of the entry
     *
     * @param name name of the entry that the user inputted
     * @param date start date of the event that the user inputted
     */
    public void removeEntry(String name, int date) {
        for (Entries ee : entryList) {
            try {
                if (name.equalsIgnoreCase(ee.getName()) && date == ee.getDate()) {
                    entryList.remove(ee);
                }
            } catch (java.lang.IndexOutOfBoundsException e) {
                System.out.println(ee.getName() + " does not exist");
            }
            return;

        }
    }

    /**
     * Checks if the date and name of an entry is in the entry list
     *
     * @param userName entry name that the user inputted as a string
     * @param userDate entry start date that the user inputted as an int
     * @return
     */
    public boolean nameDateSearch(String userName, int userDate) {

        for (Entries ee : entryList) {
            if (userName.equalsIgnoreCase(ee.getName()) && userDate == ee.getDate()) {
                ee.print();
                entryList.remove(ee);
                return true;

            }
        }
        System.out.println(userName + " on June " + userDate + "Entry does not exist");
        return false;
    }

    /**
     * edits an entry but replacing all of the fields
     *
     * @param name name of entry as a string user generated
     * @param date start date of entry
     * @param details details of the entry
     * @param typeNum type of entry as a number
     * @param endDate end date of the entry for events
     */
    public void editEntry(String name, int date, String details, int typeNum, int endDate) {

        if (typeNum == 1) {
            Events ee = new Events(typeNum, "Event", name, details, date, endDate);
            entryList.add(ee);
        } else {
            Reminders r = new Reminders(typeNum, "Reminder", name, details, date, "Incomplete");
            entryList.add(r);
        }
    }
}
