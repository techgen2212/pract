
# Function to solve 0/1 Knapsack using Dynamic Programming
def knapsack(capacity, weights, profits, n):

    # Create a DP table with (n+1) rows and (capacity+1) columns
    # Initially, all values are zero
    dp = [[0 for x in range(capacity + 1)]
          for x in range(n + 1)]

    # Traverse through each item
    for i in range(1, n + 1):

        # Check all possible knapsack capacities
        for w in range(1, capacity + 1):

            # Check if current item can fit in the knapsack
            if weights[i - 1] <= w:

                # Find maximum profit by including or excluding the item
                dp[i][w] = max(

                    # Option 1: Include the current item
                    profits[i - 1] + dp[i - 1][w - weights[i - 1]],

                    # Option 2: Exclude the current item
                    dp[i - 1][w]
                )

            else:
                # If item cannot fit, take previous maximum profit
                dp[i][w] = dp[i - 1][w]

    # Return the maximum profit from the DP table
    return dp[n][capacity]


# Main Program

# Accept the number of items
n = int(input("Enter number of items: "))

# Create empty lists for weights and profits
weights = []
profits = []

# Accept weight and profit of each item
for i in range(n):

    w = int(input("Enter weight: "))
    p = int(input("Enter profit: "))

    # Store weight and profit in lists
    weights.append(w)
    profits.append(p)

# Accept maximum knapsack capacity
capacity = int(input("Enter knapsack capacity: "))

# Call the knapsack function
result = knapsack(capacity, weights, profits, n)

# Display the maximum profit
print("Maximum Profit:", result)
