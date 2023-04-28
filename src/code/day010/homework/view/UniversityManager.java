package code.day010.homework.view;

import code.day010.homework.dao.UniversityDao;
import code.day010.homework.entity.University;
import code.day010.homework.tools.MyUtils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class UniversityManager {
    private final static Scanner scan = new Scanner(System.in);
    private boolean isLoop = true;
    private final UniversityDao uDao = new UniversityDao();

    public void run() {
        while (isLoop) {
            showMenuPage();
            int selection = scan.nextInt();
            switch (selection) {
                // 查询所有学校详情信息
                case 1 -> showAllUniversityInfo();
                // 查询所有在成都的公办理工学校
                case 2 -> showUniversityInfoBySubject();
                // 所有本科一批的公办理科学校中，2022招生分数最高的学校
                case 3 -> showTopUniFromBatchBySubject();
                // 计算出 公立 大学2022年度，招生平均分数
                case 4 -> showAvgByType();
                // 查询非公立大学2022排名最高的大学
                case 5 -> showUniversityInfoFromNotPublicByTopScore();
                // 找出本科一批中2022年度招生分数最高的学校排名
                case 6 -> showUniversityRankFromFirstBatchByTop();
                // 所有大学中排名最低的大学是
                case 7 -> showUniversityInfoByLowestRank();
                // 找出排名在50000以内的公立学校
                case 8 -> showUniversityInfoByLessFiftyThousands();
                // 根据学校性质进行分组
                case 9 -> showUniversityInfoByGroupType();
                // 按-1退出
                case -1 -> exitSystem();
                // 默认输出
                default -> defaultOperation();
            }
        }
    }

    private void showUniversityInfoByGroupType() {
        Map<String, List<University>> uMap = uDao.groupUniversityByType();
        MyUtils.printInfo("学校按找性质分: " + uMap.size() + " 类, 详情如下");
        for (String type : uMap.keySet()) {
            MyUtils.printInfo(type + " 类:");
            MyUtils.printInfo(uMap.get(type));
        }
    }

    private void showUniversityInfoByLessFiftyThousands() {
        List<University> list = uDao.queryUniversityInfoByLessFiftyThousands();
        MyUtils.printInfo(list);
    }

    private void showUniversityInfoByLowestRank() {
        University university = uDao.queryUniversityInfoByLowestRank();
        if (university != null) {
            MyUtils.printInfo("所有大学中排名最低的大学是: " + university.getUname() + ", 详情如下:");
            MyUtils.printInfo(university);
        } else {
            MyUtils.printInfo("暂未找到数据!");
        }
    }

    private void showUniversityRankFromFirstBatchByTop() {
        University university = uDao.queryUniversityInfoRankFromFirstBatch();
        if (university != null) {
            MyUtils.printInfo("本科一批中2022年度招生分数最高的学校为: " + university.getUname() + ", 排名: " + university.getRank() + ", 详情如下:");
            MyUtils.printInfo(university);
        } else {
            MyUtils.printInfo("暂未找到数据!");
        }

    }

    private void showUniversityInfoFromNotPublicByTopScore() {
        List<University> list = uDao.queryUniversityInfoFromNotPublicByTopScore();
        MyUtils.printInfo(list);
    }

    private void showAvgByType() {
        double avgScore = uDao.queryUniversityAvgScoreByType();
        MyUtils.printInfo("2022年度公立大学，招生平均分数为: " + avgScore);
    }

    private void showTopUniFromBatchBySubject() {
        List<University> list = uDao.queryUniversityInfoFromBatchBySubject();
        MyUtils.printInfo(list);
    }


    private void showAllUniversityInfo() {
        List<University> list = uDao.queryAllUniversityInfo();
        MyUtils.printInfo(list);
    }

    private void showUniversityInfoBySubject() {
        List<University> list = uDao.queryUniversityInfoBySubject();
        MyUtils.printInfo(list);
    }


    private void showMenuPage() {
        System.out.println("""
                1、查询所有学校详情信息
                2、查询所有在成都的公办理工学校
                3、所有本科一批的公办理科学校中，2022招生分数最高的学校
                4、计算出公立大学2022年度，招生平均分数
                5、查询非公立大学2022排名最高的大学
                6、找出本科一批中2022年度招生分数最高的学校排名
                7、所有大学中排名最低的大学是
                8、找出排名在50000以内的公立学校
                9、根据学校性质进行分组
                """);
    }

    /**
     * 退出系统
     */
    private void exitSystem() {
        isLoop = false;
    }

    private void defaultOperation() {
        MyUtils.printInfo("此功能暂未开通!");
    }

}
