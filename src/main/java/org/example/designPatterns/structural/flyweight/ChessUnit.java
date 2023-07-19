package org.example.designPatterns.structural.flyweight;


import lombok.AllArgsConstructor;
import lombok.ToString;
/**
 * 棋子的享元类，共享棋子的id，棋子的名字和棋子的颜色
 */
@AllArgsConstructor
@ToString
public class ChessUnit {
    private Long id;
    private String text;
    private Color color;

    public enum Color {
        RED, BLACK
    }
}
