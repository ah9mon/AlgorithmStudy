#for문을 거꾸로 돌면서 answer "0"에 안쪽부터 붙인다

def solution(food):
    answer = '0'
    for i in range(len(food)-1, 0, -1):
        lenth = food[i] // 2    #양쪽에 다 붙여야하니까 2의 배수여야함
        answer = str(lenth* str(i)) + answer + str(lenth* str(i))
    return answer