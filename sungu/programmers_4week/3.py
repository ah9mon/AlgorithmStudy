#문제 금방 풀고 제출했으나 시간초과뜸,,,,,,약수 개수 구하는 과정에서 시간이 오래 걸리나봄, 약수의 개수 구하기 구글링 해보니까, 약수의 개수 시간줄여서 구하는 꿀팁이 있었음.


def solution(number, limit, power):
    arr = [1] #1은 무조건 1개니까 1넣고 2부터 시작           
    for i in range(2, number+1):            
        cnt = 0
        for j in range(1, int(i**(1/2)) + 1): #제곱근을 구하고 제곱근까지만 약수로 구하고 몫까지 포함
            if i % j == 0:  #약수이면 cnt +1
                cnt += 1
                if j**2 != i: #약수가 제곱근이면 1개니까 제외하고, 제곱근이 아니면 cnt +1 한 번 더           
                    cnt += 1
            if cnt > limit: #약수 개수가 limit보다 크면 power 값으로 변경           
                cnt = power
                break
        arr.append(cnt)
    return sum(arr)