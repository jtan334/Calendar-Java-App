/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tanjacksoncalendarculminating;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Jackson
 */
public class TanJacksonCalendarCulminating {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {

        Calendar c = new Calendar();
        c.loadsEntryList("Entries.txt");
        System.out.println("Welcome to your personal June Calendar! ");
        System.out.println("");
        System.out.println("NOTE: All days are listed as numbers");
        int input;
        do {
            System.out.println("What would you like to do:\n");
            System.out.println("1. Add Event");
            System.out.println("2. Add Reminder");
            System.out.println("3. List and Sort all Entries from Earliest to Latest Dates");
            System.out.println("4. List and Sort all Entries Alphabetically");
            System.out.println("5. Search for Entry by Name of Entry");
            System.out.println("6. Search for Entry by Start Date of Entry");
            System.out.println("7. Save Calendar Entries and Continue Working");
            System.out.println("8.Complete Reminders or Remove Events");
            System.out.println("9. Search and Edit an Entry");
            System.out.println("0. Save and Exit");
            Scanner s = new Scanner(System.in);
            input = -1;
            while (!(input >= 0 && input <= 9)) {
                System.out.println("Please enter a number between 1 and 9, press 0 to exit");
                try {
                    input = Integer.parseInt(s.nextLine());
                } catch (NumberFormatException e) {
                }
            }
            switch (input) {
                case 0: {
                    c.saveEntriesList("Entries.txt");

                }
                break;
                case 1:

                    try {
                        int typeNumber = 1;
                        String typeName = "Event";
                        System.out.println("Please enter the name of the event: ");
                        String name = s.nextLine();
                        System.out.println("Please enter the Start Day of your event: ");
                        int startDate = getInt(s, 31);
                        System.out.println("Please enter the End Day of your event: ");
                        int endDate = getInt(s, 31);
                        System.out.println("Please enter the Details of your event: ");
                        String details = s.nextLine();
                        Events e = new Events(typeNumber, typeName, name, details, startDate, endDate);
                        c.addEvent(e);

                        System.out.println("Agenda so far!");
                        System.out.println("");
                        c.printAllEntries();
                    } catch (NumberFormatException e) {
                    }

                    break;
                case 2:
                    try {
                        int typeNumber = 2;
                        String typeName = "Reminder";
                        String complete = "Incomplete";
                        System.out.println("Please enter the name of the reminder: ");
                        String name = s.nextLine();
                        System.out.println("Please enter the Start Day of your reminder: ");
                        int startDate = getInt(s, 31);
                        System.out.println("Please enter the Details of your reminder: ");
                        String details = s.nextLine();
                        Reminders r = new Reminders(typeNumber, typeName, name, details, startDate, complete);
                        c.addReminder(r);

                        System.out.println("The reminder has been added");
                        System.out.println("Agenda so far!");
                        System.out.println("");
                        c.printAllEntries();
                    } catch (NumberFormatException e) {
                    }
                    break;
                case 3:
                    c.listAndSortByDate();

                    break;
                case 4:
                    c.listAndSortByName();
                    break;
                case 5:
                    System.out.println("Please enter the name of the entry: ");
                    String userName = s.nextLine();
                    System.out.println("Results from '" + userName + "':");
                    System.out.println("");
                    c.nameSearch(userName);
                    break;
                case 6:
                    System.out.println("Please enter the date of the entry: ");
                    int userDate = getInt(s, 31);
                    System.out.println("Results from ' " + userDate + " '");
                    c.dateSearch(userDate);
                    break;
                case 7:
                    c.saveEntriesList("Entries.txt");
                    System.out.println("Entries Saved!");
                    break;
                case 8:
                    System.out.println("Please enter the name of the entry you want to remove/complete");
                    String userNameRemove = s.nextLine();
                    System.out.println("Please enter the date of the entry you want to remove/complete");
                    int userRemove = getInt(s, 31);
                    c.removeEntry(userNameRemove, userRemove);
                    System.out.println("The event/reminder has been removed/completed");
                    System.out.println("Current entries: ");
                    System.out.println("");
                    c.printAllEntries();
                    break;
                case 9:
                    System.out.println("Please enter the name of the entry you would like to edit: ");
                    String userNameEdit = s.nextLine();
                    System.out.println("Please enter the date of the entry you would like to edit: ");
                    int userDateEdit = getInt(s, 31);
                    if (c.nameDateSearch(userNameEdit, userDateEdit) == true) {
                        System.out.println("Please enter the new name of the entry:");
                        String newName = s.nextLine();
                        System.out.println("Please enter the new date of the entry: ");
                        int newDate = getInt(s, 31);
                        System.out.println("Please enter the new details of the entry: ");
                        String newDetails = s.nextLine();
                        System.out.println("Is this still a Event (type 1) or a Reminder (type 2)? ");
                        int typeNum = getInt(s, 2);
                        if (typeNum == 1) {
                            System.out.println("Please enter the new end date: ");
                            int newEndDate = getInt(s, 31);
                            c.editEntry(newName, newDate, newDetails, typeNum, newEndDate);
                            System.out.println("Event Updated: ");
                            c.printAllEntries();
                        } else {
                            c.editEntry(newName, newDate, newDetails, typeNum, newDate);
                            System.out.println("Event Updated: ");
                            c.printAllEntries();
                        }
                    } else {
                        System.out.println("Entry with the name " + userNameEdit + " and the date " + userDateEdit + " doesn't exit!");
                    }

                    break;
            }
        } while (input != 0);
    }

    public static int getInt(Scanner s, int max) {
        int num;
        while (true) {
            try {
                num = Integer.parseInt(s.nextLine());
                if (num > 0 && num < max) {
                    return num;
                } else {
                    System.out.println("Please input an integer from 1- " + max);
                }
            } catch (NumberFormatException nfe) {
                System.out.println("Input is not an integer");
            }
        }
    }
}
