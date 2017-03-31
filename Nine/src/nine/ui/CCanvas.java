package nine.ui;

import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class CCanvas extends JPanel implements MouseListener{
	private Rectangle incell;
	private int xxx;
	private int yyy;
	private Cell[] cell;
	public static int PID = 1;
			public static int STEPN = 0;
			private boolean hasAddActionListener=false;

	
	public CCanvas(){
		//设置拼图区布局
		this.setLayout(null);//帧布局

		//创建12个小图片，添加到拼图区
		cell=new Cell[9];
		for(int i=0;i<3;i++)
		{
			for(int j=0;j<3;j++)
			{
		//加载图片
				ImageIcon icon=new ImageIcon("Pict\\"+CCanvas.PID+"_0"+(i*3+j+1)+".gif");
				
//				ImageIcon icon=new ImageIcon("2.jpg");
			cell [i*3+j]=new Cell(icon);
			cell [i*3+j].setLocation(j*150+20,i*150+20);
			this.add(cell[i*3+j]);
		
			}
		}
		this.remove(cell[8]);
//		//删除第9个小方格
	incell=new Rectangle(300+20,300+20,150,150);
//		//指定一个空
		
				
		
	}
	public void RE() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				ImageIcon icon = new ImageIcon("Pict\\"+CCanvas.PID+"_0"+ (i*3+j+1) +".gif");
				cell[i*3+j].setIcon(icon);
				
			}
		}
	}
	

	
		public void gstart(){
			
			if(!hasAddActionListener){
				for (int i = 0; i < 8; i++) {
					cell[i].addMouseListener(this);
				}
				hasAddActionListener = true;
			}
			
			//打乱
			int cc=20;
			while(cc--!=0)
			{ 
					int inx=incell.getBounds().x;
					int iny=incell.getBounds().y;
					xxx=inx;
					yyy=iny;
					
					int rand=(int )(Math.random()*4);
					if (rand==0&&inx>=170)
					{
						inx -= 150;
						mmove(inx,iny,"0");//左
						
					}
					
					if (rand==1&&inx<320)
					{
						inx += 150;
						mmove(inx,iny,"1");//右
					    
					}
					if (rand==2&&iny>=170)
					{
						iny -= 150;
						mmove(inx,iny,"2");//上
					    
					}
					if (rand==3&&iny<320)
					{
						iny += 150;
						mmove(inx,iny,"3");//下
					    
					}
			}
		}
				

			
//	
//		
//		private void mmove(int xx, int yy, String r) {
//			
//			for (int i = 0; i < 8; i++) {
//				if(cell[i].getBounds().x == xx && cell[i].getBounds().y == yy) {
//					cell[i].moveD(r);
//					incell.setLocation(xx, yy);
//					break;
//				}
//				
//			}
//		}
		
		
		private void mmove(int xx, int yy, String r) {
		
		for (int i = 0; i < 8; i++) {
			if(cell[i].getBounds().x == xx && cell[i].getBounds().y == yy) {
				incell.setLocation(xx, yy);
				cell[i].setLocation(xxx,yyy);
				break;
			}
			
		}
	}
		
	
			
	


		@Override
		public void mousePressed(MouseEvent e){
			Cell bb =(Cell)e.getSource();
			int cx=bb.getBounds().x;
			int cy=bb.getBounds().y;
			int innx=incell.getBounds().x;
			int inny=incell.getBounds().y;
			int xxx=cx;
			int yyy=cy;
			if(innx==cx&&cy==inny+150){bb.moveD("0");}
		
			//up
			else if(innx==cx&&cy==inny-150){bb.moveD("1");}
			//down
			else if(inny==cy&&cx==innx+150){bb.moveD("3");}
			//left
			
			
			else if(inny==cy&&cx==innx-150){bb.moveD("2");}
			//right
			else {return;}
			incell.setLocation(xxx, yyy);
			STEPN++;
			FFrame.step.setText("步数：" + STEPN);
	     if(Fin()){JOptionPane.showMessageDialog(this,"共用"+STEPN+"步");
	     
	     ImageIcon ic=new ImageIcon("Pict\\"+CCanvas.PID+"_09"+".gif");
	     cell[8].setIcon(ic);
//
//		cell [8]=new Cell(ic);
//		cell [8].setLocation(320,320);
//		this.add(cell[8]);
	     }
	
		}

private boolean Fin()
{
	for(int i=0;i<=8;i++)
	{int ax=cell[i].getBounds().x;
	int ay=cell[i].getBounds().y;
	if (((ay-20)/150*3+(ax-20)/150) != i) 
		return false;
	}
	return true;
}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}


		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
}
