package utils;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.List;

public class ListFiles {
	private List<File> listFiles=new ArrayList<File>();
	private String url=null;
	private String[] tailStr=null;
	
	public ListFiles(String urlStr){
		url=urlStr;
	}
	
	public ListFiles(String urlStr,String[] ts){
		url=urlStr;
		tailStr=ts;
		File[] arrayFiles=new File(url).listFiles(new myFileFilter());
		for(File file:arrayFiles){
			listFiles.add(file);
		}
	}
	
	public static void main(String[] args){
		String url="d://test";
		String[] tails={};
		ListFiles listFiles=new ListFiles(url,tails);
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

	public List<File> getListFiles() {
		return listFiles;
	}

	public void setListFiles(List<File> listFiles) {
		this.listFiles = listFiles;
	}

	
	
}
