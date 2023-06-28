def solution(s):
    answer = [] #최종 정답
    alphabet = [] #지금까지 알파벳이 있나 확인 하기 위한 리스트
    for i in range(0,len(s)):
        if s[i] in alphabet:  #이전에 알파벳이 나왔었으면
            tmp = []
            for j in range(len(alphabet)):   
                if alphabet[j] == s[i]: #알파벳 리스트에서 어디 어디 자리에 있었는지 확인
                    tmp.append(j) #각 위치를 tmp리스트에 담아주고
            answer.append(i - max(tmp)) #둘의 거리 차이 정답 리스트에 저장
            alphabet.append(s[i])
        else: #안 나왔었으면
            alphabet.append(s[i]) #알파벳 리스트에 추가
            answer.append(-1) #정답에 -1 추가
    return answer