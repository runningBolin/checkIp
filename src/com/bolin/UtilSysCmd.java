package com.bolin;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * @author bolin
 * @create 2017年4月20日
 *
 */
public class UtilSysCmd {
	
	Process p;

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @param cmd
	 * @return
	 */
	public ArrayList<String> execute(String shallCommond) {
		
		try {
			Start(shallCommond);
			ArrayList<String> vResult = new ArrayList<String>();
			DataInputStream in = new DataInputStream(p.getInputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(in));
			
			String line;
			
			do{
				line = reader.readLine();
				if(line == null){
					break;
				}else{
					vResult.add(line);
				}
				
			}while(true);
			
			reader.close();
			return vResult;
		}
		catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 * @param shallCommond
	 */
	private void Start(String shallCommond) {
		
		try {
			if(p != null){
				kill();
			}
			
			Runtime sys = Runtime.getRuntime();
			p = sys.exec(shallCommond);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @author bolin
	 * @create 2017年4月20日
	 * 
	 */
	private void kill() {
		if(p != null){
			p.destroy();
			p = null;
		}
	}

}
