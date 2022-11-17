package fr.ubx.poo.model.decor;

import fr.ubx.poo.model.go.character.Player;

public class Princess extends Decor{
    @Override
    public String toString() {
        return "Princess";
    }
    @Override
    public void computeDecor(Player player){
        player.princessFound();
    }
    @Override
    public boolean canExplode(){
        return false ;
    }
    @Override
    public boolean isPrincess(){
        return true ;
    }
}
