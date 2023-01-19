package main

import "strconv"

var stack []int
var head int

func calPoints(operations []string) int {

	lenOfOperations := len(operations)

	head = -1
	stack = make([]int, lenOfOperations)

	for i := 0; i < lenOfOperations; i++ {
		switch operations[i] {
		case "+":
			operand1 := pop()
			operand2 := peek()
			sum := operand1 + operand2
			push(operand1)
			push(sum)
		case "D":
			operand := peek()
			double := 2 * operand
			push(double)
		case "C":
			pop()
		default:
			num, _ := strconv.Atoi(operations[i])
			push(num)
		}
	}
	result := getSumOfStack()
	return result
}

func push(num int) {
	head++
	stack[head] = num
}

func pop() int {
	popped := stack[head]
	head--
	return popped
}

func peek() int {
	return stack[head]
}

func getSumOfStack() int {
	sum := 0
	for i := 0; i <= head; i++ {
		sum += stack[i]
	}
	return sum
}
