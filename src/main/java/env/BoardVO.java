package env;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

public class BoardVO implements InitializingBean, DisposableBean{

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BoardVO => afterPropertiesSet() 호출됨");		
	}
	@Override
	public void destroy() throws Exception {
		System.out.println("BoardVO => destroy() 호출됨");
	}
	
	//멤버변수
	private String pageSize;
	private String blockSize;
		
	//getter()/setter() 
	public String getPageSize() {
		return pageSize;
	}
	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}
	public String getBlockSize() {
		return blockSize;
	}
	public void setBlockSize(String blockSize) {
		this.blockSize = blockSize;
	}
}


