package com.hikari.entity;

import com.hikari.key.PageKey;
import com.hikari.util.ServletUtils;

/**
 * Page
 * @author lkc39miku_cn
 */
public class Page {

    public static Integer page() {
        return Integer.parseInt(ServletUtils.getParameter(PageKey.page));
    }

    public static Integer pageSize() {
        return Integer.parseInt(ServletUtils.getParameter(PageKey.pageSize));
    }
}
