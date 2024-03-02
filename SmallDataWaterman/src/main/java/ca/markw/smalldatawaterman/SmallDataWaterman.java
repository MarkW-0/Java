/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ca.markw.smalldatawaterman;

import java.io.*;
import java.util.*;
import java.util.regex.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Mark
 */
@SuppressWarnings({"serial", "override"})
public class SmallDataWaterman {
	//private final static Scanner INPUTSCANNER = new Scanner(System.in);
	public static void main(String[] args) {
		openFiles();
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
		 * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ReflectiveOperationException | UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger("error log").log(java.util.logging.Level.SEVERE, null, ex);
		}// </editor-fold>
		/* Create and display the form */
		new GUI().setVisible(true);
		//System.out.println(INPUTSCANNER.nextLine());
	}
	private final static String[] FILES = {"Hobo_15minutedata_2020.csv"};
	static void openFiles() {
		for (String string : FILES) {
			openFile(string);
		}
	}
	static void openFile(String path) {
		try {
			try (FileReader rawFile = new FileReader(path);
				BufferedReader file = new BufferedReader(rawFile);
			) {
				readFile(file);
			}
		} catch (IOException e) {
			System.err.println(e);
			throw new RuntimeException(e);
		}
	}
	static void readFile(Reader file) throws IOException {
		int character = file.read();
		boolean quote = false;
		String token = "";
		while (character != -1) {
			if (character == ','&& !quote) {
				store(token);
				token = "";
			} else if(character == '\n'&& !quote){
				store(token);
				newLine();
				token = "";
			} else if(character != '\r'){
				token +=  Character.toString(character);
			}
			if (character == '"') {
				quote = !quote;
			}
			character = file.read();
		}
		newPage();
	}
	private static int page = 0;
	private static int row = -1;
	private static int column = 0;
	private static String[][] titles = {{""}};
	private static int[][][] table = {{{0}}};
	static void newPage() {
		table[page] = Arrays.copyOf(table[page], row);
		row = -1;
		column = 0;
		page++;
		if (titles.length <= page) {
			titles = Arrays.copyOf(titles, titles.length * 2);
			table = Arrays.copyOf(table, titles.length * 2);
		}
		titles[page] = new String[]{""};
		table[page] = new int[][]{{0}};
}
	static void newLine() {
		if (row == -1) {
			titles[page] = Arrays.copyOf(titles[page], column);
		} else {
			table[page][row] = Arrays.copyOf(table[page][row], column);
		}
		column = 0;
		row++;
		if (table[page].length <= row) {
			table[page] = Arrays.copyOf(table[page], table[page].length * 2);
		}
		table[page][row] = new int[]{0};
	}
	static void store(String token) {
		if (row == -1) {
			if (titles[page].length <= column) {
				titles[page] = Arrays.copyOf(titles[page], titles[page].length * 2);
			}
			titles[page][column] = token;
		} else {
			if (table[page][row].length <= column) {
				table[page][row] = Arrays.copyOf(table[page][row], table[page][row].length * 2);
			}
			table[page][row][column] = parseToken(token);
		}
		column++;
	}
	private final static Pattern TIMEREGEX = Pattern.compile("([01]?\\d?|2[0-3]):([0-5]?\\d?):([0-5]?\\d?)");
	static int parseToken(String token) {
		if (token.isEmpty()) {
			return 0x7fc00000;
		}
		switch (FILES[page] + "." + column) {
			case "Hobo_15minutedata_2020.csv.0" -> {
				if(token.equals("1900-01-00")){
					return 0;
				} else {
					return (int) java.time.LocalDate.parse(token).toEpochDay();
				}
			}
			case "Hobo_15minutedata_2020.csv.1" -> {
				Matcher M = TIMEREGEX.matcher(token);
				if(M.matches()) {
					int h = Integer.parseInt(M.group(1));
					int m = Integer.parseInt(M.group(2));
					int s = Integer.parseInt(M.group(3));
					if (h < 24 && m < 60 && s <= 60){
						if(s == 60) {
							System.err.println("Warning: Leap second");
						}
						return s + 60 * (m + 60 * h);
					}
				}
				System.err.println("Warning: Can't parse " + token + " at " + page + ", " + row + ", " + column);
				return -1;
			}
			default -> {
				try {
					return Float.floatToIntBits(Float.parseFloat(token));
				} catch (java.lang.NumberFormatException e){
					return 0x7fc00000;
				}
			}
		}
	}
	private static class GUI extends JFrame {
		Date start = new Date(1577854800000L);
		Date end = new Date(1609477140000L);
		final JSpinner GUI_START = new JSpinner(new SpinnerDateModel(start, start, end, Calendar.MINUTE));
		final JSpinner GUI_END = new JSpinner(new SpinnerDateModel(end, start, end,Calendar.MINUTE));
		final Graph GUI_GRAPH = new Graph();
		GUI() {
			setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			setTitle("University of Waterloo Weather Station");
			setLayout(new GridBagLayout());
			GridBagConstraints layout = new GridBagConstraints();
			layout.insets = new Insets(5, 5, 5, 5);
			layout.gridx = 0; layout.gridy = 0;
			layout.gridwidth = 3;
			layout.anchor = GridBagConstraints.BASELINE;
			add(new JLabel("University of Waterloo Weather Station"
			), layout.clone());
			layout.gridx = 1; layout.gridy = 1;
			layout.gridwidth = 1;
			add(new JLabel("to"), layout.clone());
			layout.gridx = 2;
			layout.anchor = GridBagConstraints.BASELINE_LEADING;
			layout.weightx = 1.0;
			add(GUI_END, layout.clone());
			layout.gridx = 0;
			layout.anchor = GridBagConstraints.BASELINE_TRAILING;
			add(GUI_START, layout.clone());
			layout.gridy = 2;
			layout.gridwidth = 3;
			layout.weighty = 1.0;
			layout.fill = GridBagConstraints.BOTH;
			add(GUI_GRAPH, layout.clone());
			pack();
			GUI_GRAPH.updateAll((int) start.toInstant().getEpochSecond(), (int) end.toInstant().getEpochSecond());
			GUI_GRAPH.addComponentListener(new java.awt.event.ComponentAdapter() {
				public void componentResized(java.awt.event.ComponentEvent evt) {
					GUI_GRAPH.updateSome();
				}
			});
		}
	}
	private static class Graph extends JPanel {
		private static final int LINE = 18;
		private static final int GAP = 10;
		private static final int[] binSizes = {31104000, 7776000, 2592000      , //    year -> month
												 604800,   86400,   21600, 3600, //    week -> hour
												   1800,     600,     300,   60, //1/2 hour -> min
												     30,      10,       5,    1};//1/2 min  -> sec
		private int updates = 0xFFFE; //bitfield [updating time GraphSize]
		private int GraphWidth;
		private int GraphHeight;
		private int startTime;
		private int endTime;
		private int bin;
		private double min;
		private double max;
		private double[] data;
		protected Rectangle plot = new Rectangle();
		
		public void updateSome() {
			if((updates & 0x1) == 0x0){
				updates |= 0x1;
				updateSize();
				updatePlotSize();
				updateSteps();
				updateData();
				updates = 0;
			}
		}
		public void updateAll(int start, int end) {
			updates |= 0xFFFE;
			updateTime(start, end);
		}
		public void updateTime(int start, int end) {
			if (startTime != start || endTime != end){
				startTime = start; endTime = end;
				updates |= 0x2;
			}
			updateSome();
		}
		public void updateSize() {
			if (GraphWidth != getWidth() || GraphHeight != getHeight()){
				GraphWidth = getWidth(); GraphHeight = getHeight();
				updates |= 0x4;
			}
			updateSome();
		}
		private void updatePlotSize() {
			if ((updates | 0x4) != 0x0){
				plot.y = 0;
				plot.height = GraphHeight - plot.y - GAP - LINE - GAP - LINE;
				plot.x = LINE + GAP + LINE + GAP;
				plot.width = GraphWidth - plot.x;
			}
		}
		private void updateSteps() {
			if ((updates | 0x6) != 0x0){
				bin = (endTime - startTime)/plot.width;
				for (int binSize : binSizes) {
					if (binSize < bin){
						bin = binSize;
						break;
					}
				}
			}
		}
		private void updateData() {
			if ((updates | 0x6) != 0x0){
				data = new double[plot.width];
				max = Double.NEGATIVE_INFINITY;
				min = Double.POSITIVE_INFINITY;
				for (int x = 0, i = 0, t = startTime;x < plot.width;x++, i += bin, t += bin) {
					i = Math.min(i,table[0].length - 1);
					int[] row = table[0][i];
					int date = 86400*row[0] + row[1];
					int error = Integer.MAX_VALUE;
					while (Math.abs(date - t) < error) {
						error = Math.abs(date - t);
						i += Integer.compare(t,date);
						row = table[0][i];
						date = 86400*row[0] + row[1];
					}
					data[x] = Float.intBitsToFloat(row[2]);
					if (Double.isFinite(data[x])) {
						max = Math.max(max, data[x]);
						min = Math.min(min, data[x]);
					}
				}
			}
		}
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			paintPlot((Graphics2D) g.create(plot.x, plot.y, plot.width, plot.height));
			paintAxes((Graphics2D) g.create());
			//paintElse();
		}
		void paintPlot(Graphics2D g2d) {
			g2d.setStroke(new BasicStroke(1.75f));
			g2d.setColor(new Color((getForeground().getRGB() & 0xFEFEFE + getBackground().getRGB() & 0xFEFEFE)/2));
			for (int x = 0;x <= plot.width;x += 50) {
				g2d.drawLine(x,0,x,plot.height);
			}
			for (int y = plot.height;0 <= y;y -= 50) {
				g2d.drawLine(0,y,plot.width,y);
			}
			g2d.setColor(getForeground());
			for (int x = 0;x < plot.width;x ++) {
				g2d.drawLine(x,(int) (((double) plot.height) - ((double) plot.height) * ((data[x] - min)/(max - min))),x,plot.height);
			}
		}
		void paintAxes(Graphics2D g2d) {
			g2d.setStroke(new BasicStroke(1.75f));
			g2d.setColor(getForeground());
			g2d.draw(plot);
		}
	}
}
