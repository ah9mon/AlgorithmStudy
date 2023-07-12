#앞에서부터 for문 돌면서 cnt1, cnt2 값을 비교해가면서, 값이 같으면 포인터를 뒤로 보내고 다시 똑같이 진행

def solution(s):
    answer = 0
    cnt1 = 0  #같은 알파벳
    cnt2 = 0  #다른 알파벳들
    for i in s:
        if cnt1 == cnt2: 
            answer += 1
            key = i #새로운 포인터를 설정함
        if i == key:  #같으면 cnt1에 저장
            cnt1 += 1
        else:
            cnt2 += 1
    return answer