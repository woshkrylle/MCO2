import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RegularVMView {
    private Controller controller;
    JPanel vendingMain, cashPanel, itemMenu, maintenanceMenu;

    public RegularVMView(Controller controller){
        this.controller = controller;
        this.vendingMain = vendingMainMenu();
        this.cashPanel = cashPanel();
        this.itemMenu = itemMenu();
        this.itemMenu = maintenanceMenu();

        controller.getFrame().add(vendingMain, "Vending Features Card");
        controller.getFrame().add(vendingMain, "Receive Money Card");
        controller.getFrame().add(vendingMain, "Show Items Card");
        controller.getFrame().add(vendingMain, "Maintenancee features Card");
        
    }

    public JPanel vendingMainMenu(){
        JPanel panel = new JPanel(new GridLayout(3,1));

        JButton vendingButton = new JButton("Vending Features");
        vendingButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Receive Money Card");
            }
        });
        
        JButton maintenanceButton = new JButton("Maintenance Features");
        maintenanceButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Maintenancee features Card");
            }
        });

        JButton exitButton = new JButton("Exit");
        maintenanceButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });

        panel.add(vendingButton);
        panel.add(maintenanceButton);
        panel.add(exitButton);

        return panel;
    }

    public JPanel cashPanel(){
        JPanel panel = new JPanel(new GridLayout(6, 1));

        JPanel monnersPanel1 = new JPanel(new GridLayout(2, 1));
        JPanel monnersPanel2 = new JPanel(new GridLayout(2, 1));
        JPanel monnersPanel3 = new JPanel(new GridLayout(2, 1));
        JPanel monnersPanel4 = new JPanel(new GridLayout(2, 1));

        JButton fiveHundred = new JButton("500");
        JButton twoHundred = new JButton("200");
        
        JButton oneHundred = new JButton("100");
        JButton fifty = new JButton("50");
        
        JButton twenty = new JButton("20");
        JButton ten = new JButton("10");
        
        JButton five = new JButton("5");
        JButton one = new JButton("1");

        monnersPanel1.add(fiveHundred);
        monnersPanel1.add(twoHundred);
        
        monnersPanel2.add(oneHundred);
        monnersPanel2.add(fifty);
        
        monnersPanel3.add(twenty);
        monnersPanel3.add(ten);

        monnersPanel4.add(five);
        monnersPanel4.add(one);
        
        JPanel totalMonners = new JPanel(new FlowLayout());
        JLabel totalMoney = new JLabel();
        
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        proceedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Show Items Card");
            }
        });

        // JButton
        panel.add(totalMonners);
        panel.add(monnersPanel1);
        panel.add(monnersPanel2);
        panel.add(monnersPanel3);
        panel.add(monnersPanel4);
        panel.add(proceedButton);

        return panel;
    }

    public JPanel itemMenu(){
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel maintenanceMenu(){
        JPanel panel = new JPanel();
        return panel;
    }

}
