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
        this.maintenanceMenu = maintenanceMenu();

        controller.getFrame().add(vendingMain, "Vending Features Card");
        controller.getFrame().add(cashPanel, "Receive Money Card");
        controller.getFrame().add(itemMenu, "Regular Items Card");
        controller.getFrame().add(maintenanceMenu, "Maintenancee features Card");
        
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
        exitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });

        panel.add(vendingButton);
        panel.add(maintenanceButton);
        panel.add(exitButton);
        panel.setVisible(true);

        return panel;
    }

    public JPanel cashPanel(){
        JPanel panel = new JPanel(new GridLayout(6, 1));

        JPanel monnersPanel1 = new JPanel(new GridLayout(1, 2));
        JPanel monnersPanel2 = new JPanel(new GridLayout(1, 2));
        JPanel monnersPanel3 = new JPanel(new GridLayout(1, 2));
        JPanel monnersPanel4 = new JPanel(new GridLayout(1, 2));

        JLabel totalMoney = new JLabel();
        totalMoney.setText("Total Payment: 0");

        JButton fiveHundred = new JButton("500");
        fiveHundred.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(500, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });

        JButton twoHundred = new JButton("200");
        twoHundred.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(200, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });
        
        JButton oneHundred = new JButton("100");
        oneHundred.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(100, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });

        JButton fifty = new JButton("50");
        fifty.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(50, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });
        
        JButton twenty = new JButton("20");
        twenty.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(20, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });

        JButton ten = new JButton("10");
        ten.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(10, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });
        
        JButton five = new JButton("5");
        five.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(5, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });

        JButton one = new JButton("1");
        one.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                updateTotalMoney(1, totalMoney);
                panel.revalidate();
                panel.repaint();
            }
        });

        monnersPanel1.add(fiveHundred);
        monnersPanel1.add(twoHundred);
        monnersPanel2.add(oneHundred);
        monnersPanel2.add(fifty);
        monnersPanel3.add(twenty);
        monnersPanel3.add(ten);
        monnersPanel4.add(five);
        monnersPanel4.add(one);
        
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        proceedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.showItemMenu();
            }
        });

        // JButton
        panel.add(totalMoney);
        panel.add(monnersPanel1);
        panel.add(monnersPanel2);
        panel.add(monnersPanel3);
        panel.add(monnersPanel4);
        panel.add(proceedButton);
        panel.setVisible(true);

        return panel;
    }

    public JPanel itemMenu(){
        JPanel panel = new JPanel();
        return panel;
    }

    public JPanel maintenanceMenu(){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        return panel;
    }

    public void updateTotalMoney(int amount, JLabel label){
        int updatedMoney = controller.updateTotalPayment(amount);
        label.setText("Total Payment: " + updatedMoney);
    }

}
