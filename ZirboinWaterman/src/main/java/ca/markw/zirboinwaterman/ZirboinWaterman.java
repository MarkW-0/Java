/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package ca.markw.zirboinwaterman;

import java.util.TreeMap;
/**
 *
 * @author Mark
 */
public class ZirboinWaterman {
	private static final java.awt.GridBagConstraints LAYOUT = new java.awt.GridBagConstraints();
	static {
		LAYOUT.insets = new java.awt.Insets(5, 5, 5, 5);
		LAYOUT.gridx = 0; LAYOUT.gridy = 1;}
	@SuppressWarnings("serial")
	private static class Window extends javax.swing.JFrame {
		private final javax.swing.JButton GUIAdd = new javax.swing.JButton("+");
		private final javax.swing.JTextField GUIName = new javax.swing.JTextField("Name", 8);
		private final javax.swing.JTextField GUIValue = new javax.swing.JTextField("Value", 8);
		private final javax.swing.JTextField GUIInput = new javax.swing.JTextField("Input", 8);
		private final javax.swing.JTextField GUIOutput = new javax.swing.JTextField("Output", 8);
		private final TreeMap<Integer, Row> Rows = new TreeMap<>();
		private void NewRow (String Name, int Value, int Input, int Output){
			Row NewRow = new Row(Name, Value, Input, Output);
			if (Rows.putIfAbsent(NewRow.Value, NewRow) != null){
				System.err.println("Warning: " + NewRow.Name + " has the value ( " + NewRow.Value + " ),");
				System.err.println("	this is the same value as another coin,");
				System.err.println("	" + NewRow.Name + " will not be counted");
			}
		}
		private class Row {
			private final javax.swing.JButton GUIRemove;
			private final javax.swing.JTextField GUIName;
			final javax.swing.JSpinner GUIValue;
			final javax.swing.JSpinner GUIInput;
			final javax.swing.JTextField GUIOutput;
			String Name;
			int Value;
			int Input;
			private Row(String SetName, int SetValue, int SetInput, int Output){
				Name = SetName;
				Value = SetValue;
				Input = SetInput;
				GUIRemove = new javax.swing.JButton("-");
				GUIName = new javax.swing.JTextField(Name);
				GUIValue = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(Value, 1, null, 1));
				GUIInput = new javax.swing.JSpinner(new javax.swing.SpinnerNumberModel(Input, 0, null, 1));
				GUIOutput = new javax.swing.JTextField("" + Output, 8);
				LAYOUT.gridy ++;
				var Layout = (java.awt.GridBagConstraints) LAYOUT.clone();
				GUIRemove.addActionListener((var evt) -> {
					remove(GUIRemove);
					remove(GUIName);
					remove(GUIValue);
					remove(GUIInput);
					remove(GUIOutput);
					Rows.remove(Value, this);
					pack();
					update();
				});
				add(GUIRemove, Layout.clone());
				Layout.gridx = 1;
				Layout.fill = java.awt.GridBagConstraints.BOTH;
				GUIName.addActionListener((var evt) -> {Name = GUIName.getText();});
				add(GUIName, Layout.clone());
				Layout.gridx = 2;
				GUIValue.addChangeListener((var evt) -> {
					Rows.remove(Value, this);
					Value = (int) GUIValue.getValue();
					if (Rows.putIfAbsent(Value, this) != null){
						System.err.println("Warning: " + Name + " has the value ( " + Value + " ),");
						System.err.println("	this is the same value as another coin,");
						System.err.println("	" + Name + " will not be counted");
					}
					update();
				});
				add(GUIValue, Layout.clone());
				Layout.gridx = 3;
				GUIInput.addChangeListener((var evt) -> {
					Input = (int) GUIInput.getValue();
					update();
				});
				add(GUIInput, Layout.clone());
				Layout.gridx = 4;
				GUIOutput.setEditable(false);
				add(GUIOutput, Layout);
			}
		}
		Window() {
			setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
			this.setLayout(new java.awt.GridBagLayout());
			var Layout = (java.awt.GridBagConstraints) LAYOUT.clone();
			GUIAdd.addActionListener((var evt) -> NewRow("Name",314159,0,0));
			this.add(GUIAdd, Layout.clone());
			Layout.gridx = 1;
			Layout.fill = java.awt.GridBagConstraints.BOTH;
			GUIName.setEditable(false);
			this.add(GUIName, Layout.clone());
			Layout.gridx = 2;
			GUIValue.setEditable(false);
			this.add(GUIValue, Layout.clone());
			Layout.gridx = 3;
			GUIInput.setEditable(false);
			this.add(GUIInput, Layout.clone());
			Layout.gridx = 4;
			GUIOutput.setEditable(false);
			this.add(GUIOutput, Layout.clone());
			Layout.gridx = 0;
			Layout.gridy = 0;
			Layout.gridwidth = 5;
			Layout.insets = new java.awt.Insets(10, 10, 10, 10);
			this.add(new javax.swing.JLabel("Zirboin", javax.swing.SwingConstants.CENTER), Layout);
		}
		private void update (){
			int Total = 0;
			for (var Key = Rows.lastKey(); Key != null; Key = Rows.lowerKey(Key)) {
				Row Get = Rows.get(Key);
				Total += Get.Input * Get.Value;
			}
			for (var Key = Rows.lastKey(); Key != null; Key = Rows.lowerKey(Key)) {
				Row Get = Rows.get(Key);
				Get.GUIOutput.setText("" + Total / Get.Value);
				Total %= Get.Value;
			}
		}

	}
	public static void main(String[] args) {
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
			java.util.logging.Logger.getLogger("error log").log(java.util.logging.Level.SEVERE, null, ex);
		}// </editor-fold>
		/* Create and display the form */
		java.awt.EventQueue.invokeLater(() -> {
			Window Window = new Window();
			Window.NewRow("vrobit",          1, 542854, 354);
			Window.NewRow("blointoint",    500, 0,        1);
			Window.NewRow("frazoint",     1000, 0,        2);
			Window.NewRow("gazoontight", 10000, 0,        4);
			Window.NewRow("drobzit",     50000, 0,        0);
			Window.NewRow("clickwick",  100000, 0,        5);
			Window.pack();
			Window.setVisible(true);
		});
	}
}
