package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ljdok.com.codeimg.CodeImg;

/**
 * Servlet implementation class CheckCodeImageServlet
 */
public class CheckCodeImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCodeImageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//创建验证码类对象
			CodeImg img = new CodeImg();
			//设置验证码随机字符集
			img.setCodes("123456789");//纯数字
			//设置验证码字符个数
			img.setCount(4);
			//设置边框、颜色
			img.setBorder(0, "0,0,0");
			//设置宽、高
			img.setSize(160, 45);
			//设置字体
			img.setFont("黑体");
			//设置字体大小
			img.setFontSize(35);
			//设置验证码颜色
			img.setForeColor(img.getRandColor(20, 140));
			//设置背景色
			img.setNoiseColor(img.getRandColor(120, 200));
			//设置session名称
			img.setSessionKey("checkCode");
			//创建验证码
			img.createImg(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
