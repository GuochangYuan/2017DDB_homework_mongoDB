package common.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class TxtUtil{
	
	private String path ;
	private String filename ;
	private String filepath ;
	private FileOutputStream fos; 
	private OutputStreamWriter outputStreamWriter;
	private BufferedWriter  bw;

	public TxtUtil(String path,String filename){
		this.path = path;
		this.filename = filename;
	}
	
	public void createFile() throws IOException{
		FileUtil.createFile(this.path, this.filename);
		this.filepath = path.concat("/").concat(filename);
		File file = new File(filepath);
		fos = new FileOutputStream(file); 
		outputStreamWriter = new  OutputStreamWriter(fos,"GBK");
		bw = new BufferedWriter(outputStreamWriter);
	}
	
	public  void writeToTxt(String inStr) throws IOException{
		outputStreamWriter.write(inStr);
	}
	
	public void close(){
		if(bw != null){
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(outputStreamWriter != null){
			try {
				outputStreamWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(outputStreamWriter != null){
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
