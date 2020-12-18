package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Study002_equals {

	@Data
	@AllArgsConstructor
	public static class TestItem2 {
		String args1;
		String args2;
		boolean _기대_결과;
	}

	public static void main(String[] args) {
		// 테스트 데이터 생성
		List<TestItem2> testDataList2 = Arrays.asList(
				  new TestItem2(null      , null     , true)       //true
				, new TestItem2("123"     , "124"    , false)   //false
			    , new TestItem2("ㅇㅇㅇㅇ","ㅇㅇㅇㅇ", true)    //true
				, new TestItem2("123"     , "123"    , true)	  //true
				, new TestItem2("123"     , null     , false)	  //false
				, new TestItem2(null      , "123"    , false)   //false
				, new TestItem2("123  "   ,"123 "    , false)   //false
				, new TestItem2(" 123"    ,"123 "    , false)    //false
				, new TestItem2(" 1 2 3 " , " 1 2 3 ", true)    //false
				, new TestItem2("ABC"     ,"abc"     , false)    //false -----------TODO CHECK
		);
		
		System.out.println("----[ equals1 테스트 ]--------------");

		//false만 출력할것
		for (TestItem2 item : testDataList2) {
			
			boolean result = equals1_1(item.args1, item.args2);
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(
					String.format("%-50s %s",
					String.format("equals(\"%s\", \"%s\") == %s", item.args1, item.args2, result), testResult));
		}
		System.out.println();
		
		System.out.println("----[ equals2 테스트 ]--------------");
		
		for (TestItem2 item : testDataList2) {
			
			boolean result = equals2(item.args1, item.args2);
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(
					String.format("%-50s %s",
					String.format("equals(\"%s\", \"%s\") == %s", item.args1, item.args2, result), testResult));
		}
		
		
	}
	
	// equals1() 만들기 - equals 를 java 기본 equals 사용
	// equals2() 만들기 - equals 를 java 기본 equals --> 이거 대신 .length() 와 .charAt 사용

	/**
	 * StringUtils.equals 비슷하게 만들어 보기 1탄 - String.equals 사용
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals1(String str1, String str2) {
		
		// StringUtils.equals(cs1, cs2)
		
		if ( str1 == null && str2 == null) {			//양쪽 다 null 일때 return true
			return true;
		} else if (str1 == null && str2 != null ) {
			return false;
		} else if (str1 != null && str2 == null) {		//한쪽이 null일 때 return false
			return false;
		} else if (str1.length() != str2.length()) {    //빈문자열이 존재하거나 서로의 길이가 다르면 false
			return false;
		} else if (str1.indexOf(" ") != str2.indexOf(" ")) {  //길이는 같으나 빈문자열의 위치가 다를경우 "  123" != "123  "
			return false;
		} else if (! str1.equals(str2)) { //equals 추가
			return false;
		}
//		if (Character.isUpperCase(str1.charAt(0)) == Character.isLowerCase(str2.charAt(0))) { //대소문자 다르면 false  
//			return false;
//		}

		return true;
	}
	
	
	/**
	 * StringUtils.equals 비슷하게 만들어 보기 1탄 - String.equals 사용 -- 전창훈 개선
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals1_1(String str1, String str2) {
		
		// StringUtils.equals(cs1, cs2)
		
		// 오류가 날만한건 미리 제외 // TODO CHECK :: 아래 두줄을 한줄로
//		if (str1 == null && str2 == null) return true;		//양쪽 다 null 일때 return true
//		if (str1 == null && str2 != null) return false;
		
		if (str1 == null) return (str2 == null) ? true : false;
		return str1.equals(str2);

	}

	
	/**
	 * StringUtils.equals 비슷하게 만들어 보기 2탄 - String.charAt 사용
	 * @param str1
	 * @param str2
	 * @return
	 */
	public static boolean equals2(String str1, String str2) {
		
		if ( str1 == null && str2 == null)    return true;
		if (str1 == null && str2 != null)     return false;
		if (str1 != null && str2 == null)     return false;
		if (str1.charAt(0) != str2.charAt(0)) return false;
		if (str1.length()-1 != str2.length()-1) return false;
		
		for (int i = 0; i < str1.length(); i++) {
			if (str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}

		return true;
	}






}
