#include <string>
#include <vector>

using namespace std;

int solution(string s) {
	int length = s.length();
	int answer = length;
	 //가장 크게 자를 단위

	string* cutString = new string[length];//1개의 문자열로 나눴을 경우가 가장 많이 필요함

	string zip; // 압축

	for (int cutLength = length / 2; cutLength > 0; cutLength--) {//배열 분해를 반복
		
		int arraySize = length / cutLength + (length % cutLength != 0);//cutLength에 따른 사용하는 배열의 크기 계산
		int check = 1; // 반복횟수 체크
		zip.clear();

		//배열을 분해
		for (int i = 0; i < arraySize; i++) {
			if (i == arraySize - 1)
				cutString[i] = s.substr(i * cutLength);
			else
				cutString[i] = s.substr(i * cutLength, cutLength);
		}

		//분해한 것을 압축해봄
		for (int i = 0; i < arraySize; i++) {
			if (cutString[i] == cutString[i + 1])
				check++;
			else {
				if (check > 1)
					zip += to_string(check);
				zip += cutString[i];
				check = 1;
			}
		}
		
		//가장 짧게 압축된 문자열의 길이를 answer에 저장
		if (zip.length() < answer)
			answer = zip.length();
	}
	return answer;

}