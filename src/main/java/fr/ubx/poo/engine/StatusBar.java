/*
 * Copyright (c) 2020. Laurent Réveillère
 */

package fr.ubx.poo.engine;

import static fr.ubx.poo.view.image.ImageResource.*;

import fr.ubx.poo.game.Game;
import fr.ubx.poo.view.image.ImageFactory;
import javafx.scene.Group;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class StatusBar {
    public static final int height = 55;
    private HBox hBox = new HBox();
    private Text liveValue = new Text();
    private Text bombsValue = new Text();
    private Text rangeValue = new Text();
    private Text keyValue = new Text();
    private Text landminesValue = new Text() ;
    private Text hasScarecrow = new Text() ;
    private HBox level = new HBox();
    private int gameLevel = 1;
    private final Game game;
    private final DropShadow ds = new DropShadow();



    public StatusBar(Group root, int sceneWidth, int sceneHeight, Game game) {
        // Status bar
        this.game = game;

        level.getStyleClass().add("level");
        level.getChildren().add(new ImageView(ImageFactory.getInstance().getDigit(gameLevel)));

        ds.setRadius(5.0);
        ds.setOffsetX(3.0);
        ds.setOffsetY(3.0);
        ds.setColor(Color.color(0.5f, 0.5f, 0.5f));



        HBox status = new HBox();
        status.getStyleClass().add("status");
        HBox live = statusGroup(ImageFactory.getInstance().get(HEART), liveValue);
        HBox bombs = statusGroup(ImageFactory.getInstance().get(BANNER_BOMB), bombsValue);
        HBox range = statusGroup(ImageFactory.getInstance().get(BANNER_RANGE), rangeValue);
        HBox key = statusGroup(ImageFactory.getInstance().get(KEY), keyValue);
        HBox landmines = statusGroup(ImageFactory.getInstance().get(BANNER_LANDMINE), landminesValue);
        HBox scarecrow = statusGroup(ImageFactory.getInstance().get(BANNER_SCARECROW), hasScarecrow);
        status.setSpacing(2.0);
        status.getChildren().addAll(live, bombs, range, key, landmines, scarecrow);


        hBox.getChildren().addAll(level, status);
        hBox.getStyleClass().add("statusBar");
        hBox.relocate(0, sceneHeight);
        hBox.setPrefSize(sceneWidth, height);
        root.getChildren().add(hBox);
    }

    private void updateLevel(int n) {
        if (n != gameLevel) {
            level.getChildren().clear();
            level.getChildren().add(new ImageView(ImageFactory.getInstance().getDigit(n)));
        }
    }


    private HBox statusGroup(Image kind, Text number) {
        HBox group = new HBox();
        ImageView img = new ImageView(kind);
        group.setSpacing(4);
        number.setEffect(ds);
        number.setCache(true);
        number.setFill(Color.BLACK);
        number.getStyleClass().add("number");
        group.getChildren().addAll(img, number);
        return group;
    }

    public void update(Game game) {
        updateLevel(game.getLevel());
        liveValue.setText(String.valueOf(game.getPlayer().getLives()));
        rangeValue.setText(String.valueOf(game.getPlayer().getRange()));
        bombsValue.setText(String.valueOf(game.getPlayer().getBombs()));
        keyValue.setText(String.valueOf(game.getPlayer().getKey()));
        landminesValue.setText(String.valueOf(game.getPlayer().getLandmines()));
        //the scarecrow option is a boolean option : we can't store them
        if (game.getPlayer().getScarecrow()) hasScarecrow.setText("V") ;
        else hasScarecrow.setText("F") ;
    }

}
