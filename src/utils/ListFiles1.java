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
			boolean iflag=false;//不满足条件标示,默认满足条件
			String[] tailStrs=tailStr;
			// 定义筛选条件
	        //endWith(String str);判断是否是以指定格式结尾的
			for(String tail:tailStr){
				if (!name.toLowerCase().endsWith("."+tail.toLowerCase())) {
					iflag=true;
		        }else{
		        	iflag=false;
		        	break;
		        }
			}
	       
	      
	        // 返回定义的返回值
	         
	        //当返回true时,表示传入的文件满足条件
			
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
