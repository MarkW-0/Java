/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ca.markw.topsecretencryptionwaterman;

/**
 *
 * @author Mark
 */
public class TopSecretEncryptionWaterman extends javax.swing.JFrame {
	private final static String CHARSET = 
		"0123456789ABCDEF" +
		"GHIJKLMNOPQRSTUV" +
		"WXYZ+-*/^_abcdef" +
		"ghijklmnopqrstuv" +
		"wxyz.:,;&@%#!=?~" +
		" 	\\|'`\"$()[]{}<>" + "¤";
	private static byte inverse(Object A, int N) {
		int OldT;	int T = 0;	int NewT = 1;
		int OldR;	int R = N;	int NewR = (int) (byte) A;
		int Quotient;
		while(NewR != 0) {
			Quotient = R / NewR;
			OldT = T;
			OldR = R;
			T = NewT;
			R = NewR;
			NewT = OldT - Quotient * NewT;
			NewR = OldR - Quotient * NewR;
		}
		if(R > 1) {
			throw new Error("A is not invertible");
		}
		if(T < 0) {
			T += N;
		}
		return (byte) T;
	}
	public String Encode(byte[] Input){
		char[] Data = new char[Input.length];
		for (int i = 0; i < Input.length; i++) {
			Data[i] = CHARSET.charAt(Input[i]);
		}
		return String.valueOf(Data);
	}
	public byte[] Decode(String Input){
		char[] Chars = Input.toCharArray();
		byte[] Bytes = new byte[Chars.length];
		for (int i = 0; i < Chars.length; i++) {
			Bytes[i] = (byte) CHARSET.indexOf(Chars[i]);
			if(Bytes[i] == -1){
				Bytes[i] = (byte) CHARSET.indexOf('?');
			}
		}
		return Bytes ;
	}
	public byte[] Encrypt(byte Key, byte[] Input){
		byte[] Bytes = new byte[Input.length];
		for (int i = 0; i < Input.length; i++) {
			Bytes[i] = (byte) ((Key * Input[i]) % CHARSET.length());
		}
		return Bytes;
	}
	public void Encrypt(javax.swing.JTextField Input, javax.swing.JSpinner InputKey, javax.swing.JTextField Output, javax.swing.JSpinner OutputKey){
		OutputKey.setValue(inverse(InputKey.getValue(), CHARSET.length()));
		Output.setText(
			Encode(
				Encrypt(
					(byte) InputKey.getValue(),
					Decode(
						Input.getText()
					)
				)
			)
		);
	}
	public TopSecretEncryptionWaterman() {
		initComponents();
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        GUI_TITLE = new javax.swing.JLabel();
        GUI_INPUT = new javax.swing.JTextField();
        GUI_INPUTKEY = new javax.swing.JSpinner();
        GUI_OUTPUT = new javax.swing.JTextField();
        GUI_OUTPUTKEY = new javax.swing.JSpinner();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        GUI_TITLE.setText("Top Secret Encryption");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_TITLE, gridBagConstraints);

        GUI_INPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_INPUTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_INPUT, gridBagConstraints);

        GUI_INPUTKEY.setModel(new javax.swing.SpinnerNumberModel((byte)1, (byte)1, null, (byte)1));
        GUI_INPUTKEY.setMinimumSize(new java.awt.Dimension(64, 24));
        GUI_INPUTKEY.setPreferredSize(new java.awt.Dimension(64, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_INPUTKEY, gridBagConstraints);

        GUI_OUTPUT.setText("5SntH,ntHn,@nt++h+,o(hUanH5");
        GUI_OUTPUT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_OUTPUTActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_OUTPUT, gridBagConstraints);

        GUI_OUTPUTKEY.setModel(new javax.swing.SpinnerNumberModel((byte)1, (byte)1, null, (byte)1));
        GUI_OUTPUTKEY.setMinimumSize(new java.awt.Dimension(64, 24));
        GUI_OUTPUTKEY.setPreferredSize(new java.awt.Dimension(64, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 5, 5);
        getContentPane().add(GUI_OUTPUTKEY, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void GUI_INPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_INPUTActionPerformed
		Encrypt(GUI_INPUT, GUI_INPUTKEY, GUI_OUTPUT, GUI_OUTPUTKEY);
    }//GEN-LAST:event_GUI_INPUTActionPerformed
    private void GUI_OUTPUTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_OUTPUTActionPerformed
		Encrypt(GUI_OUTPUT, GUI_OUTPUTKEY, GUI_INPUT, GUI_INPUTKEY);
    }//GEN-LAST:event_GUI_OUTPUTActionPerformed
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
			java.util.logging.Logger.getLogger(TopSecretEncryptionWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TopSecretEncryptionWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TopSecretEncryptionWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TopSecretEncryptionWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		java.awt.EventQueue.invokeLater(() -> {
			new TopSecretEncryptionWaterman().setVisible(true);
		});
	}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField GUI_INPUT;
    private javax.swing.JSpinner GUI_INPUTKEY;
    private javax.swing.JTextField GUI_OUTPUT;
    private javax.swing.JSpinner GUI_OUTPUTKEY;
    private javax.swing.JLabel GUI_TITLE;
    // End of variables declaration//GEN-END:variables
}
