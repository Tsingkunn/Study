package code.day010.homework.dao;

import code.day010.homework.database.UniversityData;
import code.day010.homework.entity.University;

import java.util.*;
import java.util.stream.Collectors;

public class UniversityDao {

    private final List<University> uList = new UniversityData().getuList();

    public List<University> queryAllUniversityInfo() {
        return uList;
    }

    public List<University> queryUniversityInfoBySubject() {
        return uList.stream()
                .filter(university -> university.getCity().equals("成都"))
                .filter(university -> university.getType().equals(""))
                .filter(university -> university.getSubject().equals("理"))
                .collect(Collectors.toList());
    }

    public List<University> queryUniversityInfoFromBatchBySubject() {
        float max = uList.stream()
                .filter(university -> university.getSubject().equals("理") && university.getBatch().equals("本科一批") && university.getType().equals("公立"))
                .map(University::getTopScore)
                .max(Comparator.comparingDouble(Float::doubleValue))
                .orElse(0f);
        return uList.stream().filter(university -> university.getTopScore() == max).toList();
    }

    public double queryUniversityAvgScoreByType() {
        return uList.stream()
                .filter(university -> university.getType().equals("公立"))
                .mapToDouble(University::getTopScore)
                .average().orElse(0);
    }

    public List<University> queryUniversityInfoFromNotPublicByTopScore() {
        return uList.stream()
                .filter(university -> !university.getType().equals("公立"))
                .max(Comparator.comparingDouble(University::getTopScore))
                .stream()
                .collect(Collectors.toList());
    }

    public University queryUniversityInfoRankFromFirstBatch() {
        return uList.stream()
                .filter(university -> university.getBatch().equals("本科一批"))
                .max(Comparator.comparingDouble(University::getTopScore))
                .orElse(null);
    }

    public University queryUniversityInfoByLowestRank() {
        return uList.stream()
                .max(Comparator.comparingInt(University::getRank))
                .orElse(null);
    }

    public List<University> queryUniversityInfoByLessFiftyThousands() {
        return uList.stream()
                .filter(university -> university.getType().equals("公立"))
                .filter(university -> university.getRank() < 50000)
                .collect(Collectors.toList());
    }

    public Map<String, List<University>> groupUniversityByType() {
        return uList.stream()
                .collect(Collectors.groupingBy(University::getType));
    }

    public boolean isNameExist(String name) throws RuntimeException {
        for (University university : uList) {
            if (university.getUname().equals(name))
                throw new RuntimeException("学校名字重复");
        }
        return false;
    }

    public void insert(University university) {
        if (!isNameExist(university.getUname())) {
            uList.add(university);
        }
    }
}
