import javax.swing.*;
import javax.swing.text.Style;
//test if na push
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MainMenuView {
    private JPanel mainPanel, createPanel, itemPanel;
    private JButton createButton, testButton, exitButton, submitButton, backButton, proceedButton;
    private JTextField itemName, itemPrice, itemCalories, itemProcess;
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

        this.createButton = new JButton("Create a New Vending Machine");
        this.createButton.setFocusable(false);
        this.createButton.addActionListener(new ActionListener() {
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
                    controller.createRegular();
                    controller.getFrame().remove(mainPanel);
                    controller.getFrame().add(createPanel);
                    controller.getFrame().revalidate();
                    controller.getFrame().repaint();
                }
                createVM();
            }
        });

        this.testButton = new JButton("Test Existing Vending Machine");
        this.testButton.setFocusable(false);
        this.testButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                boolean existence = false;
                existence = controller.testVM();
                if(existence){
                    
                }
            }
        });

        this.exitButton = new JButton("Exit");
        this.exitButton.setFocusable(false);
        this.exitButton.addActionListener(new ActionListener() {
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
        
        this.itemName = new JTextField("Name");
        this.itemName.setColumns(15);
        panel.add(itemName);

        this.submitButton = new JButton("Add Item");
        this.submitButton.setFocusable(false);
        this.submitButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                itemName.getText();
                //pass the name to the controller by calling a controller method
            }
        });
        
        this.backButton = new JButton("Cancel");
        this.backButton.setFocusable(false);
        this.backButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                createPanel.setVisible(false);
                
            }
        });

        this.proceedButton = new JButton("Proceed");
        this.proceedButton.setFocusable(false);
        

        
        
        
        panel.add(submitButton);
        panel.add(backButton);

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
