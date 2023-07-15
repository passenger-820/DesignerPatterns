package creational.prototype.shallowCopy.directAssignment;

/**
 * 准备使用浅拷贝来复制一个音乐播放列表，以便为用户创建一个新的播放列表，同时保留原始播放列表的内容
 */
public class Song {
    String title;
    String artist;

    public Song(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "title: " + title +"; artist: " + artist;
    }
}
