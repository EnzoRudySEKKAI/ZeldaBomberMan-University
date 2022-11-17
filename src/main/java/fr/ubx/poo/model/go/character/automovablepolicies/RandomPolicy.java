
package fr.ubx.poo.model.go.character.automovablepolicies;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.model.go.character.Monster;
import java.util.Collections;
import java.util.List;

/**
 * This policy lead the monster to move randomly
 */
public class RandomPolicy extends Automovable {
    public RandomPolicy(Monster monsterToMove){
        super(monsterToMove) ;
    }

    /**
     * Shuffle the List of Direction
     * @param directions the List of directions that we have to sort.
     * @return a shuffled List of Direction
     */
    @Override
    public List<Direction> sortDirections(List<Direction> directions){
        Collections.shuffle(directions);
        return directions ;
    }
    @Override
    public AutomovableType getType(){
        return AutomovableType.RandomPolicy ;
    }
}

