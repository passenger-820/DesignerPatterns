package org.example.designPatterns.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 每个房间的棋子类
 */
@Data
@AllArgsConstructor
public class ChessPiece {
    private ChessUnit chessUnit;
    private Position position;
}
