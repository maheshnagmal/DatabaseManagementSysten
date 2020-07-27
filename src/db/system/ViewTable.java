package db.system;

import static db.system.DataBaseFunctions.getTableNames;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Mahesh
 */
public class ViewTable extends javax.swing.JFrame {

    /**
     * Creates new form ViewTable
     */
    JLabel jLabel1;
    JComboBox jComboBox1;
    JTable jTable1;
    JButton submit , cancel;
    JTextField [] jTextField=null;
    DefaultTableModel model;
    String[] columnNames ={};
    Object[] str={};
    String tableName = "";
    
    public ViewTable() {
        initComponents();
        
        jLabel1 = new JLabel("Select Table Name");
        jComboBox1 = new JComboBox(getTableNames());
        model = new DefaultTableModel();
        jTable1 = new JTable(model);
        jTable1.setRowHeight(30);
        
        model.addColumn("Name");
        model.addColumn("Data Type");
        model.addColumn("Length");
        model.addColumn("Constraint");
        
        jTable1.setPreferredScrollableViewportSize(new Dimension(500,100));
        jTable1.setFillsViewportHeight(true);
        
        jComboBox1.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox jComboBox1 = (JComboBox) e.getSource();
                if(!"Select".equals(jComboBox1.getSelectedItem().toString())){
                    model.setRowCount(0);
                    tableName=jComboBox1.getSelectedItem().toString();
                    DataBaseFunctions.displayTableData(model,tableName);
                }
            }         
        });
        setLayout(null);
        setTitle("View Table");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(jTable1);
        
        jLabel1.setBounds(30,10,120,40);
        jComboBox1.setBounds(150, 10, 200, 40);
        sp.setBounds(30,70,520,400);
        
        add(jLabel1);
        add(jComboBox1);
        add(sp);
        
        setPreferredSize(new Dimension(600,600));
        pack();
        //setSize(1400,800);
        setLocationRelativeTo(null);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 572, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 380, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTable.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ViewTable().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
