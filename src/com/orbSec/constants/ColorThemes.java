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

        switch (colorTheme) {
            case DARK:
                return "css/themeDark.css";
            case LIGHT:
                return "css/themeLight.css";
            case DEFAULT:
                return "css/themeDefault.css";
            default:
                return null;
        }
    }
}
