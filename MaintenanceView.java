import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MaintenanceView {
    private JPanel menu;
    private Controller controller;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private ArrayList<JLabel> labelList = new ArrayList<>();



    public MaintenanceView(Controller controller){
        this.controller = controller;
        this.menu = Menu();
        
        controller.getFrame().add(menu, "Supply Stocks and Money");
    }

    private JPanel Menu(){
        JPanel panel = new JPanel(new GridLayout(3,1));

        JButton restock = new JButton("Restock");
        restock.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller
            }
        });
        JButton replenishCash = new JButton("Replenish Change");
        replenishCash.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.replenishChange();
            }
        });
        JButton collectMoney = new JButton("Collect Money");
        restock.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //make money in ano 0
            }
        });

        panel.add(restock);
        panel.add(replenishCash);
        panel.add(collectMoney);
        panel.setVisible(true);
        return panel;
    }
}
