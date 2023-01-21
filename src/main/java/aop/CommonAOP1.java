package aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class CommonAOP1 {
	
	public Object runTimeAOP(ProceedingJoinPoint jointPoint)
		throws Throwable{
		String joinSignStr = jointPoint.getSignature().toShortString();
		Object obj = null;
		
		System.out.println("핵심기능1 "+ joinSignStr +" 실행전");		
		long startTime = System.currentTimeMillis();
		
		try{
			obj = jointPoint.proceed();
		}
		catch(Exception e){
			System.out.println("핵심기능 실행중 예외발생");
			e.printStackTrace();
		}
		finally{
			long endTime = System.currentTimeMillis();
			System.out.println("핵심기능1 "+ joinSignStr +" 실행후");
			System.out.println(joinSignStr +" 실행시간 : "+
					(endTime-startTime));
			System.out.println();
		}
		
		return obj;
	}
}



