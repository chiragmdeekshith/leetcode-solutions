package main

func countStudents(students []int, sandwiches []int) int {

	ctr := 0

	for len(students) > 0 {
		if students[0] == sandwiches[0] {
			students = students[1:]
			sandwiches = sandwiches[1:]
			ctr = 0
		} else {
			stu := students[0]
			students = students[1:]
			students = append(students, stu)
			ctr++
		}
		if ctr > len(students) {
			break
		}
	}

	return len(students)

}
