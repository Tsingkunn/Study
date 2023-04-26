package code.day008.bookmanager;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BookManager {

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
                case 10 -> {
                    
                }
                // -1.退出
                case -1 -> exit();
                // 显示默认信息
                default -> showDefault();
            }
        }
    }

    private void showBookInfoByKinds() {
        List<Book> list = bookDAO.selectAllBookInfo();
        Set<String> set = new HashSet<>();

        for (Book book : list) {
            set.add(book.getType());
        }
        BookUtils.print("图书有 " + set.size() + " 类,分别如下:");

        for (String type : set) {
            BookUtils.print(type + "类有如下信息:");
            BookUtils.print();
            for (Book book : list) {
                if (book.getType().equals(type)) {
                    BookUtils.print(book);
                }
            }
        }
    }

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
        List<Book> list = bookDAO.selectBookByNotOver();
        if (list != null) {
            int endIndex = 3;
            BookUtils.print(descendingSort(list), endIndex);
        } else {
            BookUtils.print("该条件下未检索到信息!");
        }
    }

    /**
     * 6.计算所有未完结小说的平均人气
     */
    private void showAvgPopByNotOver() {
        List<Book> list = bookDAO.selectBookByNotOver();
        double sum = 0;
        if (list != null) {
            for (Book book : list) {
                sum += book.getPop();
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
        List<Book> list = bookDAO.selectBookByAuthor();
        if (list != null) {
            BookUtils.print(descendingSort(list));
        } else {
            BookUtils.print("该条件下未检索到信息!");
        }
    }

    /**
     * 4.查询人气最高的仙侠小说？
     */
    private void showMostPopByXianxia() {
        List<Book> list = bookDAO.selectBookByXianxia();
        if (list != null) {
            Book maxPopBook = list.get(0);
            for (int i = 0; i < list.size() - 1; i++) {
                if (maxPopBook.getPop() < list.get(i + 1).getPop()) {
                    maxPopBook = list.get(i + 1);
                }
            }
            BookUtils.print(maxPopBook);
        } else {
            BookUtils.print("暂时未收录仙侠类别小说!");
        }
    }

    /**
     * 3.删除指定编号的图书?
     */
    private void removeBookInfoByBid() {
        String bid = BookUtils.scan.next();
        if (isBidExist(bid)) {
            List<Book> list = bookDAO.selectAllBookInfo();
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
        if (!isBidExist(bid)) {
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

    private boolean isBidExist(String bid) {

        for (Book book : bookDAO.selectAllBookInfo()) {
            if (bid.equals(book.getBid())) {
                return true;
            }
        }

        return false;
    }

    private List<Book> descendingSort(List<Book> list) {
        for (int i = 0; i < list.size() - 1; i++) {
            for (int j = 0; j < list.size() - 1 - i; j++) {
                if (list.get(j).getPop() < list.get(j + 1).getPop()) {
                    Book temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set(j + 1, temp);
                }
            }
        }
        return list;
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
