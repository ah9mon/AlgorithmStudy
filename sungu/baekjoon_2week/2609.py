a, b = map(int, input().split())

arr = []
for i in range(1, min(a,b) + 1):
    if a % i == 0 and b % i == 0:
        arr.append(i)

print(max(arr))
print(max(arr) * (a // max(arr)) * (b // max(arr)))