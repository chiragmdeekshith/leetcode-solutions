package main

import "fmt"

func main() {
	nums := []int{1, 2, 7, 3, 3, 4, 5, 1, 3, 2, 3}
	val := 3
	removeElement(nums, val)
	fmt.Println("Done!")
}

/*
func main() {
	nums := []int{1, 2, 3, 4, 4, 4, 4, 5}
	removeDuplicates(nums)
	fmt.Println("Done!")
}
*/
