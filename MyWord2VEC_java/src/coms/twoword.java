package coms;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class twoword extends JFrame{

	private static final long serialVersionUID = 1L;
	String s1 = " ";
	String s2 = " ";
	String s3 = " ";
	JLabel label1 = new JLabel("请输入第一个词:");
	JLabel label2 = new JLabel("请输入第二个词:");
	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JButton button1 = new JButton("计算相似度");
	JButton button2 = new JButton("可视化图");
	JPanel pane1 = new JPanel();
	JPanel pane2 = new JPanel();
	JPanel pane3 = new JPanel();
	JTextArea ta = new JTextArea(5,15);
	JScrollPane jsp = new JScrollPane(ta,
    		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
//	public static void main(String[] args) {
//		new twoword();
//	}
	public twoword() {
		super("基于上下文词向量空间的词语相似度计算方法研究和实现");
    	//this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(280,105,1166,821);
        //this.setSize(1308,813);
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        
        pane1.setLayout(new GridLayout(4,2));
        pane1.add(label1);
        pane1.add(tf1);
        pane1.add(label2);
        pane1.add(tf2);
        pane1.add(button1);
        button1.setContentAreaFilled(false);
        pane1.add(tf3);
        pane3.add(button2);
        button2.setContentAreaFilled(false);
        pane2.setLayout(new GridLayout(1,1));
        pane2.add(jsp);
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
        tf1.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			s1 = tf1.getText();
    		}
    	});
        tf2.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			s2 = tf2.getText();
    		}
    	});
        button1.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			if(tf1.getText().equals("") || tf2.getText().equals("")) {
    				error er = new error();
    			}
    			else {
    				Double d = w2v.distanceWith2Words(s1, s2);
    				tf3.setText(String.valueOf(d));
    			}
    		}
    	});
	}
}
