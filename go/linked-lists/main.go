package main

import "fmt"

func main() {
	fmt.Println("start")

	//var head, cur *ListNode
	head := &ListNode{}
	head.Val = 0
	head.Next = nil
	cur := head

	input := []int{2, 5, 2, 1, 3, 4, 6}

	for _, v := range input {
		newNode := &ListNode{}
		newNode.Val = v
		newNode.Next = nil
		cur.Next = newNode
		cur = cur.Next
	}

	newHead := reverseList(head)
	for newHead != nil {
		fmt.Print(newHead.Val)
		newHead = newHead.Next
	}
	fmt.Println("end")
}
