package main

func removeDuplicates(nums []int) int {

	length := len(nums)

	if length <= 1 {
		return length
	}

	left := 0
	right := 1

	for right < length {
		if nums[right-1] < nums[right] {
			left++
			nums[left] = nums[right]
		}
		right++
	}

	return left + 1
}
