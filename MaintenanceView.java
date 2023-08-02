import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MaintenanceView {
    private JPanel maintenanceMenu;

    public MaintenanceView(){
        this.maintenanceMenu = Menu();
    }

    private JPanel Menu(){
        JPanel panel = new JPanel();

        JButton restock = new JButton("Restock");
        JButton replenishCash = new JButton("Replenish Change");
        JButton collectMoney = new JButton("Collect Money");
        return panel;
    }
}
