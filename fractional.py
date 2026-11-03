
# Function to solve Fractional Knapsack using Greedy Method
def fractional_knapsack(capacity, weights, profits):

    # Find the total number of items
    n = len(weights)

    # Create an empty list to store item details
    items = []

    # Calculate profit/weight ratio for each item
    for i in range(n):
        ratio = profits[i] / weights[i]

        # Store ratio, weight and profit together
        items.append((ratio, weights[i], profits[i]))

    # Sort items in descending order of profit/weight ratio
    items.sort(reverse=True)

    # Initialize total profit to zero
    total_profit = 0

    # Select items one by one in sorted order
    for ratio, weight, profit in items:

        # Check if the complete item fits in the knapsack
        if capacity >= weight:

            # Reduce the remaining capacity
            capacity -= weight

            # Add the complete item's profit
            total_profit += profit

        else:
            # Take only the fraction of the remaining item
            total_profit += ratio * capacity

            # Stop because the knapsack is full
            break

    # Return the maximum profit
    return total_profit


# Main Program

# Accept the number of items
n = int(input("Enter number of items: "))

# Create empty lists for weights and profits
weights = []
profits = []

# Accept weight and profit of each item
for i in range(n):
    w = float(input("Enter weight of item: "))
    p = float(input("Enter profit of item: "))

    # Store values in their respective lists
    weights.append(w)
    profits.append(p)

# Accept the maximum capacity of the knapsack
capacity = float(input("Enter knapsack capacity: "))

# Call the function to calculate maximum profit
result = fractional_knapsack(capacity, weights, profits)

# Display the final maximum profit
print("Maximum Profit:", result)
