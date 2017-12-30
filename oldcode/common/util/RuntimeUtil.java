package common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RuntimeUtil {

	public static boolean sendCommand(String commandLine){
		Process process = null;
		boolean execResult = false;
		try {
			process =  Runtime.getRuntime().exec(commandLine);
			InputStreamReader isr = new InputStreamReader(process
					.getErrorStream(), "gbk");
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			StringBuilder stringBuilder = new StringBuilder();
			while ((line = br.readLine()) != null) {
				stringBuilder.append(line);
			}

			if (stringBuilder.indexOf("错误") != -1) {
				execResult = false;
			}
			
		} catch (IOException ioe) {
			ioe.printStackTrace();
			execResult = false;
		}

		if (execResult == false && process != null) {
			process.destroy();
		}

		try {
			int exitVal = process.waitFor();
			System.out.println(exitVal);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return execResult;
	}
}
