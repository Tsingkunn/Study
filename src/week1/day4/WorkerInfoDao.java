package week1.day4;

import java.util.Arrays;

public class WorkerInfoDao {
    private String[] arr = { "100-司马懿-男-11000", "101-貂蝉-女-18000", "102-孙权-男-12000", "103-黄忠-男-20000", "104-孙尚香-女-13000",
            "105-诸葛亮-男-15000", "106-西门吹雪-男-16000" };

    public String[] showAll() {
        return arr;
    }

    public boolean addWorkerInfo(WorkerInfoBean workerBean) {
        if (isIdValid(workerBean.getId()) && isNameValid(workerBean.getName())
                && isGenderValid(workerBean.getGender()) && isSalaryValid(workerBean.getSalary())) {
            String worker = workerBean.getId() + "-" + workerBean.getName() + "-" + workerBean.getGender() + "-"
                    + workerBean.getSalary();
            arr = addElement(arr, worker);
            return true;
        }
        return false;
    }

    public boolean updateWorkerName(int index, String name) {
        if (isIndexValid(index)) {
            String[] worker = arr[index].split("-");
            arr[index] = worker[0] + "-" + name + "-" + worker[2] + "-" + worker[3];
            return true;
        }
        return false;
    }

    public boolean deleteWorkerInfo(int index) {
        if (isIndexValid(index)) {
            System.arraycopy(arr, index + 1, arr, index, arr.length - 1 - index);
            arr = Arrays.copyOf(arr, arr.length - 1);
            return true;
        }
        return false;
    }

    public String[] queryWorkerByNameLike(String name) {
        String[] workerInfo = {};
        for (String worker : arr) {
            if (worker.split("-")[1].contains(name)) {
                workerInfo = addElement(workerInfo, worker);
            }
        }
        return workerInfo;
    }

    private String[] addElement(String[] arr, String element) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = element;
        return arr;
    }

    private boolean isIndexValid(int index) {
        if (index >= 0 && index < arr.length) {
            return true;
        }
        return false;
    }

    private boolean isIdValid(int id) {

        if (id > 0) {
            for (String worker : arr) {
                if (worker.split("-")[0].equals(id + "")) {
                    return false;
                } else {
                    return true;
                }
            }
        } else {
            return false;
        }
        return false;
    }

    private boolean isNameValid(String name) {
        if (name.equals("") || name == null) {
            return false;
        } else {
            return true;
        }
    }

    private boolean isGenderValid(String gender) {
        if (gender.equals("男") || gender.equals("女")) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isSalaryValid(double salary) {
        if (salary > 0) {
            return true;
        } else {
            return false;
        }
    }
}
