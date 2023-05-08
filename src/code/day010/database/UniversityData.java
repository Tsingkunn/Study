package code.day010.database;

import code.day010.entity.University;
import code.day010.tools.Config;
import code.day010.tools.MyUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UniversityData {
    private static List<University> uList = new ArrayList<>();

    public UniversityData() {
        init();
    }

    public List<University> getList() {
        return uList;
    }

    @SuppressWarnings("unchecked")
    void init() {
        try {
            uList = (List<University>) MyUtils.objectInput(new File(Config.FILE_PATHNAME));
        } catch (IOException e) {
            MyUtils.printInfo("系统初始化IO异常,详情如下:\n" + e.getMessage());
        } catch (ClassNotFoundException e) {
            MyUtils.printInfo("初始化信息失败,文件未找到对应存储文件,请核对正确路径!");
        }
        if (uList == null) {
            uList = new ArrayList<>();
        }

    }


//
//    测试用↓,用于第一次导入数据的操作,免得一次一次输入
//
//    private void olderInit() {
//        University u1 = new University("电子科技大学", "成都", "公立", "理", "本科一批", 646, 3598);
//        University u2 = new University("成都理工大学", "成都", "公立", "理", "本科一批", 565, 39551);
//        University u3 = new University("四川师范大学", "成都", "公立", "理", "本科一批", 537, 62049);
//        University u4 = new University("成都文理学院", "成都", "民办", "理", "本科二批", 459, 147612);
//        University u5 = new University("四川大学", "成都", "公立", "理", "本科一批", 635, 5777);
//        University u6 = new University("成都锦城学院", "成都", "民办", "理", "本科一批", 515, 83025);
//        University u7 = new University("西华大学", "成都", "公立", "理", "本科二批", 534, 64725);
//        uList.add(u1);
//        uList.add(u2);
//        uList.add(u3);
//        uList.add(u4);
//        uList.add(u5);
//        uList.add(u6);
//        uList.add(u7);
//
//    }
}
