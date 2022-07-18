package javapoo;



import javapoo.menu.Menu;
import javapoo.menu.crudplayers.CRUDplayer;

public class Game {

    public static void main(String[] args) {
        CRUDplayer.createIAPlayer();
        Menu.menu();
    }
}



