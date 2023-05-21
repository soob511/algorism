def solution(num_list):
    answer =0
    mul=1
    sum =0
    for i in num_list:
        sum+=i
        mul *=i
    sum *=sum
    if sum>mul:
        answer = 1
        
    return answer
  
  
