/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ca.markw.binandhexconverterwaterman;

/**
 *
 * @author Mark
 */
public class BinAndHexConverterWaterman extends javax.swing.JFrame {
	public void Update() {
		try{
			GUI_OUTPUT.setText(
				Long.toString(
					Long.parseLong(
						GUI_INPUT.getText(),
						(int) GUI_INPUTBASE.getValue()
					),
					(int) GUI_OUTPUTBASE.getValue()
				)
				.toUpperCase()
			);
		}catch(NumberFormatException e){
			GUI_OUTPUT.setText("Error “" + GUI_INPUT.getText() + "” is not in base " + (int) GUI_INPUTBASE.getValue());
		}
	}
	/**
	 * Creates new form BinAndHexConverterWaterman
	 */
	public BinAndHexConverterWaterman() {
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

        GUI_TITLE = new javax.swing.JLabel();
        GUI_INPUT = new javax.swing.JTextField();
        GUI_LABEL1 = new javax.swing.JLabel();
        GUI_INPUTBASE = new javax.swing.JSpinner();
        GUI_LABEL2 = new javax.swing.JLabel();
        GUI_OUTPUTBASE = new javax.swing.JSpinner();
        GUI_OUTPUT = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        GUI_TITLE.setText("Base converter");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_TITLE, gridBagConstraints);

        GUI_INPUT.setColumns(10);
        GUI_INPUT.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        GUI_INPUT.setText("31");
        GUI_INPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_INPUTCHANGED(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_INPUT, gridBagConstraints);

        GUI_LABEL1.setText("base");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_LABEL1, gridBagConstraints);

        GUI_INPUTBASE.setModel(new javax.swing.SpinnerNumberModel(8, 2, 36, 1));
        GUI_INPUTBASE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GUI_BASECHANGED(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_INPUTBASE, gridBagConstraints);

        GUI_LABEL2.setText("to base");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_LABEL2, gridBagConstraints);

        GUI_OUTPUTBASE.setModel(new javax.swing.SpinnerNumberModel(10, 2, 36, 1));
        GUI_OUTPUTBASE.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GUI_BASECHANGED(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_OUTPUTBASE, gridBagConstraints);

        GUI_OUTPUT.setEditable(false);
        GUI_OUTPUT.setColumns(22);
        GUI_OUTPUT.setText("25");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_OUTPUT, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void GUI_INPUTCHANGED(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_INPUTCHANGED
		Update();
    }//GEN-LAST:event_GUI_INPUTCHANGED
    private void GUI_BASECHANGED(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GUI_BASECHANGED
		Update();
    }//GEN-LAST:event_GUI_BASECHANGED

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
			java.util.logging.Logger.getLogger(BinAndHexConverterWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(BinAndHexConverterWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(BinAndHexConverterWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(BinAndHexConverterWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new BinAndHexConverterWaterman().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GUI_INPUT;
    private javax.swing.JSpinner GUI_INPUTBASE;
    private javax.swing.JLabel GUI_LABEL1;
    private javax.swing.JLabel GUI_LABEL2;
    private javax.swing.JTextField GUI_OUTPUT;
    private javax.swing.JSpinner GUI_OUTPUTBASE;
    private javax.swing.JLabel GUI_TITLE;
    // End of variables declaration//GEN-END:variables
}
