package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Study001_leftPad {
	
	//commonsUtil.leftPad("문자열","size","왼쪽에 추가할 문자열")
	public static void main2(String[] args) {
		
		System.out.println(StringUtils.leftPad("wwwww2", 6, " "));

		System.out.println(leftPad("8",2," "));
		
		String result = "str";
		int temp = 4 - result.length();
		System.out.println(result.length()+"ddd");
		for (int i=0; i<temp; i++) {
			result = result+" ";
		}
			
		
		for (int i=2; i<=9; i++) {
			System.out.println("----------------");
			System.out.println("       " + i + "단          ");
			System.out.println("----------------");
			for(int j=1; j<=9; j++) {
				int result2 = i * j;
				System.out.println(i + "X" + j + "=" + leftPad(""+result2, 2, " "));
			}
		}
	}
	
	@Data
	@AllArgsConstructor
	public static class TestItem {
		String result;
		String args1;
		public int args2;
		String args3;
	}
	
	public static void main(String[] args) {
		
		
//		StringUtils.equals(cs1, cs2);
		
		
//		System.out.println(leftPad("123", 5, "00"));
//		System.out.println(leftPad(null, 5, "0"));
//		System.out.println(leftPad("123", 2, "0"));
		
		// 테스트 데이터 생성
		List<TestItem> testDataList = Arrays.asList(
			  new TestItem("00123", "123", 5, "0")
			, new TestItem("00123", "123", 5, "00")
			, new TestItem("00123", "123", 5, "000")
		);
		
		for (TestItem item : testDataList) {
			
			//값이 false 인것만 출력
			String result = leftPad(item.args1, item.args2, item.args3);
			if (! item.result.equals(result)) {
				System.out.println("거짓 =" + item + "결과 값 =" + result) ; 
			} 
			
			
		}
		
		//해야할것
		
		//defaultString 함수로 만들기
		//StringUtils.equals(cs1, cs2); 함수로 만들기
		
		
		// 테스트 데이터 System.out.println(leftPad(null, 5, "0"));
		// 테스트 데이터 System.out.println("00123".equals(leftPad("123", 5, null)));

		
		System.out.println("00123".equals(leftPad("123", 5, "0"))); //true
		System.out.println("00123".equals(leftPad("123", 5, "00")));
//		System.out.println(leftPad("123", 5, "000"));
		System.out.println("00123".equals(leftPad("123", 5, "000")));
		System.out.println("00123".equals(leftPad("123", 5, "0000")));
		System.out.println("0000012".equals(leftPad("12", 7, "00")));
//		System.out.println("00000".equals(leftPad(null, 5, "0")));  //true
//		System.out.println("123".equals(leftPad("123", 2, "0")));	  // true
		
	}

	//여러가지 경우의 수를 생각하자
	public static String leftPad(String str, int size, String padString) {
		
		System.out.println(String.format("str = %s, size = %s, padString = %s", str, size, padString));
		
		String result = StringUtils.defaultString(str, ""); 			 // 초기값 문자열 , null 처리
		//int _체워야할_길이 = n - result.length();  // size - 문자열의 길이
		
		
		if (str.length() == size) {  //str의 길이가 n과 같을 경우 str을 리턴 (가장 단순한 경우)
			//우선순위 1.str이 null일 경우 빈 문자열로 처리하기
				return str;

		} else if (str.length() > size) { //str의 길이가 n보다 클 때 n개만큼만 잘라서 리턴 
			return str.substring(0,size);
		} else {							           // leftPad 적용사례 
//			int _체워야할_길이 = size - result.length();  // size - 문자열의 길이
//			String _결과값 = "";
//			int x = _체워야할_길이 % padString.length(); //잘리는 길이 (나머지)
//			int y = _체워야할_길이 / padString.length(); //반복되는 횟수
//			
//			for (int i = 0; i < y; i++) {
//				_결과값 += padString; // leftPad  
//			}
//			_결과값 += padString.substring(0,x); 
//			_결과값 += str;
//			return _결과값;
			
			int _체워야할_길이 = size - result.length();  // size - 문자열의 길이
			int addCount = (int)Math.ceil((double)_체워야할_길이 / padString.length()); //반복되는 횟수 2 /3 = 
			return padString.repeat(addCount).substring(0,_체워야할_길이) + str;
			
		}
				
//		for (int i = 0; i < _체워야할_길이; i++) { 
//			
//			if (result.length() == n) { // 결과값의 길이가 size의 길이가 되면 빠져나가라
//				break ;  
//			} else if ( result.length() > n) {
//				System.out.println(result+"dd");
//				//padChar = padChar.substring(0, padChar.length()-1);
//				break ;
//			}
//			result = padChar+result ; // 추가할 문자열 + 문자열
//			
//		} 
//		
//		return result;					
	}
	
	public static String rightPad(String str, int n, String padChar) {
		String result = str;
		int temp = n - result.length();
		for (int i=0; i<temp; i++) {
			result = result+padChar;
		}
		return result;
	}
}
