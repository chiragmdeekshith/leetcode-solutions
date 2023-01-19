package main

func getConcatenation(nums []int) []int {

	oldSize := len(nums)
	newSize := oldSize * 2
	ans := make([]int, newSize)
	for i, v := range nums {
		ans[i] = v
		ans[oldSize+i] = v
	}
	return ans
}
