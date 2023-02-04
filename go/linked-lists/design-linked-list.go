package main

type MyLinkedList struct {
	left  *DLLNode
	right *DLLNode
}

// DLLNode = Doubly Linked List Node
type DLLNode struct {
	value int
	prev  *DLLNode
	next  *DLLNode
}

func MyLinkedListConstructor() MyLinkedList {
	list := MyLinkedList{}

	left := &DLLNode{}
	right := &DLLNode{}

	left.prev = nil
	right.next = nil
	left.next = right
	right.prev = left

	list.left = left
	list.right = right

	return list
}

func (this *MyLinkedList) Get(index int) int {
	cur := this.left.next

	for cur != nil && index > 0 {
		cur = cur.next
		index--
	}

	if cur != nil && cur != this.right && index == 0 {
		return cur.value
	}

	return -1
}

func (this *MyLinkedList) AddAtHead(val int) {

	newNode := &DLLNode{}
	newNode.value = val

	newNode.next = this.left.next
	newNode.prev = this.left
	newNode.next.prev = newNode
	this.left.next = newNode

}

func (this *MyLinkedList) AddAtTail(val int) {
	newNode := &DLLNode{}
	newNode.value = val

	newNode.prev = this.right.prev
	newNode.next = this.right
	this.right.prev = newNode
	newNode.prev.next = newNode
}

func (this *MyLinkedList) AddAtIndex(index int, val int) {
	newNode := &DLLNode{}
	newNode.value = val

	cur := this.left.next
	for cur != nil && index > 0 {
		cur = cur.next
		index--
	}
	if cur != nil && index == 0 {
		newNode.next = cur
		newNode.prev = cur.prev
		cur.prev = newNode
		newNode.prev.next = newNode
	}
}

func (this *MyLinkedList) DeleteAtIndex(index int) {
	cur := this.left.next
	for cur != nil && index > 0 {
		cur = cur.next
		index--
	}
	if cur != nil && cur != this.right && index == 0 {
		prev := cur.prev
		next := cur.next
		prev.next = next
		next.prev = prev
	}
}
