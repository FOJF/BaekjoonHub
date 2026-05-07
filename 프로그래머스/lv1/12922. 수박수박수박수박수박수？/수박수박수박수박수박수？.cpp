#include <string>
#include <vector>

using namespace std;

string solution(int n) {
    string answer = "";
    for (int i = n/2; i > 0; i--) {
        answer += "수박";
    }
    if(n%2)
        answer += "수";
    return answer;
}