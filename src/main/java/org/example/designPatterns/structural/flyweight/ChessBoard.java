package org.example.designPatterns.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 每个房间的游戏棋盘
 */
public class ChessBoard {
    //应当持有棋子和位置
    private Map<Position,ChessPiece> chessPieceMap;

    public ChessBoard(){
        //构造棋盘
        this.chessPieceMap = new HashMap<>(64);
        //初始化棋子和位置
        Position position1 = new Position(1,2);
        chessPieceMap.put(position1,new ChessPiece(ChessUnitFactory.getChessUnit(1L),position1));
        Position position2 = new Position(1,3);
        chessPieceMap.put(position2,new ChessPiece(ChessUnitFactory.getChessUnit(2L),position2));
        Position position3 = new Position(1,4);
        chessPieceMap.put(position3,new ChessPiece(ChessUnitFactory.getChessUnit(4L),position3));
    }

    public void display(){
        for (Map.Entry<Position,ChessPiece> entry : chessPieceMap.entrySet()){
            System.out.println(entry.getKey() + "-->" + entry.getValue());

        }

    }
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard();
        chessBoard.display();
    }
}
