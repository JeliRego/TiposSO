/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.awt.BorderLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Alejandro
 */
public class Tienda extends javax.swing.JFrame {
    public int []precios=new int[10];
    public int []indice = new int [10];
    String cuent;
    String ni;
     String respuesta;
    int t;
     protected Socket sk;
    protected DataOutputStream datosalida;
    protected DataInputStream datoentrada;
    /**
     * Creates new form Tienda
     */
    public Tienda()
    {
        initComponents();
        
        precios[0]=12;
        precios[1]=13;
        precios[2]=34;
        precios[3]=90;
        precios[4]=78;
        precios[5]=12;
        precios[6]=13;
        precios[7]=34;
        precios[8]=90;
        precios[9]=78;
        
        indice[0]=0;
        indice[1]=0;
        indice[2]=0;
        indice[3]=0;
        indice[4]=0;
        indice[5]=0;
        indice[6]=0;
        indice[7]=0;
        indice[8]=0;
        indice[9]=0;
        
        
    
        PanelImagen panelFondo= new PanelImagen();
        this.add(panelFondo, BorderLayout.CENTER);
        this.pack();
        
        //PnlDibujo pnlDibujo = new PnlDibujo();
        //pnlDibujo.setSize(this.getSize());
        //add(pnlDibujo);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        panelImagen1 = new tienda.PanelImagen();
        leche = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        algodon = new javax.swing.JRadioButton();
        sopa = new javax.swing.JRadioButton();
        refresco = new javax.swing.JRadioButton();
        papas = new javax.swing.JRadioButton();
        labelleche = new javax.swing.JLabel();
        labelalgodon = new javax.swing.JLabel();
        labelsopa = new javax.swing.JLabel();
        labelrefrescos = new javax.swing.JLabel();
        labelpapas = new javax.swing.JLabel();
        pizza = new javax.swing.JRadioButton();
        labelpizza = new javax.swing.JLabel();
        fertilizante = new javax.swing.JRadioButton();
        labelfertilizante = new javax.swing.JLabel();
        hacha = new javax.swing.JRadioButton();
        labelhacha = new javax.swing.JLabel();
        nesquit = new javax.swing.JRadioButton();
        labelnesquit = new javax.swing.JLabel();
        garrafon = new javax.swing.JRadioButton();
        labelgarrafon = new javax.swing.JLabel();
        total = new javax.swing.JRadioButton();
        labeltotal = new javax.swing.JLabel();
        cuenta = new javax.swing.JTextField();
        nip = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        javax.swing.GroupLayout panelImagen1Layout = new javax.swing.GroupLayout(panelImagen1);
        panelImagen1.setLayout(panelImagen1Layout);
        panelImagen1Layout.setHorizontalGroup(
            panelImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 374, Short.MAX_VALUE)
        );
        panelImagen1Layout.setVerticalGroup(
            panelImagen1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 684, Short.MAX_VALUE)
        );

        leche.setText("Leche");
        leche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lecheActionPerformed(evt);
            }
        });

        jLabel1.setText("ARTICULOS EN EXISTENCIA                                           PRECIO");

        algodon.setText("Algodón");
        algodon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                algodonActionPerformed(evt);
            }
        });

        sopa.setText("Sopa ");
        sopa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sopaActionPerformed(evt);
            }
        });

        refresco.setText("Refresco");
        refresco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescoActionPerformed(evt);
            }
        });

        papas.setText("Papas sabritas");
        papas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                papasActionPerformed(evt);
            }
        });

        pizza.setText("Pizza");
        pizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pizzaActionPerformed(evt);
            }
        });

        fertilizante.setText("Fertilizante");
        fertilizante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fertilizanteActionPerformed(evt);
            }
        });

        hacha.setText("Hacha ");
        hacha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hachaActionPerformed(evt);
            }
        });

        nesquit.setText("Nesquit");
        nesquit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nesquitActionPerformed(evt);
            }
        });

        garrafon.setText("Garrafón de agua");
        garrafon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                garrafonActionPerformed(evt);
            }
        });

        total.setText("TOTAL");
        total.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalActionPerformed(evt);
            }
        });

        jLabel2.setText("No. cuenta");

        jLabel3.setText("Nip");

        aceptar.setText("Aceptar");
        aceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelImagen1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sopa)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 388, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(leche)
                            .addComponent(algodon)
                            .addComponent(refresco)
                            .addComponent(papas)
                            .addComponent(pizza)
                            .addComponent(fertilizante)
                            .addComponent(hacha)
                            .addComponent(nesquit)
                            .addComponent(garrafon)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(108, 108, 108)
                                .addComponent(total))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(14, 14, 14)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(109, 109, 109)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelleche, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelsopa, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelpapas, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelrefrescos, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelalgodon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelpizza, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelfertilizante, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelhacha, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelnesquit, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labelgarrafon, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(labeltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(aceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(cuenta)
                                        .addComponent(nip, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)))))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(leche)
                    .addComponent(labelleche, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(algodon)
                    .addComponent(labelalgodon, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sopa)
                    .addComponent(labelsopa, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(refresco)
                    .addComponent(labelrefrescos, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(papas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelpapas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pizza)
                    .addComponent(labelpizza, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fertilizante)
                    .addComponent(labelfertilizante, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(hacha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelhacha, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nesquit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelnesquit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(garrafon)
                    .addComponent(labelgarrafon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(total, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labeltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(44, 44, 44)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cuenta, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(panelImagen1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void lecheActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        String numero=Integer.toString(precios[0]);
        if(leche.isSelected())
        {
            labelleche.setText(numero);
            indice[0]=1;
        }else{
            labelleche.setText("");
            indice[0]=0;
        }
        
    }                                     

    private void algodonActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        String numero=Integer.toString(precios[1]);
        if(algodon.isSelected())
        {
            labelalgodon.setText(numero);
            indice[1]=1;
        }else{
            labelalgodon.setText("");
            indice[1]=0;
        }
    }                                       

    private void sopaActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
        String numero=Integer.toString(precios[2]);
        if(sopa.isSelected())
        {
            labelsopa.setText(numero);
            indice[2]=1;
        }else{
            labelsopa.setText("");
            indice[2]=0;
        }
    }                                    

    private void refrescoActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String numero=Integer.toString(precios[3]);
        if(refresco.isSelected())
        {
            labelrefrescos.setText(numero);
            indice[3]=1;
        }else{
            labelrefrescos.setText("");
            indice[3]=0;
        }
    }                                        

    private void papasActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        String numero=Integer.toString(precios[4]);
        if(papas.isSelected())
        {
            labelpapas.setText(numero);
            indice[4]=1;
        }else{
            labelpapas.setText("");
            indice[4]=0;
        }
    }                                     

    private void pizzaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        String numero=Integer.toString(precios[5]);
        if(pizza.isSelected())
        {
            labelpizza.setText(numero);
            indice[5]=1;
        }else{
            labelpizza.setText("");
            indice[5]=0;
        }
    }                                     

    private void fertilizanteActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        String numero=Integer.toString(precios[6]);
        if(fertilizante.isSelected())
        {
            labelfertilizante.setText(numero);
            indice[6]=1;
        }else{
            labelfertilizante.setText("");
            indice[6]=0;
        }
    }                                            

    private void hachaActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        String numero=Integer.toString(precios[7]);
        if(hacha.isSelected())
        {
            labelhacha.setText(numero);
            indice[7]=1;
        }else{
            labelhacha.setText("");
            indice[7]=0;
        }
    }                                     

    private void nesquitActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        String numero=Integer.toString(precios[8]);
        if(nesquit.isSelected())
        {
            labelnesquit.setText(numero);
            indice[8]=1;
        }else{
            labelnesquit.setText("");
            indice[8]=0;
        }
    }                                       

    private void garrafonActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String numero=Integer.toString(precios[9]);
        if(garrafon.isSelected())
        {
            labelgarrafon.setText(numero);
            indice[9]=1;
        }else{
            labelgarrafon.setText("");
            indice[9]=0;
        }
    }                                        

    private void totalActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        int cuenta=0;
        String cucu="";
        for (int i=0 ;i<=9;i++)
        {
            if (indice[i]==1)
            {
                cuenta=cuenta+precios[i];
            }
        }
        cucu=Integer.toString(cuenta);
        t=cuenta;
        labeltotal.setText(cucu);
        
    }                                     

    private void aceptarActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
       // cuent=cuenta.getText();
        //ni = nip.getText();
        int c=Integer.parseInt(cuenta.getText());
        int n=Integer.parseInt(nip.getText());
        int EstOp;
        try {
            sk = new Socket("10.18.13.112", 10578);
            datosalida = new DataOutputStream(sk.getOutputStream());
            datoentrada = new DataInputStream(sk.getInputStream());
            datosalida.writeInt(n);
            datosalida.writeInt(c);
            datosalida.writeInt(5);
            datosalida.writeInt(t);
            respuesta=datoentrada.readUTF();
            EstOp=datoentrada.readInt();
            if(EstOp==0)
            {
                Dialogo dialogo =new Dialogo(respuesta);
                dialogo.setVisible(true);
            }
            else
            {
                Dialogo dialogo = new Dialogo(respuesta);
                dialogo.setVisible(true);
            }
        } catch (IOException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        
    }                                       

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tienda.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton aceptar;
    private javax.swing.JRadioButton algodon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JTextField cuenta;
    private javax.swing.JRadioButton fertilizante;
    private javax.swing.JRadioButton garrafon;
    private javax.swing.JRadioButton hacha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel labelalgodon;
    private javax.swing.JLabel labelfertilizante;
    private javax.swing.JLabel labelgarrafon;
    private javax.swing.JLabel labelhacha;
    private javax.swing.JLabel labelleche;
    private javax.swing.JLabel labelnesquit;
    private javax.swing.JLabel labelpapas;
    private javax.swing.JLabel labelpizza;
    private javax.swing.JLabel labelrefrescos;
    private javax.swing.JLabel labelsopa;
    private javax.swing.JLabel labeltotal;
    private javax.swing.JRadioButton leche;
    private javax.swing.JRadioButton nesquit;
    private javax.swing.JTextField nip;
    private tienda.PanelImagen panelImagen1;
    private javax.swing.JRadioButton papas;
    private javax.swing.JRadioButton pizza;
    private javax.swing.JRadioButton refresco;
    private javax.swing.JRadioButton sopa;
    private javax.swing.JRadioButton total;
    // End of variables declaration                   
}
