import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class SpecialVMView {
    private JPanel specialPanel, basePanel, addOnPanel, processPanel;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private Controller controller;

    public SpecialVMView(Controller controller){
        this.controller = controller;
        this.specialPanel = itemMenu();

        controller.getFrame().add(specialPanel, "Special Items Card");
        // this.basePanel = baseItems();
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

        JButton customize = new JButton("Custom Order");
        customize.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Custom Card");
            }
        });

        buttonList.add(item1);
        buttonList.add(item2);
        buttonList.add(item3);
        buttonList.add(item4);
        buttonList.add(item5);
        buttonList.add(item6);
        buttonList.add(item7);
        buttonList.add(item8);
        
        JLabel changeLabel = new JLabel("Total Change: "+ controller.getPaymentTotal());
        JLabel caloriesLabel = new JLabel("Total Calories: 0");

        JButton exitButton = new JButton("Exit");
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.checkOut();
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });
        
        panel.add(item1);
        panel.add(item2);
        panel.add(item3);
        panel.add(changeLabel);
        panel.add(item4);
        panel.add(item5);
        panel.add(item6);
        panel.add(caloriesLabel);
        panel.add(item7);
        panel.add(item8);
        panel.add(customize);
        panel.add(exitButton);

        labelList.add(changeLabel);
        labelList.add(caloriesLabel);
        
        return panel;
    }

    private void updateTotalMoney(int amount, JLabel label, int denomination){
        int updatedMoney = controller.updateTotalPayment(amount, denomination);
        label.setText("Total Payment: " + updatedMoney);
    }

    public void updateItemButtons(){
        switch(controller.getSlotCount()){
            case 8:
                buttonList.get(7).setText(controller.getItemName(7)+": "+controller.getItemCount(7)+"/10");
            case 7:
                buttonList.get(6).setText(controller.getItemName(6)+": "+controller.getItemCount(6)+"/10");
            case 6:
                buttonList.get(5).setText(controller.getItemName(5)+": "+controller.getItemCount(5)+"/10");
            case 5:
                buttonList.get(4).setText(controller.getItemName(4)+": "+controller.getItemCount(4)+"/10");
            case 4:
                buttonList.get(3).setText(controller.getItemName(3)+": "+controller.getItemCount(3)+"/10");
            case 3:
                buttonList.get(2).setText(controller.getItemName(2)+": "+controller.getItemCount(2)+"/10");
            case 2:
                buttonList.get(1).setText(controller.getItemName(1)+": "+controller.getItemCount(1)+"/10");
            case 1:
                buttonList.get(0).setText(controller.getItemName(0)+": "+controller.getItemCount(0)+"/10");
            case 0:
                break;
        }
    }

    public void updateLabels(){
        labelList.get(0).setText("Total Change: "+ controller.getPaymentTotal());
        labelList.get(1).setText("Total Calories: "+ controller.getCaloriesTotal());
    }

    public void initializeItemButtons(){
        switch(controller.getSlotCount()){
            case 8:
                buttonList.get(7).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(7);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(7).setText(controller.getItemName(7)+": "+controller.getItemCount(7)+"/10");
            case 7:
                buttonList.get(6).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(6);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(6).setText(controller.getItemName(6)+": "+controller.getItemCount(6)+"/10");
            case 6:
                buttonList.get(5).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(5);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();

                    }
                });
                buttonList.get(5).setText(controller.getItemName(5)+": "+controller.getItemCount(5)+"/10");
            case 5:
                buttonList.get(4).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(4);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(4).setText(controller.getItemName(4)+": "+controller.getItemCount(4)+"/10");
            case 4:
                buttonList.get(3).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(3);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(3).setText(controller.getItemName(3)+": "+controller.getItemCount(3)+"/10");
            case 3:
                buttonList.get(2).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(2);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(2).setText(controller.getItemName(2)+": "+controller.getItemCount(2)+"/10");
            case 2:
                buttonList.get(1).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(1);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(1).setText(controller.getItemName(1)+": "+controller.getItemCount(1)+"/10");
            case 1:
                buttonList.get(0).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.removeItem(0);
                        updateItemButtons();
                        updateLabels();
                        specialPanel.revalidate();
                        specialPanel.repaint();
                    }
                });
                buttonList.get(0).setText(controller.getItemName(0)+": "+controller.getItemCount(0)+"/10");
            case 0:
                break;
        }
    }

    private JPanel baseItems()
    {
        int counter = 0;
        JPanel panel = new JPanel(new GridLayout(4,1));
        
        JLabel baseLabel = new JLabel("Base/Independent Items:");

        JPanel itemRow1 = new JPanel(new GridLayout(1,3));
        JPanel itemRow2 = new JPanel(new GridLayout(1,3));
        JPanel itemRow3 = new JPanel(new GridLayout(1,3));

        JButton item1 = new JButton(controller.getItemName(0));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });


        JButton item2 = new JButton(controller.getItemName(1));
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });


        JButton item3 = new JButton(controller.getItemName(2));
        JButton item4 = new JButton(controller.getItemName(3));
        JButton item5 = new JButton(controller.getItemName(4));
        JButton item6 = new JButton(controller.getItemName(5));
        JButton item7 = new JButton(controller.getItemName(6));
        JButton item8 = new JButton(controller.getItemName(7));

        if(controller.getItemIndependence(0)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item1);
            }
            else if(counter <= 6){
                itemRow2.add(item1);
            }
            else if(counter <= 8){
                itemRow3.add(item1);
            }
        }

        if(controller.getItemIndependence(1)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item2);
            }
            else if(counter <= 6){
                itemRow2.add(item2);
            }
            else if(counter <= 8){
                itemRow3.add(item2);
            }
            
        }

        if(controller.getItemIndependence(2)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item3);
            }
            else if(counter <= 6){
                itemRow2.add(item3);
            }
            else if(counter <= 8){
                itemRow3.add(item3);
            }
        }

        if(controller.getItemIndependence(3)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item4);
            }
            else if(counter <= 6){
                itemRow2.add(item4);
            }
            else if(counter <= 8){
                itemRow3.add(item4);
            }
            
        }

        if(controller.getItemIndependence(4)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item5);
            }
            else if(counter <= 6){
                itemRow2.add(item5);
            }
            else if(counter <= 8){
                itemRow3.add(item5);
            }
        }

        if(controller.getItemIndependence(5)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item6);
            }
            else if(counter <= 6){
                itemRow2.add(item6);
            }
            else if(counter <= 8){
                itemRow3.add(item6);
            }
        }

        if(controller.getItemIndependence(6)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item7);
            }
            else if(counter <= 6){
                itemRow2.add(item7);
            }
            else if(counter <= 8){
                itemRow3.add(item7);
            }

            
        }

        if(controller.getItemIndependence(7)){
            counter++;
            if(counter <= 3){
                itemRow1.add(item8);
            }
            else if(counter <= 6){
                itemRow2.add(item8);
            }
            else if(counter <= 8){
                itemRow3.add(item8);
            }

        }

           






    }

    private JPanel processPanel()
    {
        JPanel panel = new JPanel(new GridLayout(8, 1));

        JLabel process1 = new JLabel(controller.getProcess(index));
        JLabel process2 = new JLabel(controller.getProcess(index));
        JLabel process3 = new JLabel(controller.getProcess(index));
        JLabel process4 = new JLabel(controller.getProcess(index));
        JLabel process5 = new JLabel(controller.getProcess(index));
        JLabel process6 = new JLabel(controller.getProcess(index));
        JLabel process7 = new JLabel(controller.getProcess(index));
        JLabel process8 = new JLabel(controller.getProcess(index));


    };
}
