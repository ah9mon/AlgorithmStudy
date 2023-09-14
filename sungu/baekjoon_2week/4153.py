while True:
    num = list(map(int, input().split()))
    num.sort()
    if num[2] == 0 and num[1] == 0 and num[2] == 0:
        break
    elif (num[2] ** 2) == (num[1] ** 2) + (num[0] ** 2):
        print("right")
    else:
        print("wrong")