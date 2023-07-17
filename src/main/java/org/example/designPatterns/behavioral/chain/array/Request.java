package org.example.designPatterns.behavioral.chain.array;

import lombok.Data;

@Data
public class Request {
    private Integer num;

    public Request(Integer num) {
        this.num = num;
    }
}
