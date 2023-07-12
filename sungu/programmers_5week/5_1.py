#가격을 크게 하려면 혹시라도 개수가 부족하여 박스에 담기지 않고 버려지는 것들의 가격이 낮아야하니까 우선 score를 내림차순으로 정렬해둔다.
#상자에 담기려면 m으로 나누어 떨어져야하고, for문을 돌면서 cnt를 통해서 cnt가 m으로 나누어 떨어지는지 체크.
#나누어 떨어지면 상자에 담긴다는 뜻. 그럼 상자에서 가장 싼 사과 * m 해서 answer에 더해줌. 
#반복

def solution(k, m, score):
    answer = 0
    score.sort(reverse=True)  #내림차순 정렬
    cnt = 0
    arr = []  #사과들을 담을 상자
    for i in range(len(score)):
        arr.append(score[i])
        cnt += 1
        if cnt % m == 0:  #상자가 가득 찼다면
            value = (min(arr)) * m#상자에 담긴 사과들 중 가장 값 싼 사과 * m
            answer += value #answer에 더해줌
            arr = []  #새로운 상자로 초기화
    return answer