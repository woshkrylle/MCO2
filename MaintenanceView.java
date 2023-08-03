import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class MaintenanceView {
    private JPanel menu,
                   restock,
                   replenish,
                   collect,
                   changePrice;
    private Controller controller;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private ArrayList<JLabel> labelList = new ArrayList<>();



    public MaintenanceView(Controller controller){
        this.controller = controller;
        this.menu = menuPanel();
        this.restock = replenishStockPanel();
        this.replenish = replenishBalancePanel();
        this.collect = collectMoneyPanel();
        this.changePrice = changePricePanel();
        
        controller.getFrame().add(menu, "Maintenance Features Card");
        controller.getFrame().add(restock, "Restock Item Card");
        controller.getFrame().add(replenish, "Replenish Balance Card");
        controller.getFrame().add(collect, "Collect Money Card");
        controller.getFrame().add(changePrice, "Change Price Card");
    }

    private JPanel menuPanel(){
        JPanel panel = new JPanel(new GridLayout(5,1));

        JButton restock = new JButton("Restock");
        restock.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Restock Item Card");
            }
        });
        JButton replenishCash = new JButton("Replenish Change");
        replenishCash.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Replenish Balance Card");
            }
        });
        JButton collectMoney = new JButton("Collect Money");
        collectMoney.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Collect Money Card");
            }
        });
        JButton changePrice = new JButton("Change Item Prices");
        changePrice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Change Price Card");
            }
        });
        JButton exit = new JButton("Exit");
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });

        panel.add(restock);
        panel.add(replenishCash);
        panel.add(collectMoney);
        panel.add(changePrice);
        panel.add(exit);
        panel.setVisible(true);
        return panel;
    }

    public JPanel replenishStockPanel(){
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel replenishBalancePanel(){
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel collectMoneyPanel(){
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel changePricePanel(){
        JPanel panel = new JPanel();
        return panel;
    }
}
