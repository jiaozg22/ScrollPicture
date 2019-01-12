package utils;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.sound.midi.ControllerEventListener;
import javax.sound.midi.ShortMessage;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author  jiao_zg
 */
public class donghua2 extends javax.swing.JFrame implements Runnable, ActionListener, ItemListener, ControllerEventListener
{

	private Container container=null;
	
	private JPanel jpanel1=new  JPanel();	
	//String path = "E:\\Workspaces\\MyEclipse_9.0\\20120731\\bin\\��̬ͼ\\1\\10";
    //JavaĬ���ļ�·������Ŀ�ĸ�Ŀ¼������Ҫ�ֶ�����bin�������µ�·��
    String path="D:\\demo\\img";
    
    int idx = 1;
    String[] tails={"jpg"};
    ListFiles1 fileList=new ListFiles1(path,tails);
    File[] files=fileList.getListFiles();
    
    
    private static double framX=50;//ͼƬ��ʾ����
    private static double framY=100;//ͼƬ��ʾ����
    private static double framW=900;//ͼƬ��ʾ����
    private static double framH=600;//ͼƬ��ʾ�߶�
    
    
    private static double imgX=50;//ͼƬ��ʾ����
    private static double imgY=100;//ͼƬ��ʾ����
    private static double imgW=500;//ͼƬ��ʾ����
    private static double imgH=500;//ͼƬ��ʾ�߶�
    
    private static Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); //��Ļ���ȣ��߶�
    
  //GEN-BEGIN:variables
    // Variables declaration - do not modify
    private javax.swing.JButton jButton1;
    private JTextArea jTextArea=new JTextArea();
    // End of variables declaration//GEN-END:variables

    private static boolean mark=true;
    /** Creates new form Donttai */
    public donghua2()
    {
    	initParameters();
    	
        initComponents();
        
    }

    public void initParameters(){
        
        framW=scrSize.getWidth()*8/10;//ͼƬ��ʾ����
        framH=scrSize.getHeight()*8/10;//ͼƬ��ʾ�߶�
        
        framX=scrSize.getWidth()/2-framW/2;//ͼƬ��ʾ����
        framY=scrSize.getHeight()/2-framH/2;//ͼƬ��ʾ����
    	
    	//ͼƬ�����������
    	double  imgWTemp=framW*8/10;
    	double imgHTemp=framH*8/10;
    	
    	//ͼƬ����ʵ�ʼ���
    	imgW=imgWTemp;
    	imgH=imgHTemp;
    	
    	//������ѡ��С����Ϊʵ����ʾ�Ŀ���
    	double temp=(imgWTemp>imgHTemp)?imgHTemp:imgWTemp;
    	
    	imgW=temp;
    	imgH=temp;
    	
    	imgX=framW*7/20-imgW/2;//framW*����/2
    	imgY=framH/2-imgH/2;
    	
    }

    public void paint(Graphics g)
    {
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
        	
            File tempFile=files[idx];
            g.drawImage(ImageIO.read(tempFile), (int)imgX, (int)imgY, (int)imgW, (int)imgH,
                    imageObserver);
        }
        catch (IOException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        jButton1.setBounds(0, 0, 150, 50);
		jpanel1.add(jButton1);
		
		
		jTextArea.setBounds(0, 400, 250, 60);
		
		jpanel1.add(jTextArea);
		
		container.add(jpanel1);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    //GEN-BEGIN:initComponents
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents()
    {
    	
    	
    	
    	jpanel1.setBounds(0, 0, 650, 350);
    	
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("��ʼ/��ͣ");

//        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
//                getContentPane());
//        getContentPane().setLayout(layout);
//        layout.setHorizontalGroup(layout.createParallelGroup(
//                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//                javax.swing.GroupLayout.Alignment.TRAILING,
//                layout.createSequentialGroup()
//                        .addContainerGap(483, Short.MAX_VALUE)
//                        .addComponent(jButton1).addGap(35, 35, 35)));
//        layout.setVerticalGroup(layout.createParallelGroup(
//                javax.swing.GroupLayout.Alignment.LEADING).addGroup(
//                layout.createSequentialGroup().addGap(37, 37, 37)
//                        .addComponent(jButton1)
//                        .addContainerGap(400, Short.MAX_VALUE)));
        container=getContentPane();//��ȡ����
		container.setLayout(null);//���ò���Ϊ�Զ��岼�ַ�ʽ
		
		jButton1.setBounds(0, 0, 150, 50);
		jpanel1.add(jButton1);
		
		jTextArea.setBounds(100, 0, 250, 30);
		
		jpanel1.add(jTextArea);
		
		container.add(jpanel1);
		container.setBounds(0, 0, 650, 350);
		
        register();
        
        setVisible(true);
        //pack();
    }// </editor-fold>
    //GEN-END:initComponents

	public void register()
	{
		jButton1.setActionCommand("jButton1");  // ���ÿ�����
		
		jButton1.addActionListener(this);//ע��ʱ�������;
	}
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[])
    {
       
    	donghua2 donttai = new donghua2();
    	
    	
    	
    	donttai.setBounds((int)framX, (int)framY, (int)framW, (int)framH);
        donttai.setVisible(true);
        donttai.run();
    }

    

    @Override
    public void run()
    {
        // TODO Auto-generated method stub
        while (true)
        {
        	if(mark){
        		
        		repaint();
                if (idx < files.length-1)
                    idx++;
                else
                    idx = 1;
                
                System.out.println(idx);
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
        	}
            

        }
    }



	@Override
	public void controlChange(ShortMessage event) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand().equals("jButton1")){
			mark=!mark;
		}
	}

}