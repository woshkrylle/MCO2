/**
 * The Main class represents the entry point of the Vending Machine Simulator program.
 * It allows users to create a new vending machine, test an existing vending machine, or exit the program.
 * @author Kurt Hugo and Nauj Agbayani
 * @version 1.1
 * 
 * - Too much hard coding. Initializing the vending machine balance to 100 is a bit too arbitrary.
 * - Replenishing stocks to max every time is also very arbitrary, in general please get the user input for most functions instead of hard coding values.
 */
public class Main {
    /**
     * The main() method that will serve as the entry point for the program
     */
    public static void main(String[] args){
        Controller controller = new Controller();
        
        MainMenuView mm = new MainMenuView(controller);
        controller.setMainMenu(mm);

        RegularVMView rvmv = new RegularVMView(controller);
        controller.setRVMView(rvmv);
        
        SpecialVMView svmv = new SpecialVMView(controller);
        controller.setSVMView(svmv);

        MaintenanceView mntnv = new MaintenanceView(controller);
        controller.setMNTNView(mntnv);

        controller.Run();
    }
}
