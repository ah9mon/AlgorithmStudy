#combination 라이브러리를 사용하면 조합을 알아서 계산해줌
#Counter 라이브러리 사용하면 조합의 알파벳 개수를 세어줌
#orders에서 하나씩 꺼내와서 course 길이로 조합을 짜서 temp에 넣어줌
#


from itertools import combinations
from collections import Counter


def solution(orders, course):
    answer = []
    
    for c in course:
        temp = []
        
        for order in orders:
            combi = combinations(sorted(order), c)
            temp += combi
            
        counter = Counter(temp)
        
        if len(counter) != 0 and max(counter.values()) != 1:  #2개 이상인 것들만 세어줌
            answer += [''.join(f) for f in counter if counter[f] == max(counter.values())]  #가장 많이 나온 조합이면 answer에 더해줌

    return sorted(answer)