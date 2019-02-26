package com.liebrother.designpatterns.iterator;

import java.util.Iterator;

public class IteratorTest {

    public static void main(String[] args) {
        NetEaseMusic2 netEaseMusic2 = new NetEaseMusic2();
        netEaseMusic2.listenToMusicByLoop();
    }

}

/**
 * 网易云音乐
 */
class NetEaseMusic2{

    private IList2 songList;

    public NetEaseMusic2() {
        songList = new SongList2(3);
        songList.add(new Song("让我留在你身边", "陈奕迅"));
        songList.add(new Song("你曾是少年", "SHE"));
        songList.add(new Song("Perfect", "Ed Sheeran"));
    }

    /**
     * 列表循环
     */
    public void listenToMusicByLoop() {
        IIterator iterator = songList.iterator();
        while (iterator.hasNext()) {
            System.out.println("听歌：" + ((ISong)iterator.next()).getSongInfo());
        }

    }

}

/**
 * 容器接口
 */
interface IList2 {

    IIterator iterator();

    void add(Object object);

    Object get(int index);

    int size();
}

/**
 * 歌单
 */
class SongList2 implements IList2 {

    private ISong[] songs;
    private int index;
    private int size;

    public SongList2(int size) {
        songs = new ISong[size];
        index = 0;
        size = 0;
    }

    @Override
    public IIterator iterator() {
        return new IteratorImpl(this);
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
 * 迭代器
 */
interface IIterator {
    Object next();
    boolean hasNext();
}

/**
 * 迭代器实现类
 */
class IteratorImpl implements IIterator {

    private IList2 list;
    private int index;

    public IteratorImpl(IList2 list) {
        this.list = list;
        this.index = 0;
    }

    @Override
    public Object next() {
        return list.get(index++);
    }

    @Override
    public boolean hasNext() {
        if (index < list.size()) {
            return true;
        }
        return false;
    }
}
