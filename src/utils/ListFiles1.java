package utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ListFiles1 {
	private File[] listFiles={};
	private String url=null;
	private String[] tailStr=null;
	
	public ListFiles1(String urlStr){
		url=urlStr;
	}
	
	public ListFiles1(String urlStr,String[] ts){
		url=urlStr;
		tailStr=ts;
		listFiles=new File(url).listFiles(new myFileFilter());
		
	}
	
	public static void main(String[] args){
		String url="d://test";
		String[] tails={};
		ListFiles1 listFiles=new ListFiles1(url,tails);
		for(File f:listFiles.listFiles){
			System.out.println("file:"+f.getName());
		}
		
	}
	
	class myFileFilter implements FilenameFilter{
		
		@Override
		public boolean accept(File url, String name) {
			boolean flag=true;
			boolean iflag=false;//������������ʾ,Ĭ����������
			String[] tailStrs=tailStr;
			// ����ɸѡ����
	        //endWith(String str);�ж��Ƿ�����ָ����ʽ��β��
			for(String tail:tailStr){
				if (!name.toLowerCase().endsWith("."+tail.toLowerCase())) {
					iflag=true;
		        }else{
		        	iflag=false;
		        	break;
		        }
			}
	       
	      
	        // ���ض���ķ���ֵ
	         
	        //������trueʱ,��ʾ������ļ���������
			
			flag=!iflag;
			
	        return flag;
		}
	}

	public File[] getListFiles() {
		return listFiles;
	}

	public void setListFiles(File[] listFiles) {
		this.listFiles = listFiles;
	}

	
	
}
