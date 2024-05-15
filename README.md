SNAKE GAME
This is a simple implementation of the classic Snake Game using Java and Swing. The game features a snake that grows in length each time it eats food, and the objective is to achieve the highest score possible by eating as much food as you can without colliding with the snake's own body or the walls.

FEATURES
Classic Snake Gameplay: Control the snake to eat food and grow longer.
Food Placement: Food appears at random locations on the board.
Collision Detection: The game ends if the snake collides with itself or the edges of the board.
Score Display: The current score is displayed on the screen.

HOW TO PLAY
Use the arrow keys to control the direction of the snake:
Up Arrow: Move up
Down Arrow: Move down
Left Arrow: Move left
Right Arrow: Move right
The game starts with a stationary snake. Begin moving by pressing one of the arrow keys.
The game is over when the snake collides with itself or the boundaries of the board.

REQUIREMENTS
Java Development Kit (JDK) 8 or higher
Running the Game

CODE OVERVIEW
Main Class: SnakeGame
SnakeGame(int boardWidth, int boardHeight): Initializes the game with the specified board dimensions.
paintComponent(Graphics g): Renders the game components including the snake, food, and score.
placeFood(): Places food at a random location on the board.
move(): Handles the movement of the snake and checks for collisions.
checkCollision(): Checks if the snake has collided with itself or the boundaries of the board.
keyPressed(KeyEvent e): Handles key presses to control the direction of the snake.

INNER CLASS:TILE
Tile(int x, int y): Represents a tile on the board with x and y coordinates.

CONTRIBUTION
Contributions are welcome! Please feel free to submit a Pull Request or open an Issue to improve the game.
