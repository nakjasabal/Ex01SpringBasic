package common;

import java.util.Random;

public class LottoCreater {
	
	//난수 생성을 위한 객체 생성
	Random rnd = new Random();
	
	//6개의 중복되지 않는 난수를 생성하여 배열에 저장한다. 
	public void randomCreate(int[] arrParam) {
		//Random객체에 씨드를 설정한다. 항상 다른 패턴의 난수를 생성하기 위해 사용한다.
		rnd.setSeed(System.currentTimeMillis());
		//무한루프 조건으로 while문 구성
		while(true) {
			//일단 6개의 난수를 생성한다. 이때 중복된 난수가 배열에 삽입될 수 있다.
			for(int i=0 ; i<arrParam.length ; i++) {
				//1~45사이의 난수를 생성하여 배열의 i번째 원소에 삽입한다.
				arrParam[i] = rnd.nextInt(45) + 1;
			}
			boolean rndFlag = false;
			//배열에 중복된 숫자가 있는지 검사한다. 
			for(int i=0 ; i<6 ; i++) {
				for(int j=0 ; j<6 ; j++) {
					/*
					배열의 크기만큼 반복하되 동일한 인덱스가 아닌 경우에만 비교한다. 
					만약 같은 숫자가 발견되면 rndFlag를 true로 변경한다. 
					이경우 rndFlag를 true로 유지하기 위해 else구문은 별도로 만들지 않는다.
					 */
					if(i!=j && arrParam[i]==arrParam[j]) {
						rndFlag = true;
					}
				}
			}
			//플레그 변수가 false면 반복문을 탈출한다. true인 경우에는 처음으로 다시 돌아간다.
			if(rndFlag==false) break;
		}
	} 
	//버블정렬을 통해 오름차순으로 정렬한다. 
	public static void bubbleSort(int[] arrParam) {
		int temp;
		for(int i=0 ; i<arrParam.length-1 ; i++) {
			for(int j=0 ; j<(arrParam.length-1)-i ; j++) {
				/*
				배열의 원소중에서 j번째와 j+1번째 원소를 비교해서 큰 숫자가 
				발견되면 자리를 바꿔준다. 그래서 큰 숫자를 지속적으로 뒤로 밀어준다. 
				 */
				if(arrParam[j] > arrParam[j+1]) {
					temp = arrParam[j];
					arrParam[j] = arrParam[j+1];
					arrParam[j+1] = temp;
				}
			}
		}
	}	
	//난수생성에 관련된 기능을 "캡슐화"해놓은 메서드
	public int[] lotto() {
		//크기가 6인 배열생성
		int[] arr = new int[6];
		//중복되지 않는 난수 생성
		randomCreate(arr);	
		//오름차순 정렬
		bubbleSort(arr);
		//배열의 참조값 반환
		return arr;
	}
}
