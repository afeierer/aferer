package nine.ui;

import javax.swing.Icon;
import javax.swing.JButton;

public class Cell extends JButton{
	//只带图片的小方格
		public Cell(Icon icon) {
			super(icon);
			//设置当前小方格大小
			this.setSize(150,150);
		}



		
		
public void moveD(String r) {
	// TODO Auto-generated method stub
	int tx = this.getBounds().x;
	int ty = this.getBounds().y;
	switch (r) {
	case "0":
		this.setLocation(tx, ty - 150);//right
		break;
	case "1":
		this.setLocation(tx, ty + 150);//left
		break;
	case "2":
		this.setLocation(tx + 150, ty);//up
		break;
	case "3":
		this.setLocation(tx - 150, ty);//down
		break;
	}
}





		}