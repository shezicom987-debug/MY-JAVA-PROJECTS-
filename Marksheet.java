import java.util.Arrays;
import java.util.Scanner;

public class Marksheet{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n=====WellCome To The Student Grade System=====");

        System.out.print("Enter the number of students :");
        int Students = sc.nextInt();

        System.out.print("Enter the number of Subjects:");
        int Subjects = sc.nextInt();
        sc.nextLine();

        int[][] marks = new int[Students][Subjects];
        String[] Names = new String[Students];
        //int[] total = new int[Students];

        for(int i = 0 ;i<Students ;i++){
            
            System.out.print("\n Enter the name of Student "+(i+1)+" :");
            Names[i] = sc.nextLine(); 

            System.out.println(" ==Enter Marks for " +Names[i]+"==");
            

            for(int j = 0;j<Subjects;j++){
                System.out.print("Enter the  marks for subject "+(j+1)+" :");
                marks[i][j] = sc.nextInt();

            }

            sc.nextLine();
        }

        System.out.println("\n ----Marksheets----");



        for(int k = 0;k<Students;k++){
            System.out.println("------------------------------------");      

            System.out.println("Student Name \t"+Names[k]);
            int total = 0;
            int max = marks[k][0];
            int min = marks[k][0];
            System.out.println("------------------------------------");      



            for(int l = 0;l<Subjects;l++){  
                System.out.println("Marks of subject "+(l+1)+"\t" +marks[k][l] );
                total += marks[k][l];
                if (marks[k][l] > max) max = marks[k][l];
                if (marks[k][l] < min) min = marks[k][l];

            }

            double average = total / (double) Subjects;
            System.out.println("------------------------------------");
            System.out.println("Total Marks:\t" + total);
            System.out.println("Average Marks:\t" + average);
            System.out.println("Highest Marks:\t" + max);
            System.out.println("Lowest Marks:\t" + min);
        }
    }
}