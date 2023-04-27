package code.day008.bookmanager;

import java.util.*;

public class BookManagerView {

    BookDAO bookDAO = new BookDAO();

    public void run() {

        while (BookUtils.isLoop) {
            showMainPage();
            int selection = BookUtils.scan.nextInt();
            switch (selection) {
                // 1.查询所有图书信息？
                case 1 -> showAllBookInfo();
                // 2.增添书籍信息
                case 2 -> addBookInfo();
                // 3.删除指定编号的图书?
                case 3 -> removeBookInfoByBid();
                // 4.查询人气最高的仙侠小说？
                case 4 -> showMostPopByXianxia();
                // 5.查找作者是两个字的小说按人气进行排序？
                case 5 -> showBookInfoFromAuthorNameByPop();
                // 6.计算所有未完结小说的平均人气?
                case 6 -> showAvgPopByNotOver();
                // 7.找出未完结小说里面人气最高的三本小说信息?
                case 7 -> showBookInfoByTopThreeFromNotOver();
                // 8.人气超过50000的的未完结小说有哪些？
                case 8 -> showBookInfoByPopThanFiftyThousands();
                // 9.根据图书类型进行分组,显示每中图书类型的总数量以及每个类型下具体的商品信息？
                case 9 -> showBookInfoByKinds();
                case 10 -> showBookInfoByKindsUseMapOne();
                case 11 -> showBookInfoByKindsUseMapTwo();
                case 12 -> showBookInfoByKindsUseMapThree();

                // -1.退出
                case -1 -> exit();
                // 显示默认信息
                default -> showDefault();
            }
        }
    }

    private void showBookInfoByKindsUseMapThree() {
        List<BookEntity> list = bookDAO.selectAllBookInfo();

        Map<String, List<BookEntity>> map = new HashMap<>();
        while (list.size() > 0) {
            List<BookEntity> bl = new ArrayList<>();
            String type = list.get(0).getType();
            for (int i = 0; i < list.size(); i++) {
                if (type.equals(list.get(i).getType())) {
                    bl.add(list.get(i));
                    list.remove(i);
                    i--;
                }
            }
            map.put(type, bl);
        }
        // 打印
        BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
        for (String key : map.keySet()) {
            BookUtils.print(key + "类有如下信息:");
            BookUtils.print(map.get(key));
        }
    }

    private void showBookInfoByKindsUseMapTwo() {
        //  所有书籍的list
        List<BookEntity> list = bookDAO.selectAllBookInfo();
        // 定义的map
        Map<String, List<BookEntity>> map = new HashMap<>();
        // 所有书都遍历一遍
        for (BookEntity bookEntity : list) {
            // 从map里面取当前书籍的type
            // 如果没有这个类型,那么会返回一个空值
            if (map.get(bookEntity.getType()) == null) {
                // 如果是空值.新建一个list集合
                List<BookEntity> bl = new ArrayList<>();
                // 把当前这个书放进list
                bl.add(bookEntity);
                // 放类型,放list
                map.put(bookEntity.getType(), bl);
            } else {
                // 如果有这个类型了
                // 获取当前类型的list,list有他所有的书
                List<BookEntity> bl = map.get(bookEntity.getType());
                // 把新的书放进list
                bl.add(bookEntity);
                // 这个key我们是知道有的.
                // 我们用这个新的list,覆盖原来的旧list
                map.put(bookEntity.getType(), bl);
            }
        }

        if (!map.isEmpty()) {
            BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
            for (String key : map.keySet()) {
                BookUtils.print(key + "类有如下信息:");
                BookUtils.print(map.get(key));
            }
        } else {
            BookUtils.print("系统内暂无书籍!");
        }
    }

    private void showBookInfoByKindsUseMapOne() {
        // 这个是获取全部的信息
        List<BookEntity> list = bookDAO.selectAllBookInfo();
        Map<String, Integer> map = new HashMap<>();

        // kye-书籍类型;value-类型的数量
        for (BookEntity bookEntity : list) {
            if (map.get(bookEntity.getType()) == null) {
                map.put(bookEntity.getType(), 0);
            } else {
                map.put(bookEntity.getType(), map.get(bookEntity.getType()) + 1);
            }
        }
        // 如果系统中有书籍.打印信息
        if (!map.isEmpty()) {
            BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
            for (String key : map.keySet()) {
                BookUtils.print(key + "类有如下信息:");
                BookUtils.print();
                for (BookEntity bookEntity : list) {
                    if (bookEntity.getType().equals(key)) {
                        BookUtils.print(bookEntity);
                    }
                }
            }
        } else {
            BookUtils.print("系统内暂无书籍!");
        }
    }

    private void showBookInfoByKinds() {
        List<BookEntity> list = bookDAO.selectAllBookInfo();
        Set<String> set = new HashSet<>();
        for (BookEntity bookEntity : list) {
            set.add(bookEntity.getType());
        }
        BookUtils.print("图书有 " + set.size() + " 类,分别如下:");

        for (String type : set) {
            BookUtils.print(type + "类有如下信息:");
            BookUtils.print();
            for (BookEntity bookEntity : list) {
                if (bookEntity.getType().equals(type)) {
                    BookUtils.print(bookEntity);
                }
            }
        }
    }

    /**
     * 8.人气超过50000的的未完结小说有哪些？
     */
    private void showBookInfoByPopThanFiftyThousands() {
        List<BookEntity> list = bookDAO.selectBookByPopFiftyThousands();
        BookUtils.print(list);
    }

    /**
     * 7.找出未完结小说里面人气最高的三本小说信息
     */
    private void showBookInfoByTopThreeFromNotOver() {
        List<BookEntity> list = bookDAO.selectBookByNotOver();
        if (list != null) {
            int endIndex = 3;
            BookUtils.print(new BookUtils().descendingSort(list), endIndex);
        } else {
            BookUtils.print("该条件下未检索到信息!");
        }
    }

    /**
     * 6.计算所有未完结小说的平均人气
     */
    private void showAvgPopByNotOver() {
        List<BookEntity> list = bookDAO.selectBookByNotOver();
        double sum = 0;
        if (list != null) {
            for (BookEntity bookEntity : list) {
                sum += bookEntity.getPop();
            }
            BookUtils.print("未完结小说的平均人气是" + sum / list.size());
        } else {
            BookUtils.print("书籍中暂无未完结小说!");
        }
    }

    /**
     * 5.查找作者是两个字的小说按人气进行排序？
     */
    private void showBookInfoFromAuthorNameByPop() {
        List<BookEntity> list = bookDAO.selectBookByAuthor();
        if (list != null) {
            BookUtils.print(new BookUtils().descendingSort(list));
        } else {
            BookUtils.print("该条件下未检索到信息!");
        }
    }

    /**
     * 4.查询人气最高的仙侠小说？
     */
    private void showMostPopByXianxia() {
        List<BookEntity> list = bookDAO.selectBookByXianxia();
        if (list != null) {
            BookEntity maxPopBookEntity = list.get(0);
            for (int i = 0; i < list.size() - 1; i++) {
                if (maxPopBookEntity.getPop() < list.get(i + 1).getPop()) {
                    maxPopBookEntity = list.get(i + 1);
                }
            }
            BookUtils.print(maxPopBookEntity);
        } else {
            BookUtils.print("暂时未收录仙侠类别小说!");
        }
    }

    /**
     * 3.删除指定编号的图书?
     */
    private void removeBookInfoByBid() {
        String bid = BookUtils.scan.next();
        if (new BookUtils().isBidExist(bid)) {
            List<BookEntity> list = bookDAO.selectAllBookInfo();
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getBid().equals(bid)) {
                    if (list.remove(i) != null) {
                        BookUtils.print("删除成功!");
                    } else {
                        BookUtils.print("删除失败!");
                    }
                }
            }
        } else {
            BookUtils.print("书籍编号不存在");
        }
    }

    /**
     * 2.增加新书籍信息
     */
    private void addBookInfo() {
        BookUtils.print("请输入书籍编号:");
        String bid = BookUtils.scan.next();
        if (!new BookUtils().isBidExist(bid)) {
            BookUtils.print("请输入书籍名称:");
            String name = BookUtils.scan.next();
            System.out.println("请输入作者姓名:");
            String author = BookUtils.scan.next();
            System.out.println("请输入书籍人气:");
            int pop = BookUtils.scan.nextInt();
            System.out.println("请输入书籍类型:");
            String type = BookUtils.scan.next();
            System.out.println("请输入是否完结(完结输入1,连载中输入2):");
            int isOver = BookUtils.scan.nextInt();
            BookEntity bookEntity = new BookEntity(bid, name, author, pop, type, isOver);

            if (bookDAO.insertBook(bookEntity)) {
                BookUtils.print("添加书籍成功!");
            } else {
                BookUtils.print("添加书籍失败!");
            }
        } else {
            BookUtils.print("书籍编号信息重复");
        }
    }

    /**
     * 1.获取全部信息
     */
    private void showAllBookInfo() {
        List<BookEntity> list = bookDAO.selectAllBookInfo();
        BookUtils.print(list);
    }

    /**
     * 退出
     */
    private void exit() {
        BookUtils.isLoop = false;
    }

    /**
     * 菜单来提示信息
     */
    private void showDefault() {
        BookUtils.print("敬请期待...");
    }


    private void showMainPage() {
        System.out.println("""
                        主菜单
                 1.查询所有图书信息
                 2.增添书籍信息
                 3.删除指定编号的图书
                 4.查询人气最高的仙侠小说
                 5.查找作者是两个字的小说按人气进行排序
                 6.计算所有未完结小说的平均人气
                 7.找出未完结小说里面人气最高的三本小说信息
                 8.人气超过50000的的未完结小说
                 9.根据图书类型进行分组,显示每中图书类型的总数量以及每个类型下具体的商品信息
                            按-1退出
                """);
    }

}
