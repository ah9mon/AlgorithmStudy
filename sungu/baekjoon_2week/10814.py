import sys
input = sys.stdin.readline

n = int(input())
arr = []

for i in range(n):
    age, name = map(str, input().split())
    age = int(age)
    arr.append((age), (name))

arr.sort(key = lambda x : x[0])

for i in arr:
    print(i[0], i[1])