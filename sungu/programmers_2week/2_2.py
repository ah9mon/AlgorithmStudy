#targets에서 구해야 할 단어 가져오고, 단어의 알바펫 하나하나씩 값을 구한다.
#해당 알파벳이 keymap에 있는 원소들에서 각자 값을 얼마나 주는지 비교해서 최솟값으로 저장
#마지막에 합산

def solution(keymap, targets):
    answer = []
    
    for key in targets: #단어 하나 꺼내오기
        key_ans = []
        for i in key: #단어의 알파벳 하나씩 꺼내기
            arr = []
            for j in keymap:  #각 원소와 전부 비교해야하기 때문에 하나씩 keymap에서 꺼낸다
                if i in j:  #해당 원소 안에 알파벳이 있다면,
                    arr.append(j.find(i)+1) #원소에서 몇의 값을 주는 지 계산(내장함수 find를 사용하여 몇번째 위치인지 확인)
            if len(arr) != 0: #리스트가 비어있지 않다는 말은, 해당 원소에서 값을 얻었다는 의미
                key_ans.append(min(arr))  #각 원소들과 비교해서 얻은 값들을 비교하여 가장 작은 값 하나 리스트에 저장
            else: #리스트에 값이 없다면, 각 원소와 비교했을 때 얻을 수 있는 값이 없다는 말
                key_ans.append(-1)  #-1을 출력해야함
        if -1 in key_ans: #
            key_ans.clear()
            key_ans.append(-1)
        answer.append(sum(key_ans))
    return answer