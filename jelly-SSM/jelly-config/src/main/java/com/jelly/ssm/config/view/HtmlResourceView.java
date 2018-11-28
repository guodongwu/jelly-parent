package com.jelly.ssm.config.view;

import org.springframework.web.servlet.view.InternalResourceView;

import java.io.File;
import java.util.Locale;

/**
 * Html 解析 没用上
 * @author wu
 */
public class HtmlResourceView extends InternalResourceView {

    @Override
    public boolean checkResource(Locale locale) throws Exception {
        File file=new File(this.getServletContext().getRealPath("/")+getUrl());
        return file.exists();
    }
}
