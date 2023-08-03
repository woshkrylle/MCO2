import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;


public class SpecialVMView {
    private JPanel specialPanel, basePanel, processPanel;
    private ArrayList<JButton> buttonList = new ArrayList<>();
    private ArrayList<JLabel> labelList = new ArrayList<>();
    private ArrayList<JButton> customButtons = new ArrayList<>();
    private ArrayList<JLabel> processLabels = new ArrayList<>();
    private Controller controller;

    public SpecialVMView(Controller controller){
        this.controller = controller;
        this.specialPanel = itemMenu();
        this.basePanel = baseItems();
        this.processPanel = processPanel();

        controller.getFrame().add(specialPanel, "Special Items Card");
        controller.getFrame().add(basePanel, "Custom Card");
        controller.getFrame().add(processPanel, "Process Card");
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
                initializeCustomButtons();
                basePanel.revalidate();
                basePanel.repaint();
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

    public void updateItemButtons(){
        switch(controller.getSlotCount()){
            case 8:
                buttonList.get(7).setText(controller.getItemName(7)+": P"+controller.getItemPrice(7) +" ("+controller.getItemCount(7)+"/10)");
            case 7:
                buttonList.get(6).setText(controller.getItemName(6)+": P"+controller.getItemPrice(6) +" ("+controller.getItemCount(6)+"/10)");
            case 6:
                buttonList.get(5).setText(controller.getItemName(5)+": P"+controller.getItemPrice(5) +" ("+controller.getItemCount(5)+"/10)");
            case 5:
                buttonList.get(4).setText(controller.getItemName(4)+": P"+controller.getItemPrice(4) +" ("+controller.getItemCount(4)+"/10)");
            case 4:
                buttonList.get(3).setText(controller.getItemName(3)+": P"+controller.getItemPrice(3) +" ("+controller.getItemCount(3)+"/10)");
            case 3:
                buttonList.get(2).setText(controller.getItemName(2)+": P"+controller.getItemPrice(2) +" ("+controller.getItemCount(2)+"/10)");
            case 2:
                buttonList.get(1).setText(controller.getItemName(1)+": P"+controller.getItemPrice(1) +" ("+controller.getItemCount(1)+"/10)");
            case 1:
                buttonList.get(0).setText(controller.getItemName(0)+": P"+controller.getItemPrice(0) +" ("+controller.getItemCount(0)+"/10)");
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
        JPanel panel = new JPanel(new GridLayout(9, 1));
        
        JButton item1 = new JButton("N/A");
        JButton item2 = new JButton("N/A");
        JButton item3 = new JButton("N/A");
        JButton item4 = new JButton("N/A");
        JButton item5 = new JButton("N/A");
        JButton item6 = new JButton("N/A");
        JButton item7 = new JButton("N/A");
        JButton item8 = new JButton("N/A");

        customButtons.add(item1);
        customButtons.add(item2);
        customButtons.add(item3);
        customButtons.add(item4);
        customButtons.add(item5);
        customButtons.add(item6);
        customButtons.add(item7);
        customButtons.add(item8);

        JButton proceedButton = new JButton("Process");
        proceedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Process Card");
                controller.printProcesses(processLabels);
            }
        });

        panel.add(item1);
        panel.add(item2);
        panel.add(item3);
        panel.add(item4);
        panel.add(item5);
        panel.add(item6);
        panel.add(item7);
        panel.add(item8);
        panel.add(proceedButton);

        return panel;
    }

    public void initializeCustomButtons(){
        switch(controller.getSlotCount()){
            case 8:
                customButtons.get(7).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(7);
                        customButtons.get(7).setText(controller.getItemName(7)+": P"+controller.getItemPrice(7) +" ("+controller.getItemCount(7)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(7).setText(controller.getItemName(7)+": P"+controller.getItemPrice(7) +" ("+controller.getItemCount(7)+"/10)");
            case 7:
                customButtons.get(6).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(6);
                        customButtons.get(6).setText(controller.getItemName(6)+": P"+controller.getItemPrice(6) +" ("+controller.getItemCount(6)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(6).setText(controller.getItemName(6)+": P"+controller.getItemPrice(6) +" ("+controller.getItemCount(6)+"/10)");
            case 6:
                customButtons.get(5).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(5);
                        customButtons.get(5).setText(controller.getItemName(5)+": P"+controller.getItemPrice(5) +" ("+controller.getItemCount(5)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(5).setText(controller.getItemName(5)+": P"+controller.getItemPrice(5) +" ("+controller.getItemCount(5)+"/10)");
            case 5:
                customButtons.get(4).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(4);
                        customButtons.get(5).setText(controller.getItemName(4)+": P"+controller.getItemPrice(4) +" ("+controller.getItemCount(4)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(4).setText(controller.getItemName(4)+": P"+controller.getItemPrice(4) +" ("+controller.getItemCount(4)+"/10)");
            case 4:
                customButtons.get(3).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(3);
                        customButtons.get(3).setText(controller.getItemName(3)+": P"+controller.getItemPrice(3) +" ("+controller.getItemCount(3)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(3).setText(controller.getItemName(3)+": P"+controller.getItemPrice(3) +" ("+controller.getItemCount(3)+"/10)");
            case 3:
                customButtons.get(2).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(2);
                        customButtons.get(2).setText(controller.getItemName(2)+": P"+controller.getItemPrice(2) +" ("+controller.getItemCount(2)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(2).setText(controller.getItemName(2)+": P"+controller.getItemPrice(2) +" ("+controller.getItemCount(2)+"/10)");
            case 2:
                customButtons.get(1).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(1);
                        customButtons.get(1).setText(controller.getItemName(1)+": P"+controller.getItemPrice(1) +" ("+controller.getItemCount(1)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(1).setText(controller.getItemName(1)+": P"+controller.getItemPrice(1) +" ("+controller.getItemCount(1)+"/10)");
            case 1:
                customButtons.get(0).addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        controller.addItemToCart(0);
                        customButtons.get(0).setText(controller.getItemName(0)+": P"+controller.getItemPrice(0) +" ("+controller.getItemCount(0)+"/10)");
                        basePanel.revalidate();
                        basePanel.repaint();
                    }
                });
                customButtons.get(0).setText(controller.getItemName(0)+": P"+controller.getItemPrice(0) +" ("+controller.getItemCount(0)+"/10)");
            case 0:
                break;
        }
    }

    //Initiates the GUI for the 
    private JPanel processPanel()
    {
        JPanel panel = new JPanel(new GridLayout(8, 1));

        
        JLabel process1 = new JLabel();
        processLabels.add(process1);
        panel.add(process1);

        JLabel process2 = new JLabel();
        processLabels.add(process2);
        panel.add(process2);

        JLabel process3 = new JLabel();
        processLabels.add(process3);
        panel.add(process3);

        JLabel process4 = new JLabel();
        processLabels.add(process4);
        panel.add(process4);

        JLabel process5 = new JLabel();
        processLabels.add(process5);
        panel.add(process5);

        JLabel process6 = new JLabel();
        processLabels.add(process6);
        panel.add(process6);

        JLabel process7 = new JLabel();
        processLabels.add(process7);
        panel.add(process7);
        
        JLabel process8 = new JLabel();
        processLabels.add(process8);
        panel.add(process8);

        JButton checkOutButton = new JButton("Checkout");
        checkOutButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.checkOut();
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });
        panel.add(checkOutButton);

        return panel;
    };


}
