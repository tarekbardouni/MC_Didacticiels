import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.io.File;
import java.io.IOException;
import static java.lang.Math.PI;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import javax.swing.JOptionPane;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Tarek El Bardouni, Email: tarekbardouni@uae.ma
 * ERSN, University Abdelmalek Essaadi, Tetouan, Morocco
 * 
 **/
public class MonteCarloScatterPlot extends javax.swing.JFrame implements ActionListener{
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/YY");
    Date date = new Date();
    Calendar cal = Calendar.getInstance();
    static Boolean CancelFlag = false;
    static Boolean ProcessFlag = false;
    static Boolean ClearFlag = false;
    static Boolean SaveFlag = false;
    public static Boolean ContinueFlag = false;
    public static long Batch_Size_total, Batch_Size_init, Batch_Size, Batch_Number, Increase_Factor, success, fails, Start_I, continue_counter;
    double Disk_Radius, Square_Side_Length, Square_To_disk_Ratio, Monte_Carlo_PI;
    public static double  a, b, b_a, x, y, R2;        
    long   elapsedTime, startTime, endTime;
    public XYSeries series1, series2;
    public XYSeries xySuccessSerie = new XYSeries("  Success   ");
    public XYSeries xyFailsSerie = new XYSeries("  Failure   ");
    
    public MonteCarloScatterPlot() {
        initComponents();
        dateTF.setText(" " + dateFormat.format(date));
        setTitle("Monte Carlo simulation of Pi");
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.validate();
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
        jLabel5 = new javax.swing.JLabel();
        disk_radius = new javax.swing.JTextField();
        batch_size = new javax.swing.JTextField();
        increase_factor = new javax.swing.JTextField();
        answerLabel = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        True_Pi_Value = new javax.swing.JLabel();
        Simulation_Time = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        ProcessBtn = new javax.swing.JButton();
        BreakBtn = new javax.swing.JButton();
        ContinueBtn = new javax.swing.JButton();
        dateTF = new javax.swing.JTextField();
        ExitBtn = new javax.swing.JButton();
        clearDataBtn = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.lightGray);

        jLabel1.setFont(new java.awt.Font("Lucida Grande", 2, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Monte Carlo Simulation of PI");

        jLabel2.setText("Disk Radius in cm");

        jLabel3.setText("Sample size");

        jLabel5.setText("Increasing Factor");

        disk_radius.setText("1");

        batch_size.setText("1000");

        increase_factor.setText("1");

        True_Pi_Value.setToolTipText("");

        jProgressBar1.setForeground(new java.awt.Color(0, 10, 255));
        jProgressBar1.setPreferredSize(new java.awt.Dimension(150, 2));

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
        ContinueBtn.setEnabled(false);
        ContinueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContinueBtnActionPerformed(evt);
            }
        });
        ContinueBtn.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                ContinueBtnPropertyChange(evt);
            }
        });

        dateTF.setEditable(false);
        dateTF.setHorizontalAlignment(javax.swing.JTextField.CENTER);

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jSeparator1))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(clearDataBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(ExitBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(ProcessBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(15, 15, 15)
                                .addComponent(BreakBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15)
                                .addComponent(ContinueBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Simulation_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(answerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(42, 42, 42)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(disk_radius)
                                            .addComponent(batch_size, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE)
                                            .addComponent(increase_factor)))
                                    .addComponent(True_Pi_Value, javax.swing.GroupLayout.PREFERRED_SIZE, 349, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 334, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(100, 100, 100))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator3)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(dateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(increase_factor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(28, 28, 28)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addComponent(answerLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(True_Pi_Value, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Simulation_Time, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProcessBtn)
                    .addComponent(BreakBtn)
                    .addComponent(ContinueBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(clearDataBtn)
                    .addComponent(ExitBtn))
                .addGap(7, 7, 7))
        );

        jPanel2.setBackground(new java.awt.Color(213, 216, 214));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setPreferredSize(new java.awt.Dimension(460, 460));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 456, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 469, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 475, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ExitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitBtnActionPerformed
        Runtime.getRuntime().exit(0);
    }//GEN-LAST:event_ExitBtnActionPerformed

    private void clearDataBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearDataBtnActionPerformed
        jProgressBar1.setValue(0);
        CancelFlag = false;
        ClearFlag = true;
        ProcessFlag = false;
        ContinueFlag = false;
        xySuccessSerie.delete(0, (int) success - 1); 
        xyFailsSerie.delete(0, (int) fails - 1);
        Batch_Size_total = 0;
        success = 0;
        fails = 0;
        Start_I = 0;
    }//GEN-LAST:event_clearDataBtnActionPerformed

    private void ProcessBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProcessBtnActionPerformed
        continue_counter = 0;
        ProcessFlag = true;
        CancelFlag = false;
        ContinueBtn.setEnabled(false);         
        ProcessBtn.setEnabled(false); 
        clearDataBtn.setEnabled(false);
        xySuccessSerie.delete(0, (int) success - 1);    // reset data base
        xyFailsSerie.delete(0, (int) fails - 1);
        Batch_Size_total = Batch_Size;
        success = 0;
        fails = 0;
        Start_I = 0;
        jProgressBar1.setValue(0);
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
            Increase_Factor = Integer.parseInt(MonteCarloScatterPlot.increase_factor.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad Increase factor ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
            Batch_Size = Batch_Size * Increase_Factor;
            new Thread(this::MCcreateScatterPlot).start();                         
    }//GEN-LAST:event_ProcessBtnActionPerformed

    private void BreakBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BreakBtnActionPerformed
        CancelFlag = true;
        ProcessFlag = false;
        ContinueFlag = false;
        System.out.println("Simulation was interrupted! ");                
        ProcessBtn.setEnabled(true); 
        clearDataBtn.setEnabled(true);
        Batch_Size_total = Batch_Size;        
        jProgressBar1.setValue(0);
    }//GEN-LAST:event_BreakBtnActionPerformed

    @SuppressWarnings("empty-statement")
    private void ContinueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContinueBtnActionPerformed
        continue_counter++;
        ContinueFlag = true;
        CancelFlag = false;
        ContinueBtn.setEnabled(false);         
        ProcessBtn.setEnabled(false); 
        clearDataBtn.setEnabled(false);
        jProgressBar1.setValue(0);
        try {
            Batch_Size = Integer.parseInt(this.batch_size.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad sample size", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        try {
            Increase_Factor = Integer.parseInt(MonteCarloScatterPlot.increase_factor.getText());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Bad Increase factor ", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if(ProcessFlag){
            System.out.println("Can't continue: Simulation is already running! ");
        }else{
            new Thread(this::MCcreateScatterPlot).start();
        }
        Batch_Size = Batch_Size * Increase_Factor;
    }//GEN-LAST:event_ContinueBtnActionPerformed

    private void ContinueBtnPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_ContinueBtnPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_ContinueBtnPropertyChange

    public XYDataset MonteCarlo() {
        Random generator = new Random();
        R2 = Disk_Radius * Disk_Radius;
        Square_Side_Length = 2 * Disk_Radius;
        Square_To_disk_Ratio = (Square_Side_Length * Square_Side_Length) / (Disk_Radius * Disk_Radius);
        a = -Disk_Radius;
        b = Disk_Radius;
        b_a = b - a;
        jProgressBar1.setValue(0);
        XYSeriesCollection dataset = new XYSeriesCollection();
        if (!ContinueFlag){
            Batch_Size_total = Batch_Size;
            success = 0;
            fails = 0;
            Start_I = 0;
        }
        else{
            Batch_Size_total = Batch_Size_total + Batch_Size;
        }
        Batch_Size_total = Batch_Size_total + 1;
        
        startTime = System.currentTimeMillis();     // timer start
            
// Monte Carlo sampling of x and y coordinates of a point on a plane
            for (long i = Start_I + 1; i < Batch_Size_total ; i++) {      // Do Loop on sampled points
                x = a + b_a * generator.nextDouble();     // random x between a & b
                y = a + b_a * generator.nextDouble();     // random y between a & b 
                if (x * x + y * y <= R2) {
                    success++;
                    xySuccessSerie.add(x,y);}                   
                else{
                    fails++;
                    xyFailsSerie.add(x,y);                  
                }    
                jProgressBar1.setValue((int) ((i-Start_I)*100/(Batch_Size_total-Start_I-1)));
                if (CancelFlag) { break; }
            }
        endTime = System.currentTimeMillis();       // timer stop
        elapsedTime = endTime - startTime;          // elapsed time
        Monte_Carlo_PI = Square_To_disk_Ratio * (double) success / (double) Batch_Size_total;
        Batch_Size_total = Batch_Size_total - 1;
        if (!CancelFlag){
            this.answerLabel.setText("The Monte Carlo value of PI is : " + Monte_Carlo_PI);
            
            System.out.println(" continue_counter : "+ continue_counter + " Success :  "+ success+ "   Fails :  "+ fails);
            System.out.println( "                 Sample Size :  " + Batch_Size_total + ",   Pi value :  " + Monte_Carlo_PI);
         }
// export series  
            dataset.addSeries(xySuccessSerie);
            dataset.addSeries(xyFailsSerie);       
// display result            
        this.True_Pi_Value.setText("The true value of PI is :              " + PI);
        this.Simulation_Time.setText("Time of simulation :                  " + (double) elapsedTime / 1000 + "    seconds");           
// reset flags
        ProcessFlag = false;
        ContinueFlag = false;
        CancelFlag = false;
        ContinueBtn.setEnabled(true);         
        ProcessBtn.setEnabled(true); 
        clearDataBtn.setEnabled(true);
        Start_I = Batch_Size_total;
        return dataset;
    }
        
    private ChartPanel MCcreateScatterPlot(){
        jProgressBar1.setValue(0);
        JFreeChart chart = ChartFactory.createScatterPlot("", "X", "Y", MonteCarlo(), PlotOrientation.VERTICAL, true, true, false);
        XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(new Color(220, 220, 220));        
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        DecimalFormat format = (DecimalFormat)DecimalFormat.getNumberInstance(Locale.ENGLISH);
        xAxis.setNumberFormatOverride(format);
        yAxis.setNumberFormatOverride(format);
        xAxis.setTickUnit(new NumberTickUnit(0.5));
        yAxis.setTickUnit(new NumberTickUnit(0.5));
        plot.setDomainAxis(xAxis);
        plot.setRangeAxis(yAxis);
        XYItemRenderer renderer = plot.getRenderer();
        renderer.setSeriesPaint(0, Color.blue);
        double size = 3.0;
        double delta = size / 2.0;
        Shape shape1 = new Ellipse2D.Double(-delta, -delta, size, size);
        renderer.setSeriesShape(0, shape1);
        renderer.setSeriesShape(1, shape1);
        jPanel2.setLayout(new java.awt.BorderLayout());
        ChartPanel CP = new ChartPanel(chart);
        jPanel2.add(CP,BorderLayout.CENTER);
        jPanel2.validate();
// Saving the chart as an image
            try {
                File imageFile = new File("MonteCarloPi.png");
                ChartUtilities.saveChartAsPNG(imageFile, chart, 460, 460);
            } 
            catch (IOException ex) {
                System.err.println(ex);
            }
        return new ChartPanel(chart);
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
            java.util.logging.Logger.getLogger(MCcreateScatterPlot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } */
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
           new MonteCarloScatterPlot().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BreakBtn;
    private javax.swing.JButton ContinueBtn;
    private javax.swing.JButton ExitBtn;
    private javax.swing.JButton ProcessBtn;
    private javax.swing.JLabel Simulation_Time;
    private javax.swing.JLabel True_Pi_Value;
    private javax.swing.JLabel answerLabel;
    private javax.swing.JTextField batch_size;
    private javax.swing.JButton clearDataBtn;
    private javax.swing.JTextField dateTF;
    private javax.swing.JTextField disk_radius;
    public static javax.swing.JTextField increase_factor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    // End of variables declaration//GEN-END:variables


}
