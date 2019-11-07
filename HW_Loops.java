/*Program that takes in two DNA Strings as input,
 * and calculates the CG ratio, number of C's, 
 * and the complimentary strand + alignment
 */

import java.util.Scanner;
import java.lang.Math;

public class HW_Loops
{
    public static void main(String[] args){
        boolean validDNA = false;
        Scanner input = new Scanner(System.in);
        int sequenceTimes = 1;
        String sequence1 = "";
        String sequence2 = "";
        //sending the code to check for legality, and then asking twice
        do{
            System.out.println("Please enter a valid DNA Sequence");
            String DNASequence = input.nextLine();
            validDNA = LegalDNAChecker(DNASequence);
            if(validDNA){
                System.out.println(" ");
                if(sequenceTimes < 2){
                    sequence1 = DNASequence;
                    sequenceTimes++;
                    validDNA = false;
                }
                sequence2 = DNASequence;
            }
        }
        while(validDNA == false);
        //running the methods for the following parts
        CytosineGuanineCalc(1, sequence1);
        CytosineGuanineCalc(2, sequence2);
        String complement1 = ComplementaryStrand(sequence1);
        String complement2 = ComplementaryStrand(sequence2);
        DNAAlignment(sequence1, sequence2);

    }
    //checking that the String only has A,C,G,T
    public static boolean LegalDNAChecker(String DNASequence){
        //if the statement is false, then it will ask the question again
         for(int i = 0; i<= DNASequence.length()-1; i++){
             if((DNASequence.charAt(i) != 'C') && (DNASequence.charAt(i)) != 'G' &&
            (DNASequence.charAt(i) != 'A') && (DNASequence.charAt(i) != 'T')){
                return false;
            }

        }
        return true;
    }
    //calculating the number of C's and the ratio of C&G to the rest
    public static void CytosineGuanineCalc(int sequenceTimes, String DNASequence){
        int numberOfC = 0;
        int numberOfG = 0;
        double numberOfCandG = 0;
        double totalLength = 0;
        //loops that calculate the number of C, C&G, and total length
        for(int j = 0; j<=DNASequence.length() - 1; j++){
            if((DNASequence.charAt(j) == 'G') || (DNASequence.charAt(j) == 'C')){
                if((DNASequence.charAt(j) == 'C')){
                    numberOfC = numberOfC + 1;
                }
                numberOfCandG = numberOfCandG + 1;
            }
            totalLength+=1;
        }
        double percentCG = (numberOfCandG / totalLength);
        String strandmatch = ComplementaryStrand(DNASequence);
        //printing out the necessary statements
        System.out.printf("Sequence %d: %s%n", sequenceTimes, DNASequence);
        System.out.printf("   C-count: %d%n", numberOfC);
        System.out.printf("   CG-ratio: %1.3f%n", percentCG);
        System.out.printf("   CG-ratio: %s%n", strandmatch);

        System.out.println();

    }
    //creating the matching strand
    public static String ComplementaryStrand(String DNASequence){
        String complement = "";
        for(int i=0; i<DNASequence.length(); i++){
            if(DNASequence.charAt(i) == 'C'){
                complement = complement + 'G';
            }
            if(DNASequence.charAt(i) == 'A'){
                complement = complement + 'T';
            }
            if(DNASequence.charAt(i) == 'G'){
                complement = complement + 'C';
            }
            if(DNASequence.charAt(i) == 'T'){
                complement = complement + 'A';
            }
        }
        return complement;

    }
    //making the alignment
    public static void DNAAlignment(String sequence1, String sequence2){
        int lengthOfFirst = sequence1.length();
        int lengthOfSecond = sequence2.length();
        //If the strings are the same length, there is only one way to align them
        assert(lengthOfFirst != lengthOfSecond): "Only one alignment possible";
        int bigSequence, smallSequence, alignments;
        int lowestScore = 0;
        int highestScore = 0;
        String longestSequence, shortestSequence; 
        String highestAlignment = "";
        //if the first one is longer, then it will align the second one to it
        if(lengthOfFirst > lengthOfSecond){
            bigSequence = lengthOfFirst;
            smallSequence = lengthOfSecond;
            longestSequence = sequence1;
            shortestSequence = sequence2;
        }
        //if the second one is longer, then the first should align to the second
        else{
            bigSequence = lengthOfSecond;
            smallSequence = lengthOfFirst;
            longestSequence = sequence2;
            shortestSequence = sequence1;
        }
        //calculates the number of possible alignments
        alignments = bigSequence % smallSequence;
        for(int k = 0; k <= alignments; k++){
            for(int y = 0; y <= (smallSequence - 1) + k; y++){
                if((longestSequence.charAt(y) == shortestSequence.charAt(y)) && 
                ((longestSequence.charAt(y) == 'A') ||
                    (longestSequence.charAt(y) == 'C') || 
                    (longestSequence.charAt(y) == 'G') || 
                    (longestSequence.charAt(y) == 'T'))){
                    lowestScore++;
                }
            }
            //making the variable names correct if necessary
            if(lowestScore > highestScore){
                highestScore = lowestScore;
                highestAlignment = shortestSequence;
            }
            lowestScore = 0;
            shortestSequence = " " + shortestSequence;
        }
        //printing out the necessary statements
        System.out.println("Best alignment score: " + highestScore);

        System.out.println("  " + longestSequence);
        System.out.println("  " + highestAlignment);

    }

}
