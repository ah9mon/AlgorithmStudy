#초기코드
#몇개가 시간 초과 뜸
#def solution(ingredient):
#     answer = 0
#     Flag = True
#     while Flag == True:
#         Flag = False
#         if len(ingredient) > 3:
#             for i in range(len(ingredient)-3):
#                 if ingredient[i:i+4] == [1,2,3,1]:
#                     del ingredient[i:i+4]
#                     answer += 1
#                     Flag = True
#                     break
#         else:
#             break
#     return answer



#ingredient에서 하나씩 꺼내와서 임시 리스트에 담고 끝에 4개가  1234면 꺼내와서 pop
def solution(ingredient):
    s = []
    cnt = 0
    for i in ingredient:
        s.append(i)
        if s[-4:] == [1, 2, 3, 1]:
            cnt += 1
            for _ in range(4):
                s.pop()
    return cnt