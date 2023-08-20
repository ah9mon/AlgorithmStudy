n = int(input())

for _ in range(n):
    stack = []
    a = input()
    for i in a:
        if i == "(":
            stack.append(i)
        elif i == ")":
            if stack:
                stack.pop()
            else:
                print("NO")
                break
    else: #break 되지 않았다면
        if not stack:
          print("YES")
        else:
          print("NO")