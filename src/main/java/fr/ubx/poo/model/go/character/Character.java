/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.model.go.character;

import fr.ubx.poo.game.Direction;
import fr.ubx.poo.game.Position;
import fr.ubx.poo.model.Updatable;
import fr.ubx.poo.model.go.MovableGameObject;

import fr.ubx.poo.game.Game;

public abstract class Character extends MovableGameObject implements Updatable {
    private Direction direction ;
    public Character(Game game, Position position){
        super(game, position) ;
        this.direction = Direction.S ;
    }
    public void setDirection(Direction d){
        direction = d ;
    }
    public Direction getDirection() {
        return direction;
    }
}
