package todo;

import java.util.ArrayList;


public final class Controller {
    
    IO io = new IO();
    File f = new File();
    
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    } 
    
    Controller(){
        io.introduction();
        this.start();
        io.goodbye();
    }
    
    public void start(){
        boolean exit = false;
        do{
            ArrayList<String> lines = f.readFile();
            
            switch(io.Menu()) {
                case 1:
                    //display
                    displayItems(lines);
                    break;
                case 2:
                    //add
                    addItem(lines, io.addItem());
                    displayItems(lines);
                    break;
                case 3:
                    //delete
                    displayItems(lines);
                    deleteItem(lines, io.deleteItem());
                    break;
                default:
                    // exit
                    exit = true;
                    break;
            }
        }while(!exit);
    }
    
    public void addItem(ArrayList<String> lines, String input){
        lines.add(input);
        f.writeFile(lines);
    }
    
    public void displayItems(ArrayList<String> lines){
        System.out.println("\nList:-");
        if(lines.size() > 0){
            for(int i=0; i<lines.size(); i++){
                System.out.println(i+") "+ lines.get(i));
            }
        }  
    }
    
    public void deleteItem(ArrayList<String> lines, int index){
        if(index < lines.size() && index > -1){
            lines.remove(index);
            f.writeFile(lines);
        }else{
            System.out.println("Operation has been canceled!");
        }
    }
    
    
}
