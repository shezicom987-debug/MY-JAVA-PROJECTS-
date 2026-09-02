import java.util.*;
class game {
    int number;
    int user_number;
    int number_guased;
    int chance = 0;

    game(){
        Random rand = new Random();
        number = rand.nextInt(20);
        
    }
    void input_number(){
        System.out.println("Enter the  number to guase:");
        Scanner sc = new Scanner(System.in);
        user_number = sc.nextInt();
    }
    boolean is_correct(){
        chance++;
        if(number == user_number){
            
            System.out.println("Yes you have guased the number that is "+number+" you took "+chance+" chances");
            return true;
        }else if(user_number>number){
            System.out.println("number is too high...");


        }else{
            System.out.println("Number is too low....");
        }
        return false;

    }
}

public class NumberGuaseGame {
    public static void main(String[] args){
        game g = new game();

        boolean b = false;
        while(!b){
            g.input_number();
            b = g.is_correct();
        }
    }
    
}
