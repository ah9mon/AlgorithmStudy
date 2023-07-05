#처음에 쉽게 풀었으나 틀림, 이유는 k가 score의 크기보다 클 때의 반례가 존재. 
#두개의 경우로 나눠서 품. 
# 1)score가 k보다 큰 경우
# 2) k가 score보다 큰 경우 

def solution(k, score):
    answer = []
    arr = []
    if len(score) >= k: #score가 k보다 크면 k번까지는 그냥 그대로 입력 받고 정렬해서 제일 작은 값 빼내면 되고, 그 이후로는 임시 리스트에 값을 넣고 정렬하고 k번 째로 큰 수 빼내기
        for i in range(k):
            arr.append(score[i])
            arr.sort()
            answer.append(arr[0])
        for i in range(k, len(score)):
            arr.append(score[i])
            arr.sort()
            answer.append(arr[-k])
    else: #그냥 하나씩 계속 넣어가며 정렬하고 제일 작은 값 뺴면 됨
        for i in range(len(score)):
            arr.append(score[i])
            arr.sort()
            answer.append(arr[0])
            
    return answer