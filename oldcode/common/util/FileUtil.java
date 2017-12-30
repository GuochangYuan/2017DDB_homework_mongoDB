package common.util;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class FileUtil {

	/**
	 *  创建文件夹
	 * @param path
	 */
	public static void createDir(String path) {
		File dir = new File(path);
		if (!dir.exists()){
			dir.setExecutable(true);
			dir.setReadable(true);
			dir.setWritable(true);
			dir.mkdirs(); 
		}
			
	}

	/**
	 * 创建新文件
	 * @param path
	 * @param filename
	 * @return
	 * @throws IOException
	 */
	public static String createFile(String path, String filename)
			throws IOException {
		createDir(path);
		File file = new File(path + "/" + filename);
		if (!file.exists()){
			file.setExecutable(true);
			file.setReadable(true);
			file.createNewFile();
		}
		return file.getAbsolutePath();
	}

	/**
	 * 删除文件
	 * 
	 * @param path
	 * @param filename
	 */
	public static void delFile(String path, String filename) {
		File file = new File(path + "/" + filename);
		if (file.exists() && file.isFile())
			file.delete();
	}

	/**
	 * 递归删除文件夹
	 * 
	 * @param path
	 */
	public static void  delDir(String path) {
		File dir = new File(path);
		if (dir.exists()) {
			File[] tmp = dir.listFiles();
			for (int i = 0; i < tmp.length; i++) {
				if (tmp[i].isDirectory()) {
					delDir(path + "/" + tmp[i].getName());
				} else {
					tmp[i].delete();
				}
			}
			dir.delete();
		}
	}
	
	/**
	 * @param tempPath
	 * @param filename
	 * @param suffix 如:".tmp"
	 * @return
	 * @throws IOException 
	 */
	public static String createTempFile(String tempPath,String filename,String suffix) throws IOException{
		String uuid = UUID.randomUUID().toString();
		return createFile(tempPath, uuid.concat(filename).concat(suffix));
	}
	
	/**
	 * 文件后缀名
	 * @param filename
	 * @return
	 */
	public static String getFileNameSuffix(String filename){
		return filename.substring(filename.lastIndexOf("."),filename.length());
	}
	
	public static File buildFile(String fileName, boolean isDirectory) {

        File target = new File(fileName);

        if (isDirectory) {

            target.mkdirs();

        } else {

            if (!target.getParentFile().exists()) {

                target.getParentFile().mkdirs();

                target = new File(target.getAbsolutePath());

            }

        }

        return target;

    }
}
