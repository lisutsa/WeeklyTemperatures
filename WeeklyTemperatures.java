package weeklyTemperatures;

import java.util.ArrayList;
import java.util.Scanner;

public class WeeklyTemperatures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temperatures = new ArrayList<>();

        // Initialize days of the week
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        // Collect temperatures for each day
        for (String day : weekDays) {
            System.out.print("Enter the average temperature for " + day + ": ");
            double temp = scanner.nextDouble();
            days.add(day);
            temperatures.add(temp);
        }

        // Prompt for commands and display results
        while (true) {
            System.out.print("Enter a day of the week to get the temperature or 'week' to see all temperatures and the weekly average: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("week")) {
                double totalTemp = 0;
                System.out.println("Weekly temperatures:");
                for (int i = 0; i < days.size(); i++) {
                    System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
                    totalTemp += temperatures.get(i);
                }
                double weeklyAverage = totalTemp / days.size();
                System.out.println("Weekly average temperature: " + weeklyAverage + "°C");
                break;
            } else {
                boolean found = false;
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).equalsIgnoreCase(input)) {
                        System.out.println(days.get(i) + ": " + temperatures.get(i) + "°C");
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Invalid input. Please enter a valid day of the week or 'week'.");
                }
            }
        }

        scanner.close();
    }
}
