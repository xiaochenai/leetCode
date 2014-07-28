class LRUCache:
#http://chaoren.is-programmer.com/posts/43116.html
#the collections.OrderedDict
#the elements inserted later is behind the elements inserted earlier
#
    # @param capacity, an integer
	def __init__(self, capacity):
		LRUCache.Dict = collections.OrderedDict()
		LRUCache.capacity = capacity
		LRUCache.numItems = 0

	# @return an integer
	#use try-exception
	#if key doesnt exist will trigger the exception---return -1
	#if key exist then move the element to the front
	def get(self, key):
		try:
			value = LRUCache.Dict[key]
			del LRUCache.Dict[key]
			LRUCache.Dict[key]=value
			return value
		except:
			return -1

	# @param key, an integer
	# @param value, an integer
	# @return nothing
	#if the key exist update the value and move it to the front
	#if the key doesnt exist:1.exceed the capacity then remove the last element and insert new element to the front 2. doesnt excedd the capacity then inser the element to the front
	def set(self, key, value):
		try:
			del LRUCache.Dict[key]
			LRUCache.Dict[key]=value
			return
		except:
			if LRUCache.numItems == LRUCache.capacity:
				LRUCache.Dict.popitem(last = False)
				LRUCache.numItems-=1
			LRUCache.Dict[key] = value
			LRUCache.numItems+=1
		return