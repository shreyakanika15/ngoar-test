# Hedgehog

### Problem Statement
Given rectangular garden sized M x N. Garden consists of square zones with one apple tree in each zone.

There is an hedgehog in upper left square of the garden. It moves to lower right corner with
some restrictions: the hedgehog only can move to the next right or to the next lower square.

### Solution
- Driver Class - `HedgehogExample.java`, this class is going to read the file (whch contains the input data) and parse it.
- Node class - to create the Tree node as this is a BFS example.

### Process
1. HedgehogExample.java, will read the file and parse it.
2. This will internally read all the file data line by line.
3. Create the Tree Node so we can use and find the number of apples as needed.
4. Finally we will traverse the Node recursively and find the apples and in each recursion we will add it to the previous one and finally once we reach the end or if there is no right or lower, we'll end the executionn and return the output.

### Run the Code
This is a simple program, if needed change the `fileName` and with the input file name if you have. Or just change the content of the file `input-file.txt` already there in the code.
And run the program. Program will output the count of apples at the end.
