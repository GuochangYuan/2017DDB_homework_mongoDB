package common.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPFile;
import org.apache.commons.net.ftp.FTPReply;



public class FtpUtil {
	private static Log log = LogFactory.getLog(FtpUtil.class);
	
	private static final int SO_TIME_OUT = 1000 * 60 * 10;

	/**
	 * @param url
	 * @param port
	 * @param username
	 * @param password
	 * @param path
	 * @param filename
	 * @param input
	 * @return
	 */
	public static boolean uploadFile(String url, int port, String username,
			String password, String path, String filename, InputStream input) {
		boolean success = false;
		FTPClient ftp = new FTPClient(); 
		try {  
			log.info("###ftp url:"+url);
			log.info("###ftp port:"+port);
			log.info("###ftp username:"+username);
			log.info("###ftp password:"+password);
			log.info("###ftp path:"+path);
			log.info("###ftp filename:"+filename);
			int reply;
			ftp.setDataTimeout(SO_TIME_OUT);
			ftp.connect(url,port);// 连接FTP服务器
			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器
			ftp.login(username, password);// 登录
			reply = ftp.getReplyCode();
			if (!FTPReply.isPositiveCompletion(reply)) {
				ftp.disconnect();
				return success;
			}
			if (!ftp.changeWorkingDirectory(path)) {
				ftp.makeDirectory(path);
			}
			ftp.changeWorkingDirectory(path);
			ftp.storeFile(filename, input);
			input.close();
			ftp.logout();
			success = true;
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		} finally {
			if (ftp.isConnected()) {
				try {
					ftp.disconnect();
				} catch (IOException ioe) {
					success = false;
					ioe.printStackTrace();
				}
			}
			return success;
		}
	}

	/**
	 * Description: 从FTP服务器下载文件
	 * @Version1.0
	 * 
	 * @param url
	 *            FTP服务器hostname
	 * @param port
	 *            FTP服务器端口
	 * @param username
	 *            FTP登录账号
	 * @param password
	 *            FTP登录密码
	 * @param remotePath
	 *            FTP服务器上的相对路径
	 * @param fileName
	 *            要下载的文件名
	 * @param localPath
	 *            下载后保存到本地的路径
	 * @return
	 */

	public static boolean downFile(
			String url, // FTP服务器hostname
			int port,// FTP服务器端口
			String username, // FTP登录账号
			String password, // FTP登录密码
			String remotePath,// FTP服务器上的相对路径
			String fileName,// 要下载的文件名
			String localPath// 下载后保存到本地的路径
	) {

		boolean success = false;

		FTPClient ftp = new FTPClient();

		try {

			int reply;

			ftp.connect(url, port);

			// 如果采用默认端口，可以使用ftp.connect(url)的方式直接连接FTP服务器

			ftp.login(username, password);// 登录

			reply = ftp.getReplyCode();

			if (!FTPReply.isPositiveCompletion(reply)) {

				ftp.disconnect();

				return success;

			}

			ftp.changeWorkingDirectory(remotePath);// 转移到FTP服务器目录

			FTPFile[] fs = ftp.listFiles();

			for (FTPFile ff : fs) {

				if (ff.getName().equals(fileName)) {

					File localFile = new File(localPath + "/" + ff.getName());

					OutputStream is = new FileOutputStream(localFile);

					ftp.retrieveFile(ff.getName(), is);

					is.close();

				}

			}

			ftp.logout();

			success = true;

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			if (ftp.isConnected()) {

				try {

					ftp.disconnect();

				} catch (IOException ioe) {

				}

			}

		}

		return success;

	}
	
	/** */
    /**
     * 递归创建远程服务器目录
     * 
     * @param remote
     *            远程服务器文件绝对路径
     * 
     * @return 目录创建是否成功
     * @throws IOException
     */
    public boolean createDirecroty(FTPClient ftp ,String remote) throws IOException {
        boolean success = true;
        String directory = remote.substring(0, remote.lastIndexOf("/") + 1);
        // 如果远程目录不存在，则递归创建远程服务器目录
        if (!directory.equalsIgnoreCase("/")
                && !ftp.changeWorkingDirectory(new String(directory))) {
            int start = 0;
            int end = 0;
            if (directory.startsWith("/")) {
                start = 1;
            } else {
                start = 0;
            }
            end = directory.indexOf("/", start);
            while (true) {
                String subDirectory = new String(remote.substring(start, end));
                if (!ftp.changeWorkingDirectory(subDirectory)) {
                    if (ftp.makeDirectory(subDirectory)) {
                        ftp.changeWorkingDirectory(subDirectory);
                    } else {
                        System.out.println("创建目录失败");
                        success = false;
                        return success;
                    }
                }
                start = end + 1;
                end = directory.indexOf("/", start);
                // 检查所有目录是否创建完毕
                if (end <= start) {
                    break;
                }
            }
        }
        return success;
    }

}
