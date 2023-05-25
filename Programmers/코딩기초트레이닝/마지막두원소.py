def solution(num_list):
    answer = num_list
    num = len(num_list)-1
    if num_list[num]>num_list[num-1]:
        answer.append(num_list[num]-num_list[num-1])
    else:
        answer.append(num_list[num]*2)
    return answer
  
  
  def solution(num_list):
    a= num_list[-1]
    b = num_list[-2]
    if a>b:
        num_list.append(a-b)
    else:
        num_list.append(a*2)
    return num_list
