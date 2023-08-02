import javax.swing.*;
import javax.swing.text.Style;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
public class MainMenuView {
    private JPanel mainPanel, createPanel, itemPanel;
    private ArrayList<JLabel> itemLabels = new ArrayList<>();
    private Controller controller;

    /**
     * 
     * @param controller
     */
    public MainMenuView(Controller controller){
        this.controller = controller;

        this.mainPanel = InitializeMainPanel();
        this.createPanel = InitializeCreatePanel();
        this.itemPanel = InitializeItemPanel();

        controller.getFrame().add(mainPanel, "Main Card");
        controller.getFrame().add(createPanel, "Create Card");
        controller.getFrame().add(itemPanel, "Item Card");
        controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");

    }

    /**
     * 
     */
    private JPanel InitializeMainPanel(){
        JPanel panel = new JPanel(new GridLayout(3, 1));

        JButton createButton = new JButton("Create a New Vending Machine");
        createButton.setFocusable(false);
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                Object[] options = {"Regular", "Special"};
                int choice = JOptionPane.showOptionDialog(createButton, 
                                                  "Regular or Special?", 
                                                          "Create New Vending Machine", 
                                                          JOptionPane.YES_NO_CANCEL_OPTION, 
                                                          JOptionPane.QUESTION_MESSAGE, 
                                                          null, options, options[0]);

                if(choice == 0){
                    controller.createRegular();
                    controller.getCardLayout().show(controller.getFrame().getContentPane(), "Create Card");
                }else if (choice == 1){
                    controller.createSpecial();
                    controller.getCardLayout().show(controller.getFrame().getContentPane(), "Create Card");
                }
            }
        });

        JButton testButton = new JButton("Test Existing Vending Machine");
        testButton.setFocusable(false);
        testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                boolean existence = false;
                existence = controller.testVM();
                if(existence){
                    
                }
            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFocusable(false);
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        panel.add(createButton);
        panel.add(testButton);
        panel.add(exitButton);

        return panel;
    }

    /**
     * 
     */
    private JPanel InitializeCreatePanel(){
        JPanel panel = new JPanel(new GridLayout(2,1));

        JPanel inventoryPanel = new JPanel();
        inventoryPanel.setLayout(new BoxLayout(inventoryPanel, BoxLayout.Y_AXIS));
        JPanel itemPanel = new JPanel(new FlowLayout());

        JTextField itemName = new JTextField("Name");
        itemName.setColumns(15);
        
        JLabel lbl = new JLabel();
        lbl.setText("Slots Filled: "+ controller.getSlotCount());
        
        JButton submitButton = new JButton("Add Item");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = itemName.getText();
                
                if(!controller.checkForItem(name)){
                    controller.newItemListEntry(name);
                    controller.getCardLayout().show(controller.getFrame().getContentPane(), "Item Card");
                    lbl.setText("Slots Filled: " + controller.getSlotCount());
                    addItemCounter(name, inventoryPanel);
                    inventoryPanel.revalidate();
                    inventoryPanel.repaint();
                }else{
                    controller.addItemToInventory(name);
                    updateItemCounter(name);
                    inventoryPanel.revalidate();
                    inventoryPanel.repaint();
                }
            }
        });
        
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        proceedButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Main Card");
            }
        });
        
        inventoryPanel.add(lbl);
        itemPanel.add(itemName);
        itemPanel.add(submitButton);
        itemPanel.add(proceedButton);

        panel.add(itemPanel);
        panel.add(inventoryPanel);
        return panel;
    }

    private JPanel InitializeItemPanel(){
        JPanel panel = new JPanel(new GridLayout(5,1));

        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel priceLabel = new JLabel("Price:");
        pricePanel.add(priceLabel, BorderLayout.WEST);
        JTextField priceTextField = new JTextField();
        priceTextField.setColumns(15);
        pricePanel.add(priceTextField, BorderLayout.EAST);
        
        
        JPanel caloriePanel = new JPanel(new BorderLayout());
        JLabel calorieLabel = new JLabel("Calories:");
        caloriePanel.add(calorieLabel, BorderLayout.WEST);
        JTextField calorieTextField = new JTextField();
        calorieTextField.setColumns(15);
        caloriePanel.add(calorieTextField, BorderLayout.EAST);

        JPanel processPanel = new JPanel(new BorderLayout());
        JLabel processLabel = new JLabel("Process:");
        processPanel.add(processLabel, BorderLayout.WEST);
        JTextField processTextField = new JTextField();
        processTextField.setColumns(15);
        processPanel.add(processTextField, BorderLayout.EAST);

        JPanel independencePanel = new JPanel(new BorderLayout());
        JLabel independenceLabel = new JLabel("Ingredient can be sold on its own (True or False):");
        independencePanel.add(independenceLabel, BorderLayout.WEST);
        JTextField independenceTextField = new JTextField();
        independenceTextField.setColumns(15);
        independencePanel.add(independenceTextField, BorderLayout.EAST);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt(priceTextField.getText());
                int calories = Integer.parseInt(calorieTextField.getText());
                String process = processTextField.getText();
                boolean independence = Boolean.parseBoolean((independenceTextField.getText()).toLowerCase());
                controller.addItemToInventory(price, calories, process, independence);
                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Create Card");
            }
        });

        panel.add(pricePanel);
        panel.add(caloriePanel);
        panel.add(processPanel);
        panel.add(independencePanel);
        panel.add(submitButton);

        return panel;
    }

    /**
     * 
     */
    public void addItemCounter(String name, JPanel panel){
        JLabel newLabel = new JLabel();
        newLabel.setText(name+": 1");
        panel.add(newLabel);
        itemLabels.add(newLabel);
    }

    public void updateItemCounter(String name){
        int index = controller.getItemIndex(name);
        JLabel label = itemLabels.get(index);
        label.setText(name+": "+controller.getItemCount(name));
    }

    
}
