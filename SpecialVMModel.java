import javax.swing.JButton;
import javax.swing.JLabel;


public class SpecialVMModel extends VMModel {
    public SpecialVMModel(Controller controller){
        super(controller);
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
