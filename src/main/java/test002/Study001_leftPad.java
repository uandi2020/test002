package test002;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import lombok.AllArgsConstructor;
import lombok.Data;
import test002.Study004_rightPad.TestItem;

public class Study001_leftPad {

	//commonsUtil.leftPad("문자열","size","왼쪽에 추가할 문자열")

	@Data
	@AllArgsConstructor
	public static class TestItem {
		String _기대_결과;
		String args1;
		public int args2;
		String args3;
	}



	public static void main(String[] args) {
		// 테스트 데이터 생성
		List<TestItem> testDataList = Arrays.asList(
			  new TestItem("00123", "123", 5, "0")
			, new TestItem("00123", "123", 5, "00")
			, new TestItem("00123", "123", 5, "000")
			, new TestItem("0대한민국", "대한민국", 5, "00")
		);

		for (TestItem item : testDataList) {
			//false만 출력할것
			String result = leftPad(item.args1, item.args2, item.args3);
			//System.out.println
			String testResult = item._기대_결과 == result ? "OK" : "!!!!!!!오류!!!!!";
			System.out.println(item._기대_결과 +","+result );
			if (item._기대_결과 != result) {
				System.out.println("?");
			}
			System.out.println(String.format("leftPad(\"%s\", \"%s\" , \"%s\" ) == %s ------------- %s", item.args1, item.args2, item.args3, result, testResult));
		}

		




	}

	//여러가지 경우의 수를 생각하자
	public static String leftPad(String str, int size, String padString) {

		//System.out.println(String.format("str = %s, size = %s, padString = %s", str, size, padString));

		String result = StringUtils.defaultString(str, ""); 			 // 초기값 문자열 , null 처리
		//int _체워야할_길이 = n - result.length();  // size - 문자열의 길이


		if (str.length() == size) {  //str의 길이가 size과 같을 경우 str을 리턴 (가장 단순한 경우)
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

//		for (int i = 0; i < _체워야할_길이; i++) {                     //첫번째로 한것
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

}
