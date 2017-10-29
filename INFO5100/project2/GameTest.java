package project2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

class GameTest {

    @BeforeEach
    void setUp() throws Exception {
        
    }
    
    @RepeatedTest(50)
    void repeatedTest() {
        int players=(int) (3+Math.rint((Math.random()*3)));
        Game a=new Game(players);
        a.playAGame();
    }

}
