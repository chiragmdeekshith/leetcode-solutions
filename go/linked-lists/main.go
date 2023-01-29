package main

import "fmt"

type ListNode struct {
	Val  int
	Next *ListNode
}

func createNewLinkedList(input []int) *ListNode {
	head := &ListNode{}
	head.Next = nil
	cur := head
	for _, v := range input {
		newNode := &ListNode{}
		newNode.Val = v
		newNode.Next = nil
		cur.Next = newNode
		cur = cur.Next
	}
	return head.Next
}

func main() {
	fmt.Println("start")

	head1 := createNewLinkedList([]int{1, 2, 4, 5})
	head2 := createNewLinkedList([]int{1, 3, 6, 7})

	resultHead := mergeTwoLists(head1, head2)
	for resultHead != nil {
		fmt.Print(resultHead.Val)
		resultHead = resultHead.Next
	}
	fmt.Println("end")
}

/*
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
*/
