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
		int args2;
		String args3;
	}
	
	public static void main(String[] args) {
		
//		System.out.println(leftPad("123", 5, "00"));
//		System.out.println(leftPad(null, 5, "0"));
//		System.out.println(leftPad("123", 2, "0"));
		
		// 테스트 데이터 생성
		List<TestItem> testDataList = Arrays.asList(
			  new TestItem("00123", "123", 5, "0")
			, new TestItem("00123", "123", 5, "00")
			, new TestItem("00123", "123", 5, "000")
		);
		
		
		

		
		System.out.println("00123".equals(leftPad("123", 5, "0"))); //true
		System.out.println("00123".equals(leftPad("123", 5, "00")));
		System.out.println(leftPad("123", 5, "000"));
		System.out.println("00123".equals(leftPad("123", 5, "000")));
		System.out.println("00000".equals(leftPad(null, 5, "0")));  //true
		System.out.println("123".equals(leftPad("123", 2, "0")));	  //true
//		System.out.println("123".equals(leftPad("123", 2, "0")));
		
	}

	
	public static String leftPad(String str, int n, String padChar) {
		
		String result = StringUtils.defaultString(str, ""); 			 // 초기값 문자열 , null 처리
		int _체워야할_길이 = n - result.length();  // size - 문자열의 길이
			
		for (int i = 0; i < _체워야할_길이; i++) { 
			
			if (result.length() == n) { // 결과값의 길이가 size의 길이가 되면 빠져나가라
				break ;  
			}
			result = padChar+result ; // 추가할 문자열 + 문자열
			
		} 
		
		return result;					
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
