package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class StatisticsOfGrade {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        //input all grades on one line
        System.out.println("Enter grades of students on one line : ");
        //reads whole line include spaces and split it into array based on spaces
        String [] grades = sc.nextLine().split(" ");

        //declare scores with length of grades
        int [] scores = new int[grades.length];

        //assign grades values to score index
        for(int i = 0; i<scores.length; i++){
            int grade = Integer.parseInt(grades[i]);

            //valid user input and assign index to zero for invalid input
            if(grade<0 || grade>100){
                System.out.println("invalid input, index assigned to zero");
            } else {
                scores[i] = Integer.parseInt(grades[i]);
            }
        }
        //print score array
        System.out.println(Arrays.toString(scores));
        System.out.print(" Number of students: " + scores.length);
        System.out.println();
        System.out.println();

        System.out.println("Values: ");
        System.out.println("The minimum score is : " +  findMinimum(scores));
        System.out.println("The maximum score is : " +  findMaximum(scores));
        System.out.println("The average score is : " +  findAverageScore(scores));
        System.out.println();
        System.out.println();

        System.out.println("Graph: ");
        System.out.println();
        CreateScoresGraph(scores);

    }

    //method for creating 5 stats
    private static int [] createStats(int [] scores) {

        int [] stats = new int[5];

        //increment value of stat according to condition
        for(int grade:scores){
            if(grade <= 20) stats[0]++;
            else if(grade <= 40) stats[1]++;
            else if(grade <= 60) stats[2]++;
            else if(grade <= 80) stats[3]++;
            else stats[4]++;
        }
        return stats;
    }

    private static void CreateScoresGraph(int [] scores) {

        int [] stats =  createStats(scores);

        //finding highest height of graph
        int maxHeight = findMaximum(stats);

         //Generate the graph
        //for loop for rows decrement according to maxHeight
        for (int i = maxHeight; i > 0 ; i--) {
            String line = "  " + i + "  >  ";
            //for loop for columns increment according to stats length ex: 3
            for (int j = 0; j < stats.length; j++) {
                if (stats[j] >= i) {
                    line += "#######";
                } else {
                    line += "       ";
                }
                line += "    "; // Add space between columns
            }
            System.out.println(line);
        }

        //print stats
        System.out.println("      +-----------+---------+---------+---------+---------+");
        System.out.println("      I   0-20    I  21-40  I  41-60  I  61-80  I  81-100 I");
    }


    //method for finding average
    private static double findAverageScore(int[] scores) {

        int sum = 0;
        int len = scores.length;

        for(int i = 0 ; i < len; i++){
           sum +=scores[i];
        }
        return (double) sum /len;
    }

    //method for finding maximum
    private static int findMaximum(int[] scores) {

        int maxTemp = scores[0];

        for(int i = 0 ; i < scores.length; i++){
            if(scores[i]>maxTemp){
                maxTemp = scores[i];
            }
        }
        return maxTemp;
    }

    //method for finding minimum score
    private static int findMinimum(int[] scores) {

        int minTemp = 100;

        for(int i = 0 ; i < scores.length; i++){
            if(scores[i]<minTemp){
                minTemp = scores[i];
            }
        }
        return minTemp;
    }
}
