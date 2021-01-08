# Project 2 - CS 150: Coffee Shop Simulation

## Intro
This project is part of the CS150 Course: Data Structures and Algorithms. It tested my understanding of the following data structures in Java: ArrayList, ArrayDeque and PriorityQueue. It also tested my usage of insertion, deletion, sorting of those data structures.

## Input Specification
You are given a file “input.txt” containing the following information.

• The first line are two real numbers p1 and p2, 0.00 < p1 ≤ p2 < 10.00, the lower and upper bounds of the
estimated profit of serving each customer in dollars.

• The second line is a real number c, 0.00 < c < 1000.00, the cost of staffing a cashier counter per day in dollars.

• The third line are two integers t1 and t2, 30 < t1 ≤ t2 < 300, the lower and upper bounds of the average time
for a cashier to serve a customer in seconds.

• From the fourth line to the last line is the arrival times of the customers. Each line contains a string in the format
of ”hh:mm:ss” in the 24-hour format

## Goal
The Goal of this project was to examine different numbers of cashiers to be used in the coffee shop and analyze to see the optimal choice, in turn of waiting time and profit

## Report
![Profit to number of Cashier](project2.PNG?raw=true "Title")

After building an event-driven simulation of a coffee shop, the experimenter obtained a program that would take in different numbers of cashiers and produce average total overflow and average total profit. It can be concluded that, to minimize the number of overflows and optimize profit, the number of cashiers to be chosen should be 4 or 3.
