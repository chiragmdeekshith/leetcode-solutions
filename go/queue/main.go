package main

import "fmt"

func printStack(myStack *MyStack) {
	fmt.Println("Primary active? ", myStack.isPrimary)
	fmt.Println("Queue 1- ", myStack.primary.queue)
	fmt.Println("Queue 2- ", myStack.secondary.queue)
	fmt.Println()
}

func main() {
	fmt.Println("works!")

	myStack := Constructor()
	printStack(&myStack)

	myStack.Push(1)
	printStack(&myStack)

	myStack.Push(2)
	printStack(&myStack)

	fmt.Println(myStack.Top())
	printStack(&myStack)

	fmt.Println(myStack.Pop())
	printStack(&myStack)

	fmt.Println(myStack.Empty())
	printStack(&myStack)

}

/*
func main() {
	fmt.Println("works!")

	students := []int{1, 1, 1, 0, 0, 1} //[]int{1, 1, 0, 0}
	sandwich := []int{1, 0, 0, 0, 1, 1} // []int{0, 1, 0, 1}

	fmt.Println(countStudents(students, sandwich))
}*/
