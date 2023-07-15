package creational.prototype.shallowCopy.cloneable;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayList implements Cloneable {
    private Long id;
    private String name;
    private List<Song> songs = new ArrayList<>();

    public PlayList(){}

    public void addSong(Song song){
        songs.add(song);
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        PlayList sourcePlayList = new PlayList();
        sourcePlayList.setId(1L);
        sourcePlayList.setName("杰伦");
        sourcePlayList.addSong(new Song("稻香","杰伦"));
        sourcePlayList.addSong(new Song("迷迭香","杰伦"));
        sourcePlayList.addSong(new Song("七里香","杰伦"));
        for (Song song : sourcePlayList.getSongs()) {
            System.out.println(song);
        }
        System.out.println("---------------------------------------");
        // 浅拷贝
        PlayList targetList = (PlayList) sourcePlayList.clone();
        targetList.addSong(new Song("曹操","林俊杰"));
        for (Song song : targetList.getSongs()) {
            System.out.println(song);
        }
    }

    //当然浅拷贝还有一个做法就是使用反射技术循环遍历类中的getter和setter方法，
    // 对成员变量进行循环赋值操作，不再尝试了
}
