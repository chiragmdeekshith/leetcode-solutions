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

func printDLL(list *MyLinkedList) {
	cur := list.left
	fmt.Println("Vals")
	for cur != nil {
		fmt.Print(cur.value)
		cur = cur.next
	}
	fmt.Println("")

	fmt.Println("")
}

func printBrowserHistoryList(bh *BrowserHistory) {
	cur := bh.head.next
	fmt.Println("URLs")
	for cur != bh.tail {
		fmt.Print(cur.url, " ")
		cur = cur.next
	}
	fmt.Println("     Current-", bh.currentPage.url)
}

func main() {
	fmt.Println("start")

	myBrowserHistory := Constructor("leetcode.com")
	printBrowserHistoryList(&myBrowserHistory)
	myBrowserHistory.Visit("google.com")
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Visit("facebook.com")
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Visit("youtube.com")
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Back(1)
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Forward(1)
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Visit("linkedin.com")
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Forward(2)
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Back(2)
	printBrowserHistoryList(&myBrowserHistory)

	myBrowserHistory.Back(7)
	printBrowserHistoryList(&myBrowserHistory)

	fmt.Println("end")
}

/*
func main() {
	fmt.Println("start")
	myLinkedList := MyLinkedListConstructor()
	printDLL(&myLinkedList)
	myLinkedList.AddAtHead(1)
	printDLL(&myLinkedList)
	myLinkedList.AddAtTail(3)
	printDLL(&myLinkedList)
	myLinkedList.AddAtIndex(1, 2)
	printDLL(&myLinkedList)
	fmt.Println("GET- ", myLinkedList.Get(1))
	fmt.Println("")
	printDLL(&myLinkedList)
	myLinkedList.DeleteAtIndex(1)
	printDLL(&myLinkedList)
	fmt.Println("GET- ", myLinkedList.Get(1))
	fmt.Println("")
	printDLL(&myLinkedList)
}
*/

/*
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
*/

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
