package env;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class ConnectionVO 
		implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("afterPropertiesSet() 호출");		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("destroy() 호출");
	}
	
	//멤버변수
	private String userId;
	private String userPw;	
	
	//getter() / setter()
	public String getuserId() {
		return userId;
	}
	public void setuserId(String userId) {
		this.userId = userId;
	}
	public String getuserPw() {
		return userPw;
	}
	public void setuserPw(String userPw) {
		this.userPw = userPw;
	} 		
}
