import javax.swing.*;
import java.awt.*;

public class SpecialVMView {
    private JFrame spcFrame;
    private Controller controller;

    public SpecialVMView(Controller controller){
        this.controller = controller;
        this.spcFrame = new JFrame("Special Vending Machine");
        this.spcFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.spcFrame.setSize(480, 360);
    }

    //JPanel CustomizePanel
    //JPanel Processing
}
