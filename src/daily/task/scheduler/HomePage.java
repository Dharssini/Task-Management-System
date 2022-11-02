
package daily.task.scheduler;

import java.awt.Toolkit;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import javax.swing.JOptionPane;


public class HomePage extends javax.swing.JFrame
{

    private final Preferences preference=new Preferences();
    private final DbOperations dbOperation=new DbOperations();
    private String currentDay,currentDate;

    public HomePage() {
        preference.changeUI();
        initComponents();
        dateAndDay();
        labelDate.setText(currentDate);
        labelDay.setText(currentDay);
        refreshTable(); // Set Database data
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Images/DTS-icon.png")));
        setLocationRelativeTo(null);
    }
    
    private void refreshTable() {
        try {
            jTable.setModel(dbOperation.convert(jTable,currentDay));
            preference.tablePreference(jTable);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Something Wrong.");
        }
    }
    
    private void dateAndDay(){
        LocalDate ld=LocalDate.now();
        currentDate = ld.format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM));
        currentDay = ld.getDayOfWeek().toString();
        
//        if(currentDay.equals("SUNDAY")){
//            dbOperation.deleteAllTableData();
//            ImageIcon icon = new ImageIcon(getClass().getResource("/Images/hurrah-icon.png"));
//            JOptionPane.showMessageDialog(rootPane, "Week is completed.", "Message Box", JOptionPane.OK_OPTION, icon);
//        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code. The content of this method is always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TitleBar = new javax.swing.JPanel();
        labelSetting = new javax.swing.JLabel();
        labelDate = new javax.swing.JLabel();
        labelDay = new javax.swing.JLabel();
        TableData = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Daily Task Scheduler");
        setMinimumSize(new java.awt.Dimension(1073, 720));
        setSize(new java.awt.Dimension(1073, 720));

        TitleBar.setLayout(new java.awt.BorderLayout());

        labelSetting.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings.png"))); // NOI18N
        labelSetting.setBorder(javax.swing.BorderFactory.createEmptyBorder(15, 1, 1, 15));
        labelSetting.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelSettingMouseClicked(evt);
            }
        });
        TitleBar.add(labelSetting, java.awt.BorderLayout.LINE_END);

        labelDate.setFont(new java.awt.Font("Segoe UI Emoji", 0, 48)); // NOI18N
        labelDate.setText("Date");
        labelDate.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 1, 1));
        labelDate.setMaximumSize(new java.awt.Dimension(60, 60));
        labelDate.setMinimumSize(new java.awt.Dimension(60, 60));
        labelDate.setPreferredSize(new java.awt.Dimension(60, 60));
        labelDate.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        labelDate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                labelDateMouseClicked(evt);
            }
        });
        TitleBar.add(labelDate, java.awt.BorderLayout.CENTER);

        labelDay.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        labelDay.setText("Day");
        labelDay.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 10, 1, 1));
        TitleBar.add(labelDay, java.awt.BorderLayout.PAGE_END);

        getContentPane().add(TitleBar, java.awt.BorderLayout.PAGE_START);

        jTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {}
            },
            new String [] {

            }
        ));
        jTable.setSelectionBackground(new java.awt.Color(51, 255, 0));
        jScrollPane1.setViewportView(jTable);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/icons8-pomodoro-64.png"))); // NOI18N
        jLabel1.setMaximumSize(new java.awt.Dimension(80, 80));
        jLabel1.setMinimumSize(new java.awt.Dimension(337, 256));
        jLabel1.setPreferredSize(new java.awt.Dimension(337, 256));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TableDataLayout = new javax.swing.GroupLayout(TableData);
        TableData.setLayout(TableDataLayout);
        TableDataLayout.setHorizontalGroup(
            TableDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableDataLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1098, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableDataLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        TableDataLayout.setVerticalGroup(
            TableDataLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TableDataLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 598, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(TableData, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void labelSettingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelSettingMouseClicked
        // TODO add your handling code here:
        Settings settings = new Settings(currentDay);
        setVisible(false);
    }//GEN-LAST:event_labelSettingMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        new PomodoroTimer().setVisible(true);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void labelDateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_labelDateMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_labelDateMouseClicked

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
        }
        catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new HomePage().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel TableData;
    private javax.swing.JPanel TitleBar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable;
    private javax.swing.JLabel labelDate;
    private javax.swing.JLabel labelDay;
    private javax.swing.JLabel labelSetting;
    // End of variables declaration//GEN-END:variables
}
