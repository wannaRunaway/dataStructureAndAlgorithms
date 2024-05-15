package proxypattern.virtualproxy;

import java.awt.*;

/*
* icon接口,定义图片使用的方法
* */
public interface Icon {
    Integer getIconWidth();
    Integer getIconHeight();
    void paintIcon(final Component component, Graphics graphics, int x, int y);
}
