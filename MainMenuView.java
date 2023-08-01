import javax.swing.*;
import javax.swing.text.Style;
//test if na push
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuView {
    private JPanel mainPanel, createPanel, itemPanel;
    private ArrayList<String> tempItemList = new ArrayList<>();
    private ArrayList<ArrayList<Item>> tempInventory = new ArrayList<>();
    private int tempItemCount = 0;
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
                createVM();
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
        panel.setVisible(true);

        return panel;
    }

    /**
     * 
     */
    private JPanel InitializeCreatePanel(){
        JPanel panel = new JPanel(new FlowLayout());
        
        JTextField itemName = new JTextField("Name");
        itemName.setColumns(15);

        JButton submitButton = new JButton("Add Item");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                String name = itemName.getText();
                
                if(!tempItemList.contains(name)){
                    tempItemCount++;
                    ArrayList<Item> itemType = new ArrayList<>();
                    tempInventory.add(itemType);
                    tempItemList.add(name);
                    controller.getCardLayout().show(controller.getFrame().getContentPane(), "Item Card");
                }

                //pass the name to the controller by calling a controller method
            }
        });
        
        JButton backButton = new JButton("Cancel");
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });

        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        
        JLabel lbl = new JLabel();
        
        
        panel.add(itemName);
        panel.add(submitButton);
        panel.add(backButton);

        return panel;
    }

    private JPanel InitializeItemPanel(){
        JPanel panel = new JPanel(new GridLayout(4,1));

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


        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt(priceTextField.getText());
                int calories = Integer.parseInt(calorieTextField.getText());
                String process = processTextField.getText();
                // controller.addItem(price, calories, process); <- WALA PA TAYO LOGIC FOR THIS

                controller.getCardLayout().show(controller.getFrame().getContentPane(), "Create Card");
            }
        });

        panel.add(pricePanel);
        panel.add(caloriePanel);
        panel.add(processPanel);
        panel.add(submitButton);

        return panel;
    }

    /**
     * 
     */
    public void Open(){
    }

    /**
     * 
     */
    public void createVM(){

    }
}
