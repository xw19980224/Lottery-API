package com.xw.lottery.api.domain.menu.model;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * @ClassName: Button
 * @Author: MaxWell
 * @Description:
 * @Date: 2022/9/10 22:53
 * @Version: 1.0
 */
public class Button {
    /**
     * 一级菜单数组，个数应为1~3个
     */
    private List<SubButton> button;

    public Button() {
        button = Lists.newArrayList();
    }

    public Button(List<SubButton> button) {
        this.button = button;
    }

    public List<SubButton> getButton() {
        return button;
    }

    public void setButton(List<SubButton> button) {
        this.button = button;
    }

    public void add(SubButton subButton) {
        this.button.add(subButton);
    }
}
