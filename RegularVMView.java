import javax.swing.*;
import java.awt.*;

public class RegularVMView {
    private JFrame rvmFrame;
    private Controller controller;

    public RegularVMView(Controller controller){
        this.controller = controller;
        this.rvmFrame = new JFrame("Regular Vending Machine");
        this.rvmFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.rvmFrame.setSize(480, 360);
    }

}
