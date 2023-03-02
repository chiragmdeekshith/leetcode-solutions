package main

import "fmt"

func main() {
	fmt.Println("Works!")

	for i := 0; i < 10; i++ {
		fmt.Print(fib(i), " ")
	}
}
