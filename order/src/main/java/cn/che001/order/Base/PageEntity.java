package cn.che001.order.Base;

/**
 * Created by light on 2017/4/17.
 */
public class PageEntity extends Entity {
    private static final long serialVersionUID = 8019640499889727357L;

    //当前页
    protected Integer currentPage = Integer.valueOf(1);

    //页容量
    protected Integer pageSize = Integer.valueOf(10);

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
