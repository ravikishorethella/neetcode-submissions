class BrowserHistory {
    
    // each page is a node in doubly linked list
    // prev - back in history
    // next - forward in history
    private static class Page {
        String url;
        Page prev;
        Page next;

        Page(String url) {
            this.url = url;
        }
    }

    // this is the current page that we are on
    private Page current;

    public BrowserHistory(String homepage) {
        // initializing the browser history with the homepage
        current = new Page(homepage);
    }
    
    // when visiting a new page, it clears all the forward history
    // we achieve that by current.next = newPage
    public void visit(String url) {
        Page newPage = new Page(url);
        newPage.prev = current; // new page points back to current page
        current.next = newPage; // current page points forward to new page
        current = newPage; // current page is now new page
    }
    
    // going back steps in history and the current.prev should be present
    public String back(int steps) {
        while(steps > 0 && current.prev != null) {
            current = current.prev;
            steps--;
        }
        return current.url;
    }
    
    // going forward and the current.next should be present
    public String forward(int steps) {
        while(steps > 0 && current.next != null) {
            current = current.next;
            steps--;
        }
        return current.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */