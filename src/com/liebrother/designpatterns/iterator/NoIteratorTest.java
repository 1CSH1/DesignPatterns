package com.liebrother.designpatterns.iterator;

public class NoIteratorTest {

    public static void main(String[] args) {
        NetEaseMusic1 netEaseMusic1 = new NetEaseMusic1();
        netEaseMusic1.listenToMusicByLoop();
    }
}

/**
 * 网易云音乐
 */
class NetEaseMusic1 {

    private IList1 songList;

    public NetEaseMusic1() {
        songList = new SongList1(3);
        songList.add(new Song("让我留在你身边", "陈奕迅"));
        songList.add(new Song("你曾是少年", "SHE"));
        songList.add(new Song("Perfect", "Ed Sheeran"));
    }

    /**
     * 列表循环
     */
    public void listenToMusicByLoop() {
        for (int i = 0; i < songList.size(); i++) {
            System.out.println("听歌：" + ((ISong)songList.get(i)).getSongInfo());
        }
    }

}

/**
 * 容器接口
 */
interface IList1 {

    void add(Object object);

    Object get(int index);

    int size();
}

/**
 * 歌单
 */
class SongList1 implements IList1 {

    private ISong[] songs;
    private int index;
    private int size;

    public SongList1(int size) {
        songs = new ISong[size];
        index = 0;
        size = 0;
    }

    @Override
    public void add(Object object) {
        songs[index++] = (ISong) object;
        size ++;
    }

    @Override
    public Object get(int index) {
        if (index < size) {
            return songs[index];
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}


/**
 * 歌曲接口
 */
interface ISong {
    String getSongInfo();
}

/**
 * 歌曲
 */
class Song implements ISong{

    private String name;
    private String singer;

    public Song(String name, String singer) {
        this.name = name;
        this.singer = singer;
    }

    @Override
    public String getSongInfo() {
        return this.name + "--" + this.singer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

}
