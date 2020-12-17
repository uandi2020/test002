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

	@Data
	@AllArgsConstructor
	public static class TestItem2 {
		String args1;
		String args2;
	}

	@Data
	@AllArgsConstructor
	public static class TestItem3 {
		String result;
		String args1;
		String args2;
	}


	public static void main(String[] args) {
		// 테스트 데이터 생성
		List<TestItem> testDataList = Arrays.asList(
			  new TestItem("00123", "123", 5, "0")
			, new TestItem("00123", "123", 5, "00")
			, new TestItem("00123", "123", 5, "000")
		);

//		for (TestItem item : testDataList) {
//			//false만 출력할것
//			String result = leftPad(item.args1, item.args2, item.args3);
//			if (! item.result.equals(result)) {
//				System.out.println("거짓 =" + item + "결과 값 =" + result) ;
//			}
//		}

		List<TestItem2> testDataList2 = Arrays.asList(
				  new TestItem2(null, null)       //true
			    , new TestItem2("ㅇㅇㅇㅇ","ㅇㅇㅇㅇ")    //true
				, new TestItem2("123", "123")	  //true
				, new TestItem2("123", null)	  //false
				, new TestItem2(null, "123")      //false
				, new TestItem2("123  ","123 ")   //false
				, new TestItem2(" 123","123 ")    //false
				, new TestItem2(" 1 2 3 ", " 1 2 3 ")    //false
				, new TestItem2("ABC","abc")    //false
		);

		//false만 출력할것
//		for (TestItem2 item : testDataList2) {
//			boolean result = equals(item.args1, item.args2);
//			if (result != true) {
//				System.out.println(" 결과 = " + result + ", 결과 값 = " +item);
//			}
//		}
		String x = StringUtils.defaultString(null,"");
		List<TestItem3> testDataList3 = Arrays.asList(
				  new TestItem3("test","test",null)
			    , new TestItem3("test",null,"test")   //---------TODO CHECK str1이 null 일경우 test로 찍히게
				, new TestItem3(null,"","null")
//				, new TestItem3("","",null)
//				, new TestItem3("","",null)	  //false
//				, new TestItem3("","",null)      //false
//				, new TestItem3("","",null)   //false
		);



		//defaultString 값 체크
		for (TestItem3 item : testDataList3) {
			String result = defaultString(item.args1, item.args2);
				System.out.println(" 결과 = " + result + ", 결과 값 = " +item);

		}



//---------------------------------------------------------------------------------------------------------------------------
//
//		System.out.println(a+" default test");
		// 테스트 데이터 System.out.println(leftPad(null, 5, "0"));
		// 테스트 데이터 System.out.println("00123".equals(leftPad("123", 5, null)));

		//leftPad 테스트
//		System.out.println("00123".equals(leftPad("123", 5, "0"))); //true
//		System.out.println("00123".equals(leftPad("123", 5, "00")));
//		System.out.println(leftPad("123", 5, "000"));
//		System.out.println("00123".equals(leftPad("123", 5, "000")));
//		System.out.println("00123".equals(leftPad("123", 5, "0000")));
//		System.out.println("0000012".equals(leftPad("12", 7, "00")));
//		System.out.println("00000".equals(leftPad(null, 5, "0")));  //true
//		System.out.println("123".equals(leftPad("123", 2, "0")));	// true


		//equals 테스트
//		System.out.println(equals(null, null));	//true
//		System.out.println(equals(null,"000")); //false
//		System.out.println(equals("00",null));  //false
//		System.out.println(equals("000  ","000")); //false 공백이 있을 경우
//		System.out.println(equals(null, null)); //true
//		System.out.println("같음"+equals("test","test"));			//ture
//		System.out.println("같음"+equals("ㅇㅇㅇㅇ","ㅇㅇㅇㅇ"));  //true
//		System.out.println("abc_1111111"+equals("ABC","abc")); //false
//		System.out.println(equals(null, null)); //true
//		System.out.println(equals(" 1 2 3 ", " 1 2 3 ")); //false


		//defaultString 테스트
//		String a = defaultString("",null);
//		System.out.println("테스트 1=" + defaultString(null,"NULL")); // null
//		System.out.println("테스트 2=" + defaultString("",null));	  // ""
//		System.out.println("테스트 3=" + defaultString("test1111","null"));	  //test1111
//
//		String test = StringUtils.defaultString(null,"null");
//		System.out.println(test+"zzzzzzzzzzzzzz");
	}

//----------------------------------------------------------------------------------------------------------------------------------
	//defaultString 함수로 만들기
	String x = StringUtils.defaultString(null,""); //널값처리하는 함수 널값을 빈값으로 만들어라




	//경우의 수 1. 원래의 값이 null이고 바꿀문자열에 "null"입력하면 결과값은 "null"
	//2. 원래의 값이 빈값인데 바꿀문자열에 null을 넣으면 그냥 빈값으로 처리
	//3. 원래의 값이 "abc"이고 바꿀문자열에 null을 넣으면 "abc"로 처리
	public static String defaultString(String str1, String str2) {

		if (str1 == null ) { //&& str2.equals("null")
			return str2;
		} else if (str2 == null || str2 == "null" || str2 == "NULL") {
			return str1;
		}

		str2.replace(str1, str2);


		return str2;
	}



	public static boolean equals(String str1, String str2) {

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
		}
//		if (Character.isUpperCase(str1.charAt(0)) == Character.isLowerCase(str2.charAt(0))) { //대소문자 다르면 false     이렇게 코딩하면 대소문자 영어는 false 지만 한글, 숫자가 같으면 true 여야 하는데 같지 않다고 뜸
//			return false;
//		}

		return true;
	}



//	public static boolean isEmpty(String str) {
//		//null값일 경우 "";로
//		//""값일 경우 ""로
//		//기본값을 "str"로 설정했을 때 "str"로
//		if (str == null) {
//			return true;
//		}
//		if (str == "") {
//			return true;
//		}
//
//		if ((str instanceof Object) && (((String)str).trim().length() == 0)) {
//			return true;
//		}
//
//		return false;
//	}




	//여러가지 경우의 수를 생각하자
	public static String leftPad(String str, int size, String padString) {

		//System.out.println(String.format("str = %s, size = %s, padString = %s", str, size, padString));

		String result = defaultString(str, ""); 			 // 초기값 문자열 , null 처리
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
