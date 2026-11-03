# Non-Recursive Fibonacci

def fibonacci_iterative(n):
    a, b = 0, 1

    for i in range(n):
        print(a, end=" ")
        a, b = b, a + b

# Recursive Fibonacci

def fibonacci_recursive(n):
    if n <= 1:
        return n
    return fibonacci_recursive(n-1) + fibonacci_recursive(n-2)


n = int(input("Enter the number of terms: "))

print("\nNon-Recursive Fibonacci:")
fibonacci_iterative(n)

print("\nRecursive Fibonacci:")
for i in range(n):
    print(fibonacci_recursive(i), end=" ")




"""Method	Time Complexity	Space Complexity
Non-Recursive	O(n)	O(1)
Recursive	O(2ⁿ)	O(n)
"""