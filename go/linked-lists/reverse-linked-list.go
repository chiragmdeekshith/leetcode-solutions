package main

func reverseList(head *ListNode) *ListNode {
	if head == nil {
		return head
	}

	left := head
	right := head.Next

	head.Next = nil

	var cur *ListNode

	for right != nil {
		cur = left
		left = right
		right = right.Next
		left.Next = cur
	}

	return left
}
