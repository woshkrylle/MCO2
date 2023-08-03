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
                replenish.revalidate();
                replenish.repaint();
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Replenish Balance Card");
            }
        });
        JButton collectMoney = new JButton("Collect Money");
        collectMoney.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                collect.revalidate();
                collect.repaint();
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
        //need muna implement ung different types of menus
        return panel;
    }

    public JPanel replenishBalancePanel(){
        JPanel panel = new JPanel(new GridLayout(5, 1));

        JPanel moneyButtons1 = new JPanel();
        JPanel moneyButtons2 = new JPanel();
        JPanel moneyButtons3 = new JPanel();
        JPanel moneyButtons4 = new JPanel();

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Maintenance Features Card");
            }
        });

        JButton denom1 = new JButton("500: "+controller.getDenominationCount(1));
        denom1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(500);
                denom1.setText("500: "+controller.getDenominationCount(1));
            }
        });

        JButton denom2 = new JButton("200: "+controller.getDenominationCount(2));
        denom2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(200);
                denom2.setText("200: "+controller.getDenominationCount(2));
            }
        });

        JButton denom3 = new JButton("100: "+controller.getDenominationCount(3));
        denom3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(100);
                denom3.setText("100: "+controller.getDenominationCount(3));
            }
        });

        JButton denom4 = new JButton("50: "+controller.getDenominationCount(4));
        denom4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(50);
                denom4.setText("50: "+controller.getDenominationCount(4));
            }
        });

        JButton denom5 = new JButton("20: "+controller.getDenominationCount(5));
        denom5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(20);
                denom5.setText("20: "+controller.getDenominationCount(5));
            }
        });

        JButton denom6 = new JButton("10: "+controller.getDenominationCount(6));
        denom6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(10);
                denom6.setText("10: "+controller.getDenominationCount(6));
            }
        });

        JButton denom7 = new JButton("5: "+controller.getDenominationCount(7));
        denom7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(5);
                denom7.setText("5: "+controller.getDenominationCount(7));
            }
        });

        JButton denom8 = new JButton("1: "+controller.getDenominationCount(8));
        denom8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.addDenomination(1);
                denom8.setText("1: "+controller.getDenominationCount(8));
            }
        });

        moneyButtons1.add(denom1);
        moneyButtons1.add(denom2);
        moneyButtons2.add(denom3);
        moneyButtons2.add(denom4);
        moneyButtons3.add(denom5);
        moneyButtons3.add(denom6);
        moneyButtons4.add(denom7);
        moneyButtons4.add(denom8);
        panel.add(moneyButtons1);
        panel.add(moneyButtons2);
        panel.add(moneyButtons3);
        panel.add(moneyButtons4);
        panel.add(exitButton);
        panel.setVisible(true);
        return panel;
    }

    public JPanel collectMoneyPanel(){
        JPanel panel = new JPanel(new GridLayout(5, 1));

        JPanel moneyButtons1 = new JPanel();
        JPanel moneyButtons2 = new JPanel();
        JPanel moneyButtons3 = new JPanel();
        JPanel moneyButtons4 = new JPanel();

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Maintenance Features Card");
            }
        });

        JButton denom1 = new JButton("500: "+controller.getDenominationCount(1));
        denom1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(500);
                denom1.setText("500: "+controller.getDenominationCount(1));
            }
        });

        JButton denom2 = new JButton("200: "+controller.getDenominationCount(2));
        denom2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(200);
                denom2.setText("200: "+controller.getDenominationCount(2));
            }
        });

        JButton denom3 = new JButton("100: "+controller.getDenominationCount(3));
        denom3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(100);
                denom3.setText("100: "+controller.getDenominationCount(3));
            }
        });

        JButton denom4 = new JButton("50: "+controller.getDenominationCount(4));
        denom4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(50);
                denom4.setText("50: "+controller.getDenominationCount(4));
            }
        });

        JButton denom5 = new JButton("20: "+controller.getDenominationCount(5));
        denom5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(20);
                denom5.setText("20: "+controller.getDenominationCount(5));
            }
        });

        JButton denom6 = new JButton("10: "+controller.getDenominationCount(6));
        denom6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(10);
                denom6.setText("10: "+controller.getDenominationCount(6));
            }
        });

        JButton denom7 = new JButton("5: "+controller.getDenominationCount(7));
        denom7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(5);
                denom7.setText("5: "+controller.getDenominationCount(7));
            }
        });

        JButton denom8 = new JButton("1: "+controller.getDenominationCount(8));
        denom8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.subtractDenomination(1);
                denom8.setText("1: "+controller.getDenominationCount(8));
            }
        });

        moneyButtons1.add(denom1);
        moneyButtons1.add(denom2);
        moneyButtons2.add(denom3);
        moneyButtons2.add(denom4);
        moneyButtons3.add(denom5);
        moneyButtons3.add(denom6);
        moneyButtons4.add(denom7);
        moneyButtons4.add(denom8);
        panel.add(moneyButtons1);
        panel.add(moneyButtons2);
        panel.add(moneyButtons3);
        panel.add(moneyButtons4);
        panel.add(exitButton);
        panel.setVisible(true);
        return panel;
    }

    public JPanel changePricePanel(){
        JPanel panel = new JPanel();
        return panel;
    }

    public void updateReplenishMoneyButtons(){

    }

    public void updateCollectMoneyButtons(){
        
    }
}
