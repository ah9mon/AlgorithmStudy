n = int(input())
arr = []
for i in range(n+1):
    num = i
    lenth = len(str(i))
    for j in range(lenth):
        num = num + int(str(i)[j])
    if num == n:
        arr.append(i)
        break
if len(arr) == 0:
    print(0)
else:
    print(arr[0])