package code.day008.bookmanager.view;

import code.day008.bookmanager.dao.BookDAO;
import code.day008.bookmanager.entity.Book;
import code.day008.bookmanager.tools.BookUtils;

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
                case 9 -> showBookInfoByKindsUseMap();

                // -1.退出
                case -1 -> exit();
                // 显示默认信息
                default -> showDefault();
            }
        }
    }

    private void showBookInfoByKindsUseMap() {

        Map<String, List<Book>> map = bookDAO.selectBookInfoByKind();
        // 打印
        BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
        for (String key : map.keySet()) {
            BookUtils.print(key + "类有如下信息:");
            BookUtils.print(map.get(key));
        }
    }

//    private void showBookInfoByKindsUseMapTwo() {
//        //  所有书籍的list
//        List<Book> list = bookDAO.selectAllBookInfo();
//        // 定义的map
//        Map<String, List<Book>> map = new HashMap<>();
//        // 所有书都遍历一遍
//        for (Book book : list) {
//            // 从map里面取当前书籍的type
//            // 如果没有这个类型,那么会返回一个空值
//            if (map.get(book.getType()) == null) {
//                // 如果是空值.新建一个list集合
//                List<Book> bl = new ArrayList<>();
//                // 把当前这个书放进list
//                bl.add(book);
//                // 放类型,放list
//                map.put(book.getType(), bl);
//            } else {
//                // 如果有这个类型了
//                // 获取当前类型的list,list有他所有的书
//                List<Book> bl = map.get(book.getType());
//                // 把新的书放进list
//                bl.add(book);
//                // 这个key我们是知道有的.
//                // 我们用这个新的list,覆盖原来的旧list
//                map.put(book.getType(), bl);
//            }
//        }
//
//        if (!map.isEmpty()) {
//            BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
//            for (String key : map.keySet()) {
//                BookUtils.print(key + "类有如下信息:");
//                BookUtils.print(map.get(key));
//            }
//        } else {
//            BookUtils.print("系统内暂无书籍!");
//        }
//    }
//
//    private void showBookInfoByKindsUseMapOne() {
//        // 这个是获取全部的信息
//        List<Book> list = bookDAO.selectAllBookInfo();
//        Map<String, Integer> map = new HashMap<>();
//
//        // kye-书籍类型;value-类型的数量
//        for (Book book : list) {
//            if (map.get(book.getType()) == null) {
//                map.put(book.getType(), 0);
//            } else {
//                map.put(book.getType(), map.get(book.getType()) + 1);
//            }
//        }
//        // 如果系统中有书籍.打印信息
//        if (!map.isEmpty()) {
//            BookUtils.print("图书有 " + map.size() + " 类,分别如下:");
//            for (String key : map.keySet()) {
//                BookUtils.print(key + "类有如下信息:");
//                BookUtils.print();
//                for (Book book : list) {
//                    if (book.getType().equals(key)) {
//                        BookUtils.print(book);
//                    }
//                }
//            }
//        } else {
//            BookUtils.print("系统内暂无书籍!");
//        }
//    }
//
//    private void showBookInfoByKinds() {
//        List<Book> list = bookDAO.selectAllBookInfo();
//        Set<String> set = new HashSet<>();
//        for (Book book : list) {
//            set.add(book.getType());
//        }
//        BookUtils.print("图书有 " + set.size() + " 类,分别如下:");
//
//        for (String type : set) {
//            BookUtils.print(type + "类有如下信息:");
//            BookUtils.print();
//            for (Book book : list) {
//                if (book.getType().equals(type)) {
//                    BookUtils.print(book);
//                }
//            }
//        }
//    }

    /**
     * 8.人气超过50000的的未完结小说有哪些？
     */
    private void showBookInfoByPopThanFiftyThousands() {
        List<Book> list = bookDAO.selectBookByPopFiftyThousands();
        BookUtils.print(list);
    }

    /**
     * 7.找出未完结小说里面人气最高的三本小说信息
     */
    private void showBookInfoByTopThreeFromNotOver() {
        List<Book> list = bookDAO.selectBookByNotOverTopThreeFromNotOver();
        if (list != null) {
            BookUtils.print(list);
        } else {
            BookUtils.print("该条件下未检索到信息!");
        }
    }

    /**
     * 6.计算所有未完结小说的平均人气
     */
    private void showAvgPopByNotOver() {
        int avg = bookDAO.selectBookByNotOver();
        if (avg != -1) {
            BookUtils.print("未完结小说的平均人气是" + avg);
        } else {
            BookUtils.print("书籍中暂无未完结小说!");
        }
    }

    /**
     * 5.查找作者是两个字的小说按人气进行排序？
     */
    private void showBookInfoFromAuthorNameByPop() {
        List<Book> list = bookDAO.selectBookByAuthor();
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
        List<Book> list = bookDAO.selectTopBookByXianxia();
        if (list != null) {
            BookUtils.print(list);
        } else {
            BookUtils.print("暂时未收录仙侠类别小说!");
        }
    }

    /**
     * 3.删除指定编号的图书?
     */
    private void removeBookInfoByBid() {
        String bid = BookUtils.scan.next();
        if (bookDAO.isBidExist(bid)) {
            Book delBook = bookDAO.deleteBook(bid);

            if (delBook != null) {
                BookUtils.print("删除<<" + delBook.getName() + ">>成功!");
            } else {
                BookUtils.print("删除失败!");
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
        if (!bookDAO.isBidExist(bid)) {
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
            Book book = new Book(bid, name, author, pop, type, isOver);

            if (bookDAO.insertBook(book)) {
                BookUtils.print("添加书籍" + book.getName() + "成功!");
            } else {
                BookUtils.print("添加书籍" + book.getName() + "失败!");
            }
        } else {
            BookUtils.print("书籍编号信息重复");
        }
    }

    /**
     * 1.获取全部信息
     */
    private void showAllBookInfo() {
        List<Book> list = bookDAO.selectAllBookInfo();
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
