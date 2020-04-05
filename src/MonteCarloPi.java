import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Math.PI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tarek El Bardouni, Email: tarekbardouni@uae.ma
 * ERSN, University Abdelmalek Essaadi, Tetouan, Morocco
 * 
 **/
public class MonteCarloPi extends javax.swing.JFrame implements ActionListener{
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    static Boolean CancelFlag = false;
    static Boolean ProcessFlag = false;
    static Boolean ContinueFlag = false;
    public static long Batch_Size_init, Batch_Size, Batch_Number, Increase_Factor, success, Start_J;
    double Disk_Radius, Square_Side_Length, Square_To_disk_Ratio, Monte_Carlo_PI;
    double x, y;        
    long elapsedTime, startTime, endTime;
    public static DefaultTableModel PiTable;


    public MonteCarloPi() {
        initComponents();
        PiTable = (DefaultTableModel) table.getModel();
        dateTF.setText(" " + dateFormat.format(date));
        setTitle("Monte Carlo simulation of Pi");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }   
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        disk_radius = new javax.swing.JTextField();
        batch_size = new javax.swing.JTextField();
        batch_number = new javax.swing.JTextField();
        increase_factor = new javax.swing.JTextField();
        answerLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        True_Pi_Value = new javax.swing.JLabel();
        Simulation_Time = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jSeparator3 = new javax.swing.JSeparator();
        ProcessBtn = new javax.swing.JButton();
        BreakBtn = new javax.swing.JButton();
        ContinueBtn = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        dateTF = new javax.swing.JTextField();
        ExitBtn = new javax.swing.JButton();
        clearDataBtn = new javax.swing.JButton();
        PlotBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Monte Carlo Simulation of PI");

        jLabel2.setText("Disk Radius in cm");

        jLabel3.setText("Sample size");

        jLabel4.setText("Batches number");

        jLabel5.setText("Increasing Factor");

        disk_radius.setText("1");

        batch_size.setText("1000");

        batch_number.setText("1");

        increase_factor.setText("1");

        True_Pi_Value.setToolTipText("");

        ProcessBtn.setText("process");
        ProcessBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProcessBtnActionPerformed(evt);
            }
        });

        BreakBtn.setText("cancel");
        BreakBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BreakBtnActionPerformed(evt);
            }
        });

        ContinueBtn.setText("continue");
        ContinueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(answerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(disk_radius)
                                            .addComponent(batch_size, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(batch_number)
                                            .addComponent(increase_factor)))
                                    .addComponent(True_Pi_Value, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Simulation_Time, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jSeparator3))))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(ProcessBtn)
                .addGap(20, 20, 20)
                .addComponent(BreakBtn)
                .addGap(20, 20, 20)
                .addComponent(ContinueBtn))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(4, 4, 4)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(disk_radius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(batch_size, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(batch_number, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(increase_factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(answerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(True_Pi_Value, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Simulation_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProcessBtn)
                    .addComponent(BreakBtn)
                    .addComponent(ContinueBtn))
                .addGap(7, 7, 7))
        );

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "N", "Pi"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setColumnSelectionAllowed(true);
        table.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(table);
        table.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        ExitBtn.setText("Exit");
        ExitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitBtnActionPerformed(evt);
            }
        });

        clearDataBtn.setText("clear data");
        clearDataBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearDataBtnActionPerformed(evt);
            }
        });

        PlotBtn.setText("plot");
        PlotBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlotBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 11, Short.MAX_VALUE)
                        .addComponent(PlotBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(clearDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ExitBtn)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(16, 16, 16))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 308, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ExitBtn)
                    .addComponent(clearDataBtn)
                    .addComponent(PlotBtn))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        Runtime.getRuntime().exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void clearDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataBtnActionPerformed
        PiTable.setRowCount(0);
        jProgressBar1.setValue(0);
        CancelFlag = false;
        ProcessFlag = false;
        ContinueFlag = false;
        Batch_Number = 0;
        Batch_Size = 0;
    }//GEN-LAST:event_clearDataBtnActionPerformed

    private void ProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessBtnActionPerformed
        ProcessFlag = true;
        CancelFlag = false;
        ContinueBtn.setEnabled(false);         
        ProcessBtn.setEnabled(false); 
        clearDataBtn.setEnabled(false);

        try {
            Disk_Radius = Double.parseDouble(this.disk_radius.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad Disk Radius value", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Batch_Size = Integer.parseInt(this.batch_size.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad sample size", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Increase_Factor = Integer.parseInt(MonteCarloPi.increase_factor.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad Increase factor ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Batch_Number = Integer.parseInt(this.batch_number.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad repeat number ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            new Thread(this::MonteCarlo).start();    
    }//GEN-LAST:event_ProcessBtnActionPerformed

    private void BreakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreakBtnActionPerformed
        CancelFlag = true;
        ProcessFlag = false;
        ContinueFlag = false;
        System.out.println("Simulation was interrupted! ");                
    }//GEN-LAST:event_BreakBtnActionPerformed

    private void ContinueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueBtnActionPerformed
        ContinueFlag = true;
        CancelFlag = false;
        ContinueBtn.setEnabled(false);         
        ProcessBtn.setEnabled(false); 
        clearDataBtn.setEnabled(false);

        try {
            Increase_Factor = Integer.parseInt(MonteCarloPi.increase_factor.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad Increase factor ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Batch_Number = Integer.parseInt(this.batch_number.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad repeat number ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        new Thread(this::MonteCarlo).start();
    }//GEN-LAST:event_ContinueBtnActionPerformed

    private void PlotBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlotBtnActionPerformed
        new XYLineChart().setVisible(true);
    }//GEN-LAST:event_PlotBtnActionPerformed

    private void MonteCarlo() {
// Monte Carlo sampling of x and y coordinates of a point on a plane
        Random generator = new Random();
        double R2 = Disk_Radius * Disk_Radius;
        Square_Side_Length = 2 * Disk_Radius;
        Square_To_disk_Ratio = (Square_Side_Length * Square_Side_Length) / (Disk_Radius * Disk_Radius);
        double a = -Disk_Radius;
        double b = Disk_Radius;
        double b_a = b - a;
        Object data[] = new Object[2];
        if(ProcessFlag){
            ContinueFlag = false;
            Start_J = 0;
        }
        if(ContinueFlag){
            ProcessFlag = false;
        }
        Batch_Size_init = Batch_Size;
        startTime = System.currentTimeMillis();     // timer start
        for (long j = Start_J; j < Batch_Number; j++) {   // Do Loop on batches
            success = 0;
            if (CancelFlag ){      
                CancelFlag = false;
                ProcessFlag = false;
                ContinueFlag = false;
                Start_J = j;
                break; 
            }           
            Batch_Size = Batch_Size + 1;
        
            for (long i = 0; i < Batch_Size ; i++) {      // Do Loop on sampled points
                x = a + b_a * generator.nextDouble();    // random x between a & b
                y = a + b_a * generator.nextDouble();    // random y between a & b 
                if (x * x + y * y <= R2) {success++;}    // the point is inside the circle
            }
            
            Monte_Carlo_PI = Square_To_disk_Ratio * (double) success / (double) Batch_Size;
            Batch_Size = Batch_Size - 1;
            if(Batch_Number > 0){
                System.out.println(" Batch number : " + (j + 1) +",   Sample Size : " + Batch_Size + ",   Pi value : " + Monte_Carlo_PI);
                this.answerLabel.setText("The Monte Carlo value of PI is : " + Monte_Carlo_PI);
                data[0] = Batch_Size;
                data[1] = Monte_Carlo_PI;
                PiTable.addRow(data);            
                jProgressBar1.setValue((int) ((j+1)*100/Batch_Number));
            }
            Batch_Size = Batch_Size * Increase_Factor;
        }
        endTime = System.currentTimeMillis();       // timer stop
        elapsedTime = endTime - startTime;          // elapsed time

        this.True_Pi_Value.setText("The true value of PI is :              " + PI);
        this.Simulation_Time.setText("Time of simulation :                  " + (double) elapsedTime / 1000 + "    seconds");           
        
        ProcessFlag = false;
        ContinueFlag = false;
        CancelFlag = false;
        ContinueBtn.setEnabled(true);         
        ProcessBtn.setEnabled(true); 
        clearDataBtn.setEnabled(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                 //               
    }
       
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
   /*     try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MonteCarloPi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } */
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MonteCarloPi().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BreakBtn;
    private javax.swing.JButton ContinueBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton PlotBtn;
    private javax.swing.JButton ProcessBtn;
    private javax.swing.JLabel Simulation_Time;
    private javax.swing.JLabel True_Pi_Value;
    private javax.swing.JLabel answerLabel;
    private javax.swing.JTextField batch_number;
    private javax.swing.JTextField batch_size;
    private javax.swing.JButton clearDataBtn;
    private javax.swing.JTextField dateTF;
    private javax.swing.JTextField disk_radius;
    public static javax.swing.JTextField increase_factor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables

}
