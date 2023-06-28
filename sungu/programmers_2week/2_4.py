def solution(s, skip, index):
    answer = ''
    alphabet = "abcdefghijklmnopqrstuvwxyz"
    for i in skip:  #전체 알파벳에서 skip에 있는 단어들을 빼줌
        alphabet = alphabet.replace(i, "")
    for i in s: 
        pos = alphabet.find(i) + index  #해당 알파벳의 위치 + index
        if pos >= len(alphabet):  #현 위치가 전체 알파벳 길이를 넘으면 처음으로 돌아가야 함
            pos = pos - len(alphabet)  #위치에서 전체 길이 빼주면 다시 앞부터 시작
            answer += alphabet[pos] 
        else:
            answer += alphabet[pos]
    return answer