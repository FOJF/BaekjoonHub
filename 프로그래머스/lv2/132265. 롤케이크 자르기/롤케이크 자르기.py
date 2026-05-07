from collections import Counter

def solution(topping):
    answer = 0
    
    older = set()
    younger = Counter(topping)
    
    for t in topping:
        older.add(t)
        younger[t] -= 1
        if younger[t] == 0:
            del younger[t]

        answer += len(younger) == len(older)
            
    return answer