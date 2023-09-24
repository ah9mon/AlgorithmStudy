t = int(input())
dp = [0] * 101
dp[1] = 1
dp[2] = 1
dp[3] = 1
dp[4] = 2
dp[5] = 2
for _ in range(t):
    n = int(input())
    if n < 6:
        print(dp[n])
    else:
        for i in range(4, n+1):
            dp[i] = dp[i-2] + dp[i-3]
        print(dp[n])