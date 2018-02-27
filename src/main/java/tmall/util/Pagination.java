package tmall.util;

/**
 * 分页类
 */
public class Pagination {
    private int start;
    private int count;
    private int total;
    private String param;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public Pagination() {
        this.start = 0;
        this.count = 5;
    }

    public Pagination(int start, int count, int total) {
        this.start = start;
        this.count = count;
        this.total = total;
    }

    /**
     * @return 总页数
     */
    public int getTotalPage() {
        int totalPage = total / count - 1;
        // 如果total不能被count整除，或者为0，还要把余下的项目放到最后一页
        if (total % count != 0 || total == 0)
            totalPage = total / count;
        return totalPage;
    }

    /**
     * @return 最后一页的第一项的页码
     */
    public int getLastPage() {
        int lastPage;
        //count 5
        //total 50 -> 45
        //total 47 -> 45
        //total 0 -> 0

        if (total % count == 0) {
            lastPage = total - count;
        } else {
            lastPage = total - total % count;
        }
        //total < count
        lastPage = lastPage < 0 ? 0 : lastPage;
        return lastPage;
    }

    public boolean isHasPrevious() {
        return start > 0;
    }

    public boolean isHasNext() {
        return start != getLastPage();
    }


}
