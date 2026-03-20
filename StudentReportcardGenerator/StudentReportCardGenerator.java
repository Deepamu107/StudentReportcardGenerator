import java.io.*;
import java.util.*;

// Base class
class Student {
    protected String name;
    protected int rollNo;
    protected String className;

    public void getDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Student Name: ");
        name = sc.nextLine();
        System.out.print("Enter Roll Number: ");
        rollNo = sc.nextInt();
        sc.nextLine(); // clear buffer
        System.out.print("Enter Class: ");
        className = sc.nextLine();
    }

    public void showDetails() {
        System.out.println("Student Name : " + name);
        System.out.println("Roll Number  : " + rollNo);
        System.out.println("Class        : " + className);
    }
}

// Derived class
class ReportCard extends Student {
    private int[] marks = new int[5];
    private int total;
    private float average;
    private char grade;
    public void getMarks() {
        Scanner sc = new Scanner(System.in);
        total = 0;
        System.out.println("Enter marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
            total += marks[i];
        }
        average = total / 5.0f;
        calculateGrade();
    }
    private void calculateGrade() {
        if (average >= 90) grade = 'A';
        else if (average >= 75) grade = 'B';
        else if (average >= 60) grade = 'C';
        else if (average >= 50) grade = 'D';
        else grade = 'F';
    }
    public void displayCard() {
        System.out.println("\n--- REPORT CARD ---");
        showDetails();
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + average);
        System.out.println("Grade       : " + grade);
    }
     public String getReportData() {
return name + "," + rollNo + "," + className + "," + total + "," + average + "," + grade;
    }
}

// File handling class
class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public void saveReport(String data) {
        try (FileWriter fw = new FileWriter(fileName, true);
             BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write(data);
            bw.newLine();
            System.out.println("Report saved successfully in file: " + fileName);
        } catch (IOException e) {
            System.out.println("Error saving report: " + e.getMessage());
        }
    }

    public void displayAllReports() {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            System.out.println("\n--- All Student Reports ---");
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
System.out.println("Name: " + data[0] + " | Roll: " + data[1] + " | Class: " + data[2] +
          " | Total: " + data[3] + " | Average: " + data[4] + " | Grade: " + data[5]);
            }
        } catch (IOException e) {
            System.out.println("No reports found or error reading file.");
        }
    }
   // 🧹 Delete report by roll number
    public void deleteReportByRoll(int rollNo) {
        File inputFile = new File(fileName);
        File tempFile = new File("TempFile.txt");
         boolean found = false;
         try (BufferedReader br = new BufferedReader(new FileReader(inputFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(tempFile))) {
                String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (Integer.parseInt(data[1]) == rollNo) {
                    found = true;
                    continue; // skip writing this line (deleting it)
                }
                bw.write(line);
                bw.newLine();
            }
         } catch (IOException e) {
            System.out.println("Error processing file: " + e.getMessage());
            return;
        }
        // Replace original file with updated one
        if (!inputFile.delete()) {
            System.out.println("Could not delete original file.");
            return;
        }if (!tempFile.renameTo(inputFile)) {
            System.out.println("Could not rename temp file.");
            return;
        }if (found)
            System.out.println("Report with Roll Number " + rollNo + " deleted successfully!");
        else
            System.out.println("No report found for Roll Number: " + rollNo);
    }
}

// Main class
public class StudentReportCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FileHandler fileHandler = new FileHandler("ReportCards.txt");
        while (true) {
            System.out.println("\n===== STUDENT REPORT CARD GENERATOR =====");
            System.out.println("1. Create New Report Card");
            System.out.println("2. Display All Reports");
            System.out.println("3. Delete Report by Roll Number");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    ReportCard rc = new ReportCard();
                    rc.getDetails();
                    rc.getMarks();
                    rc.displayCard();
                    fileHandler.saveReport(rc.getReportData());
                    break;
                case 2:
                    fileHandler.displayAllReports();
                    break;
                case 3:
                    System.out.print("Enter Roll Number to delete: ");
                    int roll = sc.nextInt();
                    fileHandler.deleteReportByRoll(roll);
                    break;
                case 4:
                    System.out.println("Exiting... Thank you!");
                    return;
                    default:
                    System.out.println("Invalid choice! Please try again.");
    }   }   }
}