package common.util;


import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.SocketException;

import org.apache.commons.net.telnet.TelnetClient;

import com.ffcs.newgeye.util.Constant;


public class TelnetShell {
	
	private TelnetClient telnet = new TelnetClient();
	private InputStream in;

	private PrintStream out;

	private char prompt = '>';// 普通用户结束

	public TelnetShell(String ip, int port, String user, String password) {
		try {
			telnet.connect(ip, port);
			telnet.setConnectTimeout(1000*30);
			in = telnet.getInputStream();
			out = new PrintStream(telnet.getOutputStream());
			// 根据root用户设置结束符
			this.prompt = user.equals("root") ? '#' : '>';
			login(user, password);
		} catch (SocketException e) {
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 登录
	 * 
	 * @param user
	 * @param password
	 */
	public void login(String user, String password) {
//		readUntil("login:");
//		write(user);
		System.out.println(readUntil("Password:"));
		write(password);
		System.out.println(readUntil(prompt + ""));
	}

	/**
	 * 读取分析结果
	 * 
	 * @param pattern
	 * @return
	 */
	public String readUntil(String pattern) {
		StringBuffer sb =  new StringBuffer();;
		try {
			char lastChar = pattern.charAt(pattern.length() - 1);
			char ch = (char) in.read();
			while (true) {
				sb.append(ch);
				if (ch == lastChar) {
					if (sb.toString().endsWith(pattern)) {
						return sb.toString();
					}
				}
				ch = (char) in.read();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("return null");  
		return null;
	}

	/**
	 * 写操作
	 * 
	 * @param value
	 */
	public void write(String value) {
		try {
			out.println(value);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 向目标发送命令字符串
	 * 
	 * @param command
	 * @return
	 */
	public String sendCommand(String command) {
		try {
			write(command);
			return readUntil(prompt + "");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 关闭连接
	 */
	public void disconnect() {
		try {
			telnet.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			
		}
	}

	public static void main(String[] args) {
		System.out.println("开始执行telnet......");  
		TelnetShell telnetShell = new TelnetShell(Constant.VIDEO_SERVER_IP,
				Constant.VIDEO_SERVER_PORT, Constant.VIDEO_SERVER_USER,
				Constant.VIDEO_SERVER_PASSWORD);
		String virtualName =  "1333084666191";
		String fileRealPath =  Constant.VIDEO_BASE_PATH+"12-03/1333084666191.mp4";
		String addVideoCmd = "new "+virtualName+" vod enabled";
		String setUpVideoCmd = "setup "+virtualName+" input \""+fileRealPath+"\"";
		
		System.out.println("开始发送hostname命令");  
		String result = telnetShell.sendCommand(addVideoCmd);
		System.out.println("显示结果1 result:"+result); 
		
		result = telnetShell.sendCommand(setUpVideoCmd);
		System.out.println("显示结果2  result:"+result); 
		telnetShell.disconnect(); 
		System.out.println("telnet end :");
	}
}
