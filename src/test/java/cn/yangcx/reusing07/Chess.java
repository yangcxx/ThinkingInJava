package cn.yangcx.reusing07;

/**
 * @author YANGCX
 * @date 2021/5/28 7:04
 */
public class Chess extends BoardGame {

    public static GameFactory factory = Chess::new;

    public Chess() {
        // cxy 必须首先调用基类的构造器
        super(11);
        System.out.println("Chess constructor");
    }

    public void playGame(GameFactory factory) {
        Game game = factory.getGame();
        // other operations
        System.out.println("Game==>" + game);
    }

    public static void main(String[] args) {
        Chess chess = new Chess();
        System.out.println(chess);
        // ====
        // todo 语法糖
        chess.playGame(Chess.factory);
        chess.playGame(BoardGame::new);
    }
}

interface GameFactory {
    Game getGame();
}

class Game {
    public Game(int i) {
        System.out.println("Game constructor");
    }

    public Game() {
    }
}

class BoardGame extends Game {

    public BoardGame(int i) {
        super(i);
        System.out.println("BoardGame constructor");
    }

    public BoardGame() {
    }

    // 匿名内部类
    // public static GameFactory factory = BoardGame::new;
}
