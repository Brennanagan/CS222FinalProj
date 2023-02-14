public class GameLogic {

    // Brennan's Goals for GameLogic:

    // manage timer and score
        // talk to Serena about gui for timer and score
        // create an algorithm that combines extra time, blocks hit, and enemies killed for score
            // 100 pts for brick block, 500 pts for ? block, 300 pts for kill, 5 pts for every extra second
    // enemy behavior and player-character interaction (loss of life or killed enemy)
        // separate class for enemy behavior that takes timer as cues for movement
            // at time 0, start at origin point
            // for an interval of time, utilize one direction of movement, then switch dir of movement
        // player character interaction should be in a class that implements
            // Entity superclass
                    // contains general collision and appearance variables, lateral movement, gravity effects
                // player and enemy subclasses
                    // player
                        // vertical movement options (jumping and falling), block breaking/enemy collision
                    // enemy
                        // death collision at top of enemy, AI movement algorithm
    // level creation (possibly send data to gui portion of project as opposed to creating solely in this class
        // options for how to store info for level
            // *LEAST LIKELY* file of code
            // ***MOST LIKELY**** ArrayList of objects (blocks class?) that store collision, position, and appearance
            // **SOMEWHAT LIKELY** class that holds level info
                // or class that reads and interprets level info


}
