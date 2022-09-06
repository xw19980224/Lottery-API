package com.xw.lottery.api.domain.lucky.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Prize
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/6 23:27
 * @Version: 1.0
 */
public class Prize {
    private List<Strategy> fonts = new ArrayList<>();
    private String background;

    public Prize(Strategy fonts, String background) {
        this.fonts.add(fonts);
        this.background = background;
    }

    public Prize(List<Strategy> fonts, String background) {
        this.fonts = fonts;
        this.background = background;
    }

    public List<Strategy> getFonts() {
        return fonts;
    }

    public void setFonts(List<Strategy> fonts) {
        this.fonts = fonts;
    }

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

}
