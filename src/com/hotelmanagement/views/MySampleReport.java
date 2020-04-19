package com.hotelmanagement.views;
import javax.swing.*;


public class MySampleReport extends JFrame{
	
	private JEditorPane editor;

	public MySampleReport() {
		this.setSize(500,500);
		this.setTitle("My Notepad");
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initComponent();
	}
	
	private void initComponent() {
		editor = new JEditorPane();
		this.add(editor);
		
		editor.setContentType("text/html");
		editor.setEditable(false);
		
		String html = "<HTML>"
				+ "<BODY>"
				+ "<H3>Example of JEditorPane</h3>"
				+ "<code>Sample Html page</code>"
				+ "<Table>"
				+ "<tr><th>Sr.No.</th><th>Item name</th><th>Price</th></tr>"
				+ "<tr><td>1</td><td>Item 1</td><td>150</td></tr>"
				+ "<tr><td>2</td><td>Item 2</td><td>250</td></tr>"
				+ "</table>"
				+ "</BODY>"
				+ "</HTML>";
		
		editor.setText(html);
		
	}
	
	public static void main(String[] args) {
		MySampleReport msp = new MySampleReport();
		msp.setVisible(true);
	}

}
