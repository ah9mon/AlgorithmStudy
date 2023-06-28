def solution(s):
    
    if len(s)==1: #문자열 길이가 1이면 정답은 무조건 1
        return 1
    
    answer=[] #자른 길이마다의 문자열 길이
    
    for i in range(1, len(s)+1):  #자를 길이 차례대로 for문
        ans = ''  #문자를 이어 붙임
        cnt = 1 
        cur=s[:i] #첫 단위

        for j in range(i, len(s)+i, i): #처음부터 끝까지 i 단위로 나눠서 끊음
            
            if cur==s[j : i+j]: #앞이랑 중복이면 계수로 만들어야함
                cnt+=1
            else:
                if cnt!=1:
                    ans = ans + str(cnt)+cur
                else:
                    ans = ans + cur
                    
                cur=s[j : j+i]
                cnt = 1
                
        answer.append(len(ans))
        

    return min(answer)