Name: YOUR NAME HERE

| Date  |      Time      |                                                                                                                 Update |
|:------|:--------------:|-----------------------------------------------------------------------------------------------------------------------:|
| Sep 3 | 9:30-10:30 PM  |          I tried an approach where I had a recursive helper method that takes in a start cell and tells me how long it |
|       |                | would take to get to the end of the board from that cell. That approach didn't really work the way I wanted it to, but |
| Sep 4 | 10:00-10:40 PM |                                                                    it did help me understand the problem a lot better. |
|       |                |                         I ditched the helper method approach and instead did something similar to the mazesolvers from |
|       |                |                  last year, where I had an ArrayList of all the seen cells and all the "currently exploring" cells and |
|       |                |                         used those to find new cells to explore. I'm now passing 4/4 tests and have done a tiny little |
|       |                |                                                                                       bit of optimizing, but not much. |
| Sep 6 |  3:10-3:45 PM  |          I began recoding using the new method, using a queue instead of an ArrayList to store the next cells to visit |
|       |                |                 and using maps for looking up whether a cell has been visited and how many rolls it took to get there. |
|       |                |                                                                                          It still didn't work, though. |
| Sep 6 |  3:45-4:15 PM  |   Debugging the code that didn't work. I fixed some issues with arrays being out of bounds because of typos or because |
|       |                | I forgot that since I was 1-indexing and leaving an empty cell for 0, I needed to make all the arrays one cell larger. |
|       |                |                                                                                  Still wasn't working properly though. |
| Sep 6 |  4:15-4:45 PM  |                  I realized that the reason why my code still wasn't working is because I was checking the rolls using |
|       |                |                                                 rolls = 1; rolls < 6 which doesn't count 6 as a possible roll. oops... |


To add a new row to the table, click into a cell and then hit shift-enter.