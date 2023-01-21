package main

type MinStack struct {
	normalStack []int
	normalHead  int

	subStack []int
	subHead  int
}

func Constructor() MinStack {

	var minStack MinStack

	minStack.normalStack = make([]int, 30000)
	minStack.normalHead = -1

	minStack.subStack = make([]int, 30000)
	minStack.subHead = -1

	return minStack
}

func (this *MinStack) Push(val int) {
	this.normalHead++
	this.normalStack[this.normalHead] = val
	if this.subHead < 0 || val <= this.subStack[this.subHead] {
		this.subHead++
		this.subStack[this.subHead] = val
	}
}

func (this *MinStack) Pop() {
	normalPopped := this.normalStack[this.normalHead]
	this.normalHead--
	if this.subHead >= 0 && normalPopped == this.subStack[this.subHead] {
		this.subHead--
	}
}

func (this *MinStack) Top() int {
	return this.normalStack[this.normalHead]
}

func (this *MinStack) GetMin() int {
	return this.subStack[this.subHead]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
