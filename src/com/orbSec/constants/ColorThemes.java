package com.orbSec.constants;

public enum ColorThemes {
    LIGHT,
    DEFAULT,
    DARK;

    public String toString() {
        String result;
        switch (this) {
            case DARK:
                result = "dark";

            break;
            case LIGHT:
                result = "light";

            break;
            case DEFAULT:
                result = "default";
                
            break;
            default:
                throw new IllegalStateException("Unexpected value: " + this);
        }
        return result;
    }

    // returns the path to css file location, for each case
    public String getFilePathFor(ColorThemes colorTheme) {

        String result = "";

        switch (colorTheme) {
            case DARK:
                result = "css/themeDark.css";
            case LIGHT:
                result = "css/themeLight.css";
            case DEFAULT:
                result= "css/themeDefault.css";
        }
        return result;
    }
}
