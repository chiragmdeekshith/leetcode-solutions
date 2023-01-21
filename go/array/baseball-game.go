package main

import "strconv"

func calPoints(operations []string) int {

	var stack []int
	var head int

	peek := func() int {
		return stack[head]
	}
	push := func(num int) {
		head++
		stack[head] = num
	}
	pop := func() int {
		popped := stack[head]
		head--
		return popped
	}
	getSumOfStack := func() int {
		sum := 0
		for i := 0; i <= head; i++ {
			sum += stack[i]
		}
		return sum
	}

	lenOfOperations := len(operations)

	head = -1
	stack = make([]int, lenOfOperations)

	for i := 0; i < lenOfOperations; i++ {
		switch operations[i] {
		case "+":
			operand1 := pop()
			sum := operand1 + peek()
			push(operand1)
			push(sum)
		case "D":
			operand := peek()
			push(2 * operand)
		case "C":
			pop()
		default:
			num, _ := strconv.Atoi(operations[i])
			push(num)
		}
	}
	return getSumOfStack()
}
