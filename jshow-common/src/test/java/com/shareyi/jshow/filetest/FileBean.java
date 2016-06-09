package com.shareyi.jshow.filetest;

import com.shareyi.jshow.file.FileField;

/**
 * Created by david on 2015/10/21.
 */
public class FileBean {

    @FileField
    private String htmlContent;
    @FileField
    private String cssContent;


    public String getHtmlContent() {
        return htmlContent;
    }

    public void setHtmlContent(String htmlContent) {
        this.htmlContent = htmlContent;
    }

    public String getCssContent() {
        return cssContent;
    }

    public void setCssContent(String cssContent) {
        this.cssContent = cssContent;
    }
}
