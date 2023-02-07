package main

import "fmt"

func main() {
	fmt.Println("works!")

	students := []int{1, 1, 1, 0, 0, 1} //[]int{1, 1, 0, 0}
	sandwich := []int{1, 0, 0, 0, 1, 1} // []int{0, 1, 0, 1}

	fmt.Println(countStudents(students, sandwich))
}
