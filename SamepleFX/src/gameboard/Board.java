package gameboard;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Board extends Application {
	private static final double W = 800, H = 600;


	private Image pugPic;
	private Node pug;

	boolean running, goNorth, goSouth, goEast, goWest;

	@Override
	public void start(Stage primaryStage) {
		pugPic = new Image("file:snakeHead.png");
		pug = new ImageView(pugPic);
		Group park = new Group(pug);
		Scene scene = new Scene(park, W, H, Color.BLUE);
		primaryStage.setScene(scene);
		primaryStage.show();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = true; break;
                    case DOWN:  goSouth = true; break;
                    case LEFT:  goWest  = true; break;
                    case RIGHT: goEast  = true; break;
                    case SHIFT: running = true; break;
				default:
					break;
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    goNorth = false; break;
                    case DOWN:  goSouth = false; break;
                    case LEFT:  goWest  = false; break;
                    case RIGHT: goEast  = false; break;
                    case SHIFT: running = false; break;
				default:
					break;
                }
            }
        });

        primaryStage.setScene(scene);
        primaryStage.show();
        
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (goNorth) dy -= 1;
                if (goSouth) dy += 1;
                if (goEast)  dx += 1;
                if (goWest)  dx -= 1;
                if (running) { dx *= 3; dy *= 3; }

                movepugBy(dx, dy);
            }
        };
        timer.start();
	}
        private void movepugBy(int dx, int dy) {
            if (dx == 0 && dy == 0) return;

            final double cx = pug.getBoundsInLocal().getWidth()  / 2;
            final double cy = pug.getBoundsInLocal().getHeight() / 2;

            double x = cx + pug.getLayoutX() + dx;
            double y = cy + pug.getLayoutY() + dy;

            movepugTo(x, y);
        }

        private void movepugTo(double x, double y) {
            final double cx = pug.getBoundsInLocal().getWidth()  / 2;
            final double cy = pug.getBoundsInLocal().getHeight() / 2;

            if (x - cx >= 0 &&
                x + cx <= W &&
                y - cy >= 0 &&
                y + cy <= H) {
                pug.relocate(x - cx, y - cy);
            }
        }

        public static void main(String[] args) { 
        	launch(args);
        }
    }