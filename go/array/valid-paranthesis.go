package main

import (
	"errors"
)

func isValid(s string) bool {

	stack := make([]string, len(s))
	head := -1

	peek := func() (string, error) {
		if head < 0 {
			return "", errors.New("")
		}
		return stack[head], nil
	}
	push := func(charString string) {
		head++
		stack[head] = charString
	}
	pop := func() string {
		popped := stack[head]
		head--
		return popped
	}

	for i := 0; i < len(s); i++ {
		charString := string(s[i])
		if charString == "(" || charString == "{" || charString == "[" {
			push(charString)
		} else {
			currentChar, err := peek()
			if err != nil {
				return false
			}
			if charString == ")" {
				if currentChar != "(" {
					return false
				}
			}
			if charString == "}" {
				if currentChar != "{" {
					return false
				}
			}
			if charString == "]" {
				if currentChar != "[" {
					return false
				}
			}
			pop()
		}

	}

	return head == -1
}
