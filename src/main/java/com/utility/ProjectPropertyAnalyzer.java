package com.utility;

import com.config.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ProjectPropertyAnalyzer {
	
	public static String getProjName(String gitrepo)
	{
		int lastslashindex=gitrepo.lastIndexOf('/');
		int indexofdot=gitrepo.lastIndexOf('.');
		
		String otherpart=gitrepo.substring(0,lastslashindex-1);
		
		int secondlastindex=otherpart.lastIndexOf('/');
		
		String repoowner=gitrepo.substring(secondlastindex+1,lastslashindex);		
		String projname=gitrepo.substring(lastslashindex+1, indexofdot);
		
		String repoprojname=repoowner+"@"+projname;
		
		return repoprojname;		
	}


	public static void writeLog(String info) {
		String filename = "activity.log";
		String FILENAME = Config.repoDir + '/' +  filename;
		BufferedWriter bw = null;
		FileWriter fw = null;
		try {
			fw = new FileWriter(FILENAME, true);
			bw = new BufferedWriter(fw);
			bw.write(info);
			bw.write("\n");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
