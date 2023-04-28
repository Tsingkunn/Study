package code.day010.homework.database;

import code.day010.homework.entity.University;

import java.util.ArrayList;
import java.util.List;

public class UniversityData {

    private final List<University> uList = new ArrayList<>();

    public UniversityData() {
        init();
    }

    public List<University> getuList() {
        return uList;
    }

    /**
     * 初始化数据
     */
    private void init() {
        University u1 = new University("电子科技大学", "成都", "公立", "理", "本科一批", 646, 3598);
        University u2 = new University("成都理工大学", "成都", "公立", "理", "本科一批", 565, 39551);
        University u3 = new University("四川师范大学", "成都", "公立", "理", "本科一批", 537, 62049);
        University u4 = new University("成都文理学院", "成都", "民办", "理", "本科二批", 459, 147612);
        University u5 = new University("四川大学", "成都", "公立", "理", "本科一批", 635, 5777);
        University u6 = new University("成都锦城学院", "成都", "民办", "理", "本科一批", 515, 83025);
        University u7 = new University("西华大学", "成都", "公立", "理", "本科二批", 534, 64725);
        uList.add(u1);
        uList.add(u2);
        uList.add(u3);
        uList.add(u4);
        uList.add(u5);
        uList.add(u6);
        uList.add(u7);
    }

}
