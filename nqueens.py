
# Check whether queen can be placed safely
def is_safe(board, row, col, n):

    # Check column
    for i in range(row):
        if board[i][col] == 1:
            return False

    # Check left diagonal
    i, j = row - 1, col - 1
    while i >= 0 and j >= 0:
        if board[i][j] == 1:
            return False
        i -= 1
        j -= 1

    # Check right diagonal
    i, j = row - 1, col + 1
    while i >= 0 and j < n:
        if board[i][j] == 1:
            return False
        i -= 1
        j += 1

    return True


# Solve N-Queens using backtracking
def solve(board, row, n):

    # All queens are placed
    if row == n:
        return True

    # Try every column
    for col in range(n):

        if is_safe(board, row, col, n):

            # Place queen
            board[row][col] = 1

            # Solve next row
            if solve(board, row + 1, n):
                return True

            # Remove queen if solution fails
            board[row][col] = 0

    return False


# Main program
n = int(input("Enter value of N: "))

# Create empty chessboard
board = [[0 for j in range(n)] for i in range(n)]

# Start from the first row
if solve(board, 0, n):
    print("N-Queens Solution:")
    for row in board:
        print(*row)
else:
    print("Solution does not exist.")
