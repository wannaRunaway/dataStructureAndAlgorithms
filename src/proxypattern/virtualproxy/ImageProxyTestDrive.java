package proxypattern.virtualproxy;

import java.awt.*;
import java.net.URL;

public class ImageProxyTestDrive {
    Component imageComponent;

    public static void main(String[] args) {
//        ImageProxyTestDrive imageProxyTestDrive = new ImageProxyTestDrive();
    }

    public ImageProxyTestDrive() throws Exception {
        URL initialURL = new URL("https://www.pexels.com/photo/defocused-image-of-lights-255379/");
        Icon icon = new ImageProxy(initialURL);
//        imageComponent = new ImageComponent(icon);

    }
}
