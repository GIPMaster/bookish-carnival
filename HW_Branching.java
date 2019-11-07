//Calculates which stores have exceeded threshold and average of those stores
import java.util.Scanner;

public class HW_Branching
{
    public static void main(String args[]){
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the sales for Store 1");
        double store1=input.nextDouble();
        
        System.out.println("Enter the sales for Store 2");
        double store2=input.nextDouble();
        
        System.out.println("Enter the sales for Store 3");
        double store3=input.nextDouble();
        
        System.out.println("Enter the sales threshold");
        double salesThreshold = input.nextDouble();
        //Store 1 greater than threshold
        if(store1>=salesThreshold && store2<salesThreshold && store3<salesThreshold){
            System.out.println("Store 1 did great!");
            System.out.println("The average sales for exceeding stores: " + store1);
        }
        //store 2 greater than threshold
        else if(store2>=salesThreshold && store1<salesThreshold && store3<salesThreshold){
            System.out.println("Store 2 did great!");
            System.out.println("The average sales for exceeding stores: " + store2);
        }
        //store 3 greater than threshold
        else if(store3>=salesThreshold && store2<salesThreshold && store1<salesThreshold){
            System.out.println("Store 3 did great!");
            System.out.println("The average sales for exceeding stores: " + store3);
        }
        //stores 1 and 2 greater than threshold
        else if(store1>=salesThreshold && store2>=salesThreshold && store3<salesThreshold){
            System.out.println("Store 1 and Store 2 did great!");
            System.out.println("The average sales for exceeding stores: " + ((store1+store2)/2));
        }
        //stores 1 and 3 greater than threshold
        else if(store1>=salesThreshold && store3>=salesThreshold && store2<salesThreshold){
            System.out.println("Store 1 and Store 3 did great!");
            System.out.println("The average sales for exceeding stores: " + ((store1+store3)/2));
        }
        //stores 2 and 3 greater than threshold
        else if(store2>=salesThreshold && store3>=salesThreshold && store1<salesThreshold){
            System.out.println("Store 2 and Store 3 did great!");
            System.out.println("The average sales for exceeding stores: " + ((store3+store2)/2));
        }
        //all stores greater than threshold
        else if(store2>=salesThreshold && store3>=salesThreshold && store1>=salesThreshold){
            System.out.println("All stores did great!");
            System.out.println("The average sales for exceeding stores: " + ((store1+store2+store3)/3));
        }
        //no store greater than threshold
        else{
            System.out.println("No store met the threshold");//automatically exits code
        }
    }
}
