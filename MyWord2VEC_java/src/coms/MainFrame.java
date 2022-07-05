package coms; 

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

import javax.swing.*;

import com.ansj.vec.domain.WordEntry;

public class MainFrame extends JFrame { 
 /** 
  * 
  */ 
	String s = "文本";//修改S给添加文本;
    JSplitPane jSplitPane1 = new JSplitPane();
    JPanel jPanel1 = new JPanel(); 
    JPanel jPanel2 = new JPanel(); 
    JButton button1 = new JButton("导入文件");
    JButton button2 = new JButton("单个词语相似度");
    JButton button3 = new JButton("两个词语相似度");
    JButton button4 = new JButton("退出");
    JButton button5 = new JButton("计算相似度");
    JTextArea ta = new JTextArea(5,15);
    JTextArea ta1 = new JTextArea(5,15);
    JScrollPane jsp = new JScrollPane(ta,
    		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
    JScrollPane jsp1 = new JScrollPane(ta1,
    		ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
            ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
    ImageIcon bg=new ImageIcon("C:\\Users\\M\\Desktop\\3.jpg");//1308*813;
    JLabel label1 = new JLabel(bg);
    
    private static final long serialVersionUID = 1L; 
    public static void main(String[] args){ 
        new MainFrame(); 
    } 

    public MainFrame() { 
    	super("基于上下文词向量空间的词语相似度计算方法研究和实现");
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        this.setVisible(true);
        jPanel1.setLayout(new GridLayout(4,1));
        jPanel1.add(button1);
        jPanel1.add(button2);
        jPanel1.add(button3);
        jPanel1.add(button4);
        jPanel1.add(button5);
        button1.setContentAreaFilled(false);
        button2.setContentAreaFilled(false);
        button3.setContentAreaFilled(false);
        button4.setContentAreaFilled(false);
        button5.setContentAreaFilled(false);

        button4.setBackground(new Color(77,77,77));
    	button1.setBackground(new Color(77,77,77));
    	button2.setBackground(new Color(77,77,77));
    	button3.setBackground(new Color(77,77,77));
        button4.setBackground(new Color(77,77,77));

    	label1.setSize(1308,813);
    	jPanel2.add(label1,new Integer(Integer.MIN_VALUE));
    	//jPanel1.setBackground(Color.GRAY);
    	//jPanel2.setBackground(Color.gray);
    	this.getContentPane().add(jsp,java.awt.BorderLayout.NORTH);
    	this.getContentPane().add(jsp1,java.awt.BorderLayout.SOUTH);
    	this.getContentPane().add(jSplitPane1,java.awt.BorderLayout.CENTER);
        jSplitPane1.add(jPanel1, JSplitPane.LEFT); 
        jSplitPane1.add(jPanel2, JSplitPane.RIGHT); 
        jSplitPane1.setEnabled(false); 
        jSplitPane1.setOneTouchExpandable(true);
        button1.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			SearchFile s = new SearchFile();
    		}
    	});
        
        final File sportCorpusFile = new File("library/test.txt");


        button2.addActionListener(new ActionListener() {
        	
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			simpleword sw = new simpleword();
    		}
    	});
        button3.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			twoword t = new twoword();
    		}
    	});
        button4.addActionListener(new ActionListener() {

    		@Override
    		public void actionPerformed(ActionEvent e) {
    			// TODO Auto-generated method stub
    			System.exit(0);
    		}
    	});

        button5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        this.addComponentListener(new ComponentAdapter() { 

            public void componentResized(ComponentEvent e) { 

                jSplitPane1.setDividerLocation(0.2);
            } 
        });
    }
} 



