package container;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import javax.imageio.ImageIO;

import conf.SetupConf;
import utils.ListFiles;


public class ImgCanvas extends Canvas implements Runnable{
	
	private static final long serialVersionUID = 5008904316999562365L;

	private static String path="D:\\demo\\img";
    
    private int idx = 0;
    int markRemoveCount=idx;//�����ͣ��idx����ֵ�����״̬
    private static String[] tails={"jpg"};
    private static ListFiles fileList=new ListFiles(path,tails);
    private static List<File> listFiles=fileList.getListFiles();
    
	//private Image act1=Toolkit.getDefaultToolkit().createImage("img/act.jpg");;


	//˫�������������˸����Ӱ����
	
	private Image iBuffer;
	private Graphics gBuffer;
	
    // �Ƿ���ͼ���ƶ�
	private static boolean mark=true;
    
    private Thread thread = null;
    
    /**
     * ����ͼ��ֱ�ӵ���update������˳��˵һ�£�����paint����update, ����update����paint������ֺܺ�����¡�^^��
     */
    public ImgCanvas(){
    	thread = new Thread(this);
    	thread.start();
    }
   
	
	
    public void paint(Graphics g) {
        ImageObserver imageObserver = new ImageObserver()
        {

            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y,
                    int width, int height)
            {
                // TODO Auto-generated method stub
                return false;
            }
        };
        try
        {
            //g.drawImage(ImageIO.read(new File(Donttai.class.getResource("1.png").toString())), 20, 20, imageObserver);
        	//  String temp =fileList.getListFiles()[idx].getAbsolutePath() ;
        	
            File tempFile=null;
            if(idx>=0){
            	tempFile=listFiles.get(idx);
            }else{
            	String urlstr="img/act0.jpg";
            	String imageUrl = getClass().getResource(urlstr).toString();
            	tempFile=new File(imageUrl);
            }
            		
            g.drawImage(ImageIO.read(tempFile), 0, 0, (int)SetupConf.imageCanvasW, (int)SetupConf.imageCanvasH,
                    imageObserver);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

    /**
     * �˷��������ڷ������ʱ����ͼ��
     */
    public void update(Graphics g) {
    	if(iBuffer==null){
    		iBuffer=createImage(this.getSize().width,this.getSize().height);
    		gBuffer=iBuffer.getGraphics();
    	}
    	gBuffer.setColor(getBackground());
    	gBuffer.fillRect(0, 0, this.getSize().width, this.getSize().height);
    	
    	paint(gBuffer);
        
        g.drawImage(iBuffer,0,0, this);
        
       
    }
    
    
    public void run() {
        // TODO Auto-generated method stub
        while (true)
        {
        	if(mark){
        		
        		repaint();
                if (idx < listFiles.size()-1)
                    idx++;
                
                else
                    idx = 0;
                
                System.out.println(idx);
                markRemoveCount=idx;
                		
                try
                {
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
        	}else{
        		//Thread.yield();
        		System.out.println("."+idx);
        		
        		
        		if(idx==markRemoveCount){//����һ�ε�ʱ�����ɾ��
        			listFiles.remove(idx);
        		}
        		markRemoveCount++;//������ж������id��ʶ
        	}
            
        }
    }



	public static boolean isMark() {
		return mark;
	}



	public static void setMark(boolean mark) {
		ImgCanvas.mark = mark;
	}
    
    
}
