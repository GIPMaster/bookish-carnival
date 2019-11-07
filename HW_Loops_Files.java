/*This program will read input from the file courseData.txt and 
 * section it off into classes, while also finding the basic
 * statistics, such as average, and whether each student passed 
 * or failed
 */
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileInputStream;

public class HW_Loops_Files
{

    public static void main(String[] args){
        //sets the value of the scanner to null to be used later on
        Scanner inputStream = null;
        //try catch method to ensure that the file not found exception is caught

        try{
            inputStream = new Scanner(new FileInputStream("courseData.txt"));
        }
        catch(IOException e){
            System.out.println("File does not exist");
            System.exit(0);
        }

        //creating all of the necessary variables
        double programWeight = inputStream.nextDouble();
        double midtermWeight = inputStream.nextDouble();
        double finalExamWeight = inputStream.nextDouble();
        //a boolean to make the inner while loop run as it should
        boolean endOfClass = false;
        int nextNumber = 0;
        while(inputStream.hasNextLine()){
            //once it reaches the end of the file, this is true and the program ends
            if(inputStream.hasNextInt() == false){
                System.exit(0);
            }
            //correlating the class number

            int classNumber = inputStream.nextInt();
            ClassIntro(classNumber);
            double classAverage = 0.0;
            int numberOfStudents = 0;
            //resets classEnd
            boolean classEnd = false;
            int studentNumber = inputStream.nextInt();

            //when the classEnd is true, it will reprint the header for each class
            while(classEnd == false){
                //correlating the assignment to the grade
                double programScore = inputStream.nextInt();
                double midtermScore = inputStream.nextInt();
                double finalScore = inputStream.nextInt();

                //number of students increases every time this loop runs
                numberOfStudents++;

                //solves for the weighted average for each student
                double weightedAverage = (programAverage(programScore,programWeight) 
                        + midtermAverage(midtermScore, midtermWeight)
                        + finalAverage(finalScore,finalExamWeight));

                //test method call

                //testVariableValues(studentNumber, programScore, midtermScore,finalScore, classNumber);

                //adds the total averages together to later solve for the 
                //class average

                classAverage+=weightedAverage;

                //prints out the scores for each student
                System.out.printf("%d     ", studentNumber);
                System.out.printf("%2.0f       %2.0f       %2.0f", programScore,
                    midtermScore, finalScore);
                System.out.printf("         %.2f        ", weightedAverage);
                //determines whether the student passed or failed
                if(weightedAverage>50.0){
                    System.out.println("Pass");
                }
                else{
                    System.out.println("Fail");
                }
                //finds the next  number to run the loop again

                studentNumber = inputStream.nextInt();
                //when this is true, the header should print again

                if(studentNumber == 0){
                    classEnd = true;
                }

            }
            //solves and prints out the class average

            classAverage/=numberOfStudents;
            System.out.println("Class Average based on " 
                + numberOfStudents + ": " + classAverage);
            System.out.println(" ");
        }
    }

    //header
    public static void ClassIntro(int classNumber){
        System.out.println("Grade Data for Class " + classNumber);
        System.out.println("ID   Programs   Midterm   Final   Weighted Average   Programs Grade ");
        System.out.println("__   ________   _______   _____   ________________   ______________ ");

    }

    //solves for the weighted program average for each student
    public static double programAverage(double programScore, double programWeight){
        double programAverage = programScore * programWeight;
        return programAverage;

    }

    //solves for the weighted midterm average for each student
    public static double midtermAverage(double midtermScore, double midtermWeight){
        double midtermAverage = midtermScore * midtermWeight;
        return midtermAverage;

    }

    //solves for the weighted final average for each student
    public static double finalAverage(double finalScore, double finalWeight){
        double finalAverage = finalScore * finalWeight;
        return finalAverage;

    }

    //test function that will print out which student number is currently running
    public static void testVariableValues(int studentid, double grade1, double grade2, double grade3, int classN){
        System.out.println(" student number " + studentid + " program score " + grade1 
            + " midterm score " + grade2 + " final score " + grade3 + " class number " + classN);
    }
}
