package atm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author dusk
 */
   
public class Dialogo extends JFrame implements ActionListener {
    JLabel mensaje;
    JButton ok= new JButton("Ok");
    public Dialogo(String mensaje)/* mensaje del socket*/
    {
        this.setBounds(300, 300, 300, 300);
        this.mensaje=new JLabel(mensaje);
        this.mensaje.setBounds(0, 40, 300, 300);
        ok.setBounds(200,200,100,100);
        ok.addActionListener(this);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.getContentPane().add(ok);
        this.getContentPane().add(this.mensaje);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==ok)
        {
            this.dispose();
        } //To change body of generated methods, choose Tools | Templates.
        //To change body of generated methods, choose Tools | Templates.
    }
}
