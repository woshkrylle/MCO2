import javax.swing.*;
import javax.swing.text.Style;
//test if na push
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuView {
    private JPanel mainPanel, createPanel, itemPanel;
    private Controller controller;

    /**
     * 
     * @param controller
     */
    public MainMenuView(Controller controller){
        this.controller = controller;

        mainPanel = InitializeMainPanel();
        createPanel = InitializeCreatePanel();

        controller.getFrame().add(mainPanel);
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
                    controller.getFrame().remove(mainPanel);
                    controller.getFrame().add(createPanel);
                    controller.getFrame().revalidate();
                    controller.getFrame().repaint();
                }else if (choice == 1){
                    controller.createSpecial();
                    controller.getFrame().remove(mainPanel);
                    controller.getFrame().add(createPanel);
                    controller.getFrame().revalidate();
                    controller.getFrame().repaint();
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
        ArrayList<Item> itemList = new ArrayList<>();
        JPanel panel = new JPanel(new GridBagLayout());
        
        JTextField itemName = new JTextField("Name");
        itemName.setColumns(15);
        panel.add(itemName);

        JButton submitButton = new JButton("Add Item");
        submitButton.setFocusable(false);
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                itemName.getText();
                //pass the name to the controller by calling a controller method
            }
        });
        
        JButton backButton = new JButton("Cancel");
        backButton.setFocusable(false);
        backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createPanel.setVisible(false);
                
            }
        });

        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFocusable(false);
        

        
        
        
        panel.add(submitButton);
        panel.add(backButton);

        return panel;
    }

    private void InitializeItemPanel(){
        this.itemPanel = new JPanel(new GridLayout(4,1));

        JPanel pricePanel = new JPanel(new BorderLayout());
        JLabel priceLabel = new JLabel("Price:"):
        pricePanel.add(priceLabel, BorderLayout.WEST)
        JTextField priceTextField = new JTextField();
        priceTextField.setColumns(15);
        pricePanel.add(priceTextField, BorderLayout.EAST);
        
        
        JPanel caloriePanel = new JPanel(new BorderLayout());
        JLabel calorieLabel = new JLabel("Calories:"):
        caloriePanel.add(calorieLabel, BorderLayout.WEST)
        JTextField calorieTextField = new JTextField();
        calorieTextField.setColumns(15);
        caloriePanel.add(calorieTextField, BorderLayout.EAST)

        JPanel processPanel = new JPanel(new BorderLayout());
        JLabel processLabel = new JLabel("Process:"):
        processPanel.add(processLabel, BorderLayout.WEST)
        JTextField processTextField = new JTextField();
        processTextField.setColumns(15);
        processPanel.add(processTextField, BorderLayout.EAST)


        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                int price = Integer.parseInt(priceTextField.getText());
                int calories = Integer.parseInt(calorieTextField.getText());
                String process = processTextField.getText();
                // controller.addItem(price, calories, process); <- WALA PA TAYO LOGIC FOR THIS
            }
        });
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
