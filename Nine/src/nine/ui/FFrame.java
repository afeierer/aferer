package nine.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;





public class FFrame extends JFrame{
	private String[] items={"桃花","漫画"};
	private JComboBox<String> box;
	private CCanvas canvas;
   private JTextField name;
	public static JTextField step;
	private JButton start;
	
	public FFrame()
	{
		init();
		addComponent();
		addImage();
		addActionListener();
		
	}
	

		
		
	private void addActionListener() 
	{
		
			box.addItemListener(new ItemListener()
			{
			
			@Override
			public void itemStateChanged(ItemEvent e) 
			{
				// TODO Auto-generated method stub
				int num = box.getSelectedIndex();
				CCanvas.PID = num + 1;
				
				canvas.RE();
				name.setText("图片名称:" + box.getSelectedItem());
				int stepNum = CCanvas.STEPN = 0;
				step.setText("步数:" + stepNum);
			}
		});
			
			
			
			
			start.addActionListener(new ActionListener() {			
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					CCanvas.STEPN = 0;
					step.setText("步数:" + CCanvas.STEPN);
					
					canvas.gstart();
				}
			});
			
		}
	
	
	

	
	
	



	private void  addImage()
	{
		JPanel panel =new JPanel();
		panel.setLayout(new GridLayout(1,1));
	    canvas=new CCanvas();
		
		panel.add(canvas,BorderLayout.CENTER);
		canvas.setBorder(new TitledBorder("拼图区"));
		this.add(panel,BorderLayout.CENTER);
		
	}
	
	private void init()
	{
		this.setTitle("拼图游戏");
		this.setSize(493,580);
		//this.setLocation(150,10);
		
		this.setLocation(150,150);
		this.setResizable(false);
		
	}
			
	
	private void addComponent() {
		JPanel panel =new JPanel();
		
		panel.setLayout(new GridLayout(1,2));
		
		JPanel left =new JPanel();
		JPanel right =new JPanel();
		
		left .setBorder(new TitledBorder("菜单"));
		right.setBorder(new TitledBorder("状态"));
		
		left.setBackground(Color.PINK);
		right.setBackground(Color.PINK);
	
		panel.add(right,BorderLayout.EAST);
		panel.add(left,BorderLayout.WEST);
		
		
		
		this.add(panel,BorderLayout.CENTER);
		
		box = new JComboBox<String>(items);
		
		
		
		start = new JButton("Start");
		start.setBackground(Color.PINK);
		
		
		
		
		
		left.add(new JLabel("选择图片："));
		
		left.add(box);
		left.add(start);
		name=new JTextField("图片名称:" + box.getSelectedItem());
		//right.add(name);
		
		step=new JTextField("步数："+0);
		name.setEditable(false);
		step.setEditable(false);
		right.add(name,BorderLayout.WEST);
		right.add(step,BorderLayout.EAST);
		panel.add(right,BorderLayout.EAST);
		
		
	this.add(panel, BorderLayout.NORTH);
		
		
	
	}
	

}




