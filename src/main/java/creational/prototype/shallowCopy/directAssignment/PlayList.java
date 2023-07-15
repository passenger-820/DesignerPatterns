package creational.prototype.shallowCopy.directAssignment;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlayList {
    private Long id;
    private String name;
    private List<Song> songs = new ArrayList<>();

    public PlayList(){}

    //使用构造器传入源歌单，来实现浅拷贝，List传入的其引用
    //新歌单和旧歌单指向同一个list
    public PlayList(PlayList sourcePlayList){
        this.id = sourcePlayList.getId();
        this.name = sourcePlayList.getName();
        this.songs = sourcePlayList.getSongs();
    }

    public void addSong(Song song){
        songs.add(song);
    }

    public static void main(String[] args) {
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

        //浅拷贝一份新的歌单出来
        PlayList targetList = new PlayList(sourcePlayList);
        targetList.addSong(new Song("曹操","林俊杰"));
        for (Song song : targetList.getSongs()) {
            System.out.println(song);
        }
    }



}
