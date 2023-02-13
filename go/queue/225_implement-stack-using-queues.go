package main

type MyQueue struct {
	queue []int
}

func MyQueueConstructor() MyQueue {
	var myQueue MyQueue
	myQueue.queue = []int{}
	return myQueue
}

func (this *MyQueue) Add(x int) {
	this.queue = append(this.queue, x)
}

func (this *MyQueue) Remove() int {
	res := this.queue[0]
	this.queue = this.queue[1:]
	return res
}

type MyStack struct {
	primary   MyQueue
	secondary MyQueue
	isPrimary bool
}

func Constructor() MyStack {
	var myStack MyStack
	myStack.primary = MyQueueConstructor()
	myStack.secondary = MyQueueConstructor()
	myStack.isPrimary = true
	return myStack
}

func (this *MyStack) GetCurrentQueue() *MyQueue {
	if this.isPrimary {
		return &this.primary
	}
	return &this.secondary
}

func (this *MyStack) Push(x int) {
	cq := this.GetCurrentQueue()
	cq.Add(x)
}

func (this *MyStack) Pop() int {
	var removeFrom *MyQueue
	var moveTo *MyQueue

	if this.isPrimary {
		removeFrom = &this.primary
		moveTo = &this.secondary
	} else {
		removeFrom = &this.secondary
		moveTo = &this.primary
	}

	for len(removeFrom.queue) > 1 {
		moveTo.queue = append(moveTo.queue, removeFrom.queue[0])
		removeFrom.queue = removeFrom.queue[1:]
	}

	res := removeFrom.queue[0]
	removeFrom.queue = removeFrom.queue[1:]
	this.isPrimary = !this.isPrimary

	return res
}

func (this *MyStack) Top() int {
	cq := this.GetCurrentQueue()
	return cq.queue[len(cq.queue)-1]
}

func (this *MyStack) Empty() bool {
	cq := this.GetCurrentQueue()
	if len(cq.queue) > 0 {
		return false
	}
	return true
}

/**
 * Your MyStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(x);
 * param_2 := obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.Empty();
 */
