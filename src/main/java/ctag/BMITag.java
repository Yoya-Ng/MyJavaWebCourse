package ctag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class BMITag implements Tag {
    
    private PageContext pageContext;
    private Tag parentTag;
    private double h, w;
    
    @Override
    public void setPageContext(PageContext pc) {
        pageContext = pc;
    }
    
    @Override
    public void setParent(Tag t) {
        parentTag = t;
    }
    
    @Override
    public Tag getParent() {
        return parentTag;
    }
    
    public double getH() {
        return h;
    }
    
    public void setH(int h) {
        this.h = h;
    }
    
    public double getW() {
        return w;
    }
    
    public void setW(int w) {
        this.w = w;
    }
    
    @Override
    public int doStartTag() throws JspException {
        try {
            JspWriter out = pageContext.getOut();
            double bmi = w / Math.pow(h / 100, 2);
            out.print("身高：" + getH() + " 體重：" + getW() + " BMI : " + bmi);
        } catch (Exception e) {
        }
        return Tag.EVAL_PAGE;
    }
    
    @Override
    public int doEndTag() throws JspException {
        return Tag.EVAL_PAGE;
    }
    
    @Override
    public void release() {
        
    }
    
}
