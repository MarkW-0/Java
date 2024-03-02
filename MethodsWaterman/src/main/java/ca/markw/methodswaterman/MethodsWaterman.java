/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package ca.markw.methodswaterman;

import java.awt.Dimension;

/**
 *
 * @author Mark
 */
public class MethodsWaterman extends javax.swing.JFrame {
	/**
	 * Creates new form MethodsWaterman
	 */
	private void set(){
		double math1 = ((Number) GUI_math1.getValue()).doubleValue();//???
		double math2 = ((Number) GUI_math2.getValue()).doubleValue();
		String string1 = GUI_string1.getText();
		String string2 = GUI_string2.getText();
		String string3 = GUI_string3.getText();
		switch(GUI_method.getSelectedIndex()){
			case  0: {set(1,"" + Math.abs(math1));break;}
			case  1: {set(1,"" + Math.acos(math1));break;}
			case  2: {set(2,"" + (math1 + math2));break;}
			case  3: {set(1,"" + Math.asin(math1));break;}
			case  4: {set(1,"" + Math.atan(math1));break;}
			case  5: {set(2,"" + Math.atan2(math2,math1));break;}
			case  6: {set(1,"" + Math.cbrt(math1));break;}
			case  7: {set(1,"" + Math.ceil(math1));break;}
			case  8: {set(1,"" + Math.copySign(math1,math2));break;}
			case  9: {set(1,"" + Math.cos(math1));break;}
			case 10: {set(1,"" + Math.cosh(math1));break;}
			case 11: {set(1,"" + (math1 - 1));break;}
			case 12: {set(1,"" + Math.exp(math1));break;}
			case 13: {set(1,"" + Math.expm1(math1));break;}
			case 14: {set(1,"" + Math.floor(math1));break;}
			case 15: {set(1,"" + Math.getExponent(math1));break;}
			case 16: {set(2,"" + Math.hypot(math1,math2));break;}
			case 17: {set(2,"" + Math.IEEEremainder(math1,math2));break;}
			case 18: {set(1,"" + (math1 + 1));break;}
			case 19: {set(1,"" + Math.log(math1));break;}
			case 20: {set(1,"" + Math.log1p(math1));break;}
			case 21: {set(1,"" + Math.log10(math1));break;}
			case 22: {set(2,"" + Math.max(math1,math2));break;}
			case 23: {set(2,"" + Math.min(math1,math2));break;}
			case 24: {set(2,"" + (math1 * math2));break;}
			case 25: {set(1,"" + (-math1));break;}
			case 26: {set(2,"" + Math.nextAfter(math1,math2));break;}
			case 27: {set(1,"" + Math.nextDown(math1));break;}
			case 28: {set(1,"" + Math.nextUp(math1));break;}
			case 29: {set(2,"" + Math.pow(math1,math2));break;}
			case 30: {set(0,"" + Math.random());break;}
			case 31: {set(1,"" + Math.rint(math1));break;}
			case 32: {set(1,"" + Math.round(math1));break;}
			case 33: {set(1,"" + Math.signum(math1));break;}
			case 34: {set(1,"" + Math.sin(math1));break;}
			case 35: {set(1,"" + Math.sinh(math1));break;}
			case 36: {set(1,"" + Math.sqrt(math1));break;}
			case 37: {set(2,"" + (math1 - math2));break;}
			case 38: {set(1,"" + Math.tan(math1));break;}
			case 39: {set(1,"" + Math.tanh(math1));break;}
			case 40: {set(1,"" + Math.toDegrees(math1));break;}
			case 41: {set(1,"" + Math.toRadians(math1));break;}
			case 42: {set(1,"" + Math.ulp(math1));break;}
			case 43: {set(4,"" + string1.charAt((int) math1));break;}
			case 44: {set(4,"" + string1.codePointAt((int) math1));break;}
			case 45: {set(4,"" + string1.codePointBefore((int) math1));break;}
			case 46: {set(5,"" + string1.codePointCount((int) math1, (int) math2));break;}
			case 47: {set(6,"" + string1.compareTo(string2));break;}
			case 48: {set(6,"" + string1.compareToIgnoreCase(string2));break;}
			case 49: {set(6,"" + string1.concat(string2));break;}
			case 50: {set(6,"" + string1.contains(string2));break;}
			case 51: {set(6,"" + string1.contentEquals(string2));break;}
			case 52: {set(6,"" + string1.endsWith(string2));break;}
			case 53: {set(6,"" + string1.equals(string2));break;}
			case 54: {set(6,"" + string1.equalsIgnoreCase(string2));break;}
			case 55: {set(3,"" + string1.hashCode());break;}
			case 56: {set(4,"" + string1.indent((int) math1));break;}
			case 57: {set(7,"" + string1.indexOf(string2, (int) math1));break;}
			case 58: {set(3,"" + string1.isBlank());break;}
			case 59: {set(3,"" + string1.isEmpty());break;}
			case 60: {set(6,"" + string1.lastIndexOf(string2));break;}
			case 61: {set(3,"" + string1.length());break;}
			case 62: {set(6,"" + string1.matches(string2));break;}
			case 63: {set(5,"" + string1.offsetByCodePoints((int) math1,(int) math2));break;}
			case 64: {set(4,"" + string1.repeat((int) math1));break;}
			case 65: {set(9,"" + string1.replace(string2,string3));break;}
			case 66: {set(9,"" + string1.replaceAll(string2,string3));break;}
			case 67: {set(9,"" + string1.replaceFirst(string2,string3));break;}
			case 68: {set(7,"" + string1.startsWith(string2, (int) math1));break;}
			case 69: {set(3,"" + string1.strip());break;}
			case 70: {set(3,"" + string1.stripIndent());break;}
			case 71: {set(3,"" + string1.stripLeading());break;}
			case 72: {set(3,"" + string1.stripTrailing());break;}
			case 73: {set(5,"" + string1.substring((int) math1, (int) math2));break;}
			case 74: {set(3,"" + string1.toLowerCase());break;}
			case 75: {set(3,"" + string1.toUpperCase());break;}
			case 76: {set(3,"" + string1.translateEscapes());break;}
			case 77: {set(3,"" + string1.trim());break;}
			default: {
				System.out.println("error");
			}
		}
	};
	private void set(int type, String result){
		switch (type % 3){
			case 0: {
				GUI_math1.setVisible(false);
				GUI_math2.setVisible(false);
				break;
			}
			case 1: {
				GUI_math1.setVisible(true);
				GUI_math2.setVisible(false);
				break;
			}
			case 2: {
				GUI_math1.setVisible(true);
				GUI_math2.setVisible(true);
				break;
			}
		}
		switch (type / 3){
			case 0: {
				GUI_string1.setVisible(false);
				GUI_string2.setVisible(false);
				GUI_string3.setVisible(false);
				break;
			}
			case 1: {
				GUI_string1.setVisible(true);
				GUI_string2.setVisible(false);
				GUI_string3.setVisible(false);
				break;
			}
			case 2: {
				GUI_string1.setVisible(true);
				GUI_string2.setVisible(true);
				GUI_string3.setVisible(false);
				break;
			}
			case 0+3: {
				GUI_string1.setVisible(true);
				GUI_string2.setVisible(true);
				GUI_string3.setVisible(true);
				break;
			}
		}
		GUI_result.setText(result);
	};
	public MethodsWaterman() {
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

        GUI_math1 = new javax.swing.JSpinner();
        GUI_math2 = new javax.swing.JSpinner();
        GUI_string1 = new javax.swing.JTextField();
        GUI_string2 = new javax.swing.JTextField();
        GUI_string3 = new javax.swing.JTextField();
        GUI_method = new javax.swing.JComboBox<>();
        GUI_result = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.FlowLayout());

        GUI_math1.setModel(new javax.swing.SpinnerNumberModel(3.0d, null, null, 0.1d));
        GUI_math1.setPreferredSize(new Dimension(64,24));
        GUI_math1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GUI_StateChanged(evt);
            }
        });
        GUI_math1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                GUI_update(evt);
            }
        });
        getContentPane().add(GUI_math1);

        GUI_math2.setModel(new javax.swing.SpinnerNumberModel(4.0d, null, null, 0.1d));
        GUI_math2.setPreferredSize(GUI_math1.getPreferredSize());
        GUI_math2.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                GUI_StateChanged(evt);
            }
        });
        GUI_math2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                GUI_update(evt);
            }
        });
        getContentPane().add(GUI_math2);

        GUI_string1.setText("Welcome");
        GUI_string1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Action(evt);
            }
        });
        getContentPane().add(GUI_string1);

        GUI_string2.setText("To");
        GUI_string2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Action(evt);
            }
        });
        GUI_string2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                GUI_update(evt);
            }
        });
        getContentPane().add(GUI_string2);

        GUI_string3.setText("Java");
        GUI_string3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Action(evt);
            }
        });
        GUI_string3.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                GUI_update(evt);
            }
        });
        getContentPane().add(GUI_string3);

        GUI_method.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "abs", "acos", "add", "asin", "atan", "atan2", "cbrt", "ceil", "copySign", "cos", "cosh", "decrement", "exp", "expm1", "floor", "getExponent", "hypot", "IEEEremainder", "increment", "log", "log1p", "log10", "max", "min", "multiply", "negate", "nextAfter", "nextDown", "nextUp", "pow", "random", "rint", "round", "signum", "sin", "sinh", "sqrt", "subtract", "tan", "tanh", "toDegrees", "toRadians", "ulp", "charAt", "codePointAt", "codePointBefore", "codePointCount", "compareTo", "compareToIgnoreCase", "concat", "contains", "contentEquals", "endsWith", "equals", "equalsIgnoreCase", "hashCode", "indent", "indexOf", "isBlank", "isEmpty", "lastIndexOf", "length", "matches", "offsetByCodePoints", "repeat", "replace", "replaceAll", "replaceFirst", "startsWith", "strip", "stripIndent", "stripLeading", "stripTrailing", "substring", "toLowerCase", "toUpperCase", "translateEscapes", "trim" }));
        GUI_method.setSelectedIndex(43);
        GUI_method.setPreferredSize(new java.awt.Dimension(192, 24));
        GUI_method.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GUI_Action(evt);
            }
        });
        GUI_method.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                GUI_update(evt);
            }
        });
        getContentPane().add(GUI_method);

        GUI_result.setEditable(false);
        GUI_result.setColumns(10);
        GUI_result.setText("result");
        GUI_result.setToolTipText(""); // NOI18N
        GUI_result.setMinimumSize(new java.awt.Dimension(96, 24));
        getContentPane().add(GUI_result);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GUI_update(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_GUI_update
		set();
    }//GEN-LAST:event_GUI_update

    private void GUI_Action(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GUI_Action
		set();
    }//GEN-LAST:event_GUI_Action

    private void GUI_StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_GUI_StateChanged
		set();
    }//GEN-LAST:event_GUI_StateChanged

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
			java.util.logging.Logger.getLogger(MethodsWaterman.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		
		//</editor-fold>
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MethodsWaterman().setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner GUI_math1;
    private javax.swing.JSpinner GUI_math2;
    private javax.swing.JComboBox<String> GUI_method;
    private javax.swing.JTextField GUI_result;
    private javax.swing.JTextField GUI_string1;
    private javax.swing.JTextField GUI_string2;
    private javax.swing.JTextField GUI_string3;
    // End of variables declaration//GEN-END:variables
}
