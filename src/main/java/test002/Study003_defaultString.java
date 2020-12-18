package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Study003_defaultString {
	
	@Data
	@AllArgsConstructor
	public static class TestItem3 {
		
		String args1;
		String args2;
		String _기대_결과;
	}


	public static void main(String[] args) {
		//테스트는 여기서
		
		List<TestItem3> testDataList3 = Arrays.asList(
				  new TestItem3("te"    ,"test"   ,"test"   )
			    , new TestItem3("test"  ,null     ,"test"   )   //---------TODO CHECK str1이 null 일경우 test로 찍히게
				, new TestItem3(""	    ,"null"   ,""   	)
				, new TestItem3("test"  ,"null"   ,"test"	)
				, new TestItem3("null"  ,""       ,""     	)
//				, new TestItem3(""      ,""       ,null     )   //false
//				, new TestItem3(""      ,""       ,null     )   //false
		);
		String x = StringUtils.defaultString(null,"");
		System.out.println(x= "["+ x + "]");
		//defaultString 값 체크
		for (TestItem3 item : testDataList3) {	
			
			String result = defaultString(item.args1, item.args2);
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(String.format("equals(\"%s\", \"%s\") == %s ------------- %s", item.args1, item.args2, result, testResult));
				
		}
	}

//----------------------------------------------------------------------------------------------------------------------------------
	//defaultString 함수로 만들기
	//String x = StringUtils.defaultString(null,""); //널값처리하는 함수 널값을 빈값으로 만들어라

	//경우의 수 1. 원래의 값이 null이고 바꿀문자열에 "null"입력하면 결과값은 "null"
	//2. 원래의 값이 빈값인데 바꿀문자열에 null을 넣으면 그냥 빈값으로 처리
	//3. 원래의 값이 "abc"이고 바꿀문자열에 null을 넣으면 "abc"로 처리
	public static String defaultString(String str1, String str2) {

		if (str1 == null || str1 =="null" || str1 =="NULL") { //&& str2.equals("null")
			return str2;
		} else if (str2 == null || str2 == "null" || str2 == "NULL") {
			return str1;
		}

		str2.replace(str1, str2);

		return str2;
	}



}
