package server.org.wfileget;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import javax.swing.table.*;

public class ServerUI extends JFrame {
	public static final int VERSION_MAJOR = 1;
	public static final int VERSION_MINOR = 0;
	public ServerUI() {
		super(("WFileGet " + VERSION_MAJOR) + "." + VERSION_MINOR);
		setLayout(new BorderLayout());
		tbl = new JTable();
		String[] colNames = {"Computer name", "File path", "Date of last use", "Size"};
		for (String colName : colNames) {
			DefaultTableModel dtm = (DefaultTableModel) tbl.getModel();
			dtm.addColumn(colName);
			tbl.setModel(dtm);
		}
		load = new JButton("Download");
		JPanel pnl = new JPanel();
		pnl.add(load);
		add(pnl, "South");
		add(tbl, "Center");
		setVisible(true);
		setSize(600, 400);
		setDefaultCloseOperation(3);
	}


	// Variables
	private IServer server;
	private JTable tbl;
	private JButton load;

	public static void main(String[] args) throws Exception {
		UIManager.setLookAndFeel(new javax.swing.plaf.nimbus.NimbusLookAndFeel());
		new ServerUI();
	}
}