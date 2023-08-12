while True: 
    n = input()
    if n == "0":  #0 나오면 종료
        break
    elif n == n[::-1]:  #거꾸로 읽었을 때
        print("yes")
    else:
        print("no")