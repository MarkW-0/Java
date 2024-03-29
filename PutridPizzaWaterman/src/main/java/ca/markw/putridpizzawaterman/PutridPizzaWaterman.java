package ca.markw.putridpizzawaterman;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author Mark
 */
public class PutridPizzaWaterman extends javax.swing.JFrame {

	/**
	 * Creates new form WatermanFirstProgram
	 */
	private final double BASE = 0.75 + 0.99;
	private final double RATE = 0.50;
	private final double TAXRATE = 13;
	private final double[] DIAMETERS = {0, 15, 20, 40, Double.POSITIVE_INFINITY};
	private final String[] MESSAGES = {
		"We are going to make you a cute little pizza!",
		"This is a personal pizza.",
		"This will be delicious!",
		"Whoa, big pizza! You might need a truck to get this home!"};
	double diameter;
	String message;
	double subtotal;
	double tax;
	double total;
	private void GUI_calculate(){
		diameter = (double) GUI_diameter.getValue();
		for (int i = 0; i < MESSAGES.length; i++) {
			if(DIAMETERS[i] <= diameter && diameter < DIAMETERS[i + 1]){
				message = MESSAGES[i];
			}
		}
		subtotal = BASE + RATE * diameter;
		subtotal = Math.round(100 * subtotal) / 100;
		tax = Math.round(TAXRATE * subtotal) / 100;
		total = Math.round(100 * (subtotal + tax)) / 100;//floating-point!
		GUI_subtotal.setText("$ " + subtotal);
		GUI_tax.setText("$ " + tax);
		GUI_total.setText("$ " + total);
		GUI_message.setText(message);
	}
	public PutridPizzaWaterman() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        GUI_title = new javax.swing.JLabel();
        GUI_diameter_label = new javax.swing.JLabel();
        GUI_diameter = new javax.swing.JSpinner();
        GUI_calculate = new javax.swing.JButton();
        GUI_subtotal_label = new javax.swing.JLabel();
        GUI_subtotal = new javax.swing.JTextField();
        GUI_tax_label = new javax.swing.JLabel();
        GUI_tax = new javax.swing.JTextField();
        GUI_total_label = new javax.swing.JLabel();
        GUI_total = new javax.swing.JTextField();
        GUI_message = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(new java.awt.GridBagLayout());

        GUI_title.setFont(new java.awt.Font("Comic Sans MS", 0, 18)); // NOI18N
        GUI_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GUI_title.setText("Putrid Pizza");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(GUI_title, gridBagConstraints);

        GUI_diameter_label.setText("Diameter of pizza (cm):");
        GUI_diameter_label.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        GUI_diameter_label.setName(""); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_diameter_label, gridBagConstraints);

        GUI_diameter.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_diameter, gridBagConstraints);

        GUI_calculate.setText("Calculate");
        GUI_calculate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_calculateActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(10, 10, 10, 10);
        jPanel1.add(GUI_calculate, gridBagConstraints);

        GUI_subtotal_label.setText("Subtotal:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_subtotal_label, gridBagConstraints);

        GUI_subtotal.setEditable(false);
        GUI_subtotal.setText("Subtotal");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_subtotal, gridBagConstraints);

        GUI_tax_label.setText("Tax:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_tax_label, gridBagConstraints);

        GUI_tax.setEditable(false);
        GUI_tax.setText("Tax");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_tax, gridBagConstraints);

        GUI_total_label.setText("Grand Total:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_total_label, gridBagConstraints);

        GUI_total.setEditable(false);
        GUI_total.setText("Total");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        jPanel1.add(GUI_total, gridBagConstraints);

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        GUI_message.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        GUI_message.setText("message");
        getContentPane().add(GUI_message, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void GUI_calculateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_calculateActionPerformed
		GUI_calculate();
    }//GEN-LAST:event_GUI_calculateActionPerformed

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
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(PutridPizzaWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}// </editor-fold>
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new PutridPizzaWaterman().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GUI_calculate;
    private javax.swing.JSpinner GUI_diameter;
    private javax.swing.JLabel GUI_diameter_label;
    private javax.swing.JLabel GUI_message;
    private javax.swing.JTextField GUI_subtotal;
    private javax.swing.JLabel GUI_subtotal_label;
    private javax.swing.JTextField GUI_tax;
    private javax.swing.JLabel GUI_tax_label;
    private javax.swing.JLabel GUI_title;
    private javax.swing.JTextField GUI_total;
    private javax.swing.JLabel GUI_total_label;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
