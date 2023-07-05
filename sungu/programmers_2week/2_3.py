#goal에서 하나씩 단어를 꺼내서 그 단어가 각 카드뭉치의 첫번 째 단어랑 일치하는지 비교하고, goal에 있는 단어들을 다 꺼냈을때까지 문제 없었다면 yes, 중간에 같은 단어가 안 나오면 no

def solution(cards1, cards2, goal):
    answer = "Yes"
    while goal:
        key = goal.pop(0)
        if cards1 and key == cards1[0]:
            cards1.pop(0)
        elif cards2 and key == cards2[0]:
            cards2.pop(0)
        else:
            answer = "No"
            break
    return answer