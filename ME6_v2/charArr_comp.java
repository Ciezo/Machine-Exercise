import java.util.Scanner;



public class charArr_comp {
    
    static int counter = 0; 

    static char[] input1;
    static char[] input2;

    static String str1; 
    static String str2;  
    
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Compare two character arrays converted from String input");
        System.out.print("Enter string 1: ");
        str1 = sc.nextLine();
            System.out.println("\t Input 1: " + str1);
            
        System.out.println("NOTE: This will be compared against String 1");
        System.out.print("Enter string 2: ");
        str2 = sc.nextLine();
            System.out.println("\t Input 1: " + str2);

        System.out.println("===============================================================");
        System.out.println("Converting to char arrays for comparison on a char per char basis");

        input1 = str1.toCharArray(); 
        input2 = str2.toCharArray(); 
        
        int length1 = input1.length;
        int length2 = input2.length;

        System.out.println("Converted!");
        System.out.println("Input 1 length: " + length1);
        System.out.println("Input 2 length: " + length2);

        for(int i = 0; i < length1; i++) { 
            if (input1[i] != input2[i]) {
                counter++; 
            }
            
            else {
                System.out.println("No errors at " + input2[i] + " ");
            }
        }

        System.out.println("Errors: " + counter);
    }


}
