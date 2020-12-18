package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Study004_rightPad {

	//commonsUtil.leftPad("문자열","size","왼쪽에 추가할 문자열")

	@Data
	@AllArgsConstructor
	public static class TestItem {
		String args1;
		public int args2;
		String args3;
		String _기대_결과;
	}



	public static void main(String[] args) {
		// 테스트 데이터 생성
		List<TestItem> testDataList = Arrays.asList(
			  new TestItem("123", 5, "0" , "12300")
			, new TestItem("123", 5, "00" , "12300")
			, new TestItem("123", 5, "000", "12300")
		);

		for (TestItem item : testDataList) {
			//false만 출력할것
			String result = rightPad(item.args1, item.args2, item.args3);
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(String.format("rightPad(\"%s\", \"%s\" , \"%s\" ) == %s ------------- %s", item.args1, item.args2, item.args3, result, testResult));
		}

	}

	//여러가지 경우의 수를 생각하자
	public static String rightPad(String str, int size, String padString) {

		//System.out.println(String.format("str = %s, size = %s, padString = %s", str, size, padString));

		String result = StringUtils.defaultString(str, ""); 			 // 초기값 문자열 , null 처리
		//int _체워야할_길이 = n - result.length();  // size - 문자열의 길이


		if (str.length() == size) {  //str의 길이가 n과 같을 경우 str을 리턴 (가장 단순한 경우)
			return str;

		} else if (str.length() > size) { //str의 길이가 n보다 클 때 n개만큼만 잘라서 리턴
			return str.substring(0,size);
		} else {							           
			
			int _체워야할_길이 = size - result.length();  // size - 문자열의 길이
			int addCount = (int)Math.ceil((double)_체워야할_길이 / padString.length()); //반복되는 횟수 2 /3 =
			
			return str+padString.repeat(addCount).substring(0,_체워야할_길이);

		}
	}

	
}
