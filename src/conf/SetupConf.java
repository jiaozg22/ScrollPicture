package conf;

import java.awt.Dimension;
import java.awt.Toolkit;

public class SetupConf {
	public static Dimension scrSize=Toolkit.getDefaultToolkit().getScreenSize(); //��Ļ��ȣ��߶�
	
	
	
	public static double framW=scrSize.getWidth()*8/10;//ͼƬ��ʾ���
	public static double framH=scrSize.getHeight()*8/10;//ͼƬ��ʾ�߶�
	public static double framX=scrSize.getWidth()/2-framW/2;//ͼƬ��ʾ����
	public static double framY=scrSize.getHeight()/2-framH/2;//ͼƬ��ʾ����
	    
	
	
	public static double jpanel1W=framW*7/10;//���1
	public static double jpanel1H=framH;//���1
	public static double jpanel1X=0;//���1
	public static double jpanel1Y=0;//���1
	
	
	
	public static double imageCanvasWTemp=jpanel1W*8/10;//���1
	public static double imageCanvasHTemp=jpanel1H*8/10;//������ʾ����߶�
	//��͸�ѡ��С����Ϊ���
    public double imageCanvasWORHTemp=imageCanvasWTemp>imageCanvasHTemp?imageCanvasHTemp:imageCanvasWTemp;//��ͼƬ��������������
    
    public static double imageCanvasW=imageCanvasWTemp;
    public static double imageCanvasH=imageCanvasHTemp;
    
	public static double imageCanvasX=jpanel1W/2-imageCanvasW/2;//������ʾx����(������)
	public static double imageCanvasY=jpanel1H/2-imageCanvasH/2;//������ʾy����(������)
	
    
	
	public static double jpanel2W=framW*3/10;//�Ҳ�������ʾ���
	public static double jpanel2H=framH;//�Ҳ�������ʾ�߶�
	public static double jpanel2X=jpanel1W;//�Ҳ�������ʾ����
	public static double jpanel2Y=0;//�Ҳ�������ʾ����
	
//	public static double jButtonStartOrStopW=200;//�Ҳ�������ʾ���
//	public static double jButtonStartOrStopH=50;//�Ҳ�������ʾ�߶�
//	public static double jButtonStartOrStopX=jpanel2W/2-jButtonStartOrStopW/2;//�Ҳ�������ʾ����
//	public static double jButtonStartOrStopY=jpanel2H*8/10;//�Ҳ�������ʾ����
//	
	public static void init(){
		//��������ʾ���
        //��������ʾ�߶�
        
        //�����������Ļ����
        //�����������Ļ����
        
        
        //�����ʾ���
        //�����ʾ�߶�
        
        //�����ʾ����
        //�����ʾ����
        
        
        //������ʾ������
        
        
	}

	public static Dimension getScrSize() {
		return scrSize;
	}

	public static void setScrSize(Dimension scrSize) {
		SetupConf.scrSize = scrSize;
	}

	public static double getFramW() {
		return framW;
	}

	public static void setFramW(double framW) {
		SetupConf.framW = framW;
	}

	public static double getFramH() {
		return framH;
	}

	public static void setFramH(double framH) {
		SetupConf.framH = framH;
	}

	public static double getFramX() {
		return framX;
	}

	public static void setFramX(double framX) {
		SetupConf.framX = framX;
	}

	public static double getFramY() {
		return framY;
	}

	public static void setFramY(double framY) {
		SetupConf.framY = framY;
	}

	public static double getJpanel1W() {
		return jpanel1W;
	}

	public static void setJpanel1W(double jpanel1w) {
		jpanel1W = jpanel1w;
	}

	public static double getJpanel1H() {
		return jpanel1H;
	}

	public static void setJpanel1H(double jpanel1h) {
		jpanel1H = jpanel1h;
	}

	public static double getJpanel1X() {
		return jpanel1X;
	}

	public static void setJpanel1X(double jpanel1x) {
		jpanel1X = jpanel1x;
	}

	public static double getJpanel1Y() {
		return jpanel1Y;
	}

	public static void setJpanel1Y(double jpanel1y) {
		jpanel1Y = jpanel1y;
	}

	public static double getImageCanvasWTemp() {
		return imageCanvasWTemp;
	}

	public static void setImageCanvasWTemp(double imageCanvasWTemp) {
		SetupConf.imageCanvasWTemp = imageCanvasWTemp;
	}

	public static double getImageCanvasHTemp() {
		return imageCanvasHTemp;
	}

	public static void setImageCanvasHTemp(double imageCanvasHTemp) {
		SetupConf.imageCanvasHTemp = imageCanvasHTemp;
	}

	public double getImageCanvasWORHTemp() {
		return imageCanvasWORHTemp;
	}

	public void setImageCanvasWORHTemp(double imageCanvasWORHTemp) {
		this.imageCanvasWORHTemp = imageCanvasWORHTemp;
	}

	public static double getImageCanvasW() {
		return imageCanvasW;
	}

	public static void setImageCanvasW(double imageCanvasW) {
		SetupConf.imageCanvasW = imageCanvasW;
	}

	public static double getImageCanvasH() {
		return imageCanvasH;
	}

	public static void setImageCanvasH(double imageCanvasH) {
		SetupConf.imageCanvasH = imageCanvasH;
	}

	public static double getImageCanvasX() {
		return imageCanvasX;
	}

	public static void setImageCanvasX(double imageCanvasX) {
		SetupConf.imageCanvasX = imageCanvasX;
	}

	public static double getImageCanvasY() {
		return imageCanvasY;
	}

	public static void setImageCanvasY(double imageCanvasY) {
		SetupConf.imageCanvasY = imageCanvasY;
	}

	public static double getJpanel2W() {
		return jpanel2W;
	}

	public static void setJpanel2W(double jpanel2w) {
		jpanel2W = jpanel2w;
	}

	public static double getJpanel2H() {
		return jpanel2H;
	}

	public static void setJpanel2H(double jpanel2h) {
		jpanel2H = jpanel2h;
	}

	public static double getJpanel2X() {
		return jpanel2X;
	}

	public static void setJpanel2X(double jpanel2x) {
		jpanel2X = jpanel2x;
	}

	public static double getJpanel2Y() {
		return jpanel2Y;
	}

	public static void setJpanel2Y(double jpanel2y) {
		jpanel2Y = jpanel2y;
	}

//	public static double getjButtonStartOrStopW() {
//		return jButtonStartOrStopW;
//	}
//
//	public static void setjButtonStartOrStopW(double jButtonStartOrStopW) {
//		SetupConf.jButtonStartOrStopW = jButtonStartOrStopW;
//	}
//
//	public static double getjButtonStartOrStopH() {
//		return jButtonStartOrStopH;
//	}
//
//	public static void setjButtonStartOrStopH(double jButtonStartOrStopH) {
//		SetupConf.jButtonStartOrStopH = jButtonStartOrStopH;
//	}
//
//	public static double getjButtonStartOrStopX() {
//		return jButtonStartOrStopX;
//	}
//
//	public static void setjButtonStartOrStopX(double jButtonStartOrStopX) {
//		SetupConf.jButtonStartOrStopX = jButtonStartOrStopX;
//	}
//
//	public static double getjButtonStartOrStopY() {
//		return jButtonStartOrStopY;
//	}
//
//	public static void setjButtonStartOrStopY(double jButtonStartOrStopY) {
//		SetupConf.jButtonStartOrStopY = jButtonStartOrStopY;
//	}

	

}
