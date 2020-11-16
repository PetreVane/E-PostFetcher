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
}
