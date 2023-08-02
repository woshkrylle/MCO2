import java.util.*;
public class SpecialVMModel extends VMModel {
    private CustomItem customItem;
    private ArrayList<String> processes = new ArrayList<>();
    public SpecialVMModel(Controller controller){
        super(controller);
    }

    public CustomItem getCustomItem(){
        return this.customItem;
    }

    public ArrayList<String> getProcesses(){
        return this.processes;
    }

    public void addToCart(Item item){
        customItem.addItem(item);
        if(!processes.contains(item.getProcess())) processes.add(item.getProcess());
    }
}
