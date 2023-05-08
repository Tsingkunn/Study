package code.day013;


import code.day010.database.UniversityData;
import code.day010.entity.University;
import practice.io.TextIOOperation;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class SavaMessageTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        List<University> uList = new UniversityData().getList();
        TextIOOperation io = new TextIOOperation();
        uList.forEach(uni -> {
            StringBuilder sb = new StringBuilder();
            sb.append(uni.getUname()).append(",")
                    .append(uni.getCity()).append(",")
                    .append(uni.getType()).append(",")
                    .append(uni.getSubject()).append(",")
                    .append(uni.getBatch()).append(",")
                    .append(uni.getTopScore()).append(",")
                    .append(uni.getRank());
            try {
                io.bufferedFileWriter(new File("src/code/day013/uniMsg.txt"), sb.toString(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        });
    }
}

