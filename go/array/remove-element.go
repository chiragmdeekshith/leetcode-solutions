package main

import "fmt"

func removeElement(nums []int, val int) int {

	searcher := 0
	replacer := 0

	for searcher < len(nums) {
		if nums[searcher] != val {
			nums[replacer] = nums[searcher]
			replacer++
		}
		searcher++
	}
	fmt.Println(nums, replacer)
	return replacer
}
