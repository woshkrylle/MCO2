import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class RegularVMView {
    private Controller controller;
    private JPanel vendingMain, cashPanel, itemMenu, maintenanceMenu;
    private ArrayList<JButton> buttonList = new ArrayList<>();

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

    private JPanel vendingMainMenu(){
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

    private JPanel cashPanel(){
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

    private JPanel itemMenu(){
        JPanel panel = new JPanel(new GridLayout(3, 4));

        JButton item1 = new JButton("N/A");
        JButton item2 = new JButton("N/A");
        JButton item3 = new JButton("N/A");
        JButton item4 = new JButton("N/A");
        JButton item5 = new JButton("N/A");
        JButton item6 = new JButton("N/A");
        JButton item7 = new JButton("N/A");
        JButton item8 = new JButton("N/A");

        buttonList.add(item1);
        buttonList.add(item2);
        buttonList.add(item3);
        buttonList.add(item4);
        buttonList.add(item5);
        buttonList.add(item6);
        buttonList.add(item7);
        buttonList.add(item8);
        
        JPanel infoPanel = new JPanel();
        JLabel itemNamLabel = new JLabel("null");
        JPanel buyPanel = new JPanel();
        
        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });
        
        panel.add(item1);
        panel.add(item2);
        panel.add(item3);
        panel.add(infoPanel);
        panel.add(item4);
        panel.add(item5);
        panel.add(item6);
        panel.add(buyPanel);
        panel.add(item7);
        panel.add(item8);
        panel.add(exitButton);
        
        return panel;
    }

    private JPanel maintenanceMenu(){
        JPanel panel = new JPanel();
        panel.setVisible(true);
        return panel;
    }

    private void updateTotalMoney(int amount, JLabel label){
        int updatedMoney = controller.updateTotalPayment(amount);
        label.setText("Total Payment: " + updatedMoney);
    }

    

    public void initializeItemButtons(){
        switch(controller.getSlotCount()){
            case 8:
                buttonList.get(7).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(7).setText(controller.getItemName(7)+controller.getItemCount(7)+"/10");
            case 7:
                buttonList.get(6).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(6).setText(controller.getItemName(6)+controller.getItemCount(6)+"/10");
            case 6:
                buttonList.get(5).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(5).setText(controller.getItemName(5)+controller.getItemCount(5)+"/10");
            case 5:
                buttonList.get(4).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(4).setText(controller.getItemName(4)+controller.getItemCount(4)+"/10");
            case 4:
                buttonList.get(3).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(3).setText(controller.getItemName(3)+controller.getItemCount(3)+"/10");
            case 3:
                buttonList.get(2).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(2).setText(controller.getItemName(2)+controller.getItemCount(2)+"/10");
            case 2:
                buttonList.get(1).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(1).setText(controller.getItemName(1)+controller.getItemCount(1)+"/10");
            case 1:
                buttonList.get(0).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        
                    }
                });
                buttonList.get(0).setText(controller.getItemName(0)+controller.getItemCount(0)+"/10");
            case 0:
                break;
        }
    }

    public void updateItemButtons(){
        switch(controller.getSlotCount()){
            case 8:
                buttonList.get(7).setText(controller.getItemName(7)+" "+controller.getItemCount(7)+"/10");
            case 7:
                buttonList.get(6).setText(controller.getItemName(6)+" "+controller.getItemCount(6)+"/10");
            case 6:
                buttonList.get(5).setText(controller.getItemName(5)+" "+controller.getItemCount(5)+"/10");
            case 5:
                buttonList.get(4).setText(controller.getItemName(4)+" "+controller.getItemCount(4)+"/10");
            case 4:
                buttonList.get(3).setText(controller.getItemName(3)+" "+controller.getItemCount(3)+"/10");
            case 3:
                buttonList.get(2).setText(controller.getItemName(2)+" "+controller.getItemCount(2)+"/10");
            case 2:
                buttonList.get(1).setText(controller.getItemName(1)+" "+controller.getItemCount(1)+"/10");
            case 1:
                buttonList.get(0).setText(controller.getItemName(0)+" "+controller.getItemCount(0)+"/10");
            case 0:
                break;
        }
    }
}

