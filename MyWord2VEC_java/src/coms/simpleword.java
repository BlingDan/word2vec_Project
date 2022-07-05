package coms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class simpleword extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String s = " ";
	JLabel label1 = new JLabel("请输入一个词:");
	JTextField tf = new JTextField();
	JButton button1 = new JButton("计算相似度");
	JButton button2 = new JButton("可视化图");
	JButton button3 = new JButton("展示结果");
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JPanel pane3 = new JPanel();
	JPanel pane4 = new JPanel();
	JTextArea ta = new JTextArea(100,1);
	JScrollPane jsp = new JScrollPane(ta,
    		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
	public static void main(String[] args) {
		new simpleword();
	}
	public simpleword() {
		super("基于上下文词向量空间的词语相似度计算方法研究和实现");
    	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(280,105,1166,821);
        this.setVisible(true);
        
        pane1.setLayout(new GridLayout(1,4));
        pane1.add(label1,java.awt.BorderLayout.CENTER);
        pane1.add(tf);
        pane3.add(button1);
        button1.setContentAreaFilled(false);
        pane3.add(button3);
        pane3.add(button2);
        button2.setContentAreaFilled(false);
        button3.setContentAreaFilled(false);
        pane2.setLayout(new GridLayout(1,1));
        pane2.add(jsp);
        ta.setLineWrap(true);
        this.getContentPane().add(pane1,java.awt.BorderLayout.NORTH);
        this.getContentPane().add(pane2,java.awt.BorderLayout.CENTER);
        this.getContentPane().add(pane3,java.awt.BorderLayout.WEST);
        Word2VEC w2v = new Word2VEC() ;

        try {
			w2v.loadJavaModel("library/test.merge.model") ;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        tf.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			s = tf.getText();
    		}
    	});

        File file = new File("./temp");
        try {
			file.createNewFile();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        FileOutputStream fileOutputStream = null;
		try {
			fileOutputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        PrintStream printStream = new PrintStream(fileOutputStream);
        button1.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(tf.getText().equals("")) {
    				error er = new error();
    			}
    			else {
    				Iterator iterator = w2v.distance(s).iterator();
        			while(iterator.hasNext()) {
        				System.setOut(printStream);
//						StringBuffer vec = new StringBuffer(iterator.next().toString());
//						vec.append("\n");
        				System.out.println(iterator.next());
        			}
    			}  
    		}
    	});
        button3.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			BufferedReader br = null;
    			try {
					br = new BufferedReader(new FileReader(file));
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    			String st = null;
    			try {
					while((st = br.readLine()) != null) {
						if(st == ";") {
							ta.append("\n");
						}
						else {
							ta.append(st);
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
    		}
    	});
	}
}
