package autoscan;

import java.util.Random;

import org.springframework.stereotype.Repository;

//저장소(DAO)역할을 부여하기 위한 어노테이션 사용.
@Repository
public class LottoDAO {

	public LottoDAO()  {
		System.out.println("LottoDAO생성자호출");
	}
	public int getLottoNumber() {
		//1~6사이의 난수를 생성하여 서비스객체로 반환한다.(DB작업이라 가정하자)
		Random rand = new Random();
		return rand.nextInt(6)+1;
	}
}
