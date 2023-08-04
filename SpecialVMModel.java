import java.util.*;

/**
 * Child class of VMModel that represents a special vending machine object,
 * has the customItem attribute and processes on top of the VMModel attributes
 * and methods.
 */
public class SpecialVMModel extends VMModel {
    private CustomItem customItem = new CustomItem();;
    private ArrayList<String> processes = new ArrayList<>();

    /**
     * The constructor method for the class.
     * @param controller the reference to the controller object
     */
    public SpecialVMModel(Controller controller){
        super(controller);
    }

    /**
     * the getter for the customItem
     * @return the reference to the customItem
     */
    public CustomItem getCustomItem(){
        return this.customItem;
    }

    /**
     * the getter for the ArrayList of processes
     * @return the reference to the processes
     */
    public ArrayList<String> getProcesses(){
        return this.processes;
    }

    /**
     * Adds and item to the cart and adds the item's process 
     * to the processes if it isn't already there
     * @param item the item object to be added
     */
    public void addToCart(Item item){
        customItem.addItem(item);
        if(!processes.contains(item.getProcess())) processes.add(item.getProcess());
    }
}
