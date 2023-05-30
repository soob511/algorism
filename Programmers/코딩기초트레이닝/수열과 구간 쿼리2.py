def solution(arr, queries):
    answer = []
    for s,e,k in queries:
        num = 1000000
        for i in range(s,e+1):
            if k<arr[i]:
                num = min(arr[i],num)
        if(num==1000000):answer.append(-1)
        else:answer.append(num)
    return answer
  
  

def solution(arr, queries):
    answer = []
    for s, e, k in queries:
        tmp = []
        for x in arr[s:e+1]:
            if x > k:
                tmp.append(x)
        answer.append(-1 if not tmp else min(tmp))
    return answer
  
  
