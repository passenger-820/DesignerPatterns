package org.example.designPatterns.behavioral.chain.linked;

/**
 * 这里每一个处理器都要处理请求
 */
public class HandlerChain {
    //单链表，维护头尾节点
    private Handler head;
    private Handler tail;

    //添加Handler，本例不考虑删除Handler了
    public void addHandler(Handler handler){
        //如果链表里还“没有”节点，你即头尾
        if (head == null && tail == null){
            head = handler;
            tail = handler;
            return;
        }
        //尾插法
        tail.setNext(handler);
        tail = handler;
    }

    public void doHandle(Request request){
        if (head != null){
            //算法里的老套路，额外找个引用指向head，别随便动原有的引用
            Handler p = head;
            do {
                p.handle(request);
                p = p.next;
            }while (p != null);
        }
    }
}
