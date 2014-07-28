class Solution:
    # @param tokens, a list of string
    # @return an integer
    def evalRPN(self, tokens):
		stack = []
		for i in range(0,len(tokens)):
			if (tokens[i][0] == "-" and len(tokens[i])>1) or (tokens[i][0] >= "0" and tokens[i][0]<="9"):
				stack.append(int(tokens[i]))
				continue
			operator1 = stack.pop()
			operator2 = stack.pop()
			if tokens[i]=="+":
				stack.append(operator2+operator1)
			elif tokens[i]=="-":
				stack.append(operator2-operator1)
			elif tokens[i]=="*":
				stack.append(operator2*operator1)
			elif tokens[i]=="/":
				stack.append(int(operator2*1.0/operator1))
		return stack.pop()
s = Solution()
s.evalRPN(["10","6","9","3","+","-11","*","/","*","17","+","5","+"])