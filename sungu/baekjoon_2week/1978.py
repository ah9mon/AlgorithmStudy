n = int(input())
arr = list(map(int, input().split()))
ans_cnt = 0 #소수 개수
for i in arr:
    cnt = 0 #약수 개수
    for j in range(1, i+1):
        if i % j == 0:
            cnt += 1
    if cnt == 2:
        ans_cnt += 1
print(ans_cnt)