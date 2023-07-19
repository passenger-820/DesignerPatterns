package org.example.designPatterns.structural.flyweight;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 棋子位置是不一致的
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Position {
    private int positionX;
    private int positionY;
}
