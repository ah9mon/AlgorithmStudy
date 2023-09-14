import itertools
n, m = map(int, input().split())
card = list(map(int, input().split()))
nCr = list(itertools.combinations(card, 3)) #알아서 조합을 짜줌
arr = []
for i in range(len(nCr)):
    if sum(nCr[i]) == m:  #M이랑 같을 때가 최대이기 때문에 정답
        arr.append(m)
        break
    elif sum(nCr[i]) < m:
        arr.append(sum(nCr[i]))
print(max(arr))