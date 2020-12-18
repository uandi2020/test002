package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Study005_contains {

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
			    , new TestItem2("ㅇㅇㅇㅇ","ㅇㅇㅇㅇ", true)    //true
				, new TestItem2("123"     , "123"    , true)	  //true
				, new TestItem2("123"     , null     , false)	  //false
				, new TestItem2(null      , "123"    , false)   //false
				, new TestItem2("123  "   ,"123 "    , false)   //false
				, new TestItem2(" 123"    ,"123 "    , false)    //false
				, new TestItem2(" 1 2 3 " , " 1 2 3 ", true)    //false
				, new TestItem2("ABC"     ,"abc"     , false)    //false -----------TODO CHECK
		);

		//false만 출력할것
		for (TestItem2 item : testDataList2) {
			
			boolean result = contains(item.args1, item.args2);
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(String.format("equals(\"%s\", \"%s\") == %s ------------- %s", item.args1, item.args2, result, testResult));
		}
		
		
	}


	public static boolean contains(String str1, String str2) {

		
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

		return true;
	}

	






}
