package main

type BrowserHistory struct {
	head        *DllNode
	currentPage *DllNode
	tail        *DllNode
}

type DllNode struct {
	url  string
	prev *DllNode
	next *DllNode
}

func Constructor(homepage string) BrowserHistory {
	browserHistory := BrowserHistory{}

	head := &DllNode{}
	currentPage := &DllNode{}
	tail := &DllNode{}

	head.next = currentPage
	tail.prev = currentPage
	head.prev = nil
	tail.next = nil
	currentPage.prev = head
	currentPage.next = tail

	currentPage.url = homepage

	browserHistory.head = head
	browserHistory.currentPage = currentPage
	browserHistory.tail = tail
	return browserHistory
}

func (this *BrowserHistory) Visit(url string) {
	newPage := &DllNode{}
	newPage.url = url

	newPage.prev = this.currentPage
	this.currentPage.next = newPage
	this.currentPage = newPage

	this.currentPage.next = this.tail
	this.tail.prev = this.currentPage
	this.tail.next = nil
}

func (this *BrowserHistory) Back(steps int) string {
	for this.currentPage != this.head.next && steps > 0 {
		this.currentPage = this.currentPage.prev
		steps--
	}
	return this.currentPage.url
}

func (this *BrowserHistory) Forward(steps int) string {
	for this.currentPage != this.tail.prev && steps > 0 {
		this.currentPage = this.currentPage.next
		steps--
	}
	return this.currentPage.url
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * obj := Constructor(homepage);
 * obj.Visit(url);
 * param_2 := obj.Back(steps);
 * param_3 := obj.Forward(steps);
 */
