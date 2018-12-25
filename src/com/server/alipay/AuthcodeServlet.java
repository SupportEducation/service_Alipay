package com.server.alipay;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipaySystemOauthTokenRequest;
import com.alipay.api.request.AlipayUserInfoShareRequest;
import com.alipay.api.response.AlipaySystemOauthTokenResponse;
import com.alipay.api.response.AlipayUserInfoShareResponse;
import com.server.dao.EduExpDao;
import com.server.dao.accountDao;
import com.server.dao.teaexprienceDao;
import com.server.dao.userDao;
import com.server.entity.account;

import net.sf.json.JSONArray;

/**
 * Servlet implementation class AuthcodeServlet
 */
@WebServlet("/AuthcodeServlet")
public class AuthcodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String APP_ID = "2018121062525079";
	private static final String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAl48/LXTBXJ1GZJ2UgaK+q+ZXTqxHzmKtpKPL4i60Z3sMWQe3x92cPVTRAbnpRipBK5CtrY094GKOm5j4Cg9hD+IsOombadZ0eYw2UjY4A/XA5qtNteerR8mFd/sF+GYBAeb0DaRCG8ZiK9ksZsyLe7B1d92eHV3Cg3YkYC4nS8qMvNtaQelN92mSbcCw4NshnPZnRlj9RnlgpR9nkjQ7aZCu5o3BIY2HpwP7N9CLmbRTnYtKzjHAEGbaBhaNDasW1o1yDI3PCmZcfTCNmQArOsOX6LOJRoPj0pbLiud5P7fZwVwqBNhOOz1zcER2y7FW7OpnlYU2oanTXYS3eIqlSwIDAQAB";
	private static final String APP_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCFXmjOmBBePskpC66Peda0D4ST6y1ypVZ4NkaxdMpuRFQ0eD+3EzDuC2BBpcyOlP6Wuq4qcpn3IJb29hnjyZliIDJKc+hVYcF0/mPdc6oovERnLJjLQ96e9WRWXI1fmS8jvNdN5I6AD/S5WyBUsJiT4mGGqVHQOiew5CFJ6hl+RUpODBNTYFyEWz8C3vhm5tZMcI4vL2HUt6if0o+OwVqw/KHa+TRxy0Ed8kxK6jicCOJObK/lb4p38QZmhP8Zj+X6Cj4Fwv/8hfVQ587hjFsmsmjZQCLZ6ZfILD0BFFCMjUm3nU4QrhyUewBOvZLHLcFtC1y+c8KHV+o9xLmYUdPLAgMBAAECggEAAywuxBNb+FH4CRDtEx6r29auqbIjf6GtP+jSn7AOjLb1ZdYideFv/YmpvYYLKq0irUU9lWbqgLV2weMy1HdcPbhUWe8N7NIJfxX6HC9/Mb7gxa+K5vLzXcaqn19OQaLsOyZn3MN+HE/E24/uYfVde88b0M9AUfrALPYQUKjP+G/2u2cSnId+5aLHcqEPp93GMo34StPfyDAcN6DZR4b2VfoBmEEBf0wpCwKdSJL+FPJSVPrafJQB0QUcztoCzhxtEsLK4jK34UmCcp05AY/zkwFOu1qEv2FX82aIoQEYGiEIioYJsGS5S1PysT/IELpWCPtcSi3odJ2hnCWB8I2FeQKBgQC/6ir4Zj7wyEfvoXfxV9HWYUFAOjJxLko7r1oliQx7hC40ciKOjDLCpqYppeTlbanz3XU+AALyzS6MtUYuRuICvFpG8nMNPPKSFynpzyFGdCeWrLKcWaZ+B68NMLA4NRAjtE0cqwo3wyAEZdQEidOLFVCiN9L7Wl3S+pbhfRr2FwKBgQCx53Ec9k8AKC1nx8jZQcBsE+F+woyFk4+trh6bjSNn+F4t+4qpIZZ3tJpqC0bmfE2k06ACfg5vwpTalLPzx3mjqW4DEGwD0zd5iZnU2cYHkWRGfSNELXyE24D1bpGQLUPk5SsMDRB8iY6KvP2zmGv8UzsYMy2QaJHyMByWk9TUbQKBgQCoca35jDSePgv1pfGSoRQKaB5Pc0Um1gxNyqEC5QFRwDiVy7/NAfzjoEWjtHntbY2H/86R9oyf87txwQGySIDDCfLq5o5ZBi+aTj55e1Wncvf0Zev3EzDw2Wmp2BwzmU9rJyuvh+hV/Suy8HVg7mAAaVr2pqzF9RD4xv17OMVbTQKBgEeKHFBbM/WKMogTLM9Aw5IyhHEm5r8oUZSz+hbvMJe0ppqzFlVg7lMAyz9tfXtd7RMlDqkx67hBdP5Y4excAKwxi82rouP+4cX78WJImHuemcZGuBHIgNQkOL15Uwu5SB4Zka/s6P5Lioh760F3P6VeCtt2aRIzGs1bT4O1utYZAoGAZ5mkVPb5OrkSUrnBYRV45bOhrKNXLmLCN4oUYI2cNnME6AbGbvdUgLPMsJqmvwQ40sic1eCQai0I187gthxfV3DWKPb83kz75mGoTpsWlpdNPRXkpV5pb1VOrwWGNsEjXULzzMXjMwBiZpsXDeShKxAkysudGm7NDEmP2F63Dxo=";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthcodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		request.setCharacterEncoding("utf-8");
		String auth_code=new String(request.getParameter("authcode").getBytes(
				"utf-8"), "UTF-8");
		
		AlipayClient alipayClient = new DefaultAlipayClient("https://openapi.alipay.com/gateway.do", APP_ID, APP_PRIVATE_KEY, "json", "GBK", ALIPAY_PUBLIC_KEY, "RSA2");
		AlipaySystemOauthTokenRequest request1 = new AlipaySystemOauthTokenRequest();

		 request1.setCode(auth_code);

		 request1.setGrantType("authorization_code");

		 try {

		 AlipaySystemOauthTokenResponse oauthTokenResponse = alipayClient.execute(request1);

		 System.out.println(oauthTokenResponse.getAccessToken());
		 String AccessToken = oauthTokenResponse.getAccessToken();
		 String openid = oauthTokenResponse.getUserId();
		 
		 AlipayUserInfoShareRequest request2 = new AlipayUserInfoShareRequest();
		 AlipayUserInfoShareResponse response2 = alipayClient.execute(request2,AccessToken);

		 if(response2.isSuccess()){

		 System.out.println("调用成功");
		 String nickname = response2.getNickName();
		 String headimg = response2.getAvatar();
		 
		 response.setContentType("text/html;charset=UTF8");
			PrintWriter out = response.getWriter();
			System.out.println(openid);
			account ac=new accountDao().checkUserWX(openid);
			
			if (ac.getAid()!=0) {
				JSONArray ja = JSONArray.fromObject(ac);
				out.print(ja);
			} else {
				if(new accountDao().insertAccountWX(openid,headimg,nickname))
				{
					account acc=new accountDao().checkUserWX(openid);
					
					account accc=new accountDao().getOneAccountBYusername(openid);
					boolean flat1=new userDao().insertUser(accc.getAid());
					boolean flat2=new EduExpDao().insertEduexpWX(accc.getAid());
					boolean flat3=new teaexprienceDao().insertTeaexWX(accc.getAid());
					
					JSONArray ja = JSONArray.fromObject(acc);
					out.print(ja);
				}
				else
					out.print(0);
			}
			out.flush();
			out.close();
		 
		 } else {

		 System.out.println("调用失败");

		 }
		 
		 } catch (AlipayApiException e) {

		 //处理异常

		 e.printStackTrace();

		 }
		 
		
	}

}
