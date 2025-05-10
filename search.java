import java.util.Scanner;
import java.io.*;

class searchIFSC{
    public static void main(String[] args){
        try(Scanner scanner = new Scanner(System.in);
            BufferedReader ifsc_reader = new BufferedReader(new FileReader("ifsc.txt"));
            BufferedReader bank_reader = new BufferedReader(new FileReader("bankname.txt"));
            BufferedReader branch_reader = new BufferedReader(new FileReader("branch.txt"));
            BufferedReader state_reader = new BufferedReader(new FileReader("state.txt"));){

            System.out.println("Enter the IFSC code: ");
            String ifsc_code = scanner.nextLine();

            while(ifsc_code.isEmpty()){
                System.out.println("Empty input detected... please input IFSC code: ");
                ifsc_code = scanner.nextLine();
            }

            if(ifsc_code.length()>11){
                System.out.println("Invalid IFSC code, must be 11 digits");
            }
            String line;
            int line_num = 1;
            while((line = ifsc_reader.readLine()) != null){

                if(line.equals(ifsc_code)==false){
                    line_num++;
                }
                else if(line.equals(ifsc_code)){
                    for(int i=1;i<=line_num;i++){
                        String bank_line = bank_reader.readLine();
                        String branch_line = branch_reader.readLine();
                        String state_line = state_reader.readLine();
                        if(i==line_num){
                            System.out.println("Bank name: " + (bank_line != null ? bank_line : "Bank not found"));
                            System.out.println("Branch name: " + (branch_line != null ? branch_line : "Branch not found"));
                            System.out.println("State name: " + (state_line != null ? state_line : "State not found"));
                        }
                    }
                }
                
            }

        }
            
        catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
        catch(IOException e){
            System.out.println("Input/Output Error");
        }

    }

}