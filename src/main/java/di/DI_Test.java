package di;

class Persons {
	String name;
	int age;
	
	public Persons() {
		System.out.println("public 생성자");
	}
//	private Persons() {
//		System.out.println("private 생성자");
//	}
}
public class DI_Test {

	/*
	강한결합(독립성낮음) : new를 통해 직접 객체를 생성한다. 
		결합도가 높기때문에 person클래스의 변환에 직접적인 영향을 받는다. 
	 */
	public static void aPerson() {
		//생성자가 private이 되는 순간 에러가 발생한다. 
		Persons persons1 = new Persons();
		persons1.age = 11;
		persons1.name = "성유겸";
	}
	/*
	약한결합(독립성높음) : 미리 생성된 객체를 주입(Injection)받아 사용한다. 
		결합도가 낮아지기 때문에 Persons클래스에 변화가 생기더라도 직접적인
		영향을 받지않는다. 또한 코드도 간결해진다. 
	 */
	public static void bPerson(Persons person2) {
		person2.age = 11;
		person2.name = "성유겸";
	}
}
