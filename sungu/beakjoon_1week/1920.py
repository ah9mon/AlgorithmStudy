#시간초과 나와서 set이용

n = int(input())
list_1 = set(list(map(int, input().split())))
m = int(input())
list_2 = list(map(int ,input().split()))
for i in list_2:
    if i not in list_1:
        print(0)
    else:
        print(1)