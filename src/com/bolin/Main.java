package com.bolin;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * @author bolin
 * @create 2017年4月20日
 *
 */
public class Main {

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch (InstantiationException e) {
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new Main().show();

	}

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 */
	private void show() {
		JOptionPane.showMessageDialog(null, "您的物理地址为："+ GetPhysicalAddress.getPhysicalAddress() + 
				"\n您的IP为："+ GetPhysicalAddress.getIPAddress().replaceAll(",", ""), "提示", JOptionPane.INFORMATION_MESSAGE);
	}

}
