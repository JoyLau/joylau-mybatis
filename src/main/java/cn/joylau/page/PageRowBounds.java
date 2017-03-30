/*******************************************************************************
 * Copyright (c) 2017 by JoyLau. All rights reserved
 ******************************************************************************/

package cn.joylau.page;

import org.apache.ibatis.session.RowBounds;

/**
 */
public class PageRowBounds extends RowBounds {
    private Long total;

    public PageRowBounds(int offset, int limit) {
        super(offset, limit);
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }
}
