class Solution:
    # @return a float
    def findMedianSortedArrays(self, A, B):
		LenOA = len(A);LenOB=len(B);totalLen = LenOA+LenOB
		if totalLen%2 == 0:odd = False
		else:odd = True
		indexOA = 0
		indexOB = 0
		curr = []
		if odd:
			while len(curr)<totalLen/2+1 and indexOA<LenOA and indexOB<LenOB:
				if A[indexOA]<=B[indexOB]:
					curr.append(A[indexOA])
					indexOA = indexOA + 1
				else:
					curr.append(B[indexOB])
					indexOB = indexOB + 1
			if indexOA == LenOA:
				while len(curr)<totalLen/2+1:
					curr.append(B[indexOB])
					indexOB = indexOB + 1
			if indexOB == LenOB:
				while len(curr)<totalLen/2+1:
					curr.append(A[indexOA])
					indexOA = indexOA + 1
			return float(curr.pop())
		else:
			while len(curr)<totalLen/2+1 and indexOA<LenOA and indexOB<LenOB:
				if A[indexOA]<=B[indexOB]:
					curr.append(A[indexOA])
					indexOA = indexOA + 1
				else:
					curr.append(B[indexOB])
					indexOB = indexOB + 1
			if indexOA == LenOA:
				while len(curr)<totalLen/2+1:
					curr.append(B[indexOB])
					indexOB = indexOB + 1
			if indexOB == LenOB:
				while len(curr)<totalLen/2+1:
					curr.append(A[indexOA])
					indexOA = indexOA + 1
			return (float(curr.pop())/2 + float(curr.pop())/2)
			
			
class Solution:
    # @return a float
     
    def getMedian(self, A, B, k):
        # return kth smallest number of arrays A and B, assume len(A) <= len(B)
        lenA = len(A); lenB = len(B)
        if lenA > lenB: return self.getMedian(B, A, k)
        if lenA == 0: return B[k-1]
        if k == 1: return min(A[0], B[0])
        pa = min(k/2, lenA); pb = k - pa
        return self.getMedian(A[pa:], B, k - pa) if A[pa - 1] <= B[pb - 1] else self.getMedian(A, B[pb:], k - pb)
     
    def findMedianSortedArrays(self, A, B):
        lenA = len(A); lenB = len(B)
        if (lenA + lenB) % 2 == 1: 
            return self.getMedian(A, B, (lenA + lenB) / 2 + 1)
        else:
            return 0.5 * ( self.getMedian(A, B, (lenA + lenB) / 2) + self.getMedian(A, B, (lenA + lenB) / 2 + 1) )
# class Solution:
    # # @return a float
    # def findMedianSortedArrays(self, A, B):
		# LenOA = len(A);LenOB=len(B);totalLen = LenOA+LenOB
		# if totalLen%2 == 0:odd = False
		# else:odd = True
		# i=0
		# curr=0
		# indexOA=0
		# indexOB=0
		# while (indexOA+indexOB)<totalLen/2 and indexOA < LenOA and indexOB<LenOB:
			# if A[indexOA] < B[indexOB]:
				# indexOA = indexOA + 1
			# else:
				# indexOB = indexOB + 1
		# if odd:
			# if indexOA + indexOB < totalLen/2:
				# if indexOA == LenOA:
					# while (indexOA+indexOB)<totalLen/2 :
						# indexOB = indexOB + 1
					# return float(B[indexOB])
				# if indexOB == LenOB:
					# while (indexOA+indexOB)<totalLen/2 :
						# indexOA = indexOA + 1
					# return float(A[indexOA])
			# else:
				# if LenOA == indexOA:
					# return float(B[indexOB])
				# if LenOB == indexOB:
					# return float(A[indexOA])
				# return float(A[indexOA]) if A[indexOA]<=B[indexOB] else float(B[indexOB])
		# else:
			# a1 = 0
			# if indexOA + indexOB < totalLen/2:
				# if indexOA==LenOA:
					# while (indexOA+indexOB)<totalLen/2 :
						# indexOB = indexOB + 1
					# return float(B[indexOB])/2+float(B[indexOB-1])/2
				# if indexOB == LenOB:
					# while (indexOA+indexOB)<totalLen/2 :
						# indexOA = indexOA + 1
					# return float(A[indexOA])/2+float(A[indexOA-1])/2
			# else:
				# for i in xrange(2):
					# if indexOA == LenOA:
						# return float(B[indexOB])/2 + float(A[indexOA-1])/2
					# if indexOB == LenOB:
						# return float(A[indexOA])/2 + float(B[indexOB-1])/2
					# if A[indexOA] <= B[indexOB]:
						# a1 = float(A[indexOA])/2 + a1
						# indexOA = indexOA + 1
					# else:
						# a1 = float(B[indexOB])/2 + a1
						# indexOB = indexOB + 1
			# return a1