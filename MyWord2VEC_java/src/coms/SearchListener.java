package coms;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
 
import javax.swing.JTextField;
 
 
public class SearchListener implements ActionListener{
 
	//���������ı���
	private JTextField jtfFileName;
	private JTextField jtfPosition;
 
	ArrayList strFindFiles= new ArrayList<String>();
	private static int countFile=0;
	
	//�����ַ������������ļ�λ�ú�����
	String fileName;
	String filePosition;
	
	public SearchListener(JTextField jtfFileName,JTextField jtfPosition) {
		//�����ݹ������ı��򸶸��Լ���
		this.jtfFileName=jtfFileName;
		this.jtfPosition=jtfPosition;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//����б�
		strFindFiles.clear();
		 for(int i=0;i<strFindFiles.toArray().length;i++){
			 System.out.println(strFindFiles.toArray()[i]);
		 }
		//�õ��ı����е�����
		 fileName=jtfFileName.getText();
		 filePosition=jtfPosition.getText();
		 searchFile(filePosition);
		
		 //��
		 //FileList.setListData(strFindFiles.toArray());
		
	}
 
 
	private void searchFile(String filePosition) {
		//�����ļ�
		File dirFile=new File(filePosition);
		
		File[] resFile=dirFile.listFiles();
		
		if(resFile==null||resFile.length==0){
			return;
		}
		
		for(int i=0;i<resFile.length;i++){
			if(resFile[i].isDirectory()){
				//�õ��ļ��е�����
				String subDir=resFile[i].getAbsolutePath();
				//�ж��ļ����Ƿ��йؼ���
				if(subDir.contains((CharSequence) fileName)){
					//������У����ļ��е�·���ӵ�������
					strFindFiles.add(resFile[i].getAbsolutePath());
				}		
				
				//�ݹ鵽��һ���ļ���
				searchFile(subDir);
			}
			//������ļ�
			if(resFile[i].isFile()){
				//�õ��ļ���
				String name=resFile[i].getName();
				
				
				//�ж��Ƿ��йؼ���
				if(name.contains((CharSequence)fileName)){
					//��κ��н��ļ��ľ�Ȼ��·���ӵ�������
					strFindFiles.add(resFile[i].getAbsolutePath());
					
 
				}
				
			}
		}
		
	}
	
 
}
