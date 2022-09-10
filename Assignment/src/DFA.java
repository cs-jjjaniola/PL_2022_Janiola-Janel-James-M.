import java.util.Scanner;

class  DFA {
    public static void main(String[] args) {
        try{
            while(true){
                String state = "q0";
                Scanner sc = new Scanner(System.in);
                String input = sc.nextLine();
                input.toString();
                for(int x = 0; x < input.length(); x++) {
                    if (state.equals("q0") && input.charAt(x) == '0') {

                        state = "q1";
                    } else if (state.equals("q0") && input.charAt(x) == '1') {

                        state = "q0";
                    } else if (state.equals("q1") && input.charAt(x) == '1') {

                        state = "q2";
                    } else if (state.equals("q1") && input.charAt(x) == '0') {

                        state = "q1";
                    } else if (state.equals("q1") && input.charAt(x) == '1') {

                        state = "q2";
                    } else if(state.equals("q2") && input.charAt(x) == '0'  ){

                        state = "q1";
                    }else if(state.equals("q2") && input.charAt(x) == '1'  ){

                        state = "q0";
                    }else{
                        System.out.println("Invalid input.. Exiting automaton");
                        break;
                    }


                }
                //check if state is final state
                if(state.equals("q2")){
                    System.out.println("String accepted");
                }else{
                    System.out.println("String not accepted");
                }
            }
        }catch (Exception e){
        }
    }
}

///My Transition Table Guide for doing this program.
//[    , 0  , 1 ]
//[>q0 , q1 ,q0 ]
//[ q1 , q1 ,q2 ]
//[ q2*, q1 ,q0 ]