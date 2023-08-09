n = int(input())
arr = list(map(int, input().split()))
m = max(arr)
value = []
for i in arr:
    max_value = i / m * 100 
    value.append(max_value)

ans = (sum(value) / n)    
print(ans)